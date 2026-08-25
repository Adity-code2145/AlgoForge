class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007;
        
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.size()==0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }

        st.clear();

        for(int i =n-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        long ans = 0;
        for(int i =0;i<n;i++){
            long leftcount = i - pse[i];
            long rightcount = nse[i] -i;
            ans += arr[i] *leftcount*rightcount;
            ans %= mod;
        }
        return (int)ans;
    }
}