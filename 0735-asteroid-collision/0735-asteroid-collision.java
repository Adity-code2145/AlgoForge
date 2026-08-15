class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int arr : asteroids){
            boolean destroyed = false;
            while(st.size()>0 && st.peek()>0 && arr<0){
                if(st.peek() < -arr){
                    st.pop();
                }
                else if(st.peek() == -arr){
                    st.pop();
                    destroyed = true;
                    break;
                }
                else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                    st.push(arr);
            }
        }
        int[] adi = new int[st.size()];
        for(int i=0;i<adi.length;i++){
            adi[i] = st.get(i);
        }
        return adi;
    }
}