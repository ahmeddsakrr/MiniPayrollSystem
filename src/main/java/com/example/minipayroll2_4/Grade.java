package com.example.minipayroll2_4;

public class Grade {
    private String position;
    private double tax_rate;
    private double pay_rate;

    public Grade(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(double tax_rate) {
        this.tax_rate = tax_rate;
    }

    public double getPay_rate() {
        return pay_rate;
    }

    public void setPay_rate(double pay_rate) {
        this.pay_rate = pay_rate;
    }
}
