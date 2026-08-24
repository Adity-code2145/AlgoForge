class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\s+");
        int left =0;
        int high = words.length-1;
        while(left<high){
        String temp = words[left];
        words[left] = words[high];
        words[high] = temp;
        left++;
        high--;
        }
        return String.join(" ", words);
    }
}