package hall;

import java.util.ArrayList;

public abstract class Node {
    abstract boolean hasNext();

    ArrayList<Node> children = new ArrayList<>();
    Node parent = null;
    abstract int countAll();
    String name = "";
    int layers_in = 0;

    abstract void listAll(StringBuilder tabs);

    public abstract void list();

    public abstract int count();
}
