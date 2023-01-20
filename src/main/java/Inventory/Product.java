package Inventory;

public class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
