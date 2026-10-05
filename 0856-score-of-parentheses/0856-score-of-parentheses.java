class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(0);
            }
            else{
                int curr = st.pop();
                if(curr == 0){
                    st.push(st.pop()+1);
                }else{
                    st.push(st.pop()+2*curr);
                }
            }
        }
        return st.peek();
    }
}