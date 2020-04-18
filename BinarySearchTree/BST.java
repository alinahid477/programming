import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BST {
    
    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode head = bst.insertValue(null, 20);
        head = bst.insertValue(head, 15);
        head = bst.insertValue(head, 30);
        head = bst.insertValue(head, 21);
        head = bst.insertValue(head, 31);
        head = bst.insertValue(head, 10);
        head = bst.insertValue(head, 16);
        head = bst.insertValue(head, 9);
        head = bst.insertValue(head, 11);
        head = bst.insertValue(head, 18);
        head = bst.insertValue(head, 19);
        int height = bst.maxDepth(head);
        System.out.println(height);
        bst.prettyPrintTree(head);
    }

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

    public TreeNode insertValue(TreeNode head, int newVal) {
        Map<String, TreeNode> pos =  this.getInsertPosition(head, newVal);
        if(pos != null) {
            TreeNode newNode = new TreeNode(newVal);
            if(pos.containsKey("LEFT")) {
                pos.get("LEFT").left = newNode;            
            } else {
                pos.get("RIGHT").right = newNode;
            }
        } else {
            head = new TreeNode(newVal);
        }
        return head;
    }
    
    public int maxDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int lDepth = this.maxDepth(node.left);
        lDepth += 1;
        int rDepth = this.maxDepth(node.right);
        rDepth += 1;

        int max = Math.max(lDepth, rDepth);
        return max;
    }

    public int maxSpan(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int max = 1;
        if(node == null) {
            return max;
        }
        q.add(node);
        
        while(!q.isEmpty()) {
            TreeNode tn = q.remove();
            if(tn.left != null) {
                q.add(tn.left);
            }
            if(tn.right != null) {
                q.add(tn.right);
            }
            max = Math.max(q.size(), max);
        }
        return max;
    }
    
    public void prettyPrintTree(TreeNode node) {
        int[][] treeInArr = this.getPrintArr(node);
        for(int i=0; i<treeInArr.length; i++) {
            System.out.println();
            for(int j=0;j<treeInArr[0].length; j++) {
                if(treeInArr[i][j] > 0) {
                    System.out.print(treeInArr[i][j]);
                }
                else {
                    System.out.print("_");
                }                     
            }
        }
    }

    public int[][] getPrintArr(TreeNode node) {
        int level = 0;
        int height = this.maxDepth(node);
        int maxPossibleWidth = (int)Math.pow(2, height);
        int[][] printArr = new int[height][maxPossibleWidth];

        boolean isFirstElement = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(level < height) {
            int totalElementsAtThisLevel = q.size();
            int qsize = q.size();
            level += 1;
            isFirstElement = true;
            while(totalElementsAtThisLevel > 0) {
                totalElementsAtThisLevel -= 1;
                TreeNode tn = q.remove();
                int indent = ((int)Math.pow(2, height-level));
                if(isFirstElement) {
                    isFirstElement = false;
                    printArr[level-1][indent -1] = tn == null? -1 : tn.val;                    
                } else {
                    int gap = ((int)Math.pow(2, height-level+1));
                    gap = gap * (qsize - totalElementsAtThisLevel);
                    printArr[level-1][indent+gap-1] = tn == null? -1 : tn.val;
                } 
                if (tn != null) {
                    q.add(tn.left);
                    q.add(tn.right);
                } 
                             
            }
        }



        return printArr;
    }
}