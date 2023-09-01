package Inventory;

public class Product {
    private final int id;
    private final String name;

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
