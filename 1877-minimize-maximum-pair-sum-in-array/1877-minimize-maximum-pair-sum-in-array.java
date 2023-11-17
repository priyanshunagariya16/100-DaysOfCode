class Solution {
public int minPairSum(int[] nums) {
Arrays.sort(nums);
int sum[]= new int[nums.length/2];
int s=0,max=0,j=nums.length-1;
for(int i=0;i<nums.length/2;i++){
s=nums[i]+nums[j--];
if(s>max)
max=s;
}
return max;
}
}