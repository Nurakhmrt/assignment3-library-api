package model;

public interface Printable {
    String toPrettyString();

    default void print() {
        System.out.println(toPrettyString());
    }
}
