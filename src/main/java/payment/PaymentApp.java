package payment;

import common.App;
import common.Dependency;
import org.springframework.security.core.parameters.P;
import payment.controllers.PaymentController;
import payment.models.DummyPayment;
import payment.views.Payment;

public class PaymentApp extends App {
    protected void initializeObjects(Dependency dependency) {
        Payment page = new Payment();
        addView(page);

        PaymentController controller = new PaymentController(page,
                (DummyPayment) dependency.paymentGateway);

        router = new PaymentRouter(dependency.router, page);
    }
}
