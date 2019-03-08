package changePrimerName;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class changePrimerName {
	public static void main(String[] args) throws FileNotFoundException
	{
		// Read in file and create output file
		File f = new File("/Users/liujia/Desktop/primerPairs.txt");
		Scanner in = new Scanner(f);		
		PrintWriter out = new PrintWriter("/Users/liujia/Desktop/primerPairPcrSimulator.txt");
		
		// Read input and write output
		while(in.hasNextLine())
		{
			Scanner readLine = new Scanner(in.nextLine());
			if (readLine.hasNext())
			{
				String line = readLine.next();
				if (line.charAt(0) == '>')	// change the name of primer to fit pcrSimulator format
				{
					int i = line.indexOf('_') + 1; // get the index of forwad 'F' or reverse 'R' primer in order to obtain the type information of the primer
					char t = line.charAt(i);
					String lineNew = line.replace("_", "");
					lineNew = lineNew.replace(">", "");
					out.println(">"+t+":"+lineNew);					
				}
				else // write the sequence line into output file
				{
					out.println(line);
				}
			}
			readLine.close();
		}
		
		
		in.close();
		out.close();
	}
 
}
