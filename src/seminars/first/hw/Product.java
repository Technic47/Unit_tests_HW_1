package seminars.first.hw;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private int cost; // Стоимость продукта
    private String title; // Название

    public Product(int cost, String title) {
        this.cost = cost;
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return cost == product.cost && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, title);
    }

    @Override
    public int compareTo(Product o) {
        return new ProductComparator().compare(this, o);
    }
}

