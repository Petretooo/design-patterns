package observer;

public class Subscriber implements Observer {

	private String name;
	private int age;
	private String email;
	private Movie newMovie;
	private Observable Observable;
	
	public Subscriber(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	@Override
	public void update() {
		if(this.Observable == null) {
			return;
		}
		this.newMovie = this.Observable.getMovie();
		System.out.printf("%s, you got new movie - %s%n%n", name, this.newMovie);
	}

	@Override
	public void setObservable(Observable o) {
		this.Observable = o;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

}
