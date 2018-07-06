package com.soen6441.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.soen6441.FilteringApples;
import com.soen6441.FilteringApples.Apple;

public class TestFilteringApples {

	static FilteringApples filteringApples;

	@BeforeClass
	public static void setUp() throws Exception {
		filteringApples = new FilteringApples();
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
		assertTrue(filteringApples.isHeavyApple(new Apple(160, "green")));
	}

	@Test
	public void testIsHeavyApple_lightApple() {
		assertFalse(filteringApples.isHeavyApple(new Apple(80, "green")));
	}

}
