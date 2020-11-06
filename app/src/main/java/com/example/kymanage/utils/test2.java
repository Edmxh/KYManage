package com.example.kymanage.utils;

public class test2 {
    public static void main(String[] args) {
        String s1=".*[0-9]{1,}.*";
        String s2="abc1";
        System.out.println(s2.matches(s1));
    }
}
