class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        // Arrays.fill(nge,-1);
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && arr[i]> arr[st.peek()]){
                int prev = st.pop();
                nge[prev] = i-prev;
            }
            
            st.push(i);
        }
        return nge;
    }
}