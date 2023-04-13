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

            List<Product> products = new ArrayList<>(); // Cria uma lista de objetos Product

            String line = br.readLine(); // Atribui a leitura de linha a uma variável

            while (line != null) { // Enquanto ainda existirem linhas para ler
                String[] vect = line.split(","); // Cria um vetor com os elementos da linha separados por ,
                products.add(new Product(vect[0], Double.parseDouble(vect[1]))); // Cria um objeto Product com o vetor (Nome do produto, preço)
                line = br.readLine(); // Avança para a próxima linha
            }

            // Pipeline
            Double precoMedio = products.stream() // Transforma em stream
                    .map(Product::getPrice) // Incorpora na stream apenas os valores dos produtos
                    .reduce(0.0, Double::sum) / products.size(); // Soma os valores da stream e divide pelo tamanho

            List<String> nomeDecrescente = products.stream() // Transforma em stream
                    .filter(x -> x.getPrice() < precoMedio) // Filtra os produtos com preço menor que a média
                    .map(Product::getName) // Mantém na stream apenas o nome desses produtos
                    .sorted(Comparator.reverseOrder()) // Coloca em ordem decrescente (Z - A)
                    .toList(); // Transforma de volta em lista


            System.out.printf("Média dos produtos: $%.2f\n", precoMedio);
            System.out.println("Produtos com preços abaixo da média: ");
            nomeDecrescente.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
