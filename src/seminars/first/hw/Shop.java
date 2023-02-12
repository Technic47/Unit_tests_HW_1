package seminars.first.hw;

import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        for (int i = 1; i < this.products.size(); i++) {
            for (int j = i; j > 0 && this.products.get(j - 1).getCost() > this.products.get(j).getCost(); j--) {
                swap((j - 1), j);
            }
        }
        return this.products;
    }

    private void swap(int i, int j) {
        Product temp = this.products.get(i);
        Product temp2 = this.products.get(j);
        this.products.remove(i);
        this.products.set(i, temp2);
        this.products.remove(j);
        this.products.set(j, temp);
    }

    private void sortProductByPrice() {
        this.products.sort(new ProductComparator());
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        this.sortProductByPrice();
        int maxIndex = this.products.size();
        return this.products.get(maxIndex - 1);
    }
}