package favourites;

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

1.sort
2. If end time of current is < next start time add to result
3. else if (end Time of current < end time of next ..then merge
  else go to next interval
 */

import java.util.*;


public class MergeIntervals {

	public static void main(String[] args) {

		Intervals intervals1 = new Intervals(8,10);
		Intervals intervals2 = new Intervals(7,12);
		Intervals intervals3 = new Intervals(10,14);


		Intervals[] intervals = new Intervals[3];
		intervals[ 0 ] = intervals1;
		intervals[ 1 ] = intervals2;
		intervals[ 2 ] = intervals3;

		for(Intervals i : intervals){
			System.out.println(i.startTime +" "+i.endTime);
		}

		mergeIntervals(intervals);

	}

	public static void mergeIntervals(Intervals[] intervals){


		Arrays.sort(intervals , (Intervals i1, Intervals i2)->i1.startTime - i2.startTime);


		int index = 0;

		for (int i  = 0; i<intervals.length  ; i++){

			if(index != 0 && intervals[index - 1].startTime <= intervals[i].endTime){

				while (index != 0 && intervals[index -1].startTime <= intervals[i].endTime) {
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
