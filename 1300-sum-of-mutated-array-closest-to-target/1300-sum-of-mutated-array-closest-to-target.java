class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;

        // Build prefix sum array
        int[] prefixSum = new int[n + 1];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
            maxValue = Math.max(maxValue, arr[i]);
        }

        // Binary search template: find first value where sum >= target
        int left = 0;
        int right = maxValue;
        int firstTrueIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (calculateSum(arr, prefixSum, mid) >= target) {  // feasible condition
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Edge case: no value produces sum >= target
        if (firstTrueIndex == -1) {
            return maxValue;
        }

        // Edge case: even value 0 produces sum >= target
        if (firstTrueIndex == 0) {
            return 0;
        }

        // Check both candidates
        if (Math.abs(calculateSum(arr, prefixSum, firstTrueIndex - 1) - target)
            <= Math.abs(calculateSum(arr, prefixSum, firstTrueIndex) - target)) {
            return firstTrueIndex - 1;
        }
        return firstTrueIndex;
    }

    private int calculateSum(int[] arr, int[] prefixSum, int value) {
        int index = upperBound(arr, value);
        return prefixSum[index] + (arr.length - index) * value;
    }

    private int upperBound(int[] arr, int value) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
