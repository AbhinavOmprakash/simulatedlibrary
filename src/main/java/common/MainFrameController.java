package common;

import admin.controllers.AdminHomeController;
import admin.controllers.NewLibraryItemController;
import admin.controllers.NewMembershipPolicyController;
import login.controllers.LoginController;
import member.controllers.UpgradeMembershipController;
import member.controllers.UserAccountController;
import library.controllers.UserHomeController;
import member.models.Member;
import signup.controllers.SignUpController;

public class MainFrameController{
    MainJFrame mainFrame;
    LoginController loginController;
    SignUpController signUpController;
    UserHomeController userHomeController;
    UserAccountController userAccountController;
    AdminHomeController adminHomeController;
    NewLibraryItemController newLibraryItemController;
    NewMembershipPolicyController newMembershipPolicyController;
    UpgradeMembershipController upgradeMembershipController;

    public MainFrameController(MainJFrame mainFrame){
        this.mainFrame = mainFrame;
        loginController = new LoginController(this, mainFrame);
        signUpController = new SignUpController(this, mainFrame);
        userHomeController = new UserHomeController(this, mainFrame);
        adminHomeController = new AdminHomeController(this, mainFrame);
        newLibraryItemController = new NewLibraryItemController(this, mainFrame);
        newMembershipPolicyController = new NewMembershipPolicyController(this, mainFrame);
    }

    public void switchToSignUp() {
        signUpController.showPanel();
    }
    public void switchToLogin() {
        loginController.showPanel();
    }

    public void switchToNewLibraryItem(){
        newLibraryItemController.showPanel();
    }

    public void switchToNewMembershipPolicy(){
        newMembershipPolicyController.showPanel();
    }

    public void switchToUpgradeMembership(){
        upgradeMembershipController = new UpgradeMembershipController(this, mainFrame);
        upgradeMembershipController.showPanel();
    }
    public void switchToMyAccount() {
        // todo correct hacky solution. initializig userAccount here because it can't be initialized before
        //  the user logs in.
        userAccountController = new UserAccountController(this, mainFrame);
        userAccountController.showPanel();
    }

    public void switchToHomePage() {
        getCorrectHomePage();
    }

    private void getCorrectHomePage() {
        if(userIsMember()){
            System.out.println("user is member");
            userHomeController.showPanel();

        } else {
            System.out.println("user is an admin");
            adminHomeController.showPanel();
        }
    }

    private boolean userIsMember() {
        return (CurrentUser.getCurrentUser() instanceof Member);
    }
}
