class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            int gcd = 0;
            int lcm = 1;
            int product = 1;
            for(int j = i;j<n;j++){
                product *= nums[j];

                gcd = gcd(gcd,nums[j]);
                lcm = lcm(lcm,nums[j]);
                if(product == gcd*lcm){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
    public int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public int lcm(int a,int b){
        int max = Math.max(a,b);

        while(true){
            if(max%a == 0 && max%b == 0){
                return max;
            }
            max++;
        }
    }
}