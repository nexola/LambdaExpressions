package lessons.application;

import lessons.entities.lesson01.Product;
import lessons.entities.lesson05.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Lesson05ParameterFunction {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        ProductService ps = new ProductService();

        // Realiza a soma dos elementos resultantes da expressão do predicado, sendo assim uma função flexível
        double sum = ps.filteredSum(list, p -> p.getPrice() < 100.0);

        System.out.println("Sum = " + String.format("%.2f", sum));
    }
}
