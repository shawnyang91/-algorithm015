package com.shumin.algorithm;

/**
 * @description: 判断异位词
 * @author: yangshumin
 * @create: 2020-09-06 23:17
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 范围已知，用数组。
        // 不确定范围用哈希表。
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("anagram","nagaram"));
        System.out.println(anagram.isAnagram("cat","rat"));
    }
}
