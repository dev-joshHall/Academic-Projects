
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns of the array: ");
		String inputData = input.nextLine();
		String[] rowCol = inputData.split(" ");
		int row = Integer.parseInt(rowCol[0]);
		int col = Integer.parseInt(rowCol[1]);
		double[][] sampleArray = new double[row][col];
		
		System.out.println("Enter the array:");
		for (int i = 0; i < row; i++) {
			String rowInput = input.nextLine();
			String[] rowSplit = rowInput.split(" ");
			for (int j = 0; j < col; j++) {
				sampleArray[i][j] = Double.parseDouble(rowSplit[j]);
			}
		}
		
		double largestElem = sampleArray[0][0];
		String largestLoc = "(0, 0)";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (sampleArray[i][j] > largestElem) {
					largestElem = sampleArray[i][j];
					largestLoc = "(" + String.valueOf(i) + ", " + String.valueOf(j) + ")";
				}
			}
		}
		System.out.println("The location of the largest element is at " + largestLoc);
		
	}

}
