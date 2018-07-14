package com.soen6441.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.soen6441.main.FilteringApples;
import com.soen6441.main.FilteringApples.Apple;

/**
 * 
 * Class for testing FilteringApples
 * @author PB
 *
 */
public class FilteringApplesTest {

	static FilteringApples filteringApples;
	static List<Apple> inventory;

	/**
	 * Sets up variables before Tests start to run
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		filteringApples = new FilteringApples();
		inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
	}

	/**
	 * Tests IsGreenApple with a green apple
	 */
	@Test
	public void testIsGreenApple_greenApple() {
		assertTrue(filteringApples.isGreenApple(new Apple(50, "green")));
	}

	/**
	 * Tests IsGreenApple with a non green apple
	 */
	@Test
	public void testIsGreenApple_nonGreenApple() {
		assertFalse(filteringApples.isGreenApple(new Apple(50, "red")));
	}

	/**
	 * Tests IsHeavyApple with a heavy apple
	 */
	@Test
	public void testIsHeavyApple_heavyApple() {
		Apple apple = new Apple();
		apple.setColor("green");
		apple.setWeight(470);
		assertTrue(filteringApples.isHeavyApple(apple));
	}

	/**
	 * Tests IsHeavyApple with a light apple
	 */
	@Test
	public void testIsHeavyApple_lightApple() {
		assertFalse(filteringApples.isHeavyApple(new Apple(80, "green")));
	}

	/**
	 * Tests FilterApples with a list of apples
	 */
	@Test
	public void testFilterApples_green() {
		List<Apple> greenApples = filteringApples.filterApples(inventory, FilteringApples::isGreenApple);
		assertEquals(2, greenApples.size());
	}

	/**
	 * Tests FilterApples with a list of apples
	 */
	@Test
	public void testFilterApples_heavy() {
		List<Apple> greenApples = filteringApples.filterApples(inventory, FilteringApples::isHeavyApple);
		assertEquals(1, greenApples.size());
	}

	/**
	 * Tests FilterGreenApples
	 */
	@Test
	public void testFilterGreenApples() {
		assertEquals(2, filteringApples.filterGreenApples(inventory).size());
	}

	/**
	 * Tests FilterHeavyApples
	 */
	@Test
	public void testFilterHeavyApples() {
		assertEquals(1, filteringApples.filterHeavyApples(inventory).size());
	}
}
