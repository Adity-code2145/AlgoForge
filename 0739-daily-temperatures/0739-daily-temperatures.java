class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                int prev = st.pop();
                ans[prev] = i-prev;
            }
            st.push(i);
        }
        return ans;
    }
}