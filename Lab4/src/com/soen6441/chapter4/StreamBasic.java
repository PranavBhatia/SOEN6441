package com.soen6441.chapter4;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamBasic {

	public static void main(String... args) {
		// Java 7
		getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

		System.out.println("---");

		// Java 8
		getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

		System.out.println("---");

		// My Code
		// TASK 1
		System.out.println("TASK 1 ->");
		List<Dish> firstTwoMeatDishes = Dish.menu.stream().filter(d -> !d.isVegetarian()).limit(2).collect(toList());
		firstTwoMeatDishes.forEach(System.out::println);
		
		System.out.println("---");
		
		// TASK 2
		System.out.println("TASK 2 ->");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squares = numbers.stream().map(number -> number * number).collect(toList());
		squares.forEach(System.out::println);
		
		System.out.println("---");
		
		List<Integer> numbersList1 = Arrays.asList(1, 2, 3);
		List<Integer> numbersList2 = Arrays.asList(3, 4);
		List<List<Integer>> pairs = numbersList1.stream()
				.flatMap(x -> numbersList2.stream().map(y -> Arrays.asList(x, y))).collect(toList());
		pairs.forEach(System.out::println);
		
		System.out.println("---");
		
		List<List<Integer>> pairsDivisibleBy3 = numbersList1.stream()
				.flatMap(x -> numbersList2.stream().map(y -> Arrays.asList(x, y)))
				.filter(list -> (list.get(0) + list.get(1)) % 3 == 0).collect(toList());
		pairsDivisibleBy3.forEach(System.out::println);
		
		// TASK 3
		//System.out.println("TASK 3 ->");
	}

	public static List doThis(int number, List stream) {

		return Arrays.asList(number, stream.get(0));
	}

	public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for (Dish d : dishes) {
			if (d.getCalories() > 400) {
				lowCaloricDishes.add(d);
			}
		}
		List<String> lowCaloricDishesName = new ArrayList<>();
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		for (Dish d : lowCaloricDishes) {
			lowCaloricDishesName.add(d.getName());
		}
		return lowCaloricDishesName;
	}

	public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
		return dishes.stream().filter(d -> d.getCalories() > 400).sorted(comparing(Dish::getCalories))
				.map(Dish::getName).collect(toList());
	}
}
