package org.example.ChapterTwo;

import org.example.common.Dish;
import org.example.common.Trader;
import org.example.common.Transaction;
import org.example.enums.Type;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.*;

public class Driver {

    public static <T> void print(String prefix, List<T> data) {
        System.out.println(prefix + " ===>" + data);
    }

    public static <T> void print(String prefix, T data) {
        System.out.println(prefix + " ===>" + data);
    }

    public static void init() {
//        init1();
//        init5();
        init6();
        init7();
    }

    public static void init1() {
//        List<Dish> menu = new ArrayList<>();
//        menu.add(Dish.builder().calories(500).name("RICE").type(Type.HIGH).build());
//        menu.add(Dish.builder().calories(600).name("DAL").type(Type.HIGH).build());
//        menu.add(Dish.builder().calories(100).name("SALAD").type(Type.LOW).build());
//        menu.add(Dish.builder().calories(100).name("CHAPATI").type(Type.LOW).build());
//        menu.add(Dish.builder().calories(300).name("SABJI").type(Type.MEDIUM).build());
//
//        List<String> output = menu.stream().filter((dish -> dish.getCalories() > 400))
//                .sorted(Comparator.comparing(Dish::getCalories).reversed())
//                .map(Dish::getName)
//                .collect(Collectors.toList());
//
////        System.out.println("output======>" + output);
//        Map<Type, List<Dish>> map = menu.stream().collect(groupingBy(Dish::getType));
//        System.out.println("gropu by ::" + map);


        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("pork", false, 300, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


//        print("sorted", menu.stream().filter((dish -> dish.getCalories() > 400))
//                .map(Dish::getName)
//                .limit(3)
//                .collect(Collectors.toList()));


//        print("Distinct", menu.stream()
//                .distinct()
//                .count());


//        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//        List<Integer> numbers2 = Arrays.asList(3, 4);
//
//        numbers1.stream().flatMap(i ->
//                numbers2.stream().filter(j -> i + j % 3 == 0).map(j -> new Integer[]{i, j})
//        ).collect(Collectors.toList());
//
//        print("Hlello", menu.stream().map((dish -> 1)).reduce(0,(a, b) -> a + b));

    }

    public static void init5() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        print("first", transactions.stream().collect(groupingBy(Transaction::getYear)));

        print("First Question :", transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()));
        print("Second Question :", traders.stream().map(Trader::getCity).distinct().collect(Collectors.toList()));
        print("Third question", traders.stream().filter(t -> t.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList()));


        print("fourth question", traders.stream().map(Trader::getName).sorted().collect(Collectors.toList()));

        Optional<Trader> tr = traders.stream().filter(t -> t.getCity().equals("Milan")).findAny();
        print("fifth question", tr.get());

        print("six question", transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).collect(toList()));

        print("seventh question", transactions.stream().max(Comparator.comparing(Transaction::getValue)));

        print("eight  question", transactions.stream().min(Comparator.comparing(Transaction::getValue)));


        Stream.iterate(0, n -> n + 2)
                .limit(1)
                .forEach(System.out::println);


        Stream.iterate(1, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);





    }

    public static void init6() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        print("check========>", transactions.stream().collect(reducing(0, Transaction::getValue, Integer::sum)));
    }


    public static void init7() {

    }
}
