package projects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class HashUser {

    public HashMap<Integer, Books> hash = new HashMap<>();
    Library lib;
    Books book;
    TreeMap<Integer, Books> booksTree;

    public HashUser() throws IOException {
        this.lib = new Library();
        booksTree = lib.booksTree;
    }

    public ArrayList<Integer> searchUser(String title) {

        List<Integer> keys = new ArrayList<>(booksTree.keySet());
        //int keyfound=-1;
        ArrayList<Integer> array = new ArrayList<>();

        for (Integer key : keys) {
            book = booksTree.get(key);
            if (book.getTitle() == null ? title == null : book.getTitle().equals(title)) {
                array.add(key);
            }
        }
        return array;
    }

    void addBook(int id) {
        hash.put(id, book);
    }

}
