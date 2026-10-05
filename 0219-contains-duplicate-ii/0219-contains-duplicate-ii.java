class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            
            while(i-l>k){
                int comp = nums[l];
                map.put(comp,map.get(comp)-1);
                if(map.get(comp)==0){
                    map.remove(comp);
                }
                l++;
            }
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);  
        }
        return false;
    }
}