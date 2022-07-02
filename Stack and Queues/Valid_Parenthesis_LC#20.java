class Solution {
    private static final Map<Character, Character> map = Map.of('(',')','[',']','{','}');
    Stack<Character> stack = new Stack<>();
    
    public boolean isValid(String s) {
        for(int i =0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            else {
                if(stack.isEmpty())
                    return false;
                else {
                    Character open = stack.pop();
                    
                    if(map.get(open) != s.charAt(i)){
                        return false;
                    }
                }
            }
            
        }    
        
        return stack.isEmpty();
    }
}