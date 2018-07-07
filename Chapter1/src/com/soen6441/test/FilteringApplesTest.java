package com.soen6441.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.soen6441.FilteringApples;
import com.soen6441.FilteringApples.Apple;

public class FilteringApplesTest {

	static FilteringApples filteringApples;
	static List<Apple> inventory;

	@BeforeClass
	public static void setUp() throws Exception {
		filteringApples = new FilteringApples();
		inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
	}

	@Test
	public void testIsGreenApple_greenApple() {
		assertTrue(filteringApples.isGreenApple(new Apple(50, "green")));
	}

	@Test
	public void testIsGreenApple_nonGreenApple() {
		assertFalse(filteringApples.isGreenApple(new Apple(50, "red")));
	}

	@Test
	public void testIsHeavyApple_heavyApple() {
		Apple apple = new Apple();
		apple.setColor("green");
		apple.setWeight(470);
		assertTrue(filteringApples.isHeavyApple(apple));
	}

	@Test
	public void testIsHeavyApple_lightApple() {
		assertFalse(filteringApples.isHeavyApple(new Apple(80, "green")));
	}

	@Test
	public void testFilterApples() {
		List<Apple> greenApples = filteringApples.filterApples(inventory, FilteringApples::isGreenApple);
		assertEquals(2, greenApples.size());
	}
	
	@Test
	public void testFilterHeavyApples() {
		List<Apple> greenApples = filteringApples.filterApples(inventory, FilteringApples::isHeavyApple);
		assertEquals(1, greenApples.size());
	}
}
