package com.ArrayIndexEq;

import java.io.*;
import java.util.*;

class Solution {

    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here
        if (arr[0] == 0) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid == arr[mid]) {
                return mid;
            } else if (start == arr[start]) {
                return start;
            } else if (end == arr[end]) {
                return end;
            }

            if (arr[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
