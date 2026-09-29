class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        long max = 0;
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right =0; right<n;right++){
            sum += arr[right];
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            if(right >= k){
                int leftele = arr[right-k];
                sum -= leftele;
                map.put(leftele,map.get(leftele)-1);
                if(map.get(leftele)==0){
                    map.remove(leftele);
                }
            }
            if(right>=k-1 && map.size()==k){
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}