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
        List<Item> inStockList = vm.getItems();
        boolean run = true;
        boolean runAgain = true;
//        Program starts
//        Who does it? Main()
//        Show the initial welcome screen
//        Could include splash screen/logo
//        Program asks customer for category selection
        // DONE: 11/9/2020 Add options to all prompts - A OR Drinks or drinks or a, etc (YES or yes or y)
        do {
                prompt.info(menu.showStartMenu());
            while(runAgain) {

                prompt.info(menu.showCategoryMenu(vm.getCategories()));
                String categoryChoice = prompt.prompt("Please select your category (category letter or category name): ");
////        Customer makes a choice
////        Program reads customer selection - prompter from console
////        Program passes selection to Menu
////        Menu shows the item selection based on input
                menu.showItemMenu(customer.makeCategorySelection(categoryChoice.trim(), cat), inStockList);
////        Program asks customer for item selection
                String itemChoice = prompt.prompt("Please select your item (item number or item name): ");
////        Customer makes choice
////        VM takes selection and calculates total
                prompt.info(vm.findItem(customer.makeItemSelection(itemChoice.trim(), inStockList))); // input from console passed to findItem
////        Check availability
////        Menu displays total and requests payment
                String anythingElseResponse = prompt.prompt("Would you like to add additional items to your cart? (Yes/No)\n",
                        "[yY]|[nN]|([y|Y][e|E][s|S])|([n|N][o|O])",
                        "That is not a valid response.");

                runAgain = customer.makeAnotherChoice(anythingElseResponse.trim());
            }
            runAgain = true;
            String customerPayment = prompt.prompt("Total due is $" + vm.calculateTotal() + "\nPlease enter the amount to deposit.");
////        Program asks customer for payment input
////        Customer enter payment amount
            customer.makePayment(customerPayment.trim());
////        Payment verifies the payment
////        If sufficient -> call vm.dispenseItem()
            //vm.dispenseSomething(Payment.verifyBalance(vm.getCart()));
////        If insufficient -> show error message and ask for payment amount again
////        Loop back to 11
            while(!Payment.verifyBalance(vm.getCart())) {
                String depositAdditionalAmount = prompt.prompt("Total due is $" + Payment.getTotalCost() + "\nPlease enter the amount to deposit.");
                customer.makePayment(depositAdditionalAmount.trim());
            }
            vm.dispenseSomething(Payment.verifyBalance(vm.getCart()));
////        Menu displays item delivered, please retrieve
            prompt.info(menu.showItemRetrievable(vm.getCart()));
////        Customer picks up item
            customer.retrieveItem(vm.getCart());
            vm.cartClear();
//        Vending machine asks if customer wants anything else

////        If yes -> back to 2
////        If no -> thank and exit
            String anythingElseResponse = prompt.prompt("Would you like to purchase another item? (Yes/No)\n",
                    "[yY]|[nN]|([y|Y][e|E][s|S])|([n|N][o|O])",
                    "That is not a valid response.");
            run = customer.makeAnotherChoice(anythingElseResponse.trim());

        } while (run);

        prompt.info(menu.showClosingScreen());
        System.exit(0);
    }
}
