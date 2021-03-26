package common.controllers;

import common.models.displayPage;
import common.views.MainJFrame;
import login.controllers.LoginManager;

public abstract class GuiController {
    protected MainFrameController parentController;
    protected MainJFrame mainFrame;
    protected displayPage currentPage;

    LoginManager loginManager = new LoginManager();

    public GuiController(MainFrameController parentController, MainJFrame mainFrame) {
        this.parentController = parentController;
        this.mainFrame = mainFrame;
    }

    // todo function has side-effects. improve design?
    public void setCurrentPage(displayPage currentPage) {
        this.currentPage = currentPage;
        mainFrame.addCard(currentPage.getIdentifier(), currentPage.getPanel());
    }

    public void showPanel(){
        mainFrame.showCard(currentPage.getIdentifier());
    }
}
