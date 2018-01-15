package favourites;

import java.util.Arrays;
import java.util.PriorityQueue;

/*

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
find the minimum number of conference rooms required.

 */
public class MeetingRoomII {

	public static void main(String[] args) {

		Intervals intervals1 = new Intervals(8,10);
		Intervals intervals2 = new Intervals(7,11);
		Intervals intervals3 = new Intervals(10,14);


		Intervals[] intervals = new Intervals[3];
		intervals[ 0 ] = intervals1;
		intervals[ 1 ] = intervals2;
		intervals[ 2 ] = intervals3;

		System.out.println(countOfMeetingRoomsRequired(intervals));
	}

	public static int countOfMeetingRoomsRequired(Intervals[] intervals){

		if(intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals,(Intervals i1, Intervals i2) -> i1.startTime - i2.startTime);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(intervals[0].endTime);
		int count = 1;
		for(int i = 1; i < intervals.length;i++){

			if(intervals[i].startTime < pq.peek()){
				count++;
			} else {
				pq.poll();
			}

			pq.offer(intervals[i].endTime);
		}


		return count;
	}
}
