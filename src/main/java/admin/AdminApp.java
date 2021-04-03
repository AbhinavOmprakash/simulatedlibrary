package admin;

import admin.controllers.AdminHomeController;
import admin.controllers.ContributorFactoryController;
import admin.controllers.LibItemAssembler;
import admin.models.factories.ContributorFactory;
import admin.models.factories.LibraryItemFactory;
import admin.models.factories.PolicyFactory;
import admin.views.AdminHome;
import admin.views.NewLibraryItem;
import admin.views.NewMembershipPolicy;
import common.App;
import common.Dependency;
import common.factory.Assembler;
import common.factory.Factory;
import common.factory.FactoryController;
import common.factory.FactoryGuiController;
import common.models.DataManager;
import common.models.MembershipPolicy;
import library.models.contributors.Author;
import library.models.contributors.Contributor;
import library.models.libraryitems.Book;
import library.models.libraryitems.LibraryItem;

public class AdminApp extends App {
    @Override
    protected void initializeObjects(Dependency dependency) {
        // data managers required for the app
        DataManager libItemData = new DataManager(dependency.dataBase, new Book());
        DataManager policies = new DataManager(dependency.dataBase, new MembershipPolicy());
        DataManager contributors = new DataManager(dependency.dataBase, new Author());

        // views
        AdminHome homePage = new AdminHome();
        NewLibraryItem newLibraryItem = new NewLibraryItem();
        NewMembershipPolicy newPolicy = new NewMembershipPolicy();

        // registering views
        addView(homePage);
        addView(newLibraryItem);
        addView(newPolicy);

        // Router
        router = new AdminRouter(dependency.router, homePage, newLibraryItem, newPolicy);

        //Factories
        Factory<LibraryItem> libraryItemFactory = new LibraryItemFactory();
        Factory<Contributor> contributorFactory = new ContributorFactory();
        Factory<MembershipPolicy> policyFactory = new PolicyFactory();

        // controllers
        AdminHomeController homeController = new AdminHomeController(homePage);


        FactoryController<LibraryItem> libraryItemFactoryController = new FactoryController<>(libItemData, libraryItemFactory);
        FactoryController<Contributor> contributorFactoryController = new ContributorFactoryController(contributors,contributorFactory);
        FactoryController<MembershipPolicy> policyFactoryController = new FactoryController<>(policies, policyFactory);

        FactoryGuiController<MembershipPolicy> policyFactoryGuiController = new FactoryGuiController<>(
                newPolicy, policyFactoryController);

        // assemblers
        Assembler<LibraryItem> libraryItemAssembler = new LibItemAssembler(
                libraryItemFactoryController, contributorFactoryController);

        // controllers
        FactoryGuiController<LibraryItem> libItemGuiController =
                new FactoryGuiController<>(newLibraryItem, libraryItemAssembler);
    }
}
