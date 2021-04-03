package library;

import common.MainRouter;
import common.Router;
import common.Views;
import library.views.HomeScreen;

import java.awt.event.ActionEvent;


public class LibraryRouter extends Router {
    HomeScreen home;

    public LibraryRouter(MainRouter router, HomeScreen home) {
        super(router);
        this.home = home;
        home.registerListener(this);
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
