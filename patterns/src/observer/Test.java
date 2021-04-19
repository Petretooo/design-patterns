package observer;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		NetflixSystem o = new NetflixSystem();
		
		Observer sub1 = new Subscriber("Peter", 44, "peter@gmail.com");
		Observer sub2 = new Subscriber("John", 32, "john@gmail.com");
		Observer sub3 = new Subscriber("Kevin", 27, "kevin@gmail.com");

		o.subscribe(sub1);
		o.subscribe(sub2);
		o.subscribe(sub3);
		
		LocalDate l = LocalDate.now();
		Movie movie = new Movie("Avatar 2", "SCI-FI", l, "USA", "2:30h");
		
		o.setMovie(movie);

	}
	
	/*					OUTPUT
	 * 
	 *  Peter, you got new movie - Name: Avatar 2
	 *	Genre: SCI-FI
	 *	Premiere date: 2021-04-20
	 *	Country: USA
	 *	Duration: 2:30h
	 *	
	 *	John, you got new movie - Name: Avatar 2
	 *	Genre: SCI-FI
	 *	Premiere date: 2021-04-20
	 *	Country: USA
	 *	Duration: 2:30h
	 *	
	 *	Kevin, you got new movie - Name: Avatar 2
	 *	Genre: SCI-FI
	 *	Premiere date: 2021-04-20
	 *	Country: USA
	 *	Duration: 2:30h
	 * 
	 */

}
