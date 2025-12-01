package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private final GroceryBill bill;
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public void add(Item i) {
        bill.add(i);
        if (regularCustomer) {
            double d = i.getDiscount();
            if (d > 0.0) {
                discountCount++;
                discountAmount += d;
            }
        }
    }

    public double getTotal() {
        double base = bill.getTotal();
        double result = regularCustomer ? (base - discountAmount) : base;
        return Math.round(result * 100.0) / 100.0;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        double full = bill.getTotal();
        if (full <= 0.0) return 0.0;
        double disc = regularCustomer ? discountAmount : 0.0;
        return Math.round((disc * 100.0 / full) * 1e14) / 1e14;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }

    public boolean isRegularCustomer() {
        return regularCustomer;
    }
}
