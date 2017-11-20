package miles;

import java.util.ArrayList;

public class FindPath {

    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return null;
        deepSerach(root,target);
        return paths;
    }

    public void deepSerach(TreeNode root,int target){
        path.add(root.val);
        target = target - root.val;
        if (target == 0)
            paths.add(path);
        if (root.left!=null){
            deepSerach(root.left,target);
            target += path.remove(path.size()-1);
        }
        if (root.right!=null){
            deepSerach(root.right,target);
            target += path.remove(path.size()-1);
        }
    }

    public TreeNode createTree(int[] array,int index){
        if (index >= array.length)
            return null;
        TreeNode node = new TreeNode(array[index]);
        node.left = createTree(array,index+1);
        node.right = createTree(array,index+2);
        return node;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
