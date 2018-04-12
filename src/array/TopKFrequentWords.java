package array;

/*

692. Top K Frequent Words

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
 then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.

 */

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

public class TopKFrequentWords {

	public static void main(String[] args) {

	}

	public List<String> topKFrequent(String[] words, int k) {

		List<String> res = new ArrayList<>();
		if(words == null || words.length == 0) {
			return res;
		}

		List<Integer> buckets = new ArrayList<>(words.length);

		Map<String , Integer> frequencyMap = new HashMap<>();
		for(String s : words){
			frequencyMap.put(s, frequencyMap.getOrDefault(1,0) + 1);
		}

		return null;


	}

}
