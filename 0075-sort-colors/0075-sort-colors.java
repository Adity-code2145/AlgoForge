class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(mid<=right){
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[left];
                arr[left] = temp;
                left++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[right];
                arr[right] = temp;
                right--;
            }
        }
    }
}