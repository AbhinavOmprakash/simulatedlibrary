package common;

import admin.AdminRouter;
import common.customevents.CustomEvent;
import common.customevents.EventCotroller;
import common.customevents.EventListener;
import common.models.CurrentUser;
import common.models.Member;
import common.views.MainJFrame;
import library.LibraryRouter;
import login.LoginRouter;
import member.MemberRouter;
import payment.PaymentRouter;
import signup.SignUpRouter;

import java.awt.event.ActionEvent;
import java.util.Stack;

public class MainRouter extends Router implements EventListener {
    // initializing only when needed
    Router loginRouter = new LoginRouter(this);
    Router signupRouter = new SignUpRouter(this);
    Router adminRouter;
    Router libraryRouter;
    Router memberRouter;
    Router paymentRouter = new PaymentRouter(this);

    Stack<Views> previousViews = new Stack<>(); // hacky, might cause problems.
    Views currentView;

    public MainRouter(MainJFrame mainframe) {
        super(mainframe);
        EventCotroller.getInstanceOf().registerListener(this);
    }

    @Override
    public void homeView() {
        changeView(Views.LOGIN);
    }

    @Override
    public void changeView(Views view){
        updateCurrentView(view);
        switch (view){
            case SIGN_UP -> signupRouter.homeView();
            case LOGIN -> loginRouter.homeView();
            case ADMIN_HOME -> adminRouter.homeView();
            case LIBRARY_HOME -> libraryRouter.homeView();
            case MEMBER_HOME -> memberRouter.homeView();
            case PAYMENT -> paymentRouter.homeView();
            case BACK -> goBack();
        }
    }

    private void updateCurrentView(Views view) {
        if (!(view.equals(Views.BACK))){
            previousViews.push(currentView);
        }
        currentView = view;
    }

    private void goBack() {
        changeView(previousViews.pop());
    }

    @Override
    public void receive(CustomEvent event) {
        if(event.equals(CustomEvent.SIGNED_UP)){
            login();
        } else if(event.equals(CustomEvent.LOGGED_IN)){
            login();
        } else if(event.equals(CustomEvent.PAYMENT_GATEWAY)){
            changeView(Views.PAYMENT);
        } else if(event.equals(CustomEvent.LOG_OUT)){
            changeView(Views.LOGIN);
        }
    }

    public void login(){
        if(userIsMember()){
            libraryRouter = new LibraryRouter(this);
            memberRouter = new MemberRouter(this);
            changeView(Views.LIBRARY_HOME);

        } else {
            adminRouter = new AdminRouter(this);
            changeView(Views.ADMIN_HOME);
        }
    }

    private boolean userIsMember() {
        return (CurrentUser.getCurrentUser() instanceof Member);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
