class Solution {
    public List<String> watchedVideosByFriends(
        List<List<String>> watchedVideos, int[][] friends, int id, int level) {
      
        // Initialize BFS queue and add starting person
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(id);
      
        // Track visited people to avoid cycles
        int totalPeople = friends.length;
        boolean[] visited = new boolean[totalPeople];
        visited[id] = true;
      
        // Perform BFS to find all friends at exactly 'level' distance
        while (level > 0) {
            int currentLevelSize = queue.size();
          
            // Process all people at current level
            for (int i = 0; i < currentLevelSize; i++) {
                int currentPerson = queue.poll();
              
                // Add all unvisited friends of current person to queue
                for (int friend : friends[currentPerson]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }
            level--;
        }
      
        // Count frequency of videos watched by friends at target level
        Map<String, Integer> videoFrequency = new HashMap<>();
        for (int person : queue) {
            for (String video : watchedVideos.get(person)) {
                videoFrequency.merge(video, 1, Integer::sum);
            }
        }
      
        // Create result list from all unique videos
        List<String> result = new ArrayList<>(videoFrequency.keySet());
      
        // Sort by frequency (ascending), then alphabetically for ties
        result.sort((video1, video2) -> {
            int frequency1 = videoFrequency.get(video1);
            int frequency2 = videoFrequency.get(video2);
          
            if (frequency1 == frequency2) {
                return video1.compareTo(video2);  // Alphabetical order for same frequency
            }
            return Integer.compare(frequency1, frequency2);  // Ascending frequency order
        });
      
        return result;
    }
}
