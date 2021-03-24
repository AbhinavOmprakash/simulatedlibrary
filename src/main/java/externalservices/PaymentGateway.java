package externalservices;


import controllers.Accountant;
import models.dataobjects.library.User;

public interface PaymentGateway{
    void acceptPayment(User user, double targetAmount);
    void registerAccountant(Accountant accountant);
    void removeAccountant(Accountant accountant);
    void notifyPaymentStatus(Accountant accountant, boolean status);
}
