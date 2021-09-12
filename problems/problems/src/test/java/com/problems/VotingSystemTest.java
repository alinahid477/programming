package com.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
/**
 * Unit test for simple App.
 */
@RunWith(Parameterized.class)
public class VotingSystemTest {
    @Parameter(0)
    public List<String> input;
    @Parameter(1)
    public List<String> expected;

    @SuppressWarnings("serial")
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {  
            {new ArrayList<String>(){{add("Batman");add("Superman"); add("Batman");}}, new ArrayList<String>(){{add("Batman");}} }, 
            {(new ArrayList<String>(){{add("Batman");add("Superman"); add("Batman"); add("Superman");}}), (new ArrayList<String>(){{add("Batman");add("Superman");}}) },
        };
        return Arrays.asList(data);
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        com.problems.v.VotingSystem vs = new com.problems.v.VotingSystem();
        assertEquals( expected, vs.getWinner(input) );
    }

}
