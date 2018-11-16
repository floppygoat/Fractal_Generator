package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){
        if(!observers.contains(o)){
            observers.add(o);
        }
    }

    public void notifyObservers(String filename){
        for(Observer observer : observers){
            observer.update(filename);
        }
    }
}
