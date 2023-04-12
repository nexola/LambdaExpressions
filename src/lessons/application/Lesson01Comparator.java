package lessons.application;

import lessons.entities.lesson01.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lesson01Comparator {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        // Função anônima com expressão lambda | ARROW FUNCTION (parâmetro) -> {Implementação da função} | Se tiver apenas uma linha, podem ser retiradas as chaves
        Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        // Simplificado
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
