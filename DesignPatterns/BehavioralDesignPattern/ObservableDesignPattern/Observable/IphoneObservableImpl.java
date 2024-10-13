package Observable;

import java.util.*;
import Observer.NotificationAlertObserver;

public class IphoneObservableImpl implements StocksObservable {

    private List<NotificationAlertObserver> observerList;
    private int currentStockCount;

    public IphoneObservableImpl() {
        observerList = new ArrayList<>();
    }

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver notificationAlertObserver: observerList){
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        if(currentStockCount == 0) {
            currentStockCount =  stockCount;
            notifySubscribers();
        }
        currentStockCount = stockCount;
    }

    @Override
    public int getStockCount() {
        return currentStockCount;
    }
}
