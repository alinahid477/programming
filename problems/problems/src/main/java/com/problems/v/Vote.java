package com.problems.v;

import java.util.List;
import java.util.ArrayList;

public class Vote {
    private final int maxVote = 4;

    private int idx = 0;
    public List<String> candidateInOrder = new ArrayList<>();

    public Vote(String[] candidates) {
        for(int i=0;i<maxVote;i++) {
            candidateInOrder.add(candidates[i]);
        }
        idx = 0;
    }

    public String getCandidate() {
        return candidateInOrder.get(idx++);
    }

    public String peekCandidate() {
        return candidateInOrder.get(idx);
    }

    public String getLastCandidate() {
        return candidateInOrder.get(idx-1);
    }

    public List<String> getAllOtherCandidates() {
        List<String> l = new ArrayList<>();
        for(int i=idx; i<maxVote; i++) {
            l.add(candidateInOrder.get(i));
        }
        return l;
    }
}