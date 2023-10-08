class Solution {
     public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length+1][nums2.length+1];
        for(int i = 0; i<=nums1.length; i++) dp[i][0] = -1001;
        for(int i = 0; i<=nums2.length; i++) dp[0][i] = -1001;
        dp[0][0] = 0;
        for(int i = 1; i<=nums1.length; i++) {
            for(int j = 1; j<=nums2.length; j++) {
                dp[i][j] = Math.max(nums1[i-1]*nums2[j-1] + Math.max(dp[i-1][j-1], 0), 
                    Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[nums1.length][nums2.length];
    }
}