package com.example.lining.shopping;

/**
 * Created by 李宁 on 2017/3/29.
 */
public class Product {

    private String title;
    private int price;
    private int count;
    private boolean isChecked;

    public Product() {
    }

    public Product(String title, int count, int price) {
        this.title = title;
        this.isChecked = isChecked;
        this.count = count;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
