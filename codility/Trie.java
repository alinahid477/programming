
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    Map<Character, Node> item;
    public boolean isEndOfWord;
    
    public Node() {
        item = new HashMap<Character, Node>();
        //this.isEndOfWord = true;
    }
    
    public boolean contains(char c) {
        return this.item.containsKey(c);
    }

    public Node nodeOf(char c) {
        return this.item.get(c);
    }
}

public class Trie {
    
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        
        Node head = root;
        for(int i=0;i<word.length();i++) {
            if(head.contains(word.charAt(i))) {
                head = head.nodeOf(word.charAt(i));
                continue;
            }
            head.item.put(word.charAt(i), new Node());
            if(!head.isEndOfWord)
                head.isEndOfWord = false;
            head = head.nodeOf(word.charAt(i));
        }
        head.isEndOfWord = true;        
    }

    public void find(String str, Node head, List<String> sWords) {
        
        
        if(head.item.isEmpty()) {
            if(head.isEndOfWord) {
                sWords.add(str);
            }
            return;
        }

        String tStr = str;

        for(Character c:head.item.keySet()) {
            tStr += c;
            find(tStr, head.nodeOf(c), sWords);
            tStr = str;
        }
        
    }

    public List<String> search(String word) {
        List<String> sWords = new ArrayList<String>();
        if(word.length() < 3) {
            return sWords;
        }
        int i=0;
        Node head = root;
        for(i=0; i<word.length(); i++) {
            if(head.contains(word.charAt(i))) {
                /*if(head.isEndOfWord) {
                    sWords.add(word.substring(0, i+1));
                }*/
                head = head.nodeOf(word.charAt(i));
                continue;
            }
            break;
        }        
        if(head.isEndOfWord && i == word.length()) {
            sWords.add(word);
        }

        this.find(word, head, sWords);

        return sWords;
    }

    public static void main(String[] argv) {
        
        Trie t = new Trie();

        t.insert("and");
        t.insert("anderson");
        t.insert("andy");
        t.insert("apple");
        t.insert("append");
        t.insert("alphabet");
        t.insert("ball");
        t.insert("ten");
        t.insert("tenth");
        


        List<String> result = new ArrayList<String>();
        result.addAll(t.search("and"));
        result.addAll(t.search("app"));
        result.addAll(t.search("bal"));
        result.addAll(t.search("ten"));

        for(String s: result) {
            System.out.println(s);
        }
    }
}

