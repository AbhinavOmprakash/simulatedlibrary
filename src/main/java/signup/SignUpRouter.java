package signup;

import common.MainRouter;
import common.Views;
import common.customevents.CustomEvent;
import common.Router;
import common.models.DisplayPage;
import signup.views.SignUpPage;

import java.awt.event.ActionEvent;

public class SignUpRouter extends Router {
    SignUpPage signUpPage;

    public SignUpRouter(MainRouter router, SignUpPage page) {
        super(router);
        signUpPage = page;

        signUpPage.registerListener(this);
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
