class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int n=envelopes.length;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0; i<n; i++){
            int h=envelopes[i][1];
            if(set.size()==0 || h>set.last()){
                set.add(h);
            }else{
                int replace=set.ceiling(h);
                set.remove(replace);
                set.add(h);
            }
        }
        return set.size();
    }
}