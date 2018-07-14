package com.soen6441;
import java.util.*;

public class FilteringApples {

	public static void main(String... args) {

		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
		System.out.println(heavyApples);

		// []
		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
			public boolean test(Apple a) {
				return a.getColor().equals("red");
			}
		});
		System.out.println(redApples2);

		System.out.println("\n *****************MY CHANGES***************");
		System.out.println("\nAppleColorFormatter(): ");
		prettyPrintApple(inventory, new AppleColorFormatter());
		System.out.println("\nAppleWeightFormatter(): ");
		prettyPrintApple(inventory, new AppleWeightFormatter());
	}

	public static List<Apple> filter(List<Apple> inventory, ApplePredicate applePredicate) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (applePredicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
		for (Apple apple : inventory) {
			String output = appleFormatter.format(apple);
			System.out.println(output);
		}
	}

	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
		}
	}

	interface ApplePredicate {
		public boolean test(Apple a);
	}

	interface AppleFormatter {
		public String format(Apple apple);
	}

	static class AppleWeightPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return apple.getWeight() > 150;
		}
	}

	static class AppleColorPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return "red".equals(apple.getColor()) && apple.getWeight() > 150;
		}
	}

	static class AppleWeightFormatter implements AppleFormatter {
		@Override
		public String format(Apple apple) {
			boolean isHeavy = new AppleWeightPredicate().test(apple);
			if (isHeavy)
				return "Heavy apple: " + apple.getWeight().toString();
			else
				return "Light apple: " + apple.getWeight().toString();
		}
	}

	static class AppleColorFormatter implements AppleFormatter {
		@Override
		public String format(Apple apple) {
			boolean isHeavy = new AppleWeightPredicate().test(apple);
			if (isHeavy)
				return "Heavy apple: " + apple.getColor();
			else
				return "Light apple: " + apple.getColor();
		}
	}
}