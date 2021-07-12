# digital library

## Running the app

The entry point to the app is at
`src/main/java/common/LibrarySimulator.java`

## Description
this is a digital library that lets users borrow and return Items in the library.

The number of items that the user can borrow is dependent on their `MembershipLevel` There are two memberships available, basic and gold. 

* Basic Membership allows you to borrow only one item.
* Gold membership allows you to borrow three items.

New membership types can be added via the admin account

Once a user has reached their borrow limit, they can browse the catalog but not borrow any items. 

If the user has borrowed a book for longer than the due date, they will be charged a daily fee, which can be paid at the `PaymentGateway`. a Dummy payment gateway is built into the app. The user is not allowed to return a book if they haven't paid the overdue fees.

The user can upgrade their membership if they like.

### admin panel
* New items can be added
* new membership policies can be added

### preconfigured users
I have preconfigured a bunch of user accounts.

* Username - `abhi` password - `abhiPassword` This is a basic account.
* Username - `gold` Password - `goldPassword` This is a gold membership account.
* Username - `lazy` password - `lazyPassword` This is an account with an ovedue item
* Username - `admin` password - `admin` This is an admin account, you can use this to explore the admin capabilities.

You can also sign up for a new account.

## areas that could be improved
* The GUI is quite ugly, but a pretty front-end was not the goal of this project. I completely understand that a beautiful UI is a key part of an app.

