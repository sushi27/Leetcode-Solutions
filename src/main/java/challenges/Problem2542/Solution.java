package src.main.java.challenges.Problem2542;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        long kSum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i=0; i<k; i++) {
            kSum += arr[i][0];
            pq.add(arr[i][0]);
        }
        long ans = kSum * arr[k-1][1];
        for(int i=k; i<n; i++) {
            kSum += - pq.poll() + arr[i][0];
            pq.add(arr[i][0]);
            ans = Math.max(ans, kSum*arr[i][1]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution ob = new Solution();
        System.out.println(ob.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
    }
}
