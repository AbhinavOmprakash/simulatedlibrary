package payment;

import common.Router;
import common.Views;
import payment.views.Payment;

import java.awt.event.ActionEvent;

public class PaymentRouter extends Router {
    Payment page = new Payment(this);

    public PaymentRouter(Router router) {
        super(router);
        registerView(page);
    }

    @Override
    public void homeView() {
        setView(page);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==page.backButton){
            parentRouter.changeView(Views.BACK);
        } else if(e.getSource()==page.payButton){
            parentRouter.changeView(Views.LIBRARY_HOME);
        }

    }
}
