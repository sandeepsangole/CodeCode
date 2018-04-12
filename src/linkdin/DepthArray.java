package linkdin;

public class DepthArray {

	/*public static void main(String[] args) {

	}

	*//*{{1,1,4},2,{1,1}} = 10
			1 *2,+ 2
			2 * 1 + 2* 1 + 2 *1 + 2 *1 + 2*1


	{1,{4,{6}}} = 27

			1*1 + 2 * 4 + 3 * 6
			1 + 8 + 18
*//*

	public interface NestedInteger
	{
		*//** @return true if this NestedInteger holds a single integer, rather than a nested list *//*
		boolean isInteger();

		*//** @return the single integer that this NestedInteger holds, if it holds a single integer
		 * Return null if this NestedInteger holds a nested list *//*
		Integer getInteger();

		*//** @return the nested list that this NestedInteger holds, if it holds a nested list
		 * Return null if this NestedInteger holds a single integer *//*
		List<NestedInteger> getList();
	}

	public int depthSum (List<NestedInteger> input)
	{
		//Implementation here
    *//*
        {1,2,{5,{4,5}}
         input[{1,2}]
    int level = 1;

    1 *1 + 2 * 1 + {{{} } } ,

        *//*

		if(intput == null && input.length == 0){

			return 0;
		}

		int[] sum = new int[0];
		depthSumUtil(inputm,1,0,sum);
		return sum;

	}
	//{1,{4,{6},5,{{{{{{}}}}}
	// {4, {6}, 5}

	static int sum = 0;
	public int depthSumRec (List<NestedInteger> input,int level)
	{


		for(int i = 0;i<input.size();i++){

			if(input.get(i).isInteger()){
				//  sum += (input.get(i) * level);

				// return (input.get(i) * level) +  depthSumRec(input.get(i),level);
			}
			else if(!input.get(i).isInteger()){

				return depthSumRec(input.get(i),level + 1);//level 2
			}
		}

		return sum;



	}

	*//*public int depthSumUtil (List<NestedInteger> input,int level,int[] sum)

        for(int i = 0;i<input.size();i++){

		if(input.get(i).isInteger()){
			//sum[0] = sum[0] + (input.get(i) * level);
			return (input.get(i) * level) +  depthSumUtil(input.get(i),level);
		}
		else if(!input.get(i).isInteger()){
			return depthSumUtil(input.get(i),level + 1, sum);//level 2
		}
	}*//*



}*/


}
