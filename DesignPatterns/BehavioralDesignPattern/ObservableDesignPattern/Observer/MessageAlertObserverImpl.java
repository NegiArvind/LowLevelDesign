package Observer;

import Observable.StocksObservable;

public class MessageAlertObserverImpl implements NotificationAlertObserver {

    private String mobileNumber;
    private StocksObservable stocksObservable;

    public MessageAlertObserverImpl(String mobileNumber, StocksObservable stocksObservable) {
        this.mobileNumber = mobileNumber;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendMessage();
    }

    void sendMessage() {
        System.out.println(mobileNumber + ": stock is available now. Please buy fast otherwise it can go out of stock. Current Stock count is : " + stocksObservable.getStockCount());
    }
}
