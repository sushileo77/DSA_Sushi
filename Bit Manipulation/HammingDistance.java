/*

	LC : 461 Hamming Distance
	
	The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

	Given two integers x and y, return the Hamming distance between them.

	Time complexity  : O(1)
	Space complexity : O(1)


	Idea : Take XOR between the two and then use Brian Kernighan Algo to count number of bits

*/

public int hammingDistance(int x, int y) { 
	int xor = x^y
	int distance = 0;
	
	while(xor != 0){ 
		distance+=1;
		xor = xor&(xor-1);	
	}

	return distance;
}