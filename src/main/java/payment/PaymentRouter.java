package payment;

import common.MainRouter;
import common.Router;
import common.Views;
import payment.views.Payment;

import java.awt.event.ActionEvent;

public class PaymentRouter extends Router {
    Payment page;

    public PaymentRouter(MainRouter router, Payment page) {
        super(router);
        this.page = page;
        page.registerListener(this);
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
