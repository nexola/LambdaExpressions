package lessons.application;

import lessons.entities.lesson01.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Lesson03Consumer {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.0));
        list.add(new Product("HD Case", 80.90));

        // Para cada produto p -> Altera o preço do produto para o preço do produto * 1.1 (Preço + 10%)
        list.forEach(p -> p.setPrice(p.getPrice() * 1.1));

        /*
        list.forEach(p -> System.out.println(p));
        */

        list.forEach(System.out::println); // Method Reference
    }
}
