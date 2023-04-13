package lessons.application;

import lessons.entities.lesson01.Product;
import lessons.entities.lesson04.UpperCaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Lesson04Function {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.0));
        list.add(new Product("HD Case", 80.90));

        /* .stream() -> Transforma a lista em uma stream
           .map() -> Faz a função percorrer cada elemento da stream
           .toList() -> Retorna a stream para lista */
        List<String> names = list.stream().map(new UpperCaseName()).toList();

        // Método referência
        List<String> names2 = list.stream().map(p -> p.getName().toUpperCase()).toList();


        names.forEach(System.out::println);

    }
}
