class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max=1,anchor=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(nums[i]*(i-anchor+1)-sum >k){
                sum -= nums[anchor];
                anchor++;
            }
            max = Math.max(max, i-anchor+1);
        }
        return max;
    }
}