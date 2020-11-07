package com.aka;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Customer customer = new Customer();
        VendingMachine vm = new VendingMachine();
        Item item1 = new Item("1","XYZ", "Drinks", 2.99, true);
        Menu menu1 = new Menu("A", "Drinks");
        List<Menu> categories = new ArrayList<>();
        categories.add(new Menu("A", "Drinks"));
        categories.add(new Menu("B", "Sandwiches"));
        categories.add(new Menu("C", "Snacks"));
        Menu drinksMenu = categories.get(0);
        Menu sandwichMenu = categories.get(1);
        Menu snacksMenu = categories.get(2);
        boolean run = true;

//        Program starts
//        Who does it? Main()
//        Show the initial welcome screen
//        Could include splash screen/logo
//        Program asks customer for category selection
        do {
            Menu.showStartMenu();
            Menu.showCategoryMenu(categories);
            customer.consoleInput("A");
////        Customer makes a choice
            customer.makeCategorySelection(customer.consoleInput("A"), categories);
////        Program reads customer selection - prompter from console
//        Program.readSelection()
////        Program passes selection to Menu
////        Menu shows the item selection based on input
            Menu.showItemMenu(customer.makeCategorySelection("A", categories), item1); // includes prices
////        Program asks customer for item selection
            customer.consoleInput("1");
////        Customer makes choice
            customer.makeItemSelection("1", item1); // takes input from console for hardcode, where does item get passed in from
////        VM takes selection and calculates total
            //vm.findItem(item1);
            vm.findItem(customer.makeItemSelection("1", item1)); // input from console passed to findItem
////        Check availability
            vm.calculateTotal();
////        Menu displays total and requests payment
            Menu.showPaymentMenu(vm.calculateTotal());
////        Program asks customer for payment input
            customer.consoleInput("2.99");
////        Customer enter payment amount
            customer.makePayment("2.99");
////        Payment verifies the payment
            System.out.println(Payment.verifyBalance(item1));
////        If sufficient -> call vm.dispenseItem()
            vm.dispenseSomething(Payment.verifyBalance(item1));
////        If insufficient -> show error message and ask for payment amount again
////        Loop back to 11
////        Menu displays item delivered, please retrieve
            Menu.showItemRetrievable(item1);
////        Customer picks up item
            customer.retrieveItem(item1);
            System.out.println(item1.isInStock());
            vm.findItem(item1);
//        Vending machine asks if customer wants anything else
            Menu.showAnythingElse();
            customer.consoleInput("No");

////        If yes -> back to 2
////        If no -> thank and exit
            run  = customer.makeAnotherChoice("No");
        } while (run);

        Menu.showClosingScreen(); // Program calls exit()
    }
}
