import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.*;

public class BFS 
{
    Pattern pattern;
    private int limit = 100; // maximum number of sites to crawl
    private Queue<String> q;
    private Set<String> s;

    public BFS() 
    {
        // Instiantiate both the Queue and Set
        q = new LinkedList<String>();
        s = new HashSet<String>();
        
        // Creates a pattern with basic regualar expression for finding web addresses within a text
        pattern = Pattern.compile("https://(\\w+\\.)*(\\w+)");
    }

    public void discoverWeb(String startSite) 
    {
        int siteCount = 1;
    
        // Add startSite to the queue
        q.add(startSite);

        // Start a while loop that will run until the queue is empty or siteCount exceeds limit.
        while (!q.isEmpty() && siteCount <= limit)
        {
          // Dequeue the next website in the queue
          String nextWebsite = q.remove();
          
          // Check the set to make sure the website has not been visited
          if (!s.contains(nextWebsite))
          {
            // add the website to the set of visited sites
            s.add(nextWebsite);

            // print the following message to the console
            System.out.println("Crawling Website # " + siteCount + " found: " + nextWebsite);

            // increment siteCount
            siteCount += 1;
            
            // call readURL to receive the rawHTML text of the website
            String rawHtml = readURL(nextWebsite);
                
            // add the following to loop through the rawHTML text to find links to other websites (edges)
            Matcher matcher = pattern.matcher(rawHtml);
            while (matcher.find()) 
            { 
                String newSite = matcher.group();
                q.add(newSite);
            }
          }
        }
      
        System.out.println("\nNumber of sites left to crawl = " + q.size());
    }

    private String readURL(String webSite) {
        StringBuilder rawHtml = new StringBuilder("");
        try {
            URL url = new URL(webSite);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                rawHtml.append(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("\tProblem while crawling website: " + webSite);
        }
        return rawHtml.toString();
    }
}
