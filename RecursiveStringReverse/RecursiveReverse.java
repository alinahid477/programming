import java.util.Arrays;

public class RecursiveReverse {

    


    public static void main(String[] argv) {
        System.out.println(new RecursiveReverse().reverseRecursion("This is a recursions."));
        System.out.println("");
        System.out.println(new RecursiveReverse().reverseLoop("This is a recursion."));
        char[] arr = new char[] {'h','e','l','l','o'};
        arr = new RecursiveReverse().reverseRecursionArr(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        
    }

    private String reverseRecursion(String str) {
        if(str.isEmpty() || str==null) {
            return str;
        }
        
        return reverseRecursion(str.substring(1)) + str.charAt(0);
    }

    private char[] reverseRecursionArr(char[] s, int start, int end) {
        if(s == null || start >= end ) {
            return s;
        }
        char tmp = s[end];
        s[end] = s[start];
        s[start] = tmp;
        return reverseRecursionArr(s, start+1, end-1); 
    }

    private String reverseLoop(String str) {
        char[] newStr = str.toCharArray();
        
        for(int i=0; i<str.length()/2; i++) {
            char tmp = newStr[i];
            newStr[i] = newStr[str.length()-1-i];
            newStr[str.length()-1-i] = tmp;
        }
        return new String(newStr);
    }

    
}