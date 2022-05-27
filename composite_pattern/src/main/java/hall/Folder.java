package hall;

public class Folder extends Node {

    @Override
    public boolean hasNext() {
        return this.children.size() != 0;
    }

    @Override
    public int count() {
        int current_count = 0;
        for (Node child : children) {
            if (child  instanceof Leaf) {
                current_count++;
            }
        }
        return current_count;
    }

    @Override
    public int countAll() {
        int current_count = 0;
        for (Node child : children) {
            if (child  instanceof Leaf) {
                current_count++;
            } else {
                current_count = current_count + child.countAll();
            }
        }
        return current_count;
    }

    @Override
    public void list() {
        for (Node child : children) {
            System.out.print(child.name + "\t");
        }
        System.out.print("\n");
    }

    @Override
    public void listAll(StringBuilder num_tabs) {
        if (num_tabs.toString().equals("")) {
            System.out.println(name + ":");
        }
        for (Node child : children) {
            StringBuilder tabs = new StringBuilder();
            for (int i = 0; i < child.layers_in; i++) {
                tabs.append("\t");
            }
            if (child  instanceof Leaf) {
                System.out.println(tabs + child.name);
            } else {
                System.out.println(tabs + child.name + ":");
                child.listAll(tabs);
            }
        }
    }

}
