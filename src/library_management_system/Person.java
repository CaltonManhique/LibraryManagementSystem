package library_management_system;

public class Person {

	private String name;
	private String contact;

	public Person(String name, String contact) {
		this.name = name;
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}

	@Override
	public String toString() {
		return "[Name: " + name + ", contact: " + contact + "]";
	}

}
