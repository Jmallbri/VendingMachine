package com.techelevator.view;

import com.techelevator.PaymentCalculator;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class PaymentCalculatorTests {
    PaymentCalculator paymentCalculator = new PaymentCalculator();

    @Test
    public void fedMoney() {

        BigDecimal testFeed = new BigDecimal(10);

        BigDecimal expected = new BigDecimal(10);

        BigDecimal result = paymentCalculator.feedMoney(testFeed);

        Assert.assertTrue(expected.compareTo(result) == 0);

    }

    @Test
    public void zero() {

        BigDecimal testFeed = new BigDecimal(0);

        BigDecimal expected = new BigDecimal(0);

        BigDecimal result = paymentCalculator.feedMoney(testFeed);

        Assert.assertTrue(expected.compareTo(result) == 0);
    }

    @Test
    public void negativeNumber() {

        BigDecimal testFeed = new BigDecimal(-1);

        BigDecimal expected = new BigDecimal(0);

        BigDecimal result = paymentCalculator.feedMoney(testFeed);

        Assert.assertTrue(expected.compareTo(result) == 0);
    }

}

