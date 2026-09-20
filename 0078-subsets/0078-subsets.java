class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        print(curr,nums,ans,0);
        return ans;
    }
    public void print(List<Integer> curr, int[] nums, List<List<Integer>> ans, int idx){
        if(idx == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        print(curr,nums,ans,idx+1);
        curr.remove(curr.size()-1);
        print(curr,nums,ans,idx+1);
    }
}