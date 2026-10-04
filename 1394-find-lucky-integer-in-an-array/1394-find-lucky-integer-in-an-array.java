class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int max = -1;
        for(int i =0;i<n;i++){
            if(arr[i] == map.get(arr[i])){
                max = Math.max(max,arr[i]);
            }
        }
        return max;
    }
}