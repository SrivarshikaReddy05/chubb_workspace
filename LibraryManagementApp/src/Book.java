public class Book extends Item {
    private int totalCopies;
    private int availableCopies;

    public Book(int id, String title, String author, int copies) {
        super(id, title, author);
        this.totalCopies = Math.max(1, copies);
        this.availableCopies = this.totalCopies;
    }

    public int getAvailableCopies() { return availableCopies; }

    public boolean isAvailable() { return availableCopies > 0; }

    public void borrowOne() {
        if (availableCopies <= 0) throw new IllegalStateException("No copies available");
        availableCopies--;
    }

    public void returnOne() {
        if (availableCopies >= totalCopies) throw new IllegalStateException("All copies are already available");
        availableCopies++;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + availableCopies + "/" + totalCopies + '}';
    }
}
