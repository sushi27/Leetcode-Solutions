package challenges.Problem347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i=0; i<bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        for(int key: map.keySet()) {
            bucket[map.get(key)].add(key);
        }
        List<Integer> li = new ArrayList<>();
        for(int i=bucket.length-1; i>=0; i--) {
            li.addAll(bucket[i]);
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++) {
            ans[i] = li.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution ob = new Solution();
        System.out.println(Arrays.toString(ob.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
