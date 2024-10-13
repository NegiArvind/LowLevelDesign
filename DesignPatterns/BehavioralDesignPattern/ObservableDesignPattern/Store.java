import Observable.IphoneObservableImpl;
import Observable.StocksObservable;
import Observer.EmailAlertObserverImpl;
import Observer.MessageAlertObserverImpl;
import Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        // This is an amazon feature, where if a product gets out of stock then customer can click notify me button
        // We have to implement it that we have to notify all the user who have clicked notify me button
        StocksObservable iphoneStocksObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("arvind.negi1@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("arvind.negi2@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer3 = new MessageAlertObserverImpl("7895922245", iphoneStocksObservable);

        iphoneStocksObservable.add(observer1);
        iphoneStocksObservable.add(observer2);
        iphoneStocksObservable.add(observer3);

        iphoneStocksObservable.setStockCount(10);
        iphoneStocksObservable.setStockCount(0);
        iphoneStocksObservable.setStockCount(100);
    }
}
