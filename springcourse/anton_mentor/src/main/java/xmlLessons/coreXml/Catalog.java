package xmlLessons.coreXml;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Book> listBook = new ArrayList<>();

    public void addBook(Book book) throws IllegalAccessException {
        if(book == null){
            throw new IllegalAccessException("Null");
        }
        listBook.add(book);
    }

    public ArrayList<Book> getListBook() {
        return listBook;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "listBook=" + listBook +
                '}';
    }
}
