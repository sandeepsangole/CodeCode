package recursion;
import java.io.*;
public class FileDir {
	public static void main(String[] args) {
			traverse(new File("/Users/ctsuser/CodeCode/src/"),"");
	}

	private static void traverse(File path,String indent){

		File[] files  = path.listFiles();
		for (File f :files){
			if(f.isFile()){
				System.out.println(indent+f.getName());
			} else {
				System.out.println(indent+f.getName());
				traverse(f , indent+" ");
			}
		}
	}
	
	
}
