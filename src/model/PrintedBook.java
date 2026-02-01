package model;

public class PrintedBook extends BookBase {

    private int pages;

    public PrintedBook(int id, String title, Category category, int pages) {
        super(id, title, category);
        this.pages = pages;
    }

    @Override
    public String getBookType() {
        return "PRINTED";
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "PrintedBook: " + getTitle() +
                        " | Pages: " + pages +
                        " | Category: " + getCategory().getName()
        );
    }
}
