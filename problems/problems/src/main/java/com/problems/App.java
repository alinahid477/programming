package com.problems;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("serial")
    public static void main( String[] args )
    {
        System.out.println( "Going to get winner..." );
        com.problems.v.VotingSystem vs = new com.problems.v.VotingSystem();
        vs.findWinner(new java.util.ArrayList<String>() {{
            add("Batman");
            add("Superman");
            add("Batman");
            add("Wonderwoman");
            add("Superman");
            add("Superman");
        }});
    }
}
