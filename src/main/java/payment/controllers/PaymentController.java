package payment.controllers;

import common.customevents.CustomEvent;
import common.customevents.EventCotroller;
import common.customevents.CustomEventListener;
import payment.models.DummyPayment;
import payment.models.PaymentDetails;
import payment.models.PaymentFormDetails;
import payment.views.Payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentController implements ActionListener, CustomEventListener {
    Payment page;
    DummyPayment paymentGateway;
    PaymentDetails paymentDetails;

    public PaymentController(Payment page, DummyPayment paymentGateway) {
        this.page = page;
        this.paymentGateway = paymentGateway;
        page.registerListener(this);
        EventCotroller.getInstanceOf().registerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==page.payButton){
            paymentGateway.completePayment(paymentDetails);
            System.out.println("paying stuff");
        }
    }

    @Override
    public void receive(CustomEvent event) {
        if(event.equals(CustomEvent.NEW_PAYMENT)){
            PaymentFormDetails details = getFormDetails();
            page.populateData(details);
        }
    }

    public PaymentFormDetails getFormDetails(){
        String displayName = "Mr. Fake Credz";
        paymentDetails= paymentGateway.getLatestPayment();
        String grandTotal = String.valueOf(paymentDetails.getTargetAmount());
        return new PaymentFormDetails(displayName, grandTotal);
    }
}
