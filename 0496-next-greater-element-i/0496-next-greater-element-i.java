class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i = nums2.length-1;i>=0;i--){
            while(st.size()>0 && nums2[i]> st.peek()){
                st.pop();
            }
            if(st.size()==0) map.put(nums2[i],-1);
            else map.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }
        int[] nge = new int[nums1.length];
        for(int i =0;i<nums1.length;i++){
            nge[i] = map.get(nums1[i]);
        }
        return nge;
    }
}