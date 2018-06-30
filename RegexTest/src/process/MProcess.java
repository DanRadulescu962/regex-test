package process;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MProcess {
	private Matcher matcher;
	private Pattern pattern;
	private String previous;
	
	// Modified MProcess source file
	
	public String scrap(String line) {
		pattern = Pattern.compile("\\\\t");
		
		matcher = pattern.matcher(line);
		
		line = matcher.replaceAll("\t");
		
		pattern = Pattern.compile("\\\\n");
		
		matcher = pattern.matcher(line);
		
		line = matcher.replaceAll("\n");
		
		pattern = Pattern.compile("\\\\\\\\");
		
		matcher = pattern.matcher(line);
		
		line = matcher.replaceAll("\\\\");
		
		return line;
	}
	
	public ArrayList<String> proc(String line) {
		ArrayList<String> l = new ArrayList<>();
		
		if (previous != null) {
			pattern = Pattern.compile("(.*?)\"");
			
			matcher = pattern.matcher(line);
			
			if (matcher.find()) {
				previous = previous + matcher.group();
				l.add(previous);
				previous = null;
				line = line.substring((matcher.group()).length());
			}
			else {
				pattern = Pattern.compile("(.*?)\\\\$");
				
				matcher = pattern.matcher(line);
				
				if (matcher.find()) {
					previous = previous + matcher.group(1);
					return l;
				}
			}
		}
		
		pattern = Pattern.compile("\"(.*?)\"");
		
		matcher = pattern.matcher(line);
		
		while (matcher.find()) {
			String aux = matcher.group();
			l.add(aux);
			line = line.substring(matcher.start() + aux.length());
			matcher = pattern.matcher(line);
		}
		
		pattern = Pattern.compile("\"(.*?)\\\\$");
		
		matcher = pattern.matcher(line);
		if (matcher.find())
			previous = matcher.group();
		if (previous != null) {
			previous = previous.substring(0, previous.length() - 1);
		}
		return l;
	}
}
