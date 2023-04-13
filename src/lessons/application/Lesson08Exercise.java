package lessons.application;

import lessons.entities.lesson01.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lesson08Exercise {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\Desktop\\Projetos Java\\FunctionalProgrammingAndLambdaExpressions\\src\\lessons\\archives\\in.txt"))) {

            List<Product> products = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] vect = line.split(",");
                products.add(new Product(vect[0], Double.parseDouble(vect[1])));
                line = br.readLine();
            }

            Double precoMedio = products.stream().map(Product::getPrice).reduce(0.0, Double::sum) / products.size(); // Soma os valores da lista e divide pelo tamanho

            System.out.printf("Média dos produtos: $%.2f\n", precoMedio);

            // Pipeline
            List<String> nomeDecrescente = products.stream() // Transforma em stream
                    .filter(x -> x.getPrice() < precoMedio) // Filtra os produtos com preço menor que a média
                    .map(Product::getName) // Acrescenta a lista o nome desses produtos
                    .sorted(Comparator.reverseOrder()).toList(); // Coloca em ordem decrescente e transforma de volta em lista

            System.out.println("Produtos com preços abaixo da média: ");
            nomeDecrescente.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
