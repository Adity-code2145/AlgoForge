class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        print(arr,ans,0);
        return ans;
    }
    public void print(int[] arr,List<List<Integer>> ans, int idx){

        if(idx==arr.length){
            List<Integer> l = new ArrayList<>();
            for(int i =0;i<arr.length;i++){
                l.add(arr[i]);
            }
            ans.add(l);
        }

        for(int i =idx;i<arr.length;i++){
            swap(i,idx,arr);
            print(arr,ans,idx+1);
            swap(i,idx,arr);
        }
    }
    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}