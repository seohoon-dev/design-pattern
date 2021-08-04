package com.company.iterator;

public class BookShelf implements Aggregate {

    private final Book[] books;
    private int index = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[index] = book;
        index++;
    }

    public int getLength() {
        return index;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
