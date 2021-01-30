import java.util.*;

public class NodeData implements node_data {


    /**
     * This class implementation represents a set of operations
     * on a specific node of an Undirected & Unweighted Graph
     * <p>
     * Every node contains unique key for better identification.
     *
     * @param key - the special key every node possesses.
     * @param Tag,info - used for marking the distance between one node to another.
     * @param adjacencyMap - represents the association between of a specific node to all it's neighbors.
     */


    private HashMap<Integer, node_data> adjacencyMap;
    private int key;
    private static int incrementHelper = 0;
    private int Tag = 0;
    private String info = "";

    public NodeData() {
        adjacencyMap = new HashMap<>();
        this.key = incrementHelper++;
        this.Tag = 0;
        this.info = "";
    }

    public NodeData(node_data other) {
        adjacencyMap = new HashMap<>();
        this.key = other.getKey();
        this.Tag = other.getTag();
    }

    public NodeData(int k) {
        this.key = k;
    }

    /**
     * Return the key (id) associated with this node.
     * Note: each node_data should have a unique key.
     *
     * @return
     */
    @Override
    public int getKey() {
        return this.key;
    }


    /**
     * This method returns a collection with all the Neighbor nodes of this node_data
     */
    @Override
    public Collection<node_data> getNi() {

        return this.adjacencyMap.values();
    }


    /**
     * return true iff this<==>key are adjacent, as an edge between them.
     *
     * @param key
     * @return
     */

    @Override
    public boolean hasNi(int key) {
        return adjacencyMap.containsKey(key);
    }


    /**
     * This method adds the node_data (t) to this node_data.
     * This method is wrongly designed! and was used mainly for educational example - to be improved in Ex1
     */
    @Override
    public void addNi(node_data t) {

        this.adjacencyMap.put(t.getKey(), t);
    }


    /**
     * Removes the edge this-node,
     *
     * @param node
     */
    @Override
    public void removeNode(node_data node) {
        adjacencyMap.remove(node.getKey(), node);
    }


    /**
     * return the remark (meta data) associated with this node.
     *
     * @return
     */
    @Override
    public String getInfo() {
        return this.info;
    }


    /**
     * Allows changing the remark (meta data) associated with this node.
     *
     * @param s
     */
    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    /**
     * Temporal data (aka color: e,g, white, gray, black)
     * which can be used be algorithms
     *
     * @return
     */
    @Override
    public int getTag() {
        return this.Tag;
    }


    /**
     * Allow setting the "tag" value for temporal marking an node - common
     * practice for marking by algorithms.
     *
     * @param t - the new value of the tag
     */
    @Override
    public void setTag(int t) {
        this.Tag = t;
    }

    @Override
    public String toString() {
        return "Node[" +
                "key=" + key +
                ", Tag=" + Tag +
                ", info='" + info + '\'' +
                ']';
    }
}
