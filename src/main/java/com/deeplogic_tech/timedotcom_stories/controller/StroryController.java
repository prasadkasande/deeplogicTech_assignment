package com.deeplogic_tech.timedotcom_stories.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deeplogic_tech.timedotcom_stories.entity.Story;

@RestController
public class StroryController {
	
	 @GetMapping("/getTimeStories")
	    public List<Story> getTimeStories() throws IOException {
	        List<Story> stories = new ArrayList<>();
	        
	        // Fetch HTML content from Time.com
	        URL url = new URL("https://time.com");
	        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuilder htmlContent = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            htmlContent.append(line);
	        }
	        reader.close();
	       
	        Pattern pattern = Pattern.compile("<h3[^>]*>(.*?)</h3>.*?<a\\s+href\\s*=\\s*\"(.*?)\"");
	        Matcher matcher = pattern.matcher(htmlContent.toString());
	        while (matcher.find() && stories.size() < 6) {
	            String title = matcher.group(1).trim();
	            String link = matcher.group(2).trim();
	            stories.add(new Story(title, link));
	        }
	        
	        // Return the latest 6 stories
	        return stories;
	    }
	
	


}
