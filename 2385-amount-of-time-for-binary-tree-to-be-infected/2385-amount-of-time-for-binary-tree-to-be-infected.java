/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pair{
        int m,l;
        pair(int m, int l){
            this.m = m;
            this.l = l;
            // this.c = c;
        }
    }
    int x=0;
    public int amountOfTime(TreeNode root, int start) {
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        size(root);
        for(int i=0;i<=x;i++){
            list.add(new ArrayList<>());
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode a=q.poll();
            if(a.left!=null){
                list.get(a.val).add(a.left.val);
                list.get(a.left.val).add(a.val);
                q.offer(a.left);
            }
            if(a.right!=null){
                list.get(a.val).add(a.right.val);
                list.get(a.right.val).add(a.val);
                q.offer(a.right);
            }
        }
        boolean vis[]=new boolean[x+1];
        Queue<pair>queue=new LinkedList<>();
        int t=0;
        queue.offer(new pair(start,t));
        while(!queue.isEmpty()){
            pair p=queue.poll();
            int r=p.m, z=p.l;
            vis[r]=true;
            t=z;
            for(int i=0;i<list.get(r).size();i++){
                if(!vis[list.get(r).get(i)])
                    queue.offer(new pair(list.get(r).get(i),z+1));
            }
        }
        return t;
    }
    public void size(TreeNode root){
        if(root==null){
            return;
        }
        size(root.left);
        x=Math.max(x,root.val);
        size(root.right);
    }
}