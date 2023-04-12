package lessons.entities.lesson02;

import lessons.entities.lesson01.Product;
import java.util.function.Predicate;

public class ProductPredicate implements Predicate<Product> {
    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100.0;
    }
}
