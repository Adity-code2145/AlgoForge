class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }
     public int atMost(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right = 0;right<n;right++){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            while(map.size()>k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}