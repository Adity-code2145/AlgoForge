class Solution {
    class Pair {
        TreeNode node;
        long index;
        Pair(TreeNode node, long index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        long maxwidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            long first = q.peek().index;
            long last = first;
            for(int i = 0;i<size;i++){
                Pair curr = q.poll();
                last = curr.index;

                if(curr.node.left!= null){
                    q.offer(new Pair(curr.node.left,2*curr.index));
                }

                if(curr.node.right!=null){
                    q.offer(new Pair(curr.node.right,2*curr.index+1));
                }
            }
            maxwidth = Math.max(maxwidth,last-first+1);
        }
        return (int)maxwidth;
    }
}