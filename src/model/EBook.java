package model;

public class EBook extends BookBase {
    private double fileSizeMb;

    public EBook(int id, String title, Category category, double fileSizeMb) {
        super(id, title, category);
        this.fileSizeMb = fileSizeMb;
    }

    @Override
    public String getBookType() { return "E-BOOK"; }

    @Override
    public void displayInfo() {
        System.out.println("E-Book: " + getTitle() + " | Size: " + fileSizeMb + "MB");
    }
}