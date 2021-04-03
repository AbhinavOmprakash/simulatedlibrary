package common;


import common.models.DataStoreInterface;
import common.models.PaymentGateway;
import common.views.MainJFrame;


public class Dependency {
    public DataStoreInterface dataBase;
    public PaymentGateway paymentGateway;
    public MainJFrame mainJFrame;
    public MainRouter router;

    public Dependency() {
    }

    public Dependency(DataStoreInterface dataBase, PaymentGateway paymentGateway,
                      MainRouter router){
        this.dataBase = dataBase;
        this.paymentGateway = paymentGateway;
        this.router = router;
    }
}
