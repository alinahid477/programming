
public class CSVParser {

    public String[] getCSVValues(String s) {
        String regex = ",(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))";
        return s.split(regex);
    }

    public static void main(String[] argv) {
        String str = "val1, 1, \"some str with single ' quote\", val2, \"some str, with, comma\"";
        
        CSVParser cp = new CSVParser();

        String[] sarr= cp.getCSVValues(str);
        for(String s: sarr) {
            System.out.println(s);    
        }
        
    }

}