class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0;i<n-2;i++){
            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum<0){
                    left++;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    ans.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;
                    while(left<right && arr[left] == arr[left-1]){
                        left++;
                    }
                    while(left<right && arr[right] == arr[right+1]){
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}