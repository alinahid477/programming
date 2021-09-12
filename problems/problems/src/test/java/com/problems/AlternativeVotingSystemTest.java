package com.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.problems.v.Vote;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class AlternativeVotingSystemTest {

    @SuppressWarnings("serial")
    public static Stream<Arguments> dataForFindCount() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(){{add("Batman");add("Superman"); add("Batman");}}, new HashMap<String,Integer>(), true, new HashMap<String,Integer>(){{put("Batman", 2); put("Superman", 1);}}),
                Arguments.of(new ArrayList<String>(){{add("Batman");add("Superman"); add("Batman");}}, new HashMap<String,Integer>(){{put("Batman", 1); put("Superman", 1);}}, false, new HashMap<String,Integer>(){{put("Batman", 3); put("Superman", 2);}})
        );
    }


    @SuppressWarnings("serial")
    public static Stream<Arguments> dataForFindWinner() {
        return Stream.of(
                Arguments.of(new ArrayList<Vote>(){{
                        add(new Vote(new String[]{"Batman","Superman","NormalMan","WonderWoman"})); 
                        add(new Vote(new String[]{"Superman","Flash","Batman","NormalMan"})); 
                        add(new Vote(new String[]{"Flash","Superman","NormalMan","WonderWoman"}));
                        add(new Vote(new String[]{"Superman","WonderWoman","NormalMan","Flash"}));
                        add(new Vote(new String[]{"NormalMan","Superman","Batman","WonderWoman"})); 
                        add(new Vote(new String[]{"Batman","Flash","NormalMan","WonderWoman"})); 
                    }} , 
                    "Superman")
        );
    }

    @Disabled
    @ParameterizedTest()
    @MethodSource("dataForFindCount")
    public void findCountTest(List<String> candidates, Map<String,Integer> countByCandidate, boolean isInit, Map<String,Integer> expected) {
        com.problems.v.VotingSystem vs = new com.problems.v.VotingSystem();
        vs.findCount(candidates, countByCandidate, isInit);
        assertEquals(expected.get("Batman"), countByCandidate.get("Batman"));
        assertEquals(expected.get("Superman"), countByCandidate.get("Superman"));
    }

    @ParameterizedTest()
    @MethodSource("dataForFindWinner")
    public void findAVWinnerTest(List<Vote> input, String expected) {
        com.problems.v.VotingSystem vs = new com.problems.v.VotingSystem();
        String winner = vs.getAVWinner(input);
        assertEquals(expected, winner,"PASSED");
    }
}