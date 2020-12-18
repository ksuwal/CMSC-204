
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 *@author Kabindra Raj Suwal
 */
public class Graph implements GraphInterface<Town, Road> {

	final int noEdge = Integer.MAX_VALUE;
	final int noPath = Integer.MAX_VALUE;

	private Set<Town> t = new HashSet<>();
	private Set<Road> r = new HashSet<>();
	private ArrayList <String> ar = new ArrayList<>();
	private Town dist;
	private int endTown;

	
    /**
     * @param sV source vertex of the edge.
     * @param dV destination vertex of the edge.
     * @return an edge connecting source vertex to destination vertex.
     */
	@Override
	public Road getEdge(Town sV, Town dV) {
		Road road = null;

		for (Road r : r) {
			if (r.contains(sV) && r.contains(dV)) {
				road = r;
			}
		}
		return road;
	}

    /**
     * @param sV source vertex of the edge.
     * @param dV target(destination) vertex of the edge.
     * @param w weight of the edge
     * @param description description for edge
     * @return The newly created edge if added to the graph, otherwise null.
     * @throws IllegalArgumentException 
     * @throws NullPointerException 
     */
	@Override
	public Road addEdge(Town sV, Town dV, int w, String description) {
		if (sV == null || dV == null) {
			throw new NullPointerException ();
		}

		Road road = new Road(sV, dV, w, description);
		r.add(road);
		return road;
	}

    /**
     * Adds vertex
     * @param v vertex to be added to this graph.
     * @return true if this graph did not already contain the specified
     * vertex.
     * @throws NullPointerException 
     */
	@Override
	public boolean addVertex(Town town) {

		if (town == null) {
			throw new NullPointerException();
		}

		if (!t.contains(town)) {
			t.add(town);
			return true;
		}
		else return false;
	}


    /**
     *
     * @param sV source vertex of the edge.
     * @param dV destination vertex of the edge.
     * @return true if this graph has the edge.
     */
	@Override
	public boolean containsEdge(Town sV, Town dV) {

		for (Road r: r) {
			if (r.contains(sV) && r.contains(dV)) {
				return true;
			}
		}
		return false;
	}

    /**
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town town) {

		for (Town t : t) {
			if(t.getName().equals(town.getName())) {
				return true;
			}
		}
		return false;
	}

  

	@Override
	public Set<Road> edgeSet() {

		return r;
	}

    /**
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgesOf(Town v) {
		Set<Road> e = new HashSet<>();
		for (Road r: r) {
			if (r.contains(v)) {
				e.add(r);
			}
		}
		return e;
	}

    /**
   	 *removes edge
     * @param sV source vertex of edge.
     * @param dv destination vertex of the edge.
     * @param w weight of the edge
     * @param description description of the edge
     * @return removed edge, or null.
     */
	@Override
	public Road removeEdge(Town sV, Town dv, int w, String description) {

		Set<Road> h = new HashSet<>();
		Road road = null;
		for (Road r: r) {
			if (r.contains(dv) && r.contains(sV)
					&& (w > -1) && description != null)
				road = r;
		}
		if (r.remove(road)) {
			return road;
		}
		else {
			return null;
		}
	}

    /**
     * 
     */
	@Override
	public boolean removeVertex(Town town) {
		return t.remove(town);
	}

    /**
     */
	@Override
	public Set<Town> vertexSet() {
		return t;
	}

    /**
     * @param sV starting vertex
     * @param dV ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     */  
	@Override
	public ArrayList<String> shortestPath(Town sV, Town dV) {
		
		dist = dV;
		dijkstraShortestPath(sV);
		String shortest = "";

		for (int i = 0; i < ar.size()-1; i++) {
			
			Town source = new Town(ar.get(i));
			Town destination = new Town(ar.get(i+1));
			Road road = getEdge(source,destination);
			if (road == null) {
				break;
			}

			shortest += source+" via "+road.getName()+" to "+destination+" "+road.getWeight()+" mi;";
		}
		ar.clear();
		if(!shortest.contains(dV.getName())) {
			return ar;
		}
		for(String leg : shortest.split(";")) {
			ar.add(leg);
		}

		return ar;
	}

	 /**
     *
     * @param sV the vertex to find shortest path from
     */
	@Override
	public void dijkstraShortestPath(Town sV) {
		
		ar.clear();
		Town[] towns = new Town[t.size()];
		int ind = 0;
		
		for (Town t: t) {
			
			towns[ind] = new Town(t);
			ind++;
		}
		
		int[][] adjMatrix = new int[t.size()][t.size()];
		
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				if (i == j || !containsEdge(towns[i], towns[j])) {
					adjMatrix[i][j] = 0;
					
				} else {
					int w = getEdge(towns[i], towns[j]).getWeight();
					adjMatrix[i][j] = adjMatrix[j][i] = w;
				}
			}
		}
		int startTown = 0; 
		for (Town t: towns) {

			if (!t.equals(sV)) {
				startTown++;
			} else {
				break;
			}
		}

		endTown = 0;
		for (Town t: towns) {
			if (!t.equals(dist)) {
				endTown++;
			} else {
				break;
			}
		}

		int numofTowns = adjMatrix[0].length;
		int[] minWeight = new int[numofTowns];

		boolean[] add = new boolean[numofTowns];

		for (int townI = 0; townI < numofTowns; townI++) {

			minWeight[townI] = noEdge;
			add[townI] = false;
		}
		minWeight[startTown] = 0;
		int[] minPathLength = new int[numofTowns];
		minPathLength[startTown] = -1;

		for (int i = 1; i < numofTowns; i++) {

			int nearTown = -1;
			int minmtWeight = noEdge;
			for (int townIndex = 0; townIndex < numofTowns; townIndex++) {

				if (!add[townIndex] && minWeight[townIndex] < minmtWeight) {
					nearTown = townIndex;
					minmtWeight = minWeight[townIndex];
				}
			}

			add[nearTown] = true;

			for (int townIndex = 0; townIndex < numofTowns; townIndex++) {

				int dist = adjMatrix[nearTown][townIndex];

				if (dist > 0 && ((minmtWeight + dist)< minWeight[townIndex])) {

					minPathLength[townIndex] = nearTown;
					minWeight[townIndex] = minmtWeight + dist;
				}
			}
		}
		addToPathArrayList(endTown, minPathLength);
	}

	/**
	 * @param sV
	 * @param minPathLength
	 */
	private void addToPathArrayList(int sV, int[] minPathLength) {

		if (sV == -1) {
			return;
		}

		addToPathArrayList(minPathLength[sV], minPathLength);

		int townI = 0;

		for (Town t: t) {

			if (townI == sV) {

				ar.add(t.getName());
			}

			townI++;
		}
	}


}