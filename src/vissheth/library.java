package vissheth;


/*Questions :-

Management :-
WeLoveBooks is a library of books. Each book is identified by ISBN number and has a title. 
To be a member of a library a person needs to register with the library using his telephone number.
Telephone number must be unique. A person cannot loan more than 6 books.

Requirement
You need to develop an application which manages members, manages books and manages loaning of books. 
UI for this is application is implemented by a different team.
You need to implement back end services of this application for each user case described below.
Each user story must be attempted in the order listed. You will get disqualified if you attempt to implement user stories in any order other than the listed order.

Cannot loan more than 6 books.

Each user story must be attempted in the order listed. You will get disqualified if you attempt to implement user stories in any order other than the listed order.

User Stories
Add a new member
A librarian should be able to register a new
List all Members
A Librarian should be able to list all members of a library.
- Constraint: The results should be shown in ascending order of name.

Search Members
A librarian should be able to search a member by name.

Support Call
Librarian complains that search has become slow. Though the application has not become unusable what took millis now takes seconds to search.
What is the first thing you will do?
How can slowness be addressed?
Loan more than book

Code :-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class City{
	private static City city = new City();
	// to add more library.	
	private Set<Library> lib = new HashSet<>();
}

class Library{
	private static Library lib = new Library();
	private Set<Member> member = new HashSet<>();
	private Set<Book> book = new HashSet<>();
	
	//	private Set<Item> items = new HashSet<>();
	// In items we can add list of books , magazine or journal // or else use Factory Design pattern.
	// private Set<Journal> journal = new HashSet<>();
	// private Set<Magazine> magazine = new HashSet<>();

	private Library(){
	}

	public static Library getInstnace(){
		return lib;
	}

	public Set<Member> getMember(){
		return member;
	}
	
	public Set<Book> getBook(){
		return book;
	}
	
	public void addMember(Member mem){
		member.add(mem);
	}
	
	public void addBook (Book bk){
		book.add(bk);
	}
}

class Member{
	String telephoneNo;
	String name;
	Member(String tele, String nm){
		telephoneNo=tele;
		name=nm;
	}

	public String getName(){
		return name;
	}

	public void setName(String nm){
		name=nm;
	}

	public String getTelephoneNo(){
		return telephoneNo;
	}

	public void setTelephoneNo(String tele){
		telephoneNo = tele;
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result=1;
		result=prime*result + ((telephoneNo==null)?0:telephoneNo.hashCode());
		return result;
	}
	
	@Override
	
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
	
		if(obj==null){
			return false;
		}
	
		if(!(obj instanceof Member)){
			return false;
		}
	
		Member mem = (Member) obj;
		if(telephoneNo == null){
			if(mem.telephoneNo != null){
				return false;
			}
		}else if(!telephoneNo.equals(mem.telephoneNo)){
			return false;
		}
		return true;
	}
}

class Book{	
	String ISBN;
	String title;

	Book(String isbn, String tile){
		ISBN=isbn;
		title=tile;
	}

	public String getISBN(){
		return ISBN;
	}

	public String getTitle(){
		return title;
	}
}

enum loanStatus{
	LOANED, AVAILABLE
}

// cannot loan more than 6 books;

public class Solution {
	private static Library library = Library.getInstnace();
	// searchMember utility
	public Optional<Member> searchMember(String nm){
		return library.getMember().stream().filter(mem -> mem.getName()==nm).findFirst();
	}

	// List of all member in ascneding order
	
	public List<Member> listOfAllMember(){
		return library.getMember().stream().sorted((m1,m2) -> m1.getName().compareTo(m2.getName())).collect(Collectors.toList());
	}
	
	// Adding a new member
	
	public void addNewMember(String telePhone, String name){
		if(telePhone!=null){
			Member m = new Member(telePhone, name);
			library.addMember(m);
		}
	}
	
	// import from large csv
	
	public void importBooks(String csvFilePath){
		CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
		List<String[]> records = csvReader.readAll();
		for(String[] record : records){
			String isbn = record[0];
			String bookTitle = record[1];
			Book b = new Book(isbn,bookTitle);
			library.addBook(b);
		}
	}

	public static void main(String args[] ) throws Exception {
		// For efficient search : to optimize the databse or search with whole key word not with partial keyword.
	}

}