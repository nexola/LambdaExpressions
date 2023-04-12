package lessons.application;

import lessons.entities.lesson01.Product;
import lessons.entities.lesson02.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Lesson02Predicate {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.0));
        list.add(new Product("HD Case", 80.90));

        // METHOD REFERENCE
        list.removeIf(Product::staticProductPredicate);

        // Função lambda com variável
        double min = 100.0;
        Predicate<Product> pred = p -> p.getPrice() >= min;
        list.removeIf(pred);

        // Função lambda inline
        list.removeIf(p -> p.getPrice() >= min);

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
