package payment.views;

import common.Router;
import common.models.DisplayPage;
import payment.controllers.PaymentController;
import payment.models.PaymentDetails;
import payment.models.PaymentFormDetails;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Payment implements DisplayPage {
    private JPanel panel;
    private JTextField cardHolderName;
    private JTextField cardNumber;
    private JComboBox expMonth;
    private JComboBox expYear;
    private JTextField cvv;
    public JButton payButton;
    public JButton backButton;
    private JLabel grandTotal;

    PaymentController controller;

    public Payment(Router router) {
        controller = new PaymentController(this);
        registerListener(controller);
        registerListener(router);
    }

    @Override
    public void registerListener(ActionListener listener) {
        payButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    public void populateData(PaymentFormDetails details) {
        cardHolderName.setText(details.displayName);
        cardNumber.setText("1234 4321 1234 4321");
        grandTotal.setText(details.grandTotal);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "Payment";
    }


}
