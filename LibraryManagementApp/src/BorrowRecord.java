import java.time.LocalDate;

public class BorrowRecord {
    private final int memberId;
    private final int bookId;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowRecord(int memberId, int bookId, LocalDate borrowDate, LocalDate dueDate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

    public int getMemberId() { return memberId; }
    public int getBookId() { return bookId; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isReturned() { return returnDate != null; }

    public void setReturnDate(LocalDate date) {
        this.returnDate = date;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "memberId=" + memberId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + (returnDate == null ? "NOT_RETURNED" : returnDate) +
                '}';
    }
}
