package Inventory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {

//    List<Product> soldProductsList = new ArrayList<>();
    List<Product> soldProductsList = new CopyOnWriteArrayList<>();
    // TODO: instead of this, we can use Vector, or CopyOnWriteArrayList
//    List<Product> purchasedProductList = new ArrayList<>();
    List<Product> purchasedProductList = new CopyOnWriteArrayList<>();
    public void populateSoldProducts(){
        for(int i = 0; i < 1000; i++) {
            Product prod = new Product(i, "test-product_" + i);
            soldProductsList.add(prod);
            System.out.println("ADDED: " + prod);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts() {
        for (Product prod : soldProductsList) {
            System.out.println("PRINTING THE SOLD: " + prod.toString());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
