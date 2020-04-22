import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum4 {

    public static void main(String[] argv) {
        TwoSum4 sum = new TwoSum4();
        TreeNode head = null;
        int[] vals1 = {2,3};
        for(int i=0; i< vals1.length; i++) {
            head = BST.insertValue(head, vals1[i]);
        }
        sum.findTarget(head, 6);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        getAllNodes(root, l);
        if(l.size() == 1 && l.get(0) !=k) {
            return false;
        }
        int idx=0;
        for(int i:l) {
            int x = k - i;
            if(l.contains(Integer.valueOf(x))) {
                if(idx != l.indexOf(Integer.valueOf(x))) {
                    return true;
                }
                
            }
            idx++;
        }
        return false;
    }
    
    public void getAllNodes(TreeNode root, List<Integer> l) {
        if(root == null) {
            return;
        }
        getAllNodes(root.left, l);
        l.add(root.val);
        getAllNodes(root.right, l);
        

    }
}