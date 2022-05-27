package hall;

import java.util.ArrayList;

public class StockData {
    private ArrayList<Observer> observers;
    private ArrayList<ArrayList<ArrayList<String>>> dataList;

    public StockData(ArrayList<ArrayList<ArrayList<String>>> dList) {
        observers = new ArrayList<Observer>();
        dataList = dList;
    }

    public void registerObserver(Observer o) { observers.add(o); }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if ( i >= 0 ) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(dataList);
        }
    }
}
