package com.aka;

import com.apps.util.Prompter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Prompter prompt = new Prompter(new Scanner(System.in));
        Customer customer = new Customer();
        VendingMachine vm = new VendingMachine();

        List<Menu> categories = new ArrayList<>();
        categories.add(new Menu("A", "Drinks"));
        categories.add(new Menu("B", "Sandwich"));
        categories.add(new Menu("C", "Snacks"));

        boolean run = true;

        List<Item> items = new ArrayList<>();
        //TODO: Need to come back to this and make a Collection of each Category or make method return Sub-collection
        items.add(new Item("1", "Coke", "Drinks", 1.00, false));
        items.add(new Item("2", "Red Bull", "Drinks", 1.00, true));
        items.add(new Item("3", "Sprite", "Drinks", 1.00, true));
        items.add(new Item("4", "Fanta", "Drinks", 1.00, true));

        items.add(new Item("5", "Tuna", "Sandwich", 2.99, true));
        items.add(new Item("6","Chicken", "Sandwich", 2.99, true ));
        items.add(new Item("7","Club ", "Sandwich", 2.99, true ));
        items.add(new Item("8","Veggie", "Sandwich", 2.99, true ));

        items.add(new Item("9","Lays", "Snacks", 1.99, true ));
        items.add(new Item("10","Snickers", "Snacks", 1.99, true ));
        items.add(new Item("11","Sun Chips", "Snacks", 1.99, false ));
        items.add(new Item("12","Kit Kat", "Snacks", 1.99, true ));
        items.add(new Item("13","Sun Chips", "Snacks", 1.99, false ));

//        Program starts
//        Who does it? Main()
//        Show the initial welcome screen
//        Could include splash screen/logo
//        Program asks customer for category selection
        // DONE: 11/9/2020 Add options to all prompts - A OR Drinks or drinks or a, etc (YES or yes or y)
        do {
            prompt.info(Menu.showStartMenu());
            Menu.showCategoryMenu(categories);
            String categoryChoice = prompt.prompt("Please select your category (category letter or category name): ");
////        Customer makes a choice
////        Program reads customer selection - prompter from console
////        Program passes selection to Menu
////        Menu shows the item selection based on input
            Menu.showItemMenu(customer.makeCategorySelection(categoryChoice.trim(), categories), items);
////        Program asks customer for item selection
            String itemChoice = prompt.prompt("Please select your item (item number or item name): ");
////        Customer makes choice
////        VM takes selection and calculates total
            vm.findItem(customer.makeItemSelection(itemChoice.trim(), items)); // input from console passed to findItem
////        Check availability
////        Menu displays total and requests payment
            String customerPayment = prompt.prompt("Total due is $" + vm.calculateTotal() + "\nPlease enter the amount to deposit.");
////        Program asks customer for payment input
////        Customer enter payment amount
            customer.makePayment(customerPayment.trim());
////        Payment verifies the payment
////        If sufficient -> call vm.dispenseItem()
            vm.dispenseSomething(Payment.verifyBalance(items));
////        If insufficient -> show error message and ask for payment amount again
////        Loop back to 11
////        Menu displays item delivered, please retrieve
            //Payment.makeChange();


            Menu.showItemRetrievable(items);
////        Customer picks up item
            customer.retrieveItem(items);
//        Vending machine asks if customer wants anything else
            //Menu.showAnythingElse();
            String anythingElseResponse = prompt.prompt("Would you like to purchase another item? (Yes/No)\n", "[yY]|[nN]|([y|Y][e|E][s|S])|([n|N][o|O])",
                    "That is not a valid response.");
////        If yes -> back to 2
////        If no -> thank and exit
            run  = customer.makeAnotherChoice(anythingElseResponse.trim());
        } while (run);

        Menu.showClosingScreen();
        System.exit(0);
    }
}
