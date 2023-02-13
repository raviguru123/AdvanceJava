package org.example.chapterOneLambda;

import org.example.App;
import org.example.common.Apple;
import org.example.enums.Color;
import org.example.enums.Country;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Driver {


    public static void init() {
        List<Apple> appleList = new ArrayList<Apple>();
        appleList.add(Apple.builder().weight(30).color(Color.GREEN).country(Country.ASA).build());
        appleList.add(Apple.builder().weight(30).color(Color.GREEN).country(Country.INDIA).build());
        appleList.add(Apple.builder().weight(50).color(Color.RED).country(Country.CHINA).build());
        appleList.add(Apple.builder().weight(10).color(Color.BLUE).country(Country.INDIA).build());
        appleList.add(Apple.builder().weight(20).color(Color.BLUE).country(Country.USA).build());

        appleList.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getCountry).reversed());

        System.out.println("Hello this is apple list =========="+ appleList);


        Function<Integer, Integer> f = (x)-> x+1;
        Function<Integer, Integer> g = (x)-> x*2;
        Function<Integer, Integer> d = f.andThen(g);
        System.out.println(d.apply(10));

    }
}
