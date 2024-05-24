# Instructions  

In this assignment, you will create an algorithm to to crawl the world wide web using a breadth first search starting at a given address. Each website (vertex) may contain links (edges) to other websites. 

Create a Queue that will contain a LinkedList of websites (String) that have yet to be visited. You will also need a Set that will contain a HashSet of for websites (String) that you have visited. This will be needed so that a cycle does not occur.

BFS Constructor
```python
public BFS() {
    //Instiantiate both the Queue and Set
        
    // Creates a pattern with basic regualar expression
    // for finding web addresses within a text
    pattern = Pattern.compile("https://(\\w+\\.)*(\\w+)");
}
```
Note: The regular expression "https://(\\w+\\.)*(\\w+)" is very simple and will not always work correctly. Please feel free to create a better one if you like.

discoverWeb method
```python
public void discoverWeb(String startSite) {

    int siteCount = 1;
    
    // Add startSite to the queue

    // Start a while loop that will run until the  queue is empty or siteCount exceeds limit.

        // Dequeue the next website in the queue
        
        // Check the website to make sure it has not been visited
        
            // add the website to the set of visited sites
        
            // print the following message to the console
               "Crawling Website # " + siteCount + " found: " + website);
               
            // increment siteCount
            
            // call readURL to receive the rawHTML text of the website
                
            // add the following to loop through the rawHTML text to find
                // links to other websites (edges)
                Matcher matcher = pattern.matcher(rawHtml);
                while (matcher.find()) { 
                    String newSite = matcher.group();
                    queue.add(newSite);
                }
```
Note: There is no autograder for this problem. Submit a screenshot of your ouput to the assignment in Schoology

  