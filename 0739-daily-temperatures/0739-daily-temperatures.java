class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
               st.pop();
            }
            if(!st.isEmpty()){
                nge[i] = st.peek()-i;
            }
            st.push(i);
        }
        return nge;
    }
}