class Solution {
    public int[] findArray(int[] pref) {
        int prev = 0, temp = 0;
        for(int i = 0; i < pref.length; i++){
            temp = pref[i];
            pref[i] = prev ^ pref[i];
            prev = temp;
        }
        return pref;
    }

}