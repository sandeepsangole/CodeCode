package favourites;

import java.util.*;

/*

LeetCode – Meeting Rooms (Java)

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings. For example, Given [[0, 30],[5, 10],[15, 20]], return false.
Java Solution

If a person can attend all meetings, there must not be any overlaps between any meetings.
After sorting the intervals, we can compare the current end and next start.

 */
public class MeetingRoomI {

	public static void main(String[] args) {

		Intervals intervals1 = new Intervals(8,10);
		Intervals intervals2 = new Intervals(7,13);
		Intervals intervals3 = new Intervals(12,14);


		Intervals[] intervals = new Intervals[3];
		intervals[ 0 ] = intervals1;
		intervals[ 1 ] = intervals2;
		intervals[ 2 ] = intervals3;

		System.out.println(canAttendAllMeetings(intervals));
		System.out.println(canAttendAllMeetingsDelete(intervals));
		System.out.println(countOfMeetingRoomsRequired(intervals));
	}

	public static boolean canAttendAllMeetingsDelete(Intervals[] intervals){

		Arrays.sort(intervals, (Intervals i1 , Intervals i2) -> i1.startTime - i2.startTime);

		for (int i = 0;i<intervals.length;i++){
			if(i != 0 && intervals[i-1].startTime >= intervals[i].endTime){
				return false;
			}
		}
		return true;
	}

	/*
		7 - 8
		8 - 19
		11 - 14

		queue - 10
		      - 11
		        14
	 */
	public static int countOfMeetingRoomsRequired(Intervals[] intervals) {

		//Sort intervals

		//Add to Priority Queue only end time of First interval

		//Loop though intervals from 1

		//compare startime with queue end time if overlap incrase count and add to queue
		//else just add to queue

		Arrays.sort(intervals , (Intervals i1 , Intervals i2)-> i1.startTime - i2.startTime);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(intervals[0].endTime);

		int count = 1;
		for(int i =1;i<intervals.length;i++){

			if(intervals[i].startTime < pq.peek()){
				count++;
			} else {
				pq.poll();
			}

			pq.offer(intervals[i].endTime);
		}

		return count;
	}

	public static boolean canAttendAllMeetings(Intervals[] intervals){


		Arrays.sort(intervals , (Intervals i1 , Intervals i2) -> i1.startTime - i2.startTime);

		int endTime = intervals[0].endTime;
		for (int i = 1;i <intervals.length;i++){
			if(endTime > intervals[i].startTime){
				return false;
			}
			endTime = intervals[i].endTime;
		}

		return true;



	}

	private static void print(Intervals[] intervals) {
		for(Intervals i : intervals){
			System.out.println(i.startTime +" "+i.endTime);
		}
	}
}


