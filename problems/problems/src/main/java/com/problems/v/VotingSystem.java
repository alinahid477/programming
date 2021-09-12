package com.problems.v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class VotingSystem {

    public void printWinner(List<Vote> votes, List<String> candidates) {
        System.out.println(this.findAVWinner(votes,candidates));
    }
    
    public String findAVWinner(List<Vote> votes, List<String> candidates) {
        List<Vote> validatedVotes = new ArrayList<>();
        for(Vote v:votes) {
            if(this.validateVote(v, candidates)) {
                validatedVotes.add(v);
            }
        }
        return this.getAVWinner(votes);
    }

    public String getAVWinner(List<Vote> votes) {
        
        List<String> votedCandidates = this.getVotes(votes);
        Map<String, Integer> countedByCandidates = new HashMap<>();
        int voteSize =votes.size();
        this.findCount(votedCandidates, countedByCandidates, true);
        LinkedHashMap<String, Integer> sortedByAsc = new LinkedHashMap<>();
            countedByCandidates.entrySet().stream().sorted(Map.Entry.comparingByValue())
            .forEach(x->sortedByAsc.put(x.getKey(), x.getValue()));

        
        for(String leastVotedCandidate: sortedByAsc.keySet()) {
            LinkedHashMap<String, Integer> sortedByDesc = new LinkedHashMap<>();
            countedByCandidates.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
            .forEach(x->sortedByDesc.put(x.getKey(), x.getValue()));
            if(((Integer)sortedByDesc.values().toArray()[0] + 1) > voteSize/2) {
                return (String)sortedByDesc.keySet().toArray()[0];
            }
            this.distributeVotes(votes, countedByCandidates, leastVotedCandidate);
            countedByCandidates.remove(leastVotedCandidate);
        }
        

        return (String)countedByCandidates.keySet().toArray()[0];
    }

    public void distributeVotes(List<Vote> votes, Map<String, Integer> countedByCandidates, String leastVotedCandidate) {
        List<String> candidates = new ArrayList<>();
        List<Vote> removed = new ArrayList<>();
        for(Vote v: votes) {
            if(v.getLastCandidate().equals(leastVotedCandidate)) {
                candidates.addAll(v.getAllOtherCandidates());
                removed.add(v);
            }
        }
        if(!candidates.isEmpty()) {
            this.findCount(candidates, countedByCandidates, false);   
        }
        votes.removeAll(removed);
    }


    public List<String> getVotes(List<Vote> votes) {
        List<String> candidates = new ArrayList<>();
        for(Vote v:votes) {
            candidates.add(v.getCandidate());
        }
        return candidates;
    }

    public void findCount(List<String> votedCandidates, Map<String, Integer> candidateVoteCount, boolean isInit) {
        for(String s: votedCandidates) {
            if(candidateVoteCount.containsKey(s)) {
                int vote = candidateVoteCount.get(s) + 1;
                candidateVoteCount.put(s, vote);                
            } else if(isInit){
                candidateVoteCount.put(s, 1);
            }
        }
    }

    public boolean validateVote(Vote vote, List<String> candidates) {
        
        return candidates.stream().anyMatch(s->vote.candidateInOrder.contains(s));
    }


    public void findWinner(List<String> candidates) {
        System.out.println(Arrays.toString(this.getWinner(candidates).toArray()));
    }

    public List<String> getWinner(List<String> candidates) {
        if(candidates.isEmpty()) {
            return null;
        }
        Map<String, Integer> candidateVoteCount = new HashMap<>();
        int maxValue = Integer.MIN_VALUE;
        List<String> winners = new ArrayList<>();
        for(String s: candidates) {
            if(candidateVoteCount.containsKey(s)) {
                int vote = candidateVoteCount.get(s) + 1;
                candidateVoteCount.put(s, vote);
                if(maxValue <= vote) {
                    if(maxValue != vote) {
                        winners.clear();
                    }
                    maxValue = vote;
                    winners.add(s);
                }
            } else {
                candidateVoteCount.put(s, 1);
            }
        }

        return winners;
    }
}