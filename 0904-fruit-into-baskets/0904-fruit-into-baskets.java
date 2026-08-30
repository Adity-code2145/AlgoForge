class Solution {
    public int totalFruit(int[] fruits) {
        int[] freq = new int[1000001];

        int left =0;
        int distinct =0;
        int max = -1;
        for(int right = 0;right<fruits.length;right++){
            if(freq[fruits[right]]==0){
                distinct++;
            }

            freq[fruits[right]]++;

            while(distinct>2){
                freq[fruits[left]]--;

                if(freq[fruits[left]]==0){
                    distinct--;
                }
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}