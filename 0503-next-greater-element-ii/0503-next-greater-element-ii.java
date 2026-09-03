class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge,-1);
        for(int i =0;i<2*n-1;i++){
            int idx = i%n;
            while(!st.isEmpty() && nums[idx]> nums[st.peek()]){
                nge[st.pop()] = nums[idx];
            }
            if(i<n){
                st.push(idx);
            }
        }
        return nge;
    }
}