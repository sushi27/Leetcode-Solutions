package algorithms.Problem599;

import java.util.*;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> li = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for(int i=0; i<list1.length; i++) {
            map.put(list1[i], i);
        }
        for(int j=0; j<list2.length; j++) {
            if(map.containsKey(list2[j])) {
                int i = map.get(list2[j]);
                if(minIndex == i+j) {
                    li.add(list2[j]);
                }
                else if(i+j < minIndex) {
                    li.clear();
                    li.add(list2[j]);
                    minIndex = i+j;
                }
            }
        }

        return li.toArray(new String[0]);
    }
    public static void main(String[] args) {
        Solution ob = new Solution();
        System.out.println(Arrays.toString(ob.findRestaurant(new String[]{"happy", "sad", "good"}, new String[]{"sad", "happy", "good"})));
    }
}
