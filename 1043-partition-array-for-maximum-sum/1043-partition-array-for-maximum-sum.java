class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int maxVal = 0;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                maxHeap.offer(arr[i - j + 1]);
                maxVal = maxHeap.peek();
                dp[i] = Math.max(dp[i], (i - j >= 0 ? dp[i - j] : 0) + maxVal * j);
            }
        }

        return dp[n - 1];
    }
}