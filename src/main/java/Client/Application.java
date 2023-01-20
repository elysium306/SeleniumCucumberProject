package Client;

import Inventory.InventoryManager;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        InventoryManager manager = new InventoryManager(); // This is to create the object here

        // TODO: This is anonymous class in Java
        Thread inventoryTask = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO: this is how we initialize the thread
                manager.populateSoldProducts();
            }
        });

        Thread displayTask = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO: this is the second method from <InventoryManager> class
                manager.displaySoldProducts();
            }
        });

        inventoryTask.start();
        Thread.sleep(2000); // just so that there will be some products populated before iteration begins
//        inventoryTask.join(); [Step 2] However,this is not the way to go
//        Thread.sleep(2000); // TODO: this is old traditional way to do it [Step 1]
        displayTask.start();

    }
}
