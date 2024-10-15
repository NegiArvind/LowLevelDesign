import java.time.LocalDateTime;

public class PaymentDetails {
    int paymentId;
    int amountPaid;
    LocalDateTime dateOfPayment;
    boolean isRefundable;
    PaymentMode paymentMode;
}
