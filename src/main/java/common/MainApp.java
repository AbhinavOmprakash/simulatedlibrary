package common;

import admin.AdminApp;
import library.LibraryApp;
import login.LoginApp;
import member.MemberApp;
import payment.PaymentApp;
import signup.SignUpApp;

public class MainApp extends App {
    MainRouter mainRouter;
    public MainApp(MainRouter router) {
        mainRouter = router;
    }

    @Override
    protected void initializeObjects(Dependency dependency) {
        // login
        App loginApp = new LoginApp();
        loginApp.start(dependency);
        mainRouter.setLoginRouter(loginApp.router);

        // signup
        App signupApp = new SignUpApp();
        signupApp.start(dependency);
        mainRouter.setSignupRouter(signupApp.router);

        //Library
        App libraryApp = new LibraryApp();
        libraryApp.start(dependency);
        mainRouter.setLibraryRouter(libraryApp.router);

        // member
        App memberApp = new MemberApp();
        memberApp.start(dependency);
        mainRouter.setMemberRouter(memberApp.router);

        // payment
        App paymentApp = new PaymentApp();
        paymentApp.start(dependency);
        mainRouter.setPaymentRouter(paymentApp.router);

        //admin
        App adminApp = new AdminApp();
        adminApp.start(dependency);
        mainRouter.setAdminRouter(adminApp.router);


    }
}
