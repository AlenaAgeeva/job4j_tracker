package ru.job4j.tracker.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("ABC", 10);
        Book book3 = new Book("Weather", 500);
        Book book4 = new Book("Maternity", 345);
        Book[] books = {book1, book2, book3, book4};
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getCount());
        }
        books[0] = book4;
        books[3] = book1;
        System.out.println();
        for (Book b : books) {
            System.out.println(b.getName() + " - " + b.getCount());
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            if (books[index].getName().equals("Clean code")) {
                System.out.println(books[index].getName() + " - " + books[index].getCount());
            }
        }
    }
}
