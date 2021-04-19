package observer;

import java.util.ArrayList;
import java.util.List;

public class NetflixSystem implements Observable {
	
	private Movie movie;
	private List<Observer> subcribers;
	
	public NetflixSystem() {
		this.subcribers = new ArrayList<>();
	}
	
	@Override
	public void subscribe(Observer observer) {
		this.subcribers.add(observer);
		observer.setObservable(this);
	}

	@Override
	public void unsubscribe(Observer observer) {
		this.subcribers.remove(observer);
		observer.setObservable(null);
	}

	/*
	 * This method notify the subscribers for new movies
	 */
	@Override
	public void notifySubscribers() {
		for (Observer observer : this.subcribers) {
			observer.update();
		}
	}

	@Override
	public Movie getMovie() {
		return this.movie;	
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
		notifySubscribers();
	}
}
