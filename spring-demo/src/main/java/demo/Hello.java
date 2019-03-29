package demo;

public class Hello implements IHello {

	public void showInfo(Person person) {
		System.out.println(person.toString());
	}
}
