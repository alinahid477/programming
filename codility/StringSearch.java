

public class StringSearch {


    public boolean isVowel(char c) {
        return (c+"").matches("[a,e,i,o,u]");
    }

    public char solution(String s) {

        
        s=s.replaceAll("[^[a-z]]", "");

        int[] charMap = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            charMap[s.charAt(i)-'a']++;
            if(charMap[s.charAt(i)-'a'] == 3) {
                return s.charAt(i);
            } else if(charMap[s.charAt(i)-'a'] == 2 && this.isVowel(s.charAt(i)) && s.charAt(i) !='o' && s.charAt(i) !='e') {
                return s.charAt(i);
            }
        }

        return '.';
    }

    public static void main(String[] argv) {
        //we134lcoommme
        StringSearch ss = new StringSearch();
        ss.solution("we134l@@xxcoommeii");
    }

}

