package observer;

import java.time.LocalDate;

public class Movie {
	private String name;
	private String genre;
	private LocalDate premiereDate;
	private String country;
	private String duration;
	
	public Movie(String name, String genre, LocalDate premiere, String country, String duration) {
		this.name = name;
		this.genre = genre;
		this.premiereDate = premiere;
		this.country = country;
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public LocalDate getPremiere() {
		return premiereDate;
	}
	public void setPremiere(LocalDate premiere) {
		this.premiereDate = premiere;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Name: %s", this.getName()));
		sb.append(System.lineSeparator());
		sb.append(String.format("Genre: %s", this.getGenre()));
		sb.append(System.lineSeparator());
		sb.append(String.format("Premiere date: %s", this.getPremiere().toString()));
		sb.append(System.lineSeparator());
		sb.append(String.format("Country: %s", this.getCountry()));
		sb.append(System.lineSeparator());
		sb.append(String.format("Duration: %s", this.getDuration()));
		return sb.toString().trim();
	}
	
	
}
