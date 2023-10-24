class Solution {
    public String reverseWords(String s) {
        int n=s.length()-1;
        StringBuilder ans=new StringBuilder("");
        StringBuilder temp=new StringBuilder("");

        for(int i=n;i>=0;i--){
            char ch=s.charAt(i);

            if(ch != ' ')
                temp.append(ch);
            //i==0 condition because we need to include the last word
            if((ch ==' ' || i==0) && temp.length() > 0){
                //word space in the ans
                if(ans.length() > 0)
                    ans.append(" ");
                //reverse because we are reading from last
                temp.reverse();
                ans.append(temp);
                //reset the string
                temp.setLength(0);
            }
        }

        return ans.toString();
       
    }
}