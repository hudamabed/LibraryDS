package projects;
public class Books {
    private int bookId;
    private String title;
    private String author;
    private int quantity;
    private String publisher;
    private String publishedDate;
    private long isbn;
    private int totalPages;
    private float rating;

    public Books() {
    }
   
    public Books(int bookId , String title , String author,int quantity, String publisher , String publishedDate ,long isbn, int totalPages ,float rating  ) {
        this.bookId=bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.isbn = isbn;
        this.publisher=publisher;
        this.publishedDate =publishedDate;
        this.isbn = isbn;
        this.totalPages=totalPages;
        this.rating=rating;  
    }
    
    

    public int getBookId() {
        return bookId;
    }
    
      public int getQuantity() {
        return quantity;
    }
     public void setQuantity(int quantity) {
        this.quantity= quantity;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    
    @Override
    public String toString() {
        return this.bookId + " - " + this.title + " by " + author + " published by " + publisher + " on "
                + publishedDate;
    }
    
}
