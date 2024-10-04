import java.util.*;

// Define Book class
class Book {
    private String ISBN;
    private String title;

    // Constructor
    public Book(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
    }

    // Getters
    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }
}

// Define Member class
class Member {
    private String phoneNumber;
    private String name;
    private List<Book> booksLoaned;

    // Constructor
    public Member(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.booksLoaned = new ArrayList<>();
    }

    // Getters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooksLoaned() {
        return booksLoaned;
    }

    // Add a book to the list of books loaned
    public void loanBook(Book book) {
        if (booksLoaned.size() < 6) {
            booksLoaned.add(book);
        } else {
            System.out.println("Cannot loan more than 6 books.");
        }
    }
}

// Library Management System
class Library {
    private List<Member> members;

    // Constructor
    public Library() {
        this.members = new ArrayList<>();
    }

    // Add a new member
    public void addMember(String phoneNumber, String name) {
        // Check if phoneNumber is unique
        if (isUniquePhoneNumber(phoneNumber)) {
            Member newMember = new Member(phoneNumber, name);
            members.add(newMember);
        } else {
            System.out.println("Phone number already exists.");
        }
    }

    // Check if phone number already exists
    private boolean isUniquePhoneNumber(String phoneNumber) {
        for (Member member : members) {
            if (member.getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
        }
        return true;
    }

    // List all members in ascending order of name
    public void listAllMembers() {
        members.sort(Comparator.comparing(Member::getName));
        for (Member member : members) {
            System.out.println("Name: " + member.getName() + ", Phone: " + member.getPhoneNumber());
        }
    }

    // Search member by name
    public void searchMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + member.getName() + ", Phone: " + member.getPhoneNumber());
                return;
            }
        }
        System.out.println("Member not found.");
    }

    // Method to handle support call for slow search
    public void handleSupportCall() {
        // Analyze and optimize search algorithms, possibly implementing indexing or caching mechanisms.
        // Also, analyze database queries and indexes for performance optimization.
        System.out.println("Optimizing search functionality...");
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Instantiate Library
        Library library = new Library();

        // Perform operations based on user stories
        library.addMember("1234567890", "John Doe");
        library.addMember("0987654321", "Alice Smith");

        System.out.println("List of all members:");
        library.listAllMembers();

        System.out.println("\nSearch result for member with name 'John Doe':");
        library.searchMemberByName("John Doe");

        System.out.println("\nHandling support call for slow search:");
        library.handleSupportCall();
    }
}
