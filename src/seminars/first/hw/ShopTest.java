package seminars.first.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
    private final Shop testShop;
    private final Product mostExpensive;
    private final List<Product> testList;
    private final Product apple = new Product(50, "Apple");
    private final Product banana = new Product(65, "Banana");
    private final Product fish = new Product(150, "Fish");
    private final Product beef = new Product(100, "Beef");
    private final Product egg = new Product(25, "Egg");

    public ShopTest(Shop testShop) {
        this.testShop = testShop;
        this.testList = this.addItems(apple, banana, fish, beef, egg);
        this.mostExpensive = maxcheck(this.testList);
    }

    private List<Product> addItems(Product... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    private Product maxcheck(List<Product> list) {
        Product mostExpensive = null;
        int maxx = 0;
        for (Product product : list) {
            int cost = product.getCost();
            if (cost > maxx) {
                mostExpensive = product;
                maxx = cost;
            }
        }
        return mostExpensive;
    }

    private List<Product> sortByPriceTest() {
        this.testList.sort(new ProductComparator());
        return this.testList;
    }


    /*
         1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
         2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
         3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
        */

    public String checks() {
        assertThat(this.testShop.getProducts())
                .contains(apple, banana, fish, beef, egg)
                .hasSize(5);

        Product prod1 = this.testShop.getMostExpensiveProduct();
        assertThat(prod1).isEqualTo(this.mostExpensive);

        List<Product> list1 = this.testShop.getSortedListProducts();
        assertThat(list1).isEqualTo(this.sortByPriceTest());
        assertThat(list1).containsSequence(this.sortByPriceTest());
        return "Pass";
    }
}


class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getCost(), o2.getCost());
    }
}

class main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Product apple1 = new Product(50, "Apple");
        Product banana1 = new Product(65, "Banana");
        Product fish1 = new Product(150, "Fish");
        Product beef1 = new Product(100, "Beef");
        Product egg1 = new Product(25, "Egg");
        List<Product> shopList = Arrays.asList(apple1, fish1, banana1, beef1, egg1);
        shop.setProducts(shopList);

        ShopTest shopTest = new ShopTest(shop);
        System.out.println("Tests status: ");
        System.out.println(shopTest.checks());
    }
}



