class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[]finalAns = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>();
        //Keep storing the index of the temperature till you find a larger temperature.
        //If you find larger temperature than the previous recently stored temperature, update the finalAns array by the difference of the indexes.
        for(int i=0; i<temperatures.length; i++){
            while(!stk.isEmpty() && temperatures[stk.peek()]< temperatures[i]){
                finalAns[stk.peek()] = i-stk.peek();
                stk.pop();
            }
            stk.push(i);
        }
        return finalAns;
    }
}