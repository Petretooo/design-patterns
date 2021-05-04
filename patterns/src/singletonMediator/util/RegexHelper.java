package singletonMediator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHelper {
	
	private Pattern pattern;
	private Matcher matcher;
	
	private String fixedText;
	private String allMatches;
	
	public RegexHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean findMatch(String text, String findText) {
		
		this.allMatches = "";
		this.fixedText = "";
		
		boolean isMatch = false;
		
		pattern = Pattern.compile(findText, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(text);
		
		while(matcher.find()) {
			text = text.replace(matcher.group(), "");
			this.allMatches += matcher.group() + ", ";
			isMatch = true;
		}
		fixedText = text;
		return isMatch;
	};
	
	public String getAllMatches() {
		return this.allMatches;
	}
	
	public String getFixedText() {
		return this.fixedText;
	}
	
}