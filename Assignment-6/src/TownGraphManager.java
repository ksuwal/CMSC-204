import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;



/**
 * 
 * @author Kabindra Raj Suwal
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {

	private Graph graph = new Graph();

	/**
	 * Adds a road with 2 towns and a road name
	 * @param t1 name of town 1
	 * @param t2 name of town 2 
	 * @param roadName 
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String t1, String t2, int weight, String roadName) {
		Town tA, tB;
		boolean result = false;
		tA = new Town(t1);
		tB = new Town(t2);
		if (graph.addEdge(tA, tB, weight, roadName) != null) {
			result = true;
		}
		return result;
	}

	/**
	 * Returns the road that both towns are connected through
	 * @param t1 
	 * @param t2 
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String t1, String t2) {

		Town tA, tB;
		tA = new Town(t1);
		tB = new Town(t2);

		return graph.getEdge(tA, tB).getName();
	}

	/**
	 * Adds a town to the graph
	 * @param n the town's name  
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String n) {

		Town town;
		town = new Town(n);

		return graph.addVertex(town);
	}

	/**
	 * Gets a town with a given name
	 * @param n the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String n) {
		Town town;
		town = new Town(n);
		for (Town t: graph.vertexSet()) {
			if (t.equals(town)) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Determines if a town is already in the graph
	 * @param n the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String n) {
		Town town;
		town = new Town(n);

		return graph.containsVertex(town);
	}

	/**
	 * Determines if a road is in the graph
	 * @param t1 
	 * @param t2
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String t1, String t2) {

		Town tA, tB;
		tA = new Town(t1);
		tB = new Town(t2);

		return graph.containsEdge(tA,  tB);
	}

	/**
	 * @return an arraylist of all road in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> a = new ArrayList<>();
		for(Road r: graph.edgeSet()) {
			a.add(r.getName());
		}
		Collections.sort(a);
		return a;
	}

	/**
	 * Deletes a road from the graph
	 * @param t1 name of town 1 
	 * @param t2 name of town 2 
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String t1, String t2, String road) {
		Town tA, tB;
		tA = new Town(t1);
		tB = new Town(t2);
		int weight = 0;
		String roadName = "";
		boolean result = false;

		for (Road r: graph.edgeSet()) {
			if (r.contains(tA) && r.contains(tB)) {
				weight = r.getWeight();
			}
			roadName = r.getName();
		}
		if (graph.removeEdge(tA, tB, weight, roadName) != null) {
			result = true;
		}
		return result;
	}

	/**
	 * Deletes a town from the graph
	 * @param n name of town
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String n) {
		Town town;
		town = new Town(n);
		return graph.removeVertex(town);
	}

	/**
	 * 
	 * @return an arraylist of all towns in alphabetical order
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> a = new ArrayList<>();
		for(Town t: graph.vertexSet()) {
			a.add(t.getName());
		}
		Collections.sort(a);
		return a;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param t1 name of town 1 
	 * @param t2 name of town 2 
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String t1, String t2) {
		Town tA, tB;
		tA = new Town(t1);
		tB = new Town(t2);

		return graph.shortestPath(tA,tB);
	}

	/**
	 * This method populates the graph with all of the towns and roads from a file.
	 * @param f
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void populateTownGraph(File f) throws FileNotFoundException, IOException {

		Scanner scan;
		if (f != null) {
			String[] line, text;
			String t1, t2;
			scan = new Scanner(f);
			while(scan.hasNext()) {
				line = scan.nextLine().split(";");
				t1 = line[1];
				Town t1Town = new Town(t1);
				t2 = line[2];
				Town t2Town = new Town(t2);
				text = line[0].split(",");
				graph.addVertex(t1Town);
				graph.addVertex(t2Town);
				graph.addEdge(t1Town,  t2Town,  Integer.parseInt(text[1]), text[0]);
			}

		}


	}




}