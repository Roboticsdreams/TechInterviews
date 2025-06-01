package com.rdreams.interviewquest.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
An AWS client wants to deploy multiple applications and needs two servers, one for their frontend and another for 
their backend. They have a list of integers representing the quality of servers in terms of availablity. The client's
preference is that the availability of an application's frontend server must be greater than that of its backend.

Two arrays of same size n, frontend[n] and backend[n] where elements represent the quality of the servers, create 
pairs of elements (frontend[i], backend[i]) such that frontend[i] > backend[i] in each pair. Each element from an
array can be picked only once to from a pair, Find the maximum number of pairs that can be formed.

Example:
Given n=3 frontend = [1,2,3] and backend = [1,2,1] the possible valid pairs which can be made are
(2,1) and (3,1) or (2,1) and (3,2). So it can be seen that a maximum of 2 valid pairs.
 */

public class MaxPairs {
    public int getMaxPairs(Integer[] frontend, Integer[] backend) {
        Arrays.sort(frontend,Collections.reverseOrder());
        Arrays.sort(backend, Collections.reverseOrder());
        int n = frontend.length;
        int i = 0;
        int j = 0;
        List<String> result = new ArrayList<>();
        for(i=0, j = 0; i< n && j < n;){
            if (frontend[i] > backend[j]) {
                result.add(frontend[i]+","+backend[j]);
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return result.size();
    }
}
