package com.interview.atls.Voting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VotingSystem {
    
    //[
    // {{"A":"1"},{"B":"2"},{"C":3}},
    // {{"A":"2"},{"B":"1"},{"C":3}},
    // {{"A":"3"},{"B":"2"},{"C":1}},
    // {{"A":"1"},{"B":"2"},{"C":3}},
    // {{"A":"1"},{"B":"3"},{"C":2}}
    //];
    //["A", "B", "A", "C", "D", "B", "A"];

    public enum COMPARE_METHOD {
        lessthan,
        greaterthan
    }

    public String findWinner(List<String> votes) {
        Map<String, Integer> candidates = new HashMap<>();
        
        int max = Integer.MIN_VALUE;
        String candidateName = null;
        for(String c: votes) {
            if(candidates.get(c) == null) {
                candidates.put(c, 0);
            }
            candidates.put(c, candidates.get(c).intValue()+1);
            if(candidates.get(c) > max ) {
                max = candidates.get(c);
                candidateName = c;
            }
        }

        return candidateName;
    }

    public String findWinnerByMostPoint(List<List<Object[][]>> votes) {
        return this.findWinner(votes, Integer.MIN_VALUE, COMPARE_METHOD.greaterthan);
    }

    public String findWinnerByLeastPoint(List<List<Object[][]>> votes) {
        return this.findWinner(votes, Integer.MAX_VALUE, COMPARE_METHOD.lessthan);
    }

    public String findWinner(List<List<Object[][]>> votes, int comparingThreshold, COMPARE_METHOD compareMethod) {
        Map<String, Integer> candidates = new HashMap<>();
        
        boolean is1Place = false;
        
        String winnerName = null;
        for(List<Object[][]> eachVote: votes) {
            is1Place = true;
            for(Object[][] cv: eachVote) {
                String candidateName = (String)cv[0][0];
                int candidatePoint =  is1Place ? 1 : 0; //((Integer)cv[0][1]).intValue();
                if(candidates.get(candidateName) == null) {
                    candidates.put(candidateName, 0);
                }
                candidates.put(candidateName, candidates.get(candidateName).intValue()+candidatePoint);
                if(compareMethod == COMPARE_METHOD.lessthan) {
                    if(candidates.get(candidateName) < comparingThreshold ) {
                        comparingThreshold = candidates.get(candidateName);
                        winnerName = candidateName;
                    }
                } else {
                    if(candidates.get(candidateName) > comparingThreshold ) {
                        comparingThreshold = candidates.get(candidateName);
                        winnerName = candidateName;
                    }
                }
                is1Place = false;
            }
        }
        

        return winnerName;
    }

}