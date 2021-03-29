package payment.controllers;

import common.customevents.CustomEvent;
import common.customevents.EventCotroller;
import common.customevents.EventListener;
import payment.models.DummyPayment;
import payment.models.PaymentDetails;
import payment.models.PaymentFormDetails;
import payment.views.Payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentController implements ActionListener, EventListener {
    Payment page;
    DummyPayment payment = DummyPayment.getInstanceOf();
    PaymentDetails paymentDetails;

    public PaymentController(Payment page) {
        this.page = page;
        EventCotroller.getInstanceOf().registerListener(this);
    }

    public PaymentFormDetails getFormDetails(){
        String displayName = "Mr. Fake Credz";
        paymentDetails= payment.getLatestPayment();
        String grandTotal = String.valueOf(paymentDetails.getTargetAmount());
        return new PaymentFormDetails(displayName, grandTotal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==page.payButton){
            DummyPayment.getInstanceOf().completePayment(paymentDetails);
        }
    }

    @Override
    public void receive(CustomEvent event) {
        if(event.equals(CustomEvent.NEW_PAYMENT)){
            PaymentFormDetails details = getFormDetails();
            page.populateData(details);
        }
    }
}
