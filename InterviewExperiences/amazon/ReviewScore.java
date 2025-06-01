package com.rdreams.interviewquest.amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
Suppose that Amazon has marked n strings that are prohibited in reviews. 
They assign a score to each review that denotes how well it follows the guidelines. 
The score of a review is defined as the longest contiguous substring of the review which does not contain any string among the list of n prohibited strings. A string contains a prohibited word if it has a contiguous substring that matches a word from the prohibited list, ignoring the case.
Given a review and a list of prohibited strings, calculate the review score.

Example:

review = "GoodProductButScrapAfterWash"
prohibitedWords = ['crap", "odpro"]

Some of the substrings that do not contain a prohibited word are:
• ProductBut
• rapAfterWash
• dProductButScu
• Wash

The longest substring is "dProductButScra", return its length, 15.
*/

public class ReviewScore {

    public int findReviewScore(String review, List<String> prohibitedWords) {
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<review.length();i++) {
            for(int j = i+1; j<= review.length(); j++) {
                String str = review.substring(i,j).toLowerCase();
                if(map.getOrDefault(str, null) == null){
                    map.put(str, str.length());
                }
            }
        }
        List<Map.Entry<String, Integer>> nlist = new ArrayList<>(map.entrySet());
        nlist.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Entry<String, Integer> s: nlist) {
            String key = s.getKey();
            int len = key.length();
            boolean flag = false;
            for(String pw: prohibitedWords) {
                if(key.indexOf(pw.toLowerCase()) != -1) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                max = len;
                break;
            }
        }
        return max;
    }
}