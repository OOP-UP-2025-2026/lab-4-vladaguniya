package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    private Employee clerk;
    private List<Item> items = new ArrayList<>();

    public GroceryBill(Employee clerk) { this.clerk = clerk; }

    public void add(Item i) { items.add(i); }

    public double getTotal() {
        double total = 0;
        for (Item i : items) total += i.getPrice();
        return total;
    }

    public Employee getClerk() { return clerk; }
}
