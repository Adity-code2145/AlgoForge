class StockSpanner {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> prices = new ArrayList<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        prices.add(price);
        int i = prices.size()-1;
        while(!st.isEmpty() && prices.get(st.peek()) <= price){
            st.pop();
        }
        int span;
        if(st.isEmpty()){
            span = i + 1;
        } else{
            span = i - st.peek();
        }
        st.push(i);
        return span;
    }
}