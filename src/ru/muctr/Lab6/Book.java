package ru.muctr.Lab6;

public class Book {
    private int id;
    private String title;
    private String subject;
    private int year;
    private double price;
    private String language;

    public Book(int id, String title, String subject, int year, double price, String language) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.year = year;
        this.price = price;
        this.language = language;
    }

    // Геттеры и сеттеры для всех полей

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}

