import java.util.HashMap;
import java.util.Map;

public class BST {
    


    public Map<String, TreeNode> getInsertPosition(TreeNode head, int newVal) {
        if(head == null) {
            return null;
        }
        
        if(newVal < head.val) {
            if(head.left == null) {
                Map<String, TreeNode> pos = new HashMap<String, TreeNode>();
                pos.put("LEFT", head); 
                return pos;
            }
            return getInsertPosition(head.left, newVal);
        }

        //if(newVal >= head.val)
        if(head.right == null) {
            Map<String, TreeNode> pos = new HashMap<String, TreeNode>();
            pos.put("RIGHT", head); 
            return pos;
        }

        return getInsertPosition(head.right, newVal);
    }

    public void insertValue(TreeNode head, int newVal) {
        Map<String, TreeNode> pos =  this.getInsertPosition(head, newVal);
        TreeNode newNode = new TreeNode(newVal);
        if(pos.containsKey("LEFT")) {
            pos.get("LEFT").left = newNode;            
        } else {
            pos.get("RIGHT").right = newNode;
        }    
    }
    
    

    public void printTree(TreeNode head) {

        System.out.print(head.val);
    }
}