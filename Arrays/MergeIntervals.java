/*
 
 LC # 56 : Merge Intervals
 
 Given an array of intervals where intervals[i] = [starti, endi],
 merge all overlapping intervals, and return an array of the 
 non-overlapping intervals that cover all the intervals in the input.

  Space Complexity : O(N)
  Time Complexity  : O(NlogN)
*/



	 public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        
        for(int[] interval : intervals) {
            if(merged.isEmpty() || (merged.getLast()[1] < interval[0])) {
                merged.add(interval);
            }
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        
        return merged.toArray(new int[merged.size()][]);
    }
}


// Driver program

public int[][] main {
	
	intervals = [[1,3],[2,6],[8,10],[15,18]];
	
	// print Before Merged
	
	merge(intervals)
	
	// print after merging
}