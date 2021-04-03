package common;

import common.models.DisplayPage;
import common.views.MainJFrame;

import java.util.ArrayList;

/*
all apps must have a setup class that subclasses this.
the mainJframe is initialized by the Setup subclass in common.
the apps must use the empty constructor.
 */

public abstract class App {
    private static MainJFrame frame; // must be set before subclasses are instantiated.
    protected ArrayList<DisplayPage> views = new ArrayList<>();
    public Router router; //set the app's router to this. will be used by the mainFrame.

    // to be used by all other apps
    public App() {
    }

    public static void setFrame(MainJFrame frame) {
        App.frame = frame;
    }

    public void start(Dependency dependency){
        initializeObjects(dependency);
        registerViews();

        frame.pack();
        frame.setVisible(true);
    }

    protected abstract void initializeObjects(Dependency dependency);
    // initialize app specific objects here

    protected void addView(DisplayPage view){
        // use this method to make sure all your views get registered.
        views.add(view);
    }

    private void registerViews(){
        for (DisplayPage page: views){
            frame.add(page.getIdentifier(), page.getPanel());
        }
    }

}
