package Observer;

import Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    private StocksObservable stocksObservable;
    private String email;

    public EmailAlertObserverImpl(String email, StocksObservable stocksObservable) {
        this.email = email;
        this.stocksObservable = stocksObservable;
    }

    @Override
    public void update() {
        sendEmail();
    }

    private void sendEmail() {
        System.out.println(email + ": Iphone stock is available now. Please buy fast otherwise it can go out of stock. Current Stock count is : " + stocksObservable.getStockCount());
    }
}
