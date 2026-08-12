class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> rt = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(st.size()==0){
            st.push(x);
        }
        else{
            while(st.size()>0){
                rt.push(st.pop());
            }
            st.push(x);
            while(rt.size()>0){
                st.push(rt.pop());
            }
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        if(st.size()==0) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */