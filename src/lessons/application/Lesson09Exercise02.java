package lessons.application;

import lessons.entities.lesson09.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Lesson09Exercise02 {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vitor\\Desktop\\Projetos Java\\FunctionalProgrammingAndLambdaExpressions\\src\\lessons\\archives\\input.txt"))) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            String line = br.readLine();
            List<Funcionario> funcionarios = new ArrayList<>();

            while (line != null) {
                String[] vetor = line.split(",");
                funcionarios.add(new Funcionario(vetor[0], vetor[1], Double.parseDouble(vetor[2])));
                line = br.readLine();
            }

            System.out.print("Mostrar email de funcionários que recebam acima de: $");
            Double valor = sc.nextDouble();

            List<String> emails = funcionarios.stream()
                    .filter(f -> f.getSalario() > valor)
                    .sorted((f1, f2) -> f1.getEmail().compareTo(f2.getEmail()))
                    .map(Funcionario::getEmail)
                    .toList();

            double soma = funcionarios.stream()
                    .filter(f -> f.getNome().charAt(0) == 'M')
                    .map(Funcionario::getSalario)
                    .reduce(0.0, Double::sum);

            System.out.printf("Email das pessoas que recebem acima de %.2f \n", valor);
            emails.forEach(System.out::println);
            System.out.printf("Soma do salário das pessoas cujo nome começa com a letra 'M': $%.2f", soma);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
