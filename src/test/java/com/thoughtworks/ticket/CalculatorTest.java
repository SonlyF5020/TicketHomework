package com.thoughtworks.ticket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    List<Commodity> commodities;

    @Before
    public void initCommodities() {
        commodities = new ArrayList<>();
    }

    @Test
    public void should_calculate_normal_commodities_price() {
        commodities.add(Commodity.COLA);
        commodities.add(Commodity.COLA);
        commodities.add(Commodity.BANANA);
        assertThat(Calculator.calculate(commodities), is(8.00));
    }

    @Test
    public void should_calculate_two_and_more_commodities_price() {
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        assertThat(Calculator.calculate(commodities), is(2.00));
    }

    @Test
    public void should_calculate_on_sale_commodities_price() {
        commodities.add(Commodity.BASKETBALL);
        commodities.add(Commodity.APPLE);
        commodities.add(Commodity.APPLE);
        assertThat(Calculator.calculate(commodities), is(105.00));
    }

    @Test
    public void should_calculate_combined_commodities_price() {
        commodities.add(Commodity.COLA);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BADMINTON);
        commodities.add(Commodity.BASKETBALL);
        commodities.add(Commodity.APPLE);
        assertThat(Calculator.calculate(commodities), is(105.00));
    }

    @Test
    public void should_calculate_normal_commodities_with_quantity() {
        assertThat(Calculator.calculate(Commodity.COLA, 3), is(9.00));
    }

    @Test
    public void should_calculate_two_plus_one_commodities_with_quantity() {
        assertThat(Calculator.calculate(Commodity.BADMINTON, 3), is(2.00));
    }

    @Test
    public void should_calculate_two_plus_one_commodities_with_more_quantity() {
        assertThat(Calculator.calculate(Commodity.BADMINTON, 7), is(5.00));
    }

    @Test
    public void should_calculate_two_plus_one_commodities_amount_with_quantity() {
        assertThat(Calculator.calculateTwoPlusOneDiscountAmount(Long.valueOf(5)), is(1L));
    }

    @Test
    public void should_calculate_two_plus_one_commodities_amount_with_more_quantity() {
        assertThat(Calculator.calculateTwoPlusOneDiscountAmount(Long.valueOf(7)), is(2L));
    }

    @Test
    public void should_calculate_on_sale_commodities_with_quantity() {
        assertThat(Calculator.calculate(Commodity.BASKETBALL, 3), is(285.00));
    }
}
