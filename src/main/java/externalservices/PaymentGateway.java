package externalservices;


import library.Accountant;
import library.User;

public interface PaymentGateway{
    void initializePayment(User user, double targetAmount);
    void acceptPayment(User user, double targetAmount);
    void registerAccountant(Accountant accountant);
    void removeAccountant(Accountant accountant);
    void notifyPaymentStatus(Accountant accountant, boolean status);
}
