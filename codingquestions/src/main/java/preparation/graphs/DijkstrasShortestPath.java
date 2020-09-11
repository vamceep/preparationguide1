package preparation.graphs;

import java.util.*;

public class DijkstrasShortestPath {
    /**
     * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/?ref=rp
     *
     * Given a graph and a source vertex in graph, find shortest paths from source to all vertices in the given graph.
     */

    private int dist[];
    private int V;
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private List<List<Node> > adj;

    public DijkstrasShortestPath(int V) {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<>();
        pq = new PriorityQueue<>(V, new Node()); // V is capacity and Node is comparator
    }
    static class Node implements Comparator<Node> {
        public int node;
        public int cost;
        public Node() {

        }
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.cost < o2.cost) {
                return -1;
            }else if(o1.cost > o2.cost) {
                return 1;
            }else {
                return 0;
            }
        }
    }

    public void dijkstra(List<List<Node>> adj, int src) {
        this.adj = adj;
        for(int i=0;i < V;i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        // add source node to pq
        pq.add(new Node(src, 0));

        // for src node to itself distance is 0
        dist[src] = 0;
        while (settled.size() != V) {
            // remove minimum distace node (which is given by pq based on cost
            int u = pq.remove().node;

            // adding the node whose distance is finalized
            settled.add(u);
            neighbours((u));
        }
    }

    private  void neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        for(int i=0;i<adj.get(u).size();i++) {
            Node v = adj.get(u).get(i);
            // if current node isn't already processed
            if(!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;
            }

            // if new distance is cheaper than the cost
            if(newDistance < dist[v.node]) {
                dist[v.node] = newDistance;
            }

            // add current node to queue
            pq.add(new Node(v.node, dist[v.node]));
        }
    }
    public static void main(String arg[])
    {
        int V = 5;
        int source = 0;
        // Adjacency list representation of the
        // connected edges
        List<List<Node>> adj = new ArrayList<List<Node> >();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        // Calculate the single source shortest path
        DijkstrasShortestPath dpq = new DijkstrasShortestPath(V);
        dpq.dijkstra(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);
    }
}
