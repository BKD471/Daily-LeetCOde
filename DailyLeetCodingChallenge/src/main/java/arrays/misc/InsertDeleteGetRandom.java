package arrays.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RandomizedSet {
    Set<Integer> hash;
    public RandomizedSet() {
        hash=new HashSet<>();
    }

    public boolean insert(int val) {
        return hash.add(val);
    }

    public boolean remove(int val) {
        return hash.remove(val);
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<Integer>(hash);
        int max=hash.size()-1;
        int min=0;
        int randomIndex=min + (int)(Math.random() * ((max - min) + 1));
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class InsertDeleteGetRandom {

}
