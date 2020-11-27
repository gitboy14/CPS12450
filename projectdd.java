package tool;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Input the copy of course information from keanwise, and get a neat course data :)

public class Tool {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input the courses: ");
		String text = input.nextLine();
		
		for(String[] a: format(text)) {
			for(String s:a)
				System.out.println(s);
		}
		//Traverse and print
	}

	public static String[][] format(String t) {
		
		String[][] courses = new String[10][2];
		//HERE IS THE DOUBLE-DIMESIONAL ARRAY !!!
		
		Pattern name = Pattern.compile(".{8}\\*W..");
		Pattern section = Pattern.compile("Lecture[\\s\\S]+?M\\,");
		//"CPS*2231*W04"
		//"Lecture Monday, Thursday 04:00PM - 06:45PM"
		
		Matcher mName = name.matcher(t);
		Matcher mSection = section.matcher(t);
		
		int i = 0;		
		while (mName.find()) {						
			courses[i][0] = mName.group();
			i++;
		}
		
		int j = 0;
		while (mSection.find()) {						
			courses[j][1] = mSection.group();
			j++;
		}
		
		return courses;
	}
}
