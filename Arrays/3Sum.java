/*
 Apporach (2)
 No-Sort Apporach 
    
*/


    Idea : <1> We add dups in outter loop to skip duplicates as we have already processed for that nums[i] previously
              
    
    Iead : <2> For every iteration of J,  you are trying to find complement -nums[i] -nums[j].
            Here, i is fixed and you are moving j from i+1 < length
            So, basically you are trying to find nums[i] = -nums[j] -nums[i]
            
            Key Trick is to Store nums[j] in HashMap with index of i, so that we know we are working for that particular index of i
            
            This will change as i changes in outer loop
    
    Idea : <3> Sort the triplet before storing; or else we wil populate results array with same three entries, just in different order
    */
    
    public List<List<Integer>> threeSum(int[] nums) {
     Set<List<Integer>> res = new HashSet<>();
     Set<Integer> dups = new HashSet<>();
        
     Map<Integer, Integer> seen = new HashMap<>();
        
     for(int i =0; i < nums.length; i++){
         if(dups.add(nums[i])){
             for(int j = i+1; j < nums.length; j++){
                 int complement = -nums[i] - nums[j];
                 if(seen.containsKey(complement) && seen.get(complement) == i){
                     List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                     Collections.sort(triplet);
                     res.add(triplet);
                 }
                 seen.put(nums[j],i);
             }
         }
       }
        
        return new ArrayList(res);
        
    }
}