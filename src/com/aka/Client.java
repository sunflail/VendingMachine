package com.aka;

public class Client {
    public static void main(String[] args) {
        Customer customer = new Customer();
        VendingMachine vm = new VendingMachine();
        Item item1 = new Item("XYZ", "Drinks", 2.99, true);
        Menu menu1 = new Menu("Drinks");

//        Program starts
//        Who does it? Main()
//        Show the initial welcome screen
//        Could include splash screen/logo
//        Program asks customer for category selection

        Menu.showStartMenu();
        Menu.showCategoryMenu(menu1);
        customer.askForResponse();
////        Customer makes a choice
        customer.makeSelection();
////        Program reads customer selection - prompter from console
//        Program.readSelection()
////        Program passes selection to Menu
////        Menu shows the item selection based on input
        Menu.showItemMenu(customer.makeSelection(), item1); // includes prices
////        Program asks customer for item selection
        customer.askForResponse();
////        Customer makes choice
        customer.makeItemSelection();
////        VM takes selection and calculates total
        vm.findItem(item1);
////        Check availability
        vm.calculateTotal();
////        Menu displays total and requests payment
        Menu.showPaymentMenu(vm.calculateTotal());
////        Program asks customer for payment input
        customer.askForResponse();
////        Customer enter payment amount
        customer.makePayment(2.99);
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
        customer.askForResponse();

////        If yes -> back to 2
////        If no -> thank and exit
        customer.makeAnotherChoice();
        Menu.showClosingScreen(); // Program calls exit()
    }
}
