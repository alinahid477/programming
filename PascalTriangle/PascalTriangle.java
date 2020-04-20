import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {

    public static void main(String[] argv) {
        System.out.println(Arrays.toString((new PascalTriangle()).getRow(32).toArray()));
        System.out.println(Arrays.toString((new PascalTriangle()).getRowTriangle(5).toArray()));
    }


    public List<Integer> getRowTriangle(int rowIndex) {
        return this.getTriangle(rowIndex).get(rowIndex-1);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<>();
        Map<String,Integer> mem = new HashMap<>();
        int row = rowIndex + 1;
        for(int col=1;col<=row;col++) {
            int val = this.getVal2(row, col, mem);
            l.add(val);
        }
        return l;
    }


    public int getVal2(int row, int col, Map<String, Integer> mem) {
        if(col == 1 || row==col) {
            return 1;
        } else if(col == 2 || row - col == 1) {
            return row-1;
        } 
        if(mem.containsKey(row+"+"+col)) {
                return mem.get(row+"+"+col );
        }
        
        int val1 = getVal2(row-1, col-1, mem);
        int val2 = getVal2(row-1, col, mem);
        int val = val1+val2;
        mem.put(row+"+"+col, val);
        
        return val;
    }


    public int getVal(int row, int col, Map<String, Integer> mem) {
        if(col == 1 || row==col) {
            return 1;
        } else if(col == 2 || row - col == 1) {
            return row-1;
        } 
        if(col > row/2) {
            if(mem.containsKey(row+"+"+(row-col + 1))) {
                return mem.get(row+"+"+(row-col + 1) );
            }
        } else {
            if(mem.containsKey(row+"+"+col)) {
                return mem.get(row+"+"+col);
            }
        }
        int val1 = getVal(row-1, col-1, mem);
        int val2 = getVal(row-1, col, mem);
        int val = val1+val2;
        if(col > row/2) {
            if(!mem.containsKey(row+"+"+(row-col + 1))) {
                mem.put(row+"+"+(row-col + 1),val );
            }
        } else {
            if(!mem.containsKey(row+"+"+col)) {
                mem.put(row+"+"+col, val);
            }
        }
        
        
        return val;
    }

    public List<List<Integer>> getTriangle(int row) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        
        for(int i=1; i<row; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            

            // do calculate
            if(i > 1) {
                List<Integer> prevRow = triangle.get(i-1);
                for(int j=1; j<i; j++) {
                    currentRow.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }            
            currentRow.add(1);
            triangle.add(currentRow);
        }
        return triangle;
    }
}