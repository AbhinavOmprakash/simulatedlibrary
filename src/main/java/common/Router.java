package common;

import common.controllers.GuiController;
import common.views.MainJFrame;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Router {
    private static final MainJFrame mainFrame = new MainJFrame();

    protected void registerController(GuiController controller){
        addViews(controller.getViewIdentifier(), controller.getViewPage());
    }

    private void addViews(String id, JPanel panel){
        mainFrame.addCard(id, panel);
    }

    public abstract void changeView(Page page);

    protected abstract void passOnToParent(Page page);

    protected void setView(GuiController controller){
        mainFrame.showCard(controller.getViewIdentifier());
    }



}
