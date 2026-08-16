class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int maxArea = 0;
        for(int i =0;i<rows;i++){
            for(int j =0;j<col;j++){
                if(matrix[i][j]=='1') {
                    heights[j] += 1;
                }else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights){
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        for(int i =0;i<=n;i++){
            int h = (i == n) ? 0 : heights[i];
            while(st.size()>0 && heights[st.peek()]>=h){
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i-st.peek() - 1;
                maxArea = Math.max(maxArea, height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}