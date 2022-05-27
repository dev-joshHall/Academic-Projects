package hall;

public class Leaf extends Node {
    @Override
    public boolean hasNext() {
        return this.children.size() != 0;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public void listAll(StringBuilder tabs) {}

    @Override
    public void list() {}

    @Override
    public int count() {
        return 0;
    }
}
