class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int z =0;
        int[] ans = new int[n-k+1];
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        nge[n-1] = n;
        st.push(n-1);
        for(int i =n-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.size()==0) nge[i] = n;
            else nge[i] = st.peek();
            st.push(i);
        }
        int j =0;
        for(int i =0;i<n-k+1;i++){
            if(j>=i+k) j =i;
            int max = arr[j];
            while(j<i+k){
                max = arr[j];
                j = nge[j];
            }
            ans[z++] = max;
        }
        return ans;
    }
}