class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if(!isvalid(top,ch)){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public boolean isvalid(char top, char ch){
        if(top == '(' && ch ==')'){
            return true;
        }
        if(top == '{' && ch == '}'){
            return true;
        }
        if(top == '[' && ch == ']') {
            return true;
        }
        return false;
    }
}