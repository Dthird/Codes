package leetcode;

/**
 * Created by jason on 3/22/17.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Reconstruct Itinerary
 */
public class M332 {
    private HashMap<String, PriorityQueue<String>> flights = new HashMap<>();
    private LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(String[][] tickets) {
        if (tickets.length == 0 || tickets[0].length == 0)
            return path;
        for (String[] ticket : tickets){
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    private void dfs(String departure){
        PriorityQueue<String> destinations = flights.get(departure);
        while (destinations != null && !destinations.isEmpty()){
            dfs(destinations.poll());
        }
        path.addFirst(departure);
    }
}
