class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int sz = cost.length;
        int minCost[] = new int[sz];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for(int indx = 2; indx < sz; indx++){
                minCost[indx] = cost[indx] +  Math.min(minCost[indx - 1], minCost[indx - 2]);
        }
        return Math.min(minCost[sz - 2], minCost[sz - 1]);
    }
}