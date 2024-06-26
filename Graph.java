import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Graph class that implements the GraphInterface.
 * Due: 05/05/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
public class Graph implements GraphInterface<Town, Road>{
	private Map<Town, List<Road>> adjacencyList;
	/**
	 * Constructor for Graph
	 */
	public Graph()
	{
		this.adjacencyList = new HashMap<>();
    }
	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex)
	{
		if (containsVertex(sourceVertex) == false || containsVertex(destinationVertex) == false)
		{
			return null;
		}
		else if (containsEdge(sourceVertex, destinationVertex) == false)
		{
			return null;
		}
		else if (sourceVertex == null || destinationVertex == null)
		{
			return null;
		}
		else
		{
			for (Road road : edgeSet())
			{
				if ((road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex)) || (road.getSource().equals(destinationVertex) && road.getDestination().equals(sourceVertex)))
				{
					return road;
				}
			}
		}
		return null;
	}
	/**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
	{
		if (containsVertex(sourceVertex) == false || containsVertex(destinationVertex) == false)
		{
			throw new IllegalArgumentException();
		}
		else if (sourceVertex == null || destinationVertex == null)
		{
			throw new NullPointerException();
		}
		else if ((containsVertex(sourceVertex) == true && containsVertex(destinationVertex) == true) && (sourceVertex != null && destinationVertex != null))
		{
			Road road = new Road(sourceVertex, destinationVertex, weight, description);
			this.adjacencyList.get(sourceVertex).add(road);
			this.adjacencyList.get(destinationVertex).add(road);
	        sourceVertex.addToListOfAdjacentTowns(destinationVertex);
	        destinationVertex.addToListOfAdjacentTowns(sourceVertex);
	        return road;
		}
		return null;
	}
	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v)
	{
		if (containsVertex(v) == true)
		{
			return false;
		}
		else if (v == null)
		{
			throw new NullPointerException();
		}
		else
		{
			this.adjacencyList.put(v, new LinkedList<>());
			return true;
		}
	}
	/**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex)
	{
		if (containsVertex(sourceVertex) == false || containsVertex(destinationVertex) == false)
		{
			return false;
		}
		else if (sourceVertex == null || destinationVertex == null)
		{
			return false;
		}
		else
		{
			for (Road road : edgeSet())
			{
				if ((road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex)) || (road.getSource().equals(destinationVertex) && road.getDestination().equals(sourceVertex)))
				{
					return true;
				}
			}
		}
		return false;
	}
	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v)
	{
		if (v == null)
		{
			return false;
		}
		else
		{
			for (Town town : vertexSet())
			{
				if (town.equals(v) == true)
				{
					return true;
				}
			}
		}
		return false;
	}
	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet()
	{
		Set<Road> roadSet = new HashSet<Road>();
		for (Map.Entry<Town, List<Road>> entry : this.adjacencyList.entrySet())
		{
            for (Road road : entry.getValue())
            {
                roadSet.add(road);
            }
        }
		return roadSet;
	}
	/**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex)
	{
		if (containsVertex(vertex) == false)
		{
			throw new IllegalArgumentException();
		}
		else if (vertex == null)
		{
			throw new NullPointerException();
		}
		else
		{
			List<Road> roads = this.adjacencyList.get(vertex);
			if (roads != null)
			{
				Set<Road> roadSet = new HashSet<Road>(this.adjacencyList.get(vertex));
				return roadSet;
			}
			else
			{
				return Collections.emptySet();
			}
		}
	}
	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
	{
		if (containsVertex(sourceVertex) == false || containsVertex(destinationVertex) == false)
		{
			return null;
		}
		else if (containsEdge(sourceVertex, destinationVertex) == false || containsEdge(destinationVertex, sourceVertex) == false)
		{
			return null;
		}
		else if (sourceVertex == null || destinationVertex == null)
		{
			return null;
		}
		else
		{
			Iterator<Road> iterator = this.adjacencyList.get(sourceVertex).iterator();
			while (iterator.hasNext())
			{
				Road road = iterator.next();
				if (road.getDestination().equals(destinationVertex))
				{
					if ((weight <= -1 || road.getWeight() == weight) && (description == null || road.getName().equals(description)))
					{
						iterator.remove();
						this.adjacencyList.get(destinationVertex).remove(road);
						sourceVertex.removeFromListOfAdjacentTowns(destinationVertex);
						destinationVertex.removeFromListOfAdjacentTowns(sourceVertex);
						return road;
					}
				}
			}
		}
		return null;
	}
	/**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v)
	{
		if (containsVertex(v) == false)
		{
			return false;
		}
		else if (v == null)
		{
			return false;
		}
		else
		{
			for (List<Road> roads : this.adjacencyList.values())
			{
				Iterator<Road> iterator = roads.iterator();
				while (iterator.hasNext())
				{
					Road road = iterator.next();
					if (road.getSource().equals(v) || road.getDestination().equals(v))
					{
						if (road.getSource().equals(v))
						{
							road.getDestination().removeFromListOfAdjacentTowns(v);
							iterator.remove();
						}
						else if (road.getDestination().equals(v))
						{
							road.getSource().removeFromListOfAdjacentTowns(v);
							iterator.remove();
						}
					}
				}
			}
			v.getListOfAdjacentTowns().clear();
			this.adjacencyList.remove(v);
			return true;
		}
	}
	/**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet()
	{
		Set<Town> townSet = new HashSet<Town>();
		townSet = this.adjacencyList.keySet();
		return townSet;
	}
	/**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex)
	{
		dijkstraShortestPath(sourceVertex);
		Map<Town, Integer> distances = new HashMap<>();
		PriorityQueue<Town> priorityQueue = new PriorityQueue<Town>(Comparator.comparingInt(distances::get));
		Map<Town, Town> lastVertex = new HashMap<>();
		for (Town town : this.adjacencyList.keySet())
		{
			distances.put(town, Integer.MAX_VALUE);
			lastVertex.put(town, null);
		}
		distances.put(sourceVertex, 0);
		priorityQueue.offer(sourceVertex);
		while(!priorityQueue.isEmpty())
		{
			Town current = priorityQueue.poll();
			for (Road road : this.adjacencyList.get(current))
			{
				Town neighbor = road.getDestination();
				int newWeight = distances.get(current) + road.getWeight();
				if (newWeight < distances.get(neighbor))
				{
					distances.put(neighbor, newWeight);
					lastVertex.put(neighbor, current);
					priorityQueue.offer(neighbor);
				}
			}
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		Town currentVertex = destinationVertex;
		while (currentVertex != null)
		{
			Town previous = lastVertex.get(currentVertex);
			if (previous != null)
			{
				Road road = getEdge(previous, currentVertex);
				arrayList.add(0, previous.getName() + " via " + road.getName() + " to " + currentVertex.getName() + " " + road.getWeight() + " mi");
			}
			currentVertex = previous;
		}
		return arrayList;
	}
	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex)
	{
		Map<Town, Integer> distances = new HashMap<>();
		PriorityQueue<Town> priorityQueue = new PriorityQueue<Town>(Comparator.comparingInt(distances::get));
		Map<Town, Town> lastVertex = new HashMap<>();
		for (Town town : this.adjacencyList.keySet())
		{
			distances.put(town, Integer.MAX_VALUE);
			lastVertex.put(town, null);
		}
		distances.put(sourceVertex, 0);
		priorityQueue.offer(sourceVertex);
		while(!priorityQueue.isEmpty())
		{
			Town current = priorityQueue.poll();
			for (Road road : this.adjacencyList.get(current))
			{
				Town neighbor = road.getDestination();
				int newWeight = distances.get(current) + road.getWeight();
				if (newWeight < distances.get(neighbor))
				{
					distances.put(neighbor, newWeight);
					lastVertex.put(neighbor, current);
					priorityQueue.offer(neighbor);
				}
			}
		}
	}
}
