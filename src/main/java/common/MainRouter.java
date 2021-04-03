package common;

import common.customevents.CustomEvent;
import common.customevents.EventCotroller;
import common.customevents.CustomEventListener;
import common.models.DisplayPage;
import common.models.Member;
import common.models.Session;
import common.views.MainJFrame;

import java.util.Stack;

public class MainRouter implements CustomEventListener {
    Router loginRouter;
    Router signupRouter;
    Router adminRouter;
    Router libraryRouter;
    Router memberRouter;
    Router paymentRouter;

    Stack<Views> previousViews = new Stack<>(); // hacky, might cause problems.
    Views currentView;

    MainJFrame frame;

    public MainRouter(MainJFrame mainframe) {
        frame = mainframe;
        EventCotroller.getInstanceOf().registerListener(this);
    }

    public void homeView() {
        changeView(Views.LOGIN);
    }

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
            System.out.println("trynna login");
            login();
        } else if(event.equals(CustomEvent.PAYMENT_GATEWAY) ||
                event.equals(CustomEvent.NEW_PAYMENT)){

            changeView(Views.PAYMENT);
        } else if(event.equals(CustomEvent.LOG_OUT)){
            changeView(Views.LOGIN);
        }
    }

    public void login(){
        if(userIsMember()){
            changeView(Views.LIBRARY_HOME);

        } else {
            changeView(Views.ADMIN_HOME);
        }
    }

    private boolean userIsMember() {
        return (Session.getAccessPrivilege().equals(Member.getAccessPrivilege()));
    }

    public void setView(DisplayPage page){
        frame.showCard(page.getIdentifier());
    }

    public void setLoginRouter(Router loginRouter) {
        this.loginRouter = loginRouter;
    }

    public void setSignupRouter(Router signupRouter) {
        this.signupRouter = signupRouter;
    }

    public void setAdminRouter(Router adminRouter) {
        this.adminRouter = adminRouter;
    }

    public void setLibraryRouter(Router libraryRouter) {
        this.libraryRouter = libraryRouter;
    }

    public void setMemberRouter(Router memberRouter) {
        this.memberRouter = memberRouter;
    }

    public void setPaymentRouter(Router paymentRouter) {
        this.paymentRouter = paymentRouter;
    }
}
