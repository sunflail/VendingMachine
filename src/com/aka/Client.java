package com.aka;

import com.apps.util.Prompter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Prompter prompt = new Prompter(new Scanner(System.in));
        Customer customer = new Customer();
        VendingMachine vm = new VendingMachine();
        Item item1 = new Item("1","XYZ", "Drinks", 2.99, true);
        Menu menu1 = new Menu("A", "Drinks");

        List<Menu> categories = new ArrayList<>();
        categories.add(new Menu("A", "Drinks"));
        categories.add(new Menu("B", "Sandwich"));
        categories.add(new Menu("C", "Snacks"));
        Menu drinksMenu = categories.get(0);
        Menu sandwichMenu = categories.get(1);
        Menu snacksMenu = categories.get(2);
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

        //Items of drinks
        Item drinksItem1 = items.get(0);
        Item drinksItem2 = items.get(1);
        Item drinksItem3 = items.get(2);
        Item drinksItem4 = items.get(3);

        //Items of sandwich
        Item sandwichItem1 = items.get(4);
        Item sandwichItem2 = items.get(5);
        Item sandwichItem3 = items.get(6);
        Item sandwichItem4 = items.get(7);

        // Items of snacks
        Item snackItem1 = items.get(8);
        Item snackItem2 = items.get(9);
        Item snackItem3 = items.get(10);
        Item snackItem4 = items.get(11);
        Item snackItem5 = items.get(12);


//        Program starts
//        Who does it? Main()
//        Show the initial welcome screen
//        Could include splash screen/logo
//        Program asks customer for category selection
        // TODO: 11/9/2020 Add options to all prompts - A OR Drinks or drinks or a, etc (YES or yes or y)
        do {
            prompt.info(Menu.showStartMenu());
            Menu.showCategoryMenu(categories);
            String categoryChoice = prompt.prompt("Category Selection: ");
////        Customer makes a choice
////        Program reads customer selection - prompter from console
////        Program passes selection to Menu
////        Menu shows the item selection based on input

            Menu.showItemMenu(customer.makeCategorySelection(categoryChoice.trim(), categories), items);

////        Program asks customer for item selection
            String itemChoice = prompt.prompt("Item Selection: ");
////        Customer makes choice
////        VM takes selection and calculates total
            vm.findItem(customer.makeItemSelection(itemChoice.trim(), items)); // input from console passed to findItem
////        Check availability
            //vm.calculateTotal();
////        Menu displays total and requests payment
            String customerPayment = prompt.prompt("Please deposit $" + vm.calculateTotal());
            //Menu.showPaymentMenu(vm.calculateTotal());
////        Program asks customer for payment input
            //customer.consoleInput("2.99");
////        Customer enter payment amount
            customer.makePayment(customerPayment.trim());
////        Payment verifies the payment
            //System.out.println(Payment.verifyBalance(items));
////        If sufficient -> call vm.dispenseItem()
            vm.dispenseSomething(Payment.verifyBalance(items));
////        If insufficient -> show error message and ask for payment amount again
////        Loop back to 11
////        Menu displays item delivered, please retrieve
            Menu.showItemRetrievable(items);
////        Customer picks up item
            customer.retrieveItem(items);
//        Vending machine asks if customer wants anything else
            //Menu.showAnythingElse();
            String anythingElseResponse = prompt.prompt("Would you like to purchase another item? (Yes/No)");
////        If yes -> back to 2
////        If no -> thank and exit
            run  = customer.makeAnotherChoice(anythingElseResponse.trim());
        } while (run);

        Menu.showClosingScreen();
        System.exit(0);
    }
}
