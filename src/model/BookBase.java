package model;

public abstract class BookBase {
    private int id;
    private String title;
    private Category category;

    public BookBase(int id, String title, Category category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public Category getCategory() { return category; }

    public abstract String getBookType();
    public abstract void displayInfo();
}