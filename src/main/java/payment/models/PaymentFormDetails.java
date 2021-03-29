package payment.models;

public class PaymentFormDetails {
    public String displayName;
    public String grandTotal;

    public PaymentFormDetails(String displayName, String grandTotal) {
        this.displayName = displayName;
        this.grandTotal = grandTotal;
    }
}
