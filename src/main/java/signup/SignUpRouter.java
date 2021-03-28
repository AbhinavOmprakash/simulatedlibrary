package signup;

import common.Views;
import common.customevents.CustomEvent;
import common.Router;
import common.models.DisplayPage;
import signup.views.SignUpPage;

import java.awt.event.ActionEvent;

@SuppressWarnings({"rawtypes","unchecked"})
public class SignUpRouter extends Router {

    SignUpPage signUpPage = new SignUpPage(this);

    public SignUpRouter(Router router) {
        super(router);
        registerView(signUpPage);
    }

    @Override
    public void homeView() {
        setView(signUpPage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signUpPage.haveAnAccountButton){
            parentRouter.changeView(Views.LOGIN);
        }
    }

}
