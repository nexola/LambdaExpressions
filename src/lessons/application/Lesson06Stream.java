package lessons.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lesson06Stream {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        // toArray() converte a stream para vetor
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob").map(String::toUpperCase);
        System.out.println(Arrays.toString(st2.toArray()));

        // iterate(primeiro elemento da stream, equação de geração de stream
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        // limit(tamanho máximo da stream)
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        // Stream infinita da sequência de Fibonacci
        Stream<Long> st4 = Stream.iterate(new long[]{ 0L, 1L }, p->new long[]{ p[1], p[0]+p[1] }).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(15).toArray()));
    }
}
