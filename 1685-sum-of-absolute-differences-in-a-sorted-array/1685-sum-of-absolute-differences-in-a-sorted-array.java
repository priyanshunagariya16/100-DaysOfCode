class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
          int n = nums.length;

        int ans[] = new int[n];
         
         long totalSum = 0;
        for(int i = 0 ;i < nums.length; i++) totalSum += nums[i];

        long prefix = 0;

        for(int i = 0 ;i < nums.length ; i++) {

            // for left  current elemtn is greater

            long left  = ((i * nums[i]) - prefix );
            
            prefix = prefix + nums[i];

            long suffix = totalSum - prefix;

            long right  = suffix -  ((n - i - 1) * nums[i]);

            int val = (int)left + (int) right;

            ans[i] = val;
        }

        return ans;
    }
}