package hall;

import java.util.List;
import java.util.Collections;

public class SortedList {
    List<String> arr;
    String sort_strat;

    SortedList(List<String> lst) {
        arr = lst;
        sort_strat = "quick_sort";
    }

    void add(String element) {
        arr.add(element);
    }

    void display() {
        for (String person: arr) {
            System.out.println(person);
        }
    }

    void set_sort_strat(String strategy) {
        sort_strat = strategy;
    }

    void sort() {
        if (sort_strat.equals("quick_sort")) {
            Collections.sort(arr);
        } else if (sort_strat.equals("shell_sort")) {
            Collections.sort(arr);
        } else if (sort_strat.equals("merge_sort")) {
            Collections.sort(arr);
        } else {
            System.out.println("Invalid sort strategy used.");
        }
    }
}
