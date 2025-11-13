public class Member extends Person {
    private final String email;

    public Member(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }
}
