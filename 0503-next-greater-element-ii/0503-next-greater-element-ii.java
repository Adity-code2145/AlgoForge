class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        Arrays.fill(nge,-1);
        for(int i =2*n-1;i>=0;i--){
            int idx = i%n;
            while(!st.isEmpty() && nums[idx] >= st.peek()){
                st.pop();
            }
            if(!st.isEmpty()){
                nge[idx] = st.peek();
            }
            st.push(nums[idx]);
        }
        return nge;
    }
}