class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(n==1) return arr[0];
        if(arr[0] !=arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
                return arr[mid];
            }
            int f = mid;
            int s = mid;
            if(arr[mid] == arr[mid-1]) f = mid-1;
            else s = mid+1;
            int leftcount = f-low;
            int rightcount = high - s;
            if(leftcount%2==0) low = s+1;
            else high = f-1;
        }
        return 123;
    }
}