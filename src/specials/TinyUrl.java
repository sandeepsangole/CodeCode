package specials;

import java.util.*;
public class TinyUrl {

	public static void main(String[] args) {
		TinyUrl obj = new TinyUrl();
		String str = obj.encode("https://leetcode.com/problems/design-tinyurl");
		System.out.println(str);
		String dec = obj.decode(str);
		System.out.println(dec);
	}
	
	Map<Integer, String> map = new HashMap<>();

	public String encode(String longUrl) {
		map.put(longUrl.hashCode(), longUrl);
		return "http://tinyurl.com/" + longUrl.hashCode();
	}

	public String decode(String shortUrl) {
		return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	}
	
}
