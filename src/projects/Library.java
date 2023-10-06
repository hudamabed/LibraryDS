package projects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.TreeMap;

public class Library {

    BufferedReader reader;

    final public TreeMap<Integer, Books> booksTree;
    int totalBooks = 0;

    public Library() throws FileNotFoundException, IOException, NumberFormatException {
        this.reader = new BufferedReader(new FileReader("books_file.txt"));
        booksTree = new TreeMap<>();
        List<Books> books = new ArrayList<>();
        String line = null;
        Books book = new Books();
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                books.add(book);
                book = new Books();
            } else if (!line.contains("->")) {
                try {
                    book.setBookId(Integer.parseInt(line));
                    totalBooks++;
                } catch (NumberFormatException e) {
                }
            } else {
                String[] data = line.trim().split(" -> ");
                String attr = data[0].trim();
                String value;
                if (data.length > 1) {
                    value = data[1].trim();
                } else {
                    value = "";
                }

                switch (attr) {
                    case "title":
                        book.setTitle(value);
                        break;
                    case "author":
                        book.setAuthor(value);
                        break;
                    case "quantity":
                        book.setQuantity(Integer.parseInt(value));
                        break;
                    case "publisher":
                        book.setPublisher(value);
                        break;
                    case "published_date":
                        book.setPublishedDate(value);
                        break;
                    case "isbn":
                        book.setIsbn(Long.parseLong(value));
                        break;
                    case "total_pages":
                        book.setTotalPages(Integer.parseInt(value));
                        break;
                    case "rating":
                        book.setRating(Float.parseFloat(value));
                        break;
                    default:
                        break;
                }
            }
        }
        reader.close();
        books.forEach((b) -> {
            if (b.getQuantity() > 0) {
                booksTree.put(b.getBookId(), b);
            }
        });

    }

    public void insert(String title, String author, int quantity, long isbn, String publisher, int totalPages, float rating, String publishedDate) throws IOException {
        try ( FileWriter myWriter = new FileWriter("books_file.txt", true)) {
            myWriter.write("\n" + totalBooks + "\n");
            myWriter.write("title -> " + title + "\n");
            myWriter.write("author -> " + author + "\n");
            myWriter.write("quantity -> " + quantity + "\n");
            myWriter.write("isbn -> " + isbn + "\n");
            myWriter.write("publisher -> " + publisher + "\n");
            myWriter.write("total_pages -> " + totalPages + "\n");
            myWriter.write("rating -> " + rating + "\n");
            myWriter.write("published_date -> " + publishedDate + "\n");
            myWriter.write("quantity-> " + quantity + "\n" + "\n");
            totalBooks = totalBooks + 1;
        }

    }

    public ArrayList<Integer> searchAdmin(String value) {
        List<Integer> keys = new ArrayList<>(booksTree.keySet());
        ArrayList array = new ArrayList();
        Books book;
        for (Integer key : keys) {
            book = booksTree.get(key);
            if (book.getTitle() == null ? value == null : book.getTitle().equals(value)) {
                array.add(key);
            } else if (book.getAuthor() == null ? value == null : book.getAuthor().equals(value)) {
                array.add(key);
            } else if (String.valueOf(book.getIsbn()) == null ? value == null : String.valueOf(book.getIsbn()).equals(value)) {
                array.add(key);

            } else if (String.valueOf(book.getRating()) == null ? value == null : String.valueOf(book.getRating()).equals(value)) {
                array.add(key);

            } else if (String.valueOf(book.getQuantity()) == null ? value == null : String.valueOf(book.getQuantity()).equals(value)) {
                array.add(key);

            } else if (book.getPublisher() == null ? value == null : book.getPublisher().equals(value)) {
                array.add(key);
            }

        }
        return array;
    }

    public Object[] get(int key) {
        Object[] array = new Object[5];
        List<Integer> keys = new ArrayList<>(booksTree.keySet());
        Books book;

        for (Integer key1 : keys) {
            book = booksTree.get(key1);
            if (key1 == key) {
                array[0] = key;
                array[1] = book.getTitle();
                array[2] = book.getAuthor();
                array[3] = book.getRating();
                array[4] = book.getQuantity();
            }
        }
        return array;
    }

    public Object[] delete(int key) {
        Object[] array = new Object[5];
        List<Integer> keys = new ArrayList<>(booksTree.keySet());
        Books book;

        for (Integer key1 : keys) {
            book = booksTree.get(key1);
            if (key1 == key) {
                array[0] = key;
                array[1] = book.getTitle();
                array[2] = book.getAuthor();
                array[3] = book.getRating();
                array[4] = book.getQuantity();
            }
        }
        booksTree.remove(key);
        return array;

    }
}
