class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        nse[n-1] = n;
        st.push(n-1);
        for(int i =n-2;i>=0;i--){
            while(st.size()>0 && heights[i]<= heights[st.peek()]){
                st.pop();
            }
            if(st.size()==0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        Stack<Integer> ts = new Stack<>();
        ts.push(0);
        pse[0] = -1;
        for(int i =0;i<n;i++){
            while(ts.size()>0 && heights[i]<= heights[ts.peek()]){
                ts.pop();
            }
            if(ts.size()==0) pse[i] = -1;
            else pse[i] = ts.peek();
            ts.push(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int sum = heights[i]*(nse[i]-pse[i]-1);
            max = Math.max(max,sum);
        }
        return max; 
    }
}