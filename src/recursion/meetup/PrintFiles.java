package recursion.meetup;

import java.io.*;

public class PrintFiles {

	public static void main(String[] args) {
		printFileNames("/Users/ctsuser/Desktop/");
		System.out.println(changeXtoY("sandxxsandddax"));
	}

	public static void printFileNames(String path){

		File[] files = new File(path).listFiles();

		if(files == null || files.length == 0){
			System.out.println(path);
		} else {
			for (File subPath : files) {

				if (subPath.isDirectory()) {
					printFileNames(subPath.toString());
				} else {
					System.out.println(subPath.toString());
				}
			}
		}
	}

	public static void printFileNames1(String path){


	}

	public static String changeXtoY(String str){
		if(str.length() < 1){
			return "";
		}

		if(str.charAt(0) =='x'){
			return 'y' + changeXtoY(str.substring(1));
		}
		return str.charAt(0) + changeXtoY(str.substring(1));
	}
}
