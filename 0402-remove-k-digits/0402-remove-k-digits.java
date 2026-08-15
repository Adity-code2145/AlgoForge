class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char ch: num.toCharArray()){
            while(st.size()>0 && k>0 && st.peek()> ch){
                st.pop();
                k--;
            }
            st.push(ch);

        }

        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();

        while(st.size()>0){
            ans.append(st.pop());
        }

        ans.reverse();
        // Remove leading zero
        int i = 0;
        while(i < ans.length()-1 && ans.charAt(i) == '0'){
            i++;
        }
        ans = new StringBuilder(ans.substring(i));
        if(ans.length()== 0){
            return "0";
        }
        return ans.toString();
    }
}