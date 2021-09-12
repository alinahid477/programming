package com.problems.algos;

public class LookAndSay {


    public void lookNSay(int n) {
        System.out.println(this.findLookAndSay(n));
    }

    public String findLookAndSay(int n) {
        if(n == 0) {
            return "1"; 
        }
        if(n==1) {
            return "11";
        }
        String prevTerm = findLookAndSay(n-1);
        return doLookAndSay(prevTerm);
    }

    public String doLookAndSay(String prevTerm) {
        int sum = 1;
        char ch = prevTerm.charAt(0);
        String currTerm = ch+""; //2
        String totalTerm = "";
        for(int i=1; i< prevTerm.length(); i++) {
            if(ch == prevTerm.charAt(i)) {
                sum++;
            } else {
                currTerm = sum+currTerm;
                totalTerm = totalTerm + currTerm;
                sum = 1;
                ch = prevTerm.charAt(i);
                currTerm = ch+"";
            }
            if(i == prevTerm.length() -1) {
                currTerm = sum+currTerm;
                totalTerm = totalTerm + currTerm;
            }
        }

        return totalTerm;
    }
}