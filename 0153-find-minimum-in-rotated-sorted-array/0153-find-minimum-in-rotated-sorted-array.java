class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low =0;
        int high = n-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid]>arr[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return arr[low];
    }
}