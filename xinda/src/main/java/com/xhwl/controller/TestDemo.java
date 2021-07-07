package com.xhwl.controller;

import javax.lang.model.element.VariableElement;

/**
 * @program: xinda
 * @description: 作者: zhongYB
 * 时间: 2021-06-29 16:08
 */
public class TestDemo {
    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
        String s = method(strs);
        System.out.println(s);

        /*String abc = "([)]";
        boolean valid = isValid(abc);
        System.out.println(valid);*/
        /*int[] arr={0};
        int[] add = add(arr);
        for (int i : add) {
            System.out.println(i);
        }*/

    }

    private static String method(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    public static boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }

    public static int[] add(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += String.valueOf(arr[i]);
        }
        Integer integer = Integer.valueOf(s);

        integer=integer+ 1;

        String s1 = String.valueOf(integer);
        int[] arr1=new int[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            arr1[i]=Integer.parseInt(s1.substring(i,i+1));
        }
        return arr1;
    }
}

