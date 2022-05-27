package hall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 *
 */
public class App 
{

    static ArrayList<Node> nodes = new ArrayList<Node>();

    public static void main( String[] args )
    {
        ArrayList<String> lines = new ArrayList<>();
        Node top = null;
        try {
            File file = new File("C:\\Users\\User\\composite_pattern\\src\\main\\java\\hall/sample_tree.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replace("\n", "");
                lines.add(line);
            }
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains(":")) {
                    Node folder = new Folder();
                    folder.name = line.replace(":", "").replace(" ", "");
                    if (notInList(folder, nodes)) {
                        nodes.add(folder);
                    } else {
                        for (Node node : nodes) {
                            if (folder.name.equals(node.name)) {
                                folder = node;
//                                System.out.println(folder.name + " it happened!");
                            }
                        }
                    }
                    if (top == null) {
                        top = folder;
                    }
                    int indent = count(line, ' ') / 3; // how many times the current line is indented
                    folder.layers_in = indent;
                    int j = i + 1; // start searching on the next line
                    String lineJ = lines.get(j);
                    while (j < lines.size()) {
                        int indentJ = count(lineJ, ' ') / 3;
                        if (indentJ == indent && lineJ.contains(":")) {
                            break; // do not look into other directories on the same level
                        }
                        if (indentJ == indent + 1) { // look for children on the indentation level below
                            Node current_node;
                            if (!lineJ.contains(":")) {
                                current_node = new Leaf();
                                current_node.name = lineJ.replace(" ", "");
                            } else {
                                current_node = new Folder();
                                current_node.name = lineJ.replace(" ", "").replace(":", "");
                            }
                            current_node.layers_in = indentJ;
                            if (notInList(current_node, nodes)) {
//                                System.out.println("added " + current_node.name);
                                nodes.add(current_node);
                                current_node.parent = folder;
                                folder.children.add(current_node);
//                                for (Node child : folder.children) {
//                                    System.out.println(folder.name + " " + child.name);
//                                }
                            }
                        }
                        j++;
                        if (j < lines.size()) {
                            lineJ = lines.get(j);
                        }
                    }
                }
            }

            // main running code
            if (top != null) {
                PositionTracker tracker = new PositionTracker(top);
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("top> ");
                String input = scanner1.nextLine();
                while (!input.equalsIgnoreCase("quit") && !input.equalsIgnoreCase("q")) {
                    if (input.equalsIgnoreCase("list")) {
                        tracker.current_folder.list();
                    } else if (input.equalsIgnoreCase("listall")) {
                        tracker.current_folder.listAll(new StringBuilder());
                    } else if (input.toLowerCase().contains("chdir ")) {
                        tracker.changeDir(input.split(" ")[1]);
                    } else if (input.equalsIgnoreCase("up")) {
                        tracker.up();
                    } else if (input.equalsIgnoreCase("count")) {
                        System.out.println(tracker.current_folder.count());
                    } else if (input.equalsIgnoreCase("countall")) {
                        System.out.println(tracker.current_folder.countAll());
                    } else {
                        System.out.println("Invalid command '" + input + "'");
                    }
                    System.out.print(tracker.current_folder.name + "> ");
                    input = scanner1.nextLine();
                }
                System.out.println("Exiting program...");

//                top.listAll(new StringBuilder());
//                for (Node child : top.children) {
//                    if (child instanceof Folder) {
//                        System.out.println(child.children);
//                    }
//                }
            }
        } catch (FileNotFoundException err) {
            System.out.println("Error opening file.");
            err.printStackTrace();
        }
    }

    private static int count(String someString, char someChar) {
        int current_count = 0;
        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) == someChar) {
                current_count++;
            }
        }
        return current_count;
    }

    private static boolean notInList(Node node, ArrayList<Node> lst) {
        for (Node lnode : lst) {
            if (lnode.name.equals(node.name)) {
                return false;
            }
        }
        return true;
    }
}
