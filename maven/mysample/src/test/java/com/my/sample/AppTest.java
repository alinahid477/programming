package com.my.sample;

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
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Parameter(value = 0)
    public int[] input;
    @Parameter(value =1)
    public List<String> output;


    @Parameters(name= "{index}: {0}={1}")
    public static Collection<Object[]> prepare() {
        return Arrays.asList(
            new Object[][] {
                {new int[] {0,1}, Arrays.asList("ad", "ae","af", "bd", "be", "bf", "cd", "ce", "cf")}
            }    
        
        );
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        com.my.sample.PhoneNumbers pn = new com.my.sample.PhoneNumbers();
        pn.init();
        List<String> l = pn.gen(input,0,(new char[input.length]), 0,new ArrayList<String>());
        assertEquals(output, l);
    }
}
