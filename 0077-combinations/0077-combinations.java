class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backtrack(1, n, k, currentList, resultList);
        return resultList;
    }

    private void backtrack(int start, int n, int k, List<Integer> currentList, List<List<Integer>> resultList) {
        if (k == 0) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            currentList.add(i);
            backtrack(i + 1, n, k - 1, currentList, resultList);
            currentList.remove(currentList.size() - 1);
        } 
    }
}