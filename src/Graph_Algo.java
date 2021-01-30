import java.util.*;

@SuppressWarnings("ALL")
public class Graph_Algo implements graph_algorithms {

    private graph algo;

    public Graph_Algo() {
        algo = new Graph_DS();
    }


    /**
     * Initialize  the graph on which this set of algorithms operates on.
     *
     * @param g
     */
    @Override
    public void init(graph g) {
        this.algo = g;
    }

    /**
     * returns true if this graph is empty
     * otherwise false.
     *
     * @return
     */
    public boolean isEmpty() {
        return this.algo.nodeSize() == 0 && this.algo.edgeSize() == 0;
    }

    /**
     * Compute a deep copy of this graph.
     *
     * @return
     */
    @Override
    public graph copy() {
        graph ans = new Graph_DS();
       for (node_data v:algo.getV()){
           ans.addNode(new NodeData(v));
       }
       for (node_data v:algo.getV()){
           for (node_data u:v.getNi()){
               ans.connect(v.getKey(),u.getKey());
           }
       }
       return ans;
    }

    /**
     * Returns true if and only if  there is a valid path from every node to each
     * other node.
     *
     * @return
     */
    @Override
    public boolean isConnected() {
        int counter = 0;


        if (algo.nodeSize() == 0 || algo.nodeSize() == 1) {
            return true;
        }
        for (node_data u : algo.getV()) {
            u.setTag(0);
            u.setInfo("White");
        }
        Queue<node_data> queue = new LinkedList<node_data>();

        for (node_data u : algo.getV()) {
            queue.add(u);
            u.setInfo("Gray");
            counter++;
            break;
        }
        while (!queue.isEmpty()) {
            node_data u = queue.poll();
            for (node_data v : u.getNi()) {
                if (v.getInfo() == "White") {
                    v.setInfo("Gray");
                    v.setTag(u.getTag() + 1);
                    queue.add(v);
                    counter++;
                }
            }
        }
        return algo.nodeSize() == counter;
    }

    /**
     * returns the length of the shortest path between src to dest
     * Note: if no such path --> returns -1
     *
     * @param src  - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public int shortestPathDist(int src, int dest) {

        List<node_data> adjList = new LinkedList<node_data>();
        adjList = shortestPath(src, dest);


        return adjList.size() - 1;

    }

    /**
     * returns the the shortest path between src to dest - as an ordered List of nodes:
     * src--> n1-->n2-->...dest
     * see: https://en.wikipedia.org/wiki/Shortest_path_problem
     * Note if no such path --> returns null;
     *
     * @param src  - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public List<node_data> shortestPath(int src, int dest) {
        LinkedList<node_data> adjList = new LinkedList<>();
        Queue<node_data> queue = new LinkedList<>();
        node_data sourceNode = algo.getNode(src);
        node_data destinationNode = algo.getNode(dest);
        if (sourceNode == null || destinationNode == null) return adjList;
        if (algo.nodeSize() != 0) {
            if (src == dest) {
                adjList.add(algo.getNode(src));
                return adjList;
            }

            for (node_data u : algo.getV()) {
                u.setTag(0);
                u.setInfo("White");
            }
            sourceNode.setInfo("Grey");
            queue.add(sourceNode);
            while (!queue.isEmpty()) {
                node_data visited = queue.poll();
                for (node_data v : visited.getNi()) {
                    if (v.getTag() == 0 && v.getInfo() == "White") {
                        v.setTag(visited.getTag() + 1);
                        v.setInfo("Grey");
                        queue.add(v);
                    }
                }
            }
            queue.clear();
            if (destinationNode.getTag() != 0) {
                adjList.add(algo.getNode(dest));
                queue.add(algo.getNode(dest));
            }
            int dist = algo.getNode(dest).getTag();
            node_data tmp = algo.getNode(dest);

            while (dist > 0) {
                for (node_data v : tmp.getNi()) {
                    if (v.getTag() == dist - 1 && v.getInfo() == "Grey") {
                        adjList.addFirst(v);
                        v.setInfo("White");
                        tmp = v;
                        dist--;
                    }
                }
            }
            return adjList;
        }
        return adjList;
    }

    @Override
    public String toString() {
        return "Graph_Algo{" +
                "G=" + algo +
                '}';
    }
}
