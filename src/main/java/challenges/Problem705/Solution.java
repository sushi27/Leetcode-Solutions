package challenges.Problem705;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    private final List<Integer> set;
    public MyHashSet() {
        set = new ArrayList<>();
    }

    public void add(int key) {
        for (Integer integer : set) {
            if (integer == key) return;
        }
        set.add(key);
    }

    public void remove(int key) {
        for(int i=0; i<set.size(); i++) {
            if(set.get(i) == key) {
                set.remove(i);
                return;
            }
        }
    }

    public boolean contains(int key) {
        for (Integer integer : set) {
            if (integer == key) return true;
        }
        return false;
    }
}
public class Solution {
    public static void main(String[] args) {
        MyHashSet ob = new MyHashSet();
        ob.add(1);
        ob.add(2);
        System.out.println(ob.contains(1));
        System.out.println(ob.contains(3));
        ob.add(2);
        System.out.println(ob.contains(2));
        ob.remove(2);
        System.out.println(ob.contains(2));
    }
}
