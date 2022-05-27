package hall;

import java.util.ArrayList;

/**
 * Creates a student list and sorts it in several different ways
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SortedList lst = new SortedList(new ArrayList<String>());
        lst.add("Jimmy");
        lst.add("Samual");
        lst.add("Vivek");
        lst.add("Sandra");
        lst.add("Anna");
        lst.set_sort_strat("quick_sort");
        lst.sort();
        System.out.println("Quick Sorted List:");
        lst.display();
        lst.set_sort_strat("shell_sort");
        lst.sort();
        System.out.println("\nShell Sorted List:");
        lst.display();
        lst.set_sort_strat("merge_sort");
        lst.sort();
        System.out.println("\nMerge Sorted List:");
        lst.display();
    }
}
