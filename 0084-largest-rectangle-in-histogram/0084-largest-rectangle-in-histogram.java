class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        nse[n-1] = n;
        st.push(n-1);
        for(int i= n-2;i>=0;i--){
            while(!st.isEmpty() && h[i] <= h[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        Stack<Integer> ts = new Stack<>();
        pse[0] = -1;
        ts.push(0);
        for(int i =0;i<n;i++){
            while(ts.isEmpty() && h[i] <= h[ts.peek()]){
                ts.pop();
            }
            if(ts.isEmpty()) pse[i] = n;
            else pse[i] = ts.peek();
            ts.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int sum = h[i]*(nse[i]-pse[i]+1);
            max = Math.max(max,sum);
        }
        return max;
    }
}