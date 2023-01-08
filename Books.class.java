public class Books {
    
    private int ID;
    private String BookName;
    private String Publisher;
    private int PageNumber;
    private String Author;

    public Books(int ID, String BookName, String Publisher, int PageNumber, String Author) {
        this.ID = ID;
        this.BookName = BookName;
        this.Publisher = Publisher;
        this.PageNumber = PageNumber;
        this.Author = Author;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int PageNumber) {
        this.PageNumber = PageNumber;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
    
}
