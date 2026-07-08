class Solution {
    /**
     * Filters and sorts restaurants based on given criteria.
     * 
     * @param restaurants    2D array where each row contains [id, rating, veganFriendly, price, distance]
     * @param veganFriendly  1 if only vegan-friendly restaurants should be included, 0 otherwise
     * @param maxPrice       Maximum acceptable price
     * @param maxDistance    Maximum acceptable distance
     * @return List of restaurant IDs sorted by rating (descending) then by ID (descending)
     */
    public List<Integer> filterRestaurants(
            int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
      
        // Sort restaurants by rating (descending), then by ID (descending) if ratings are equal
        Arrays.sort(restaurants, (restaurantA, restaurantB) -> {
            // Compare by rating first (index 1)
            if (restaurantA[1] == restaurantB[1]) {
                // If ratings are equal, sort by ID in descending order (index 0)
                return restaurantB[0] - restaurantA[0];
            }
            // Sort by rating in descending order
            return restaurantB[1] - restaurantA[1];
        });
      
        // Initialize result list to store filtered restaurant IDs
        List<Integer> filteredRestaurantIds = new ArrayList<>();
      
        // Iterate through sorted restaurants and apply filters
        for (int[] restaurant : restaurants) {
            int id = restaurant[0];
            int rating = restaurant[1];
            int isVeganFriendly = restaurant[2];
            int price = restaurant[3];
            int distance = restaurant[4];
          
            // Check if restaurant meets all filtering criteria
            boolean meetsVeganRequirement = isVeganFriendly >= veganFriendly;
            boolean withinPriceRange = price <= maxPrice;
            boolean withinDistance = distance <= maxDistance;
          
            if (meetsVeganRequirement && withinPriceRange && withinDistance) {
                filteredRestaurantIds.add(id);
            }
        }
      
        return filteredRestaurantIds;
    }
}
