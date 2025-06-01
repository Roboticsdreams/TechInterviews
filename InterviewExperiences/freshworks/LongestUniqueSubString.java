package com.rdreams.interviewquest.freshworks;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class LongestUniqueSubString {
    public int getMaxUniqueSubStr(String inputString) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = inputString.toCharArray();
        int res = 0;
        int start = 0;
        for(int i=0; i<chars.length;i++){
            if (map.getOrDefault(chars[i],-1) == -1) {
                map.put(chars[i],i);
            }
            else {
                start = map.getOrDefault(chars[i],-1)+1;
                map.put(chars[i],i);
            }
            res = Math.max(res, (i-start+1));
        }
        return res;
    }
}