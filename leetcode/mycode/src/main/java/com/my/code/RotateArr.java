package com.my.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArr {

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int len = arr.size();
        int[] arr2 = new int[len];
        int idx = 0;
        for (int i = 0; i < len - d; i++) {
            arr2[idx++] = arr.get(d + i);
        }
        for (int i = 0; i < d; i++) {
            arr2[idx++] = arr.get(i);
        }

        return Arrays.stream(arr2).boxed().collect(Collectors.toList());
    }

    public static void main(String[] argv) {
        Integer[] ints = new Integer[] { 1, 2, 3, 4, 5 };
        List<Integer> l = Arrays.asList(ints);

        List<Integer> rotated = rotateLeft(2, l);

    }
}
