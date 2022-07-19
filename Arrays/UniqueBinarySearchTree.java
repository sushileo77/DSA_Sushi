/*


	LC #96 Unique Binary Search Tree
	Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

	Idea : Catalan Numbers

*/

class Solution {
    
    // Catalan number series :  2(2n+1)/(n+2)*C
    
    public int numTrees(int n) {
    
        long C = 1;
        
        
        for(int i =0; i < n; i++) {
            C = C*2*(2*i + 1)/(i+2);
        }
        
        return (int)C;
    }
}
