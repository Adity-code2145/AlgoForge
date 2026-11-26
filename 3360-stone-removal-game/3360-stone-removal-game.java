class Solution {
    public boolean canAliceWin(int n) {
        int s = n;
        int t = 0;
        int remove = 10;
        while(s>=remove){
            s -= remove;
            remove--;
            t++;
        }
        return t%2 == 1;
    }
}