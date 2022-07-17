/*
	LC : 338
	Counting Bits
	
	Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.


*/

public int[] countBits(int n) { 
	int[] ans = new int[n+1];
	
	for(int x =0; x<=n; x++){
		ans[x] = popCount(x);
	}

	return ans;
}

private int popCount(int x) {
	int count = 0;
	while(x!=0) {
		x&=x-1; // flip least significant bit, unless there are no more 1 bit left
		count++;
	}

	return count;
}