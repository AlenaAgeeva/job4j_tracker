package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("7sfe", "Jacket"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        Assert.assertEquals(map.get("3sfe"), new Order("3sfe", "Dress"));
        Assert.assertEquals(map.get("7sfe"), new Order("7sfe", "Jacket"));
    }
}