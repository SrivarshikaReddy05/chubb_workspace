public class Item {
    protected final int id;
    protected final String title;
    protected final String author;

    public Item(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return id + ": \"" + title + "\" by " + author;
    }
}
