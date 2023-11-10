class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
       Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            adjList.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            adjList.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        int index = 0;
        int start = 0;
        for (int key : adjList.keySet()) {
            if (adjList.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        Set<Integer> visited = new HashSet<>();
        dfs(adjList, start, visited, result, index);

        return result;
    }

    private void dfs(Map<Integer, List<Integer>> adjList, int curr, Set<Integer> visited, int[] result, int index) {
        visited.add(curr);
        result[index] = curr;
        List<Integer> neighbors = adjList.get(curr);
        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(adjList, neighbor, visited, result, index + 1);
            }
        }
    }
}