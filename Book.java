public class Book {
    private final int id;
    private final String name;
    private boolean issued;
    private String issuedTo;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.issued = false;
        this.issuedTo = null;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isIssued() { return issued; }
    public String getIssuedTo() { return issuedTo; }

    public void issueTo(String student) {
        this.issued = true;
        this.issuedTo = student;
    }

    public void markReturned() {
        this.issued = false;
        this.issuedTo = null;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name
                + (issued ? " | Issued to: " + issuedTo : " | Available");
    }
}
