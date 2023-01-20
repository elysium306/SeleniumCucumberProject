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
        Thread.sleep(2000);
        displayTask.start();

    }
}
