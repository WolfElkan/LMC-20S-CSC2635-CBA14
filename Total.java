import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
	This program reads a file with numbers, and writes the numbers to another 
	file, lined up in a column and followed by their total.
*/
public class Total
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		// Prompt fo the input and output file names

		Scanner console = new Scanner(System.in);
		System.out.print("Input file: ");
		String inputFileName = console.next();
		System.out.print("Output file: ");
		String outputFileName = console.next();

		// Construct the Scanner and PrintWriter objects for reading and writing

		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter(outputFileName);

		// Read the input and write the output

		double total = 0;

		boolean left = true;
		while (in.hasNextDouble())
		{
			double value = in.nextDouble();
			out.printf("%9.2f", value);
			total = total + value;
			left ^= true;
			if (left) {
				out.println();
			}
		}

		out.printf("Total: %11.2f\n", total);

		in.close();
		out.close();
	}
}