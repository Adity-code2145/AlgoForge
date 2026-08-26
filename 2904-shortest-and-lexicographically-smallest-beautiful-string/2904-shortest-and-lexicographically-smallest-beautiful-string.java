class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        ArrayList<Integer> ones = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                ones.add(i);
            }
        }
        if(ones.size()<k){
            return "";
        }
        String ans = "";
        for(int i =0;i+k-1<ones.size();i++){
            int start = ones.get(i);
            int end = ones.get(i+k-1);

            String curr = s.substring(start,end+1);
            if(ans.equals("") || curr.length()< ans.length() || (curr.length() == ans.length() && curr.compareTo(ans)<0)){
                ans = curr;
            }
        }
        return ans;
    }
}