class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> freq=new HashMap<>();
        int res=0;
        for(int num: nums) {
            int diff=(num-rev(num)), fr;
            freq.put(diff, fr=freq.getOrDefault(diff, 0) + 1);
            res=(int)(((long)res+fr-1)%1000000007);
        }
        return res;
    } 
    int rev(int num) {
        int r=0;
        while(num>0) {
            r=r*10+num%10;
            num/=10;
        }
        return r;
    }
}
