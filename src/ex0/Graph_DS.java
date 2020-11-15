package ex0;


import java.util.*;


public class Graph_DS implements graph {

    HashMap<Integer, node_data> gMap;
    private int MC;
    private int NC;
    private int EC;


    public Graph_DS() {
        gMap = new HashMap<Integer, node_data>();
        MC = 0;
        NC = 0;
        EC = 0;
    }

    public Graph_DS(graph other) {
        this.gMap = new HashMap<>();
        NC = other.nodeSize();
        this.MC = other.getMC();
        this.EC = other.edgeSize();
        for (node_data v : other.getV()) {
            node_data copy = new NodeData(v.getKey());
            this.addNode(copy);
        }
        for (node_data v : other.getV()) {
            for (node_data u : v.getNi()) {
                this.connect(v.getKey(), u.getKey());
            }
        }

    }

    /**
     * returns  the node_data by the node_id,
     *
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */

    @Override
    public node_data getNode(int key) {
        return this.gMap.get(key);
    }


    /**
     * returns true if and only if  there is an edge between node1 and node2
     * Note: this method should run in O(1) time.
     *
     * @param node1
     * @param node2
     * @return
     */
    @Override
    public boolean hasEdge(int node1, int node2) {

        node_data n1 = getNode(node1);
        node_data n2 = getNode(node2);

        if (n1.hasNi(node2) && n2.hasNi(node1)) return true;


        return false;
    }

    /**
     * add a new node to the graph with the given node_data.
     * Note: this method should run in O(1) time.
     *
     * @param n
     */
    @Override
    public void addNode(node_data n) {
        this.gMap.put(n.getKey(), n);
        MC++;
        NC++;
    }

    /**
     * Connect an edge between node1 and node2.
     * Note: this method should run in O(1) time.
     * Note2: if the edge node1-node2 already exists - the method simply does nothing.
     *
     * @param node1
     * @param node2
     */
    @Override
    public void connect(int node1, int node2) {
        if (!this.gMap.containsKey(node1) || !this.gMap.containsKey(node2)) {
            throw new IllegalArgumentException("Node Doesn't exist.");
        }
        if (node1 == node2) return;

        node_data n1 = getNode(node1);
        node_data n2 = getNode(node2);

        if (!hasEdge(node1, node2)) {
            gMap.get(node1).addNi(n2);
            gMap.get(node2).addNi(n1);
            MC++;
            this.EC++;
        }

    }

    /**
     * This method return a pointer (shallow copy) for the
     * collection representing all the nodes in the graph.
     * Note: this method should run in O(1) time.
     *
     * @return Collection<node_data>
     */
    @Override
    public Collection<node_data> getV() {
        return this.gMap.values();
    }

    /**
     * This method returns a collection containing all the
     * nodes connected to node_id
     * Note: this method should run in O(1) time.
     *
     * @param node_id
     * @return Collection<node_data>
     */
    @Override
    public Collection<node_data> getV(int node_id) {
        node_data id = getNode(node_id);
        return id.getNi();
    }


    /**
     * Delete the node (with the given ID) from the graph -
     * and removes all edges which starts or ends at this node.
     * This method should run in O(n), |V|=n, as all the edges should be removed.
     *
     * @param key
     * @return the data of the removed node (null if none).
     */

    @Override
    public node_data removeNode(int key) {
        node_data target = this.getNode(key);
        if (target != null) {
            for (node_data ni : target.getNi()) {
                ni.removeNode(target);
                EC--;
                MC++;
            }
            gMap.remove(key);
            MC++;
        }
        NC--;
        return target;
    }
    /**
     * Delete the edge from the graph,
     * Note: this method should run in O(1) time.
     *
     * @param node1
     * @param node2
     */
    @Override
    public void removeEdge(int node1, int node2) {
        node_data n1 = getNode(node1);
        node_data n2 = getNode(node2);
        boolean b = hasEdge(node1, node2);
        if (node1 == node2) return;
        if (b) {
            n1.removeNode(n2);
            n2.removeNode(n1);
            MC++;
            EC--;
        }
    }
    /**
     * return the number of vertices (nodes) in the graph.
     * Note: this method should run in O(1) time.
     *
     * @return
     */
    @Override
    public int nodeSize() {
        return gMap.size();
    }

    /**
     * return the number of edges (unidirectional graph).
     * Note: this method should run in O(1) time.
     *
     * @return
     */
    @Override
    public int edgeSize() {
        return EC;
    }

    /**
     * return the Mode Count - for testing changes in the graph.
     * Any change in the inner state of the graph should cause an increment in the ModeCount
     *
     * @return
     */
    @Override
    public int getMC() {
        return MC;
    }
    @Override
    public String toString() {
        return "G[ " +
                gMap +
                ": " +
                " |V|=" + nodeSize() +
                ", |E|=" + edgeSize() +
                ']';
    }
}




