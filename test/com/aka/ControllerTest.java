package com.aka;

import com.apps.util.Prompter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ControllerTest {

    /*
     * Copy this test, create a new txt file with the appropriate responses, and change assertions as needed.
     * Example: testBuyAllDrinks - create the txt file for that (a 1 y a 2 y a 3 y a 4 n for the drinks loop)
     * Made some prompts be assigned to variables for assertion size
     * Example: String start, so assertEquals could be (string, start)
     * Added some public getters for private items just for testing purposes - comment added in each class.
     */
    @Test
    public void testOneRunOneItemOnly() throws Exception{
        Prompter prompt = new Prompter(new Scanner(new File("responses/onerunoneitemonly.txt")));
        Selection selection = new Selection(); // this can be removed if selection is migrated to VendingMachine or elsewhere
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
                String start = prompt.info(menu.showCategoryMenu(vm.getCategories()));
                assertEquals("A - Drinks\nB - Sandwich\nC - Snacks\n", start);
                String categoryChoice = prompt.prompt("Please select your category (category letter or category name): ",
                        "[aA-cC]",
                        "Invalid response, please choose category letter.");
                assertEquals("a", categoryChoice);
                String responseToCategoryChoice = prompt.info(menu.showItemMenu(selection.makeCategorySelection(categoryChoice.trim(), cat), inStockList));
                if (!responseToCategoryChoice.equals("Sorry, currently out of stock")) {
                    String itemChoice = prompt.prompt("Please select your item (item number): ",
                            "\\d+",
                            "Invalid response. Please select the item number.");
                    prompt.info(vm.findItem(itemChoice.trim(), inStockList)); // input from console passed to findItem
                    assertEquals("1", vm.getSelectedItem().getItemId());
                    vm.setCategories();
                }
                String anythingElseResponse = prompt.prompt("Would you like to add additional items to your cart? (Yes/No)\n",
                        "[yY]|[nN]|([y|Y][e|E][s|S])|([n|N][o|O])",
                        "That is not a valid response.");
                assertEquals("n", anythingElseResponse);
                runAgain = selection.makeAnotherChoice(anythingElseResponse.trim());
            }
            runAgain = true;
            String customerPayment = prompt.prompt("Total due is $" + vm.calculateTotal() + "\nPlease enter the amount to deposit.");
            assertEquals(1.0, vm.getTotalCost(), .01);
            assertEquals(1.0, Payment.getTotalCost(), .01);
            selection.makePayment(customerPayment.trim());
            assertEquals(1.0, Payment.getInputAmount(), .01);
            while(!Payment.verifyBalance()) {
                String depositAdditionalAmount = prompt.prompt("Total due is $" + Payment.getTotalCost() + "\nPlease enter the amount to deposit.");
                selection.makePayment(depositAdditionalAmount.trim());
            }
            assertTrue(Payment.verifyBalance());
            vm.dispenseSomething(Payment.verifyBalance());
            prompt.info(menu.showItemRetrievable(vm.getCart()));
            assertEquals("Coke",  vm.getCart().get(0).getName());
            assertTrue(vm.getCart().get(0).isRetrievable());
            assertTrue(vm.getCart().get(0).isInStock());
            vm.retrieveItem(vm.getCart());
            assertFalse(vm.getCart().get(0).isInStock());
            assertFalse(vm.getCart().get(0).isRetrievable());
            vm.cartClear();
            assertTrue(vm.getCart().isEmpty());
            String anythingElseResponse = prompt.prompt("Would you like to purchase another item? (Yes/No)\n",
                    "[yY]|[nN]|([y|Y][e|E][s|S])|([n|N][o|O])",
                    "That is not a valid response.");
            assertEquals("n", anythingElseResponse);
            run = selection.makeAnotherChoice(anythingElseResponse.trim());
        } while (run);
        assertFalse(run);
        String end = prompt.info(menu.showClosingScreen());
        assertEquals("Thank you, have a nice day.", end);
    }
}