package com.aka;

import com.apps.util.Prompter;

import java.util.List;
import java.util.Scanner;

public class Controller {
    protected void initialize() {
        Prompter prompt = new Prompter(new Scanner(System.in));
        Selection selection = new Selection(); // this can be removed once customer is migrated to VendingMachine or elsewhere
        VendingMachine vm = new VendingMachine();
        vm.setCategories();
        vm.setItems();
        Menu menu = new Menu(vm.getCategory());
        List<Menu> cat = vm.getCategories();
        List<Item> inStockList = vm.getItems();
        boolean run = true;
        boolean runAgain = true;

        do {
                prompt.info(menu.showStartMenu());
            while(runAgain) {
                prompt.info(menu.showCategoryMenu(vm.getCategories()));
                String categoryChoice = prompt.prompt("Please select your category (category letter or category name): ",
                        "[aA-cC]",
                        "Invalid response, please choose category letter.");
                String responseToCategoryChoice = prompt.info(menu.showItemMenu(selection.makeCategorySelection(categoryChoice.trim(), cat), inStockList));
                if (!responseToCategoryChoice.equals("Sorry, currently out of stock")) {
                    String itemChoice = prompt.prompt("Please select your item (item number): ",
                            "\\d+",
                            "Invalid response. Please select the item number.");
                    prompt.info(vm.findItem(itemChoice.trim(), inStockList)); // input from console passed to findItem
                    vm.setCategories();
                }
                    String anythingElseResponse = prompt.prompt("Would you like to add additional items to your cart? (Yes/No)\n",
                            "[yY]|[nN]|([y|Y][e|E][s|S])|([n|N][o|O])",
                            "That is not a valid response.");
                    runAgain = selection.makeAnotherChoice(anythingElseResponse.trim());
            }
            runAgain = true;
            String customerPayment = prompt.prompt("Total due is $" + vm.calculateTotal() + "\nPlease enter the amount to deposit.");
            selection.makePayment(customerPayment.trim());
            while(!Payment.verifyBalance()) {
                String depositAdditionalAmount = prompt.prompt("Total due is $" + Payment.getTotalCost() + "\nPlease enter the amount to deposit.");
                selection.makePayment(depositAdditionalAmount.trim());
            }
            vm.dispenseSomething(Payment.verifyBalance());
            prompt.info(menu.showItemRetrievable(vm.getCart()));
            vm.retrieveItem(vm.getCart());
            vm.cartClear();
            String anythingElseResponse = prompt.prompt("Would you like to purchase another item? (Yes/No)\n",
                    "[yY]|[nN]|([y|Y][e|E][s|S])|([n|N][o|O])",
                    "That is not a valid response.");
            run = selection.makeAnotherChoice(anythingElseResponse.trim());
        } while (run);
        prompt.info(menu.showClosingScreen());
        System.exit(0);
    }
}
