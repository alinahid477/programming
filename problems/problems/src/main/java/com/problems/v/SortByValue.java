package com.problems.v;

public class SortByValue implements java.util.Comparator<Integer>{

    @Override
    public int compare(Integer v1, Integer v2) {
        return v1-v2;
    }
}