class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(list.size(), val);
        
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int lastElement = list.get(list.size() - 1);
        int Idx = map.get(val);
        
        
        list.set(Idx, lastElement); // uset : < Set > and not Add < Keep in mind > Set in Java ArrayList is used to replace an existing element at index with a new element
        map.put(lastElement, Idx); // you need to update the index of the last element after swapping
        
        list.remove(list.size() - 1);
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
