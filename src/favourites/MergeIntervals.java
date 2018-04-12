package favourites;

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

1. sort
2. If end time of current is < next start time add to result
3. else if (end Time of current < end time of next ..then merge
  else go to next interval
 */

import java.util.*;


public class MergeIntervals {

	public static void main(String[] args) {

		Intervals intervals1 = new Intervals(10,11);
		Intervals intervals2 = new Intervals(7,12);
		Intervals intervals3 = new Intervals(12,14);

		Intervals[] intervals = new Intervals[3];
		intervals[ 0 ] = intervals1;
		intervals[ 1 ] = intervals2;
		intervals[ 2 ] = intervals3;

		
 
		mergeIntervals(intervals);

		System.out.println();
		List<Intervals> res1 = mergeIntervals1(intervals);
		for (Intervals i : res1) {
			System.out.println(i.startTime + " " + i.endTime);
		}

	}

	public static List<Intervals> mergeIntervals1(Intervals[] intervals){
		
		Arrays.sort(intervals , (i1 , i2)->i1.startTime - i2.startTime);
		List<Intervals> res = new ArrayList<>();
		
		Intervals curr = intervals[0];
		Intervals merged = null;

		for (int i = 1 ;i<intervals.length ; i++){
			if(intervals[i].startTime > curr.endTime){
				res.add(curr);
				curr = intervals[i];
			} else {
				merged = new Intervals(Math.min(curr.startTime,intervals[i].startTime) , 
												Math.max(curr.endTime , intervals[i].endTime));
				curr = merged;
			}
			
		}
		
		res.add(merged);
		return res;
		
	}
	public static void mergeIntervals(Intervals[] intervals){


		Arrays.sort(intervals , (Intervals i1, Intervals i2)->i1.startTime - i2.startTime);


		int index = 0;

		for (int i  = 0; i<intervals.length; i++){

			if(index != 0 && intervals[index - 1].endTime >= intervals[i].startTime){

				while (index != 0 && intervals[index - 1].endTime >= intervals[i].startTime) {
					intervals[ index - 1 ].endTime = Math.max(intervals[ index - 1 ].endTime, intervals[ i ].endTime);
					intervals[ index - 1 ].startTime = Math.min(intervals[ index - 1 ].startTime, intervals[ i ].startTime);
					index--;
				}

			} else {
				intervals[index] = intervals[i];
			}

			index++;
		}

		System.out.println();System.out.println();
		for(int i =0;i<index;i++){
			System.out.println(intervals[i].startTime +" "+intervals[i].endTime);
		}

	}
}
