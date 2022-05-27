package hall;

import java.util.Objects;

public class PositionTracker {
    Node current_folder;
    Node current_parent = null;

    public PositionTracker(Node current_folder) {
        this.current_folder = current_folder;
    }

    public int changeDir(String dir_name) {
        for (Node child : current_folder.children) {
            if (dir_name.equals(child.name)) {
                if (child instanceof Leaf) {
                    System.out.println("No such directory");
                    return -1;
                }
                current_parent = current_folder;
                current_folder = child;
                return 0;
            }
        }
        System.out.println("No such directory");
        return -1;
    }

    public int up() {
        if (current_parent == null) {
            return -1;
        }
        current_folder = current_parent;
        current_parent = current_folder.parent;
        return 0;
    }

}
