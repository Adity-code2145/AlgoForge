class Solution {
    public int findPairs(int[] nums, int k) {
       HashSet<Integer> set = new HashSet<>();
       HashSet<Integer> ans = new HashSet<>();

       for(int x : nums){
        if(set.contains(x-k)){
            ans.add(x-k);
        }
        if(set.contains(x+k)){
            ans.add(x);
        }
        set.add(x);
       }
       return ans.size();
    }
}