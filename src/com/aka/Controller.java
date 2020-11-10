package com.aka;

import com.apps.util.Prompter;

import java.util.List;
import java.util.Scanner;

public class Controller {
    protected void initialize() {
        Prompter prompt = new Prompter(new Scanner(System.in));
        Customer customer = new Customer(); // this can be removed once customer is migrated to VendingMachine or elsewhere
        VendingMachine vm = new VendingMachine();
        vm.setCategories();
        vm.setItems();
        Menu menu = new Menu(vm.getCategory());
        List<Menu> cat = vm.getCategories();
        List<Item> itemList = vm.getItems();
        boolean run = true;
//        Program starts
//        Who does it? Main()
//        Show the initial welcome screen
//        Could include splash screen/logo
//        Program asks customer for category selection
        // DONE: 11/9/2020 Add options to all prompts - A OR Drinks or drinks or a, etc (YES or yes or y)
        do {
            prompt.info(menu.showStartMenu());
            prompt.info(menu.showCategoryMenu(vm.getCategories()));
            String categoryChoice = prompt.prompt("Please select your category (category letter or category name): ");
////        Customer makes a choice
////        Program reads customer selection - prompter from console
////        Program passes selection to Menu
////        Menu shows the item selection based on input
            menu.showItemMenu(customer.makeCategorySelection(categoryChoice.trim(), cat), itemList);
////        Program asks customer for item selection
            String itemChoice = prompt.prompt("Please select your item (item number or item name): ");
////        Customer makes choice
////        VM takes selection and calculates total
            prompt.info(vm.findItem(customer.makeItemSelection(itemChoice.trim(), itemList))); // input from console passed to findItem
////        Check availability
////        Menu displays total and requests payment
            String customerPayment = prompt.prompt("Total due is $" + vm.calculateTotal() + "\nPlease enter the amount to deposit.");
////        Program asks customer for payment input
////        Customer enter payment amount
            customer.makePayment(customerPayment.trim());
////        Payment verifies the payment
////        If sufficient -> call vm.dispenseItem()
            vm.dispenseSomething(Payment.verifyBalance(itemList));
////        If insufficient -> show error message and ask for payment amount again
////        Loop back to 11
////        Menu displays item delivered, please retrieve
            prompt.info(menu.showItemRetrievable(itemList));
////        Customer picks up item
            customer.retrieveItem(itemList);
//        Vending machine asks if customer wants anything else
            String anythingElseResponse = prompt.prompt("Would you like to purchase another item? (Yes/No)\n",
                    "[yY]|[nN]|([y|Y][e|E][s|S])|([n|N][o|O])",
                    "That is not a valid response.");
////        If yes -> back to 2
////        If no -> thank and exit
            run = customer.makeAnotherChoice(anythingElseResponse.trim());
        } while (run);

        prompt.info(menu.showClosingScreen());
        System.exit(0);
    }
}
