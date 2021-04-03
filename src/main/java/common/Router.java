package common;

import common.models.DisplayPage;

import java.awt.event.ActionListener;

public abstract class Router implements ActionListener{
    protected MainRouter parentRouter;

    public Router(MainRouter router) {
        this.parentRouter = router;
    }
    public abstract void homeView();

    protected void setView(DisplayPage page){
        page.refresh();
        parentRouter.setView(page);
    }
}
