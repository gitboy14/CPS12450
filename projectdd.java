package Projectdd;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Input the copy of course information from keanwise, and get a neat course data :)

public class Projectdd {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the courses: ");
		String text = input.nextLine();
		
		String[][] matrix = getMatrix(text);
		print(matrix);
	}


	public static String[][] getMatrix(String t) {
		
		String[][] m = new String[10][2];
		//HERE IS THE DOUBLE-DIMENSIONAL ARRAY !!!
		
		Pattern name = Pattern.compile(".{8}\\*W..");
		//"CPS*2231*W04"
		Pattern period = Pattern.compile("Lecture[\\s\\S]+?M\\,");
		//"Lecture Monday, Thursday 04:00PM - 06:45PM"
		
		Matcher mName = name.matcher(t);
		Matcher mPeriod = period.matcher(t);
		
		int i = 0;		
		while (mName.find()) {						
			m[i][0] = mName.group();
			i++;
		}
		
		int j = 0;
		while (mPeriod.find()) {						
			m[j][1] = mPeriod.group();
			j++;
		}
		
		return m;
	}
	
	public static void print(String[][] m) {
		
		for(int i = 0; m[i][0] != null; i++) {
			System.out.println(m[i][0]);
			System.out.println(m[i][1]);
		}
	}
		
}
