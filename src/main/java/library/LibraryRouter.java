package library;

import common.Router;
import common.Views;
import library.views.HomeScreen;

import java.awt.event.ActionEvent;


public class LibraryRouter extends Router {
    HomeScreen home = new HomeScreen(this);

    public LibraryRouter(Router router){
        super(router);
        registerView(home);
    }

    @Override
    public void homeView() {
        setView(home);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == home.myAccountButton){
            parentRouter.changeView(Views.MEMBER_HOME);
        }

    }
}
