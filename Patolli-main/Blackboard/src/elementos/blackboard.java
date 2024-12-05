
package elementos;

import entidades.Juego;
import observer.IObservable;
import observer.IObserver;

/**
 * 
 * @author SDavidLedesma
 */
public class blackboard implements IObservable{
    
   public static Juego juego = Juego.getInstance();

    public blackboard() {
        this.addObserver(controlBlackboard.getInstance());
    }
   

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String command, Object source) {
        for (IObserver observer : observers) {
            observer.notifyObserver(command, source);
        }
    }

}
