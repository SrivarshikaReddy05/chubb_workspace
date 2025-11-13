import java.time.LocalDate;
import java.util.*;

public class Library {
    private int nextBookId = 1;
    private int nextMemberId = 1;

    private final Map<Integer, Book> books = new HashMap<>();
    private final Map<Integer, Member> members = new HashMap<>();
    private final List<BorrowRecord> borrowRecords = new ArrayList<>();
    private final Map<Integer, BorrowRecord> activeBorrowByBook = new HashMap<>();
    private final Map<Integer, List<BorrowRecord>> borrowsByMember = new HashMap<>();

    public Book addBook(String title, String author, int copies) {
        Book b = new Book(nextBookId++, title, author, copies);
        books.put(b.getId(), b);
        return b;
    }

    public Member addMember(String name, String email) {
        Member m = new Member(nextMemberId++, name, email);
        members.put(m.getId(), m);
        return m;
    }

    public BorrowRecord borrowBook(int memberId, int bookId, int days) {
        Member member = members.get(memberId);
        if (member == null) throw new IllegalArgumentException("Member not found: " + memberId);

        Book book = books.get(bookId);
        if (book == null) throw new IllegalArgumentException("Book not found: " + bookId);

        if (!book.isAvailable()) throw new IllegalArgumentException("No copies available for book: " + book.getTitle());

        book.borrowOne();
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(Math.max(1, days));

        BorrowRecord rec = new BorrowRecord(memberId, bookId, borrowDate, dueDate);
        borrowRecords.add(rec);
        activeBorrowByBook.put(bookId, rec);
        borrowsByMember.computeIfAbsent(memberId, k -> new ArrayList<>()).add(rec);
        return rec;
    }

    public void returnBook(int memberId, int bookId) {
        Member member = members.get(memberId);
        if (member == null) throw new IllegalArgumentException("Member not found: " + memberId);
        Book book = books.get(bookId);
        if (book == null) throw new IllegalArgumentException("Book not found: " + bookId);

        List<BorrowRecord> memberBorrows = borrowsByMember.getOrDefault(memberId, Collections.emptyList());
        BorrowRecord target = null;
        for (BorrowRecord r : memberBorrows) {
            if (r.getBookId() == bookId && !r.isReturned()) {
                target = r;
                break;
            }
        }
        if (target == null) throw new IllegalArgumentException("No active borrow found for this book.");

        target.setReturnDate(LocalDate.now());
        book.returnOne();
        BorrowRecord active = activeBorrowByBook.get(bookId);
        if (active != null && active == target) activeBorrowByBook.remove(bookId);
    }

    public Collection<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Collection<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    public List<BorrowRecord> getAllBorrowRecords() {
        return new ArrayList<>(borrowRecords);
    }

    public List<Book> searchBooksByTitle(String q) {
        String lower = q.toLowerCase();
        List<Book> res = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.getTitle().toLowerCase().contains(lower)) res.add(b);
        }
        return res;
    }
}
