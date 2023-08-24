package insert_delete_getrandom_O1_380;

import java.util.*;

class RandomizedSet {
    private final HashSet<Integer> set = new HashSet<>();
    private final Random random = new Random();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
            if (set.contains(val)) {
            return false;
        }

        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }

        return false;
    }
    
    public int getRandom() {
        int idx = random.nextInt(set.size());
        ArrayList<Integer> list = new ArrayList<>(set);
        return list.get(idx);
    }
}