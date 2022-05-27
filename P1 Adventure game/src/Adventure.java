import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Adventure {

	int columnCor = 0;
	int rowCor = 0;
	
	public static void main(String[] args) {

		try {
			File inputFile = new File(args[0]);
			Scanner scanner = new Scanner(inputFile);
			int mapRows;
			int mapCols;
			char[][] fileContents;
			if (scanner.hasNextLine()) {
				String firstLine = scanner.nextLine();
				String[] mapSize = firstLine.split(" ");
				mapRows = Integer.parseInt(mapSize[0]);
				mapCols = Integer.parseInt(mapSize[1]);
				fileContents = new char[mapRows + 2][mapCols + 2];
				for (int i = 0; i < fileContents.length; i++) {
					for (int j = 0; j < fileContents[i].length; j++) {
						if (i == 0 || i == fileContents.length - 1) {
							fileContents[i][j] = 'X';
						} else if (j == 0 || j == fileContents[i].length - 1) {
							fileContents[i][j] = 'X';
						}
					}
				}
				int lineNum = 1;
				while (scanner.hasNextLine()) {
					String data = scanner.nextLine();
					for (int i = 0; i < data.length(); i++) {
						fileContents[lineNum][i + 1] = data.charAt(i);
					}
					lineNum++;
				}
				System.out.println("Map loaded:");
				for (int i = 0; i < fileContents.length; i++) {
					for (int j = 0; j < fileContents[i].length; j++) {
						System.out.print(fileContents[i][j]);
					}
					System.out.println("");
				}
			} else {
				System.out.println("Error: Empty File.");
				scanner.close();
				return;
			}
			scanner.close();
		
			Scanner input = new Scanner(System.in);
			Adventure adventure = new Adventure();
			String[] inventory = {"brass lantern", "rope", "rations", "staff"};
			System.out.print("> ");
		    String command = input.nextLine();
		    while (true) {
		    	
		    	if ((command.toLowerCase().equals("quit")) || (command.toLowerCase().equals("q"))) {
		    		break;
		    	} 
		    	
		    	else if ((command.toLowerCase().equals("inventory")) || (command.toLowerCase().equals("i"))) {
		    		System.out.print("You are carrying:\n");
		    		for (String item : inventory) {
		    			System.out.println(String.format("\t%s", item));
		    		}
		    		System.out.println(String.format("You are at location (%d, %d)", adventure.rowCor, adventure.columnCor));
		    	} 
		    	
		    	else if (command.toLowerCase().startsWith("g")) {
		    		String commandParts[] = command.toLowerCase().split(" ");
		    		if (commandParts.length != 2) {
		    			System.out.println("Invalid parameters. Must provide a direction (Example: 'Go North')");
		    		} else if (!Arrays.asList(commandParts).contains("north") 
		    				&& !Arrays.asList(commandParts).contains("south") 
		    				&& !Arrays.asList(commandParts).contains("east") 
		    				&& !Arrays.asList(commandParts).contains("west") 
		    				&& !Arrays.asList(commandParts).contains("n") 
		    				&& !Arrays.asList(commandParts).contains("s") 
		    				&& !Arrays.asList(commandParts).contains("e") 
		    				&& !Arrays.asList(commandParts).contains("w")) {
		    			System.out.println("You can't go that way.");
		    			System.out.println(String.format("You are at location (%d, %d)", adventure.rowCor, adventure.columnCor));
		    		} else {
		    			if (commandParts[1].equals("north") || commandParts[1].equals("n")) {
		    				if (adventure.rowCor == 0) {
		    					System.out.println("You cannot go that for North.");
		    				} else {
		    					adventure.rowCor--;
		    					System.out.println(String.format("Moving North...\nYou are at location (%d, %d)", adventure.rowCor, adventure.columnCor));
		    				}
		    			} else if (commandParts[1].equals("south") || commandParts[1].equals("s")) {
		    				if (adventure.rowCor == mapRows - 1) {
		    					System.out.println("You cannot go that for South.");
		    				} else {
		    					adventure.rowCor++;
		    					System.out.println(String.format("Moving South...\nYou are at location (%d, %d)", adventure.rowCor, adventure.columnCor));
		    				}
		    			} else if (commandParts[1].equals("east") || commandParts[1].equals("e")) {
		    				if (adventure.columnCor == mapCols - 1) {
		    					System.out.println("You cannot go that for East.");
		    				} else {
		    					adventure.columnCor++;
		    					System.out.println(String.format("Moving East...\nYou are at location (%d, %d)", adventure.rowCor, adventure.columnCor));
		    				}
		    			} else {
		    				if (adventure.columnCor == 0) {
		    					System.out.println("You cannot go that for West.");
		    				} else {
		    					adventure.columnCor--;
		    					System.out.println(String.format("Moving West...\nYou are at location (%d, %d)", adventure.rowCor, adventure.columnCor));
		    				}
		    			}
		    		}
		    	} 
		    	
		    	else {
		    		System.out.println(String.format("Invalid command: %s", command));
		    		System.out.println(String.format("You are at location (%d, %d)", adventure.rowCor, adventure.columnCor));
		    	}
		    	for (int i = 0; i < fileContents.length; i++) {
					for (int j = 0; j < fileContents[i].length; j++) {
						if ((i < adventure.rowCor + 3 && i > adventure.rowCor - 1) && (j < adventure.columnCor + 3 && j > adventure.columnCor - 1)) {
							System.out.print(fileContents[i][j]);
						}
					}
					System.out.println("");
				}
		    	System.out.print("> ");
			    command = input.nextLine();
			    command = command.strip();
		    }
		    System.out.println(String.format("Farewell\nYou are at location (%d, %d)", adventure.rowCor, adventure.columnCor));
		    input.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid text file parameters (out of bounds).");
			return;
		}
	}
}
