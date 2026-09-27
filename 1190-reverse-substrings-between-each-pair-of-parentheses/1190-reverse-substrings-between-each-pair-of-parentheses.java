class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder curr = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(curr.toString());
                curr.setLength(0);
            }
            else if(ch == ')'){
                curr.reverse();
                String prev = st.pop();
                curr.insert(0,prev);
            }
            else{
            curr.append(ch);
            }
        }
        return curr.toString();
    }
}