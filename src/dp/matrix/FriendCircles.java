package dp.matrix;

/*

547. Friend Circles

count = 1;
s d r sh
t t t 0
boolean[] visited = new booelan[n - 1];

   s d r sh
s  1 1 0 0
d  1 1 1 0
r  0 1 1 0
sh 0 0 0 1

There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature.
For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the
ith and jth students are direct friends with each other, otherwise not. And you have to output the total number
of friend circles among all the students.

Example 1:
Input:
 [[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.

 */

public class FriendCircles {

	public static void main(String[] args) {
		int[][] mat = {
				{1,1,0},
		      {1,1,1},
				{0,1,1}
		};

		System.out.println(findFriendCricles(mat));

	}

	public static int findFriendCricles(int[][] matrix){

		int len = matrix.length;
		boolean[] visited = new boolean[len];
		int count  = 0;

		for(int i=0 ;i< matrix.length;i++){
				if(!visited[i]){
					count++;
					visited[i] = true;
					findCircles(matrix,visited , i);
				}
		}

		return count;
	}

	public static void findCircles(int[][] mat , boolean[] visited , int index){

		for (int i = 0;i<mat.length;i++){
			if(!visited[i] && mat[index][i] == 1){
				visited[i] = true;
				findCircles(mat,visited,i);
			}
		}
	}
}
