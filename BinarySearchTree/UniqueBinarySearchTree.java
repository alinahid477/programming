import java.util.ArrayList;
import java.util.List;


public class UniqueBinarySearchTree {

    

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        return genTrees(1, n);
                
    }

    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> genTree = new ArrayList<>();
        if(start > end) {
            genTree.add(null);
            return genTree;
        }

        for(int i=start; i<=end; i++) {
            List<TreeNode> leftTree = genTrees(start, i - 1);
            List<TreeNode> rightTree = genTrees(i + 1, end);
            for(TreeNode left: leftTree) {
                for(TreeNode right: rightTree) {
                    TreeNode tn = new TreeNode(i);
                    tn.left = left;
                    tn.right = right;
                    genTree.add(tn);
                }
            }
        }
        return genTree;
    }

}