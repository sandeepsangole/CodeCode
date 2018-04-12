package favourites;

/*
Problem:

Given a set of non-overlapping & sorted intervals, insert a new interval
into the intervals (merge if necessary).

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 */

import java.util.*;

public class InsertInterval {

	public static void main(String[] args) {
		Intervals it    = new Intervals(1, 3);
		Intervals it1   = new Intervals(6, 9);
		Intervals merge = new Intervals(2, 5);

		Intervals[] itArray = new Intervals[ 2 ];
		itArray[ 0 ] = it;
		itArray[ 1 ] = it1;

		//Case 1. New Interval start end before first one starts . Add new to result
		//Case 2. New interval starts after end of current interval. add current to result
		//CAse 3: Overalap. take min start time and max of end time and set as new inerval.

		List<Intervals> res = insertInterval(itArray, merge);
		for (Intervals i : res) {
			System.out.println(i.startTime + " " + i.endTime);
		}

		System.out.println();
		List<Intervals> res1 = insertInterval1(itArray, merge);
		for (Intervals i : res1) {
			System.out.println(i.startTime + " " + i.endTime);
		}
	}
	
	private static List<Intervals> insertInterval1(Intervals[] arr , Intervals merge){

		List<Intervals> res = new ArrayList<>();
		for (Intervals currInterval : arr){
			
			if(currInterval.endTime < merge.startTime){
				res.add(currInterval);
			} else if(merge.endTime < currInterval.startTime){
				res.add(merge);
				merge = currInterval;
			} else {
				merge.startTime = Math.min(currInterval.startTime , merge.startTime);
				merge.endTime  = Math.max(currInterval.endTime , merge.endTime);
				
			}
		}
		res.add(merge);
		return res;
		
	}
	
	
	
	
	
	
	
	
	

	public static List<Intervals> insertInterval(Intervals[] intervals, Intervals mergeInterval) {

		List<Intervals> result = new ArrayList<>();

		for (Intervals in : intervals) {
			//Merge interval starts after this interval . so add current interval to result
			if (mergeInterval.startTime > in.endTime) {
				result.add(in);
			}
			//Merge interval val ends before next starts. So add merge interval to list , after that its no longer valid
			// so overwrite it with in processed current interval
			else if (mergeInterval.endTime < in.startTime) {
				result.add(mergeInterval);
				mergeInterval = in;
			}
			//If there is overlap then create new interval with min start and max end and insert
			else if (mergeInterval.startTime >= in.startTime || mergeInterval.endTime <= in.endTime) {
				mergeInterval = new Intervals(Math.min(in.startTime, mergeInterval.startTime), Math.max(in.endTime, mergeInterval.endTime));

			}

		}
		result.add(mergeInterval);
		return result;
	}

}
