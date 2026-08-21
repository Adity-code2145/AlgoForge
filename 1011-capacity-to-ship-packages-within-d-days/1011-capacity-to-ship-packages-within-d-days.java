class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low =0;
        int high = 0;

        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }

        while(low<high){
            int mid = low+ (high-low)/2;
            if(result(weights,days,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private boolean result(int[] weights, int days, int capacity){
        int currWeight = 0;
        int usedDays = 1;

        for(int weight : weights){
            if(currWeight + weight > capacity){
                usedDays++;
                currWeight = weight;
            }else{
                currWeight += weight;
            }
        }
        return usedDays<= days;
    }
}