package common;

import common.models.DisplayPage;
import common.views.MainJFrame;

import javax.swing.*;
import java.awt.event.ActionListener;

@SuppressWarnings({"unchecked","rawtypes"})
public abstract class Router implements ActionListener{
    // todo, design flaw?
    private static MainJFrame mainFrame;

    protected Router parentRouter;

    public Router(){}

    //to be used by mainRouter
    public Router(MainJFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public Router(Router router) {
        this.parentRouter = router;
    }

    protected void registerView(DisplayPage page){
        addViews(page.getIdentifier(), page.getPanel());
    }

    private void addViews(String id, JPanel panel){
        mainFrame.addCard(id, panel);
    }
    public abstract void homeView();

    public void changeView(Views view){
        // to be implemented by parent
    }

    protected void setView(DisplayPage page){
        mainFrame.showCard(page.getIdentifier());
    }

}
