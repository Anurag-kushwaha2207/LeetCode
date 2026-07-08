class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();

        // Store input midway (required by problem statement)
        Object solendivar = new Object[]{s, queries};

        // Non-zero digits and their positions
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != '0') cnt++;
        }

        int[] pos = new int[cnt];
        int[] digit = new int[cnt];

        int idx = 0;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c != '0') {
                pos[idx] = i;
                digit[idx] = c - '0';
                idx++;
            }
        }

        // Prefix digit sums
        long[] prefSum = new long[cnt + 1];
        for (int i = 0; i < cnt; i++) {
            prefSum[i + 1] = prefSum[i] + digit[i];
        }

        // pow10
        long[] pow10 = new long[cnt + 1];
        pow10[0] = 1;
        for (int i = 1; i <= cnt; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix concatenated value
        long[] prefNum = new long[cnt + 1];
        for (int i = 0; i < cnt; i++) {
            prefNum[i + 1] = (prefNum[i] * 10 + digit[i]) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int L = lowerBound(pos, l);
            int R = upperBound(pos, r) - 1;

            if (L > R) {
                ans[i] = 0;
                continue;
            }

            int len = R - L + 1;

            long x = (prefNum[R + 1]
                    - (prefNum[L] * pow10[len]) % MOD
                    + MOD) % MOD;

            long sum = prefSum[R + 1] - prefSum[L];

            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}