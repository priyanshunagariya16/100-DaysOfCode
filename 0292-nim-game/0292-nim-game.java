class Solution {
    public boolean canWinNim(int n) {
         boolean k=true;
        if(n<4)
        k=true;
        if(n>3)
        {
            if(n%4==0)
            k=false;
            else
            k=true;
        }
        return k;
    }
}