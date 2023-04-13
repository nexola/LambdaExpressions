package lessons.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lesson07Pipeline {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);

        System.out.println(Arrays.toString(st1.toArray()));

        int sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum = " + sum);

        // Pipeline
        List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0) // Filtra a stream com base no predicado
                .map(x -> x * 10) // Continua as equações com o resultado anterior
                .toList();

        System.out.println(Arrays.toString(newList.toArray()));
    }
}
