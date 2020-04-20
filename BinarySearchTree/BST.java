import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BST {
    
    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode head = null;
        int[] vals1 = {20,15,30,21,31,10,16,9,11,18,19};
        for(int i=0; i< vals1.length; i++) {
            head = bst.insertValue(head, vals1[i]);
        }
        int height = bst.maxDepth(head);
        System.out.println(height);
        bst.prettyPrintTree(head);


        int[] vals2 = {5,3,6,2,4};
        head = null;
        for(int i=0; i< vals2.length; i++) {
            head = bst.insertValue(head, vals2[i]);
        }
        int maxWidthIncludingNull = bst.maxWidthIncludingNull(head);
        System.out.println(maxWidthIncludingNull);
    }

    public int[] searchNode(TreeNode head, int val) {
        TreeNode node = this.findNode(head, val);
        if(node == null) {
            return new int[0];
        }
        Map<Integer,Integer> treeMap = new HashMap<>();
        this.getSubtree(node, treeMap, 0);
        int[] treeInArr = new int[treeMap.size()];
        for(int i=0; i<treeInArr.length; i++) {
            treeInArr[i] = treeMap.get(i);
        }
        return treeInArr;    
    }

    public TreeNode findNode(TreeNode head, int val) {
        if(head == null) {
            return null;
        } else if(head.val == val) {
            return head;
        }
        TreeNode node = findNode(head.left, val);
        if(node == null) {
            node = findNode(head.right, val);
        }
        return node;
    }

    public void getSubtree(TreeNode node, Map<Integer, Integer> treeMap, int position) {
        if(node == null) {
            return;
        }
        treeMap.put(position, node.val);
        getSubtree(node.left, treeMap, position*2);
        getSubtree(node.right, treeMap, position*2 + 1);
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

    public int maxWidthIncludingNull(TreeNode node) {
        Map<Integer, Integer> leftmostPositionAtLevel = new HashMap<>();
        int width = 0;
        getMaxWidthIncludingNull(node, 0, 1, width, leftmostPositionAtLevel);
        return width;
    }

    public void getMaxWidthIncludingNull(TreeNode node, int level, int position, int width, Map<Integer, Integer> leftmostPositionAtLevel) {
        if(node == null) {
            return;
        }
        leftmostPositionAtLevel.computeIfAbsent(level, x->position);
        width = Math.max(width, position - leftmostPositionAtLevel.get(level) );
        this.getMaxWidthIncludingNull(node.left, level+1, position * 2, width, leftmostPositionAtLevel);
        this.getMaxWidthIncludingNull(node.right, level+1, position * 2 + 1, width, leftmostPositionAtLevel);
    }

    public int[][] getPrintArr(TreeNode node) {
        int level = 0;
        int height = this.maxDepth(node);
        int maxPossibleWidth = (int)Math.pow(2, height);
        int[][] printArr = new int[height][maxPossibleWidth];
        int gapCount = 0;
        boolean isFirstElement = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(level < height) {
            int totalElementsAtThisLevel = q.size();
            //int qsize = q.size();
            level += 1;
            isFirstElement = true;
            gapCount=0;
            while(totalElementsAtThisLevel > 0) {
                totalElementsAtThisLevel -= 1;
                TreeNode tn = q.remove();
                int indent = ((int)Math.pow(2, height-level));
                if(isFirstElement) {
                    isFirstElement = false;
                    printArr[level-1][indent -1] = tn == null? -1 : tn.val;                    
                } else {
                    gapCount+=1;
                    int gap = ((int)Math.pow(2, height-level+1)) * gapCount;
                    //gap = gap * (qsize - totalElementsAtThisLevel);
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