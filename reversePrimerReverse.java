package reversePrimerReverse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class reversePrimerReverse {
	public static void main(String[] args) throws FileNotFoundException
	{
		File f = new File("/Users/liujia/Desktop/primerPairPcrSimulator.txt");
		Scanner in = new Scanner(f);
		PrintWriter out = new PrintWriter("/Users/liujia/Desktop/reversePrimerPairPcrSimulator.txt");
		
		while (in.hasNextLine())
		{
			 Scanner readLine = new Scanner(in.nextLine());
			 if (readLine.hasNext())
			 {
				 String line = readLine.next();
				 if (line.charAt(1)== 'R')	//write out the reverse primer name and the reversed sequences
				 {
					 out.println(line);	// write the reverse primer name into the output 
					 if (in.hasNextLine())
					 {
						 // reverse the reverse primer sequences
						 String newLine = in.nextLine();
						 String reverse = "";
						 for (int i = newLine.length()-1; i>=0; i--)
						 {
							 reverse += newLine.charAt(i);
						 }
						 out.println(reverse);
					 }
					 
				 }
				 else if (line.charAt(1) == 'F')	// write out the name for forward primer and write out the sequence on the next line
				 {
					 out.println(line);
					 if (in.hasNextLine())
					 {
						 String newLine = in.nextLine();
						 out.println(newLine);
					 }
				 }
				 
				 
			 }
			 
			 readLine.close();
		}
		
		
		
		
		in.close();
		out.close();
	}

}
