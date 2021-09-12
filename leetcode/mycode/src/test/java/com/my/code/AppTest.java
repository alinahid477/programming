package com.my.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }


    @Test
    public void testReverseInteger() {
        ReverseInteger rint = new ReverseInteger();
        assertEquals(0, rint.callSolution(-2147483648), "120 reversed to 21");
        assertEquals(-321, rint.callSolution(-123), "-123 reversed to -321");        
    }


    @Test
    public void testIsPalindromInteger() {
        PalindromInteger pint = new PalindromInteger();
        assertEquals(false, pint.callSolution(10), "10 reversed to 01");        
        assertEquals(true, pint.callSolution(121), "121 reversed to 121");
        assertEquals(false, pint.callSolution(-121), "-121 reversed to 121-");
        assertEquals(true, pint.callSolution(2), "2 reversed to 2");        
        
    }

    @Test
    public void testLongestCommongPrefix() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        assertEquals("a", lcp.callSolution(new String[]{"ab","a"}));
        assertEquals("fl", lcp.callSolution( new String[]{"flower","flow","flight"} ));
        assertEquals("", lcp.callSolution(new String[]{"dog","racecar","car"}));
        assertEquals("d", lcp.callSolution(new String[]{"dog","dmx","drag"}));
        assertEquals("dog", lcp.callSolution(new String[]{"dog"}));        
    }

    @Test
    public void testRunningSum() {
        RunningSum1dArray rs = new RunningSum1dArray();
        assertArrayEquals(new int[]{1,3,6,10}, rs.callSolution(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{1,2,3,4,5}, rs.callSolution(new int[]{1,1,1,1,1}));
    }

    @Test
    public void testPlusOne() {
        PlusOne po = new PlusOne();
        assertArrayEquals(new int[]{1}, po.callSolution(new int[]{0}), "0");
        assertArrayEquals(new int[]{1,2,4}, po.callSolution(new int[]{1,2,3}), "123");
        assertArrayEquals(new int[]{1,0,0,0}, po.callSolution(new int[]{9,9,9}), "999");
        assertArrayEquals(new int[]{9,9,0}, po.callSolution(new int[]{9,8,9}), "989"); 
    }

    @Test
    public void testMoveZeros() {
        MoveZeros mz = new MoveZeros();
        int[] nums = new int[] {0,1};
        mz.callSolution(nums);
        assertArrayEquals(new int[]{1,0}, nums, "-1");
        nums = new int[] {2,1};
        mz.callSolution(nums);
        assertArrayEquals(new int[]{2,1}, nums, "0");
        nums = new int[] {0,0,1,0,2};
        mz.callSolution(nums);
        assertArrayEquals(new int[]{1,2,0,0,0}, nums, "1");
        nums = new int[] {0,0,1,0,0};
        mz.callSolution(nums);
        assertArrayEquals(new int[]{1,0,0,0,0}, nums, "2");
        nums = new int[]{2,12,0,3,0,0};
        mz.callSolution(nums);
        assertArrayEquals(new int[]{2,12,3,0,0,0}, nums, "3");
        
    }

    @Test
    public void testFirstUniqueCharacter() {
        FirstUniqueCharacter fuc= new FirstUniqueCharacter();
        assertEquals(0, fuc.callSolution("leetcode"), "leetcode");
        assertEquals(2, fuc.callSolution("loveleetcode"), "loveleetcode");
    }
}
