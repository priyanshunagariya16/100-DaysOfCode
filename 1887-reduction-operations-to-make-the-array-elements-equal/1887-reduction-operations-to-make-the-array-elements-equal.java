class Solution {
    
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int pos = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                pos += 1;
                count += pos;
            }
            else{
                count += pos;
            }    
        }
    return count;
    }
}