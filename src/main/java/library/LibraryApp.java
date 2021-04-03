package library;

import common.App;
import common.Dependency;
import common.Router;
import common.models.BorrowedItems;
import common.models.DataManager;
import common.models.FinancialAccount;
import common.models.Member;
import library.controllers.UserHomeController;
import library.models.*;
import library.models.contributors.Author;
import library.models.contributors.Contributor;
import library.models.libraryitems.Book;
import library.models.libraryitems.LibraryItem;
import library.views.HomeScreen;

import javax.xml.crypto.Data;

public class LibraryApp extends App {
    @Override
    protected void initializeObjects(Dependency dependency) {
        DataManager libraryItems = new DataManager(dependency.dataBase, new Book());
        DataManager contributors =  new DataManager(dependency.dataBase, new Author());
        DataManager borrowedItems =  new DataManager(dependency.dataBase,new BorrowedItem());
        DataManager financials = new DataManager(dependency.dataBase, new FinancialAccount());
        DataManager members = new DataManager(dependency.dataBase, new Member());

        //models
        LibraryUtils libraryUtils = new LibraryUtils(borrowedItems);
        MemberUtils memberUtils = new MemberUtils(members);
        Utils utils = new Utils(libraryUtils, memberUtils);

        OverdueAccountant accountant = new OverdueAccountant(financials, dependency.paymentGateway);

        BorrowIncharge borrowIncharge = new NormalBorrow(borrowedItems, members);
        BorrowLibrarian borrowLibrarian = new BorrowLibrarian(borrowIncharge, utils);

        //views
        HomeScreen homePage = new HomeScreen(utils, borrowLibrarian);
        addView(homePage);

        // Router
        router = new LibraryRouter(dependency.router, homePage);

        // controllers
        UserHomeController controller = new UserHomeController(libraryItems, homePage, utils);


    }

}
