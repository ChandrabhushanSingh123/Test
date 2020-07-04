package JAVAProgramming;

public class Book {
	String title;
	
	public Book(String title) {
		this.title=title;
	}
	
	public Book() { }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
//@override
	
public String toString() {
	return "BOOK[title="+title+"]";
	
}


}
