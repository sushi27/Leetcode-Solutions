package challenges.Problem703;

import java.util.PriorityQueue;

class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums) {
            pq.add(num);
        }
    }

    public int add(int val) {
        pq.add(val);
        while(pq.size() != k) pq.poll();
        return pq.peek();
    }
}
public class Solution {
    public static void main(String[] args) {
        KthLargest ob = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(ob.add(3));
        System.out.println(ob.add(5));
        System.out.println(ob.add(10));
        System.out.println(ob.add(9));
        System.out.println(ob.add(4));
    }
}
