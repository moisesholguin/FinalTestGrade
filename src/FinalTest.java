import java.io.*;
import java.util.*;
/**
* author: Moises Holguin
* date: Monday, November 26, 2012
* UTCS Problem #3
*/
public class FinalTest {
	public static void main(String[] args) throws IOException {
		Scanner infile = new Scanner(new File("finaltest.dat"));
		infile.nextLine();
		
		while(infile.hasNext()) {
			String name = infile.nextLine();
			String percentLine = infile.nextLine();
			String percentParts[] = percentLine.split("[ ]");

			double homeworkPercent = Integer.parseInt(percentParts[0])/100.0;
			double quizPercent = Integer.parseInt(percentParts[1])/100.0;
			double testPercent = Integer.parseInt(percentParts[2])/100.0;
			
			String homeworkLine = infile.nextLine();
			double homeworkGrade = getGrade(homeworkLine);
			
			String quizLine = infile.nextLine();
			double quizGrade = getGrade(quizLine);

			double rawScore = homeworkPercent*homeworkGrade + quizPercent*quizGrade;
			
			int needed_for_A = 0;
			int needed_for_B = 0;
			int needed_for_C = 0;
			
			if((90-rawScore)>0)
				needed_for_A = (int)Math.ceil(((90-rawScore)/testPercent));
			if((80-rawScore)>0)
				needed_for_B = (int)Math.ceil(((80-rawScore)/testPercent));
			if((70-rawScore)>0)
				needed_for_C = (int)Math.ceil(((70-rawScore)/testPercent));

			System.out.println("Student: " + name);
			
			if(needed_for_A<=100)
				System.out.println("Desired Grade: A\tTest Grade Needed: "+needed_for_A);
			else
				System.out.println("Desired Grade: A\tTest Grade Needed: SORRY");
			
			if(needed_for_B<=100)
				System.out.println("Desired Grade: B\tTest Grade Needed: "+needed_for_B);
			else
				System.out.println("Desired Grade: B\tTest Grade Needed: SORRY");
			
			if(needed_for_C<=100)
				System.out.println("Desired Grade: C\tTest Grade Needed: "+needed_for_C);
			else
				System.out.println("Desired Grade: C\tTest Grade Needed: SORRY");
			
			System.out.println();			
		}
	}
	
	public static int getGrade(String line) {
		int total = 0;
		String parts[] = line.split("[ ]");
		for(String s: parts)
			total+=Integer.parseInt(s);
		
		return total/parts.length;
	}
}