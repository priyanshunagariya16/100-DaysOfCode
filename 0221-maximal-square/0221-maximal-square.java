class Solution {
    public int maximalSquare(char[][] m) {
        int s=Integer.MIN_VALUE;
        int dp[][]=new int[m.length][m[0].length];
        for(int i=m.length-1;i>=0;i--){
            for(int j=m[0].length-1;j>=0;j--){
                if(m[i][j]=='1'){
                    if(i==m.length-1||j==m[0].length-1) {
                        dp[i][j]=1;
                        s=Math.max(s,dp[i][j]);
                    }
                    else{
 dp[i][j]=Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i][j+1]))+1;
 s=Math.max(s,dp[i][j]);
                    }
                }
            }
        }
        return s*s;
    }
}