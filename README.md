# Ex0


For Installation https://github.com/simon-pikalov/Ariel_OOP_2020/tree/master/Assignments/Ex0


### Author:
David Kokiashvili 
-----------


## Summary:
-------
The project focus on unweighted undirected graph and has three main Classes.
1. node_data - an interface that represents a node in the graph implemented by NodeData.
2. graph - an interface that represents an undirected unweighted graph implemented by Graph_DS.
3. graph_algorithms - an interface that represents a set of algorithms to perform on a graph implemented by Graph_Algo.
 
## Setup and data structure
My implementation for the Graph data structere is using a hashmap and the Nodedata methods.
## NodeData class methods:
------ 
all the methods below are O(1)
1. getKey – returns the key (id) associated to a specific node.
2. getNi – returns a Collection of all neigbor nodes. 
3. hasNi – checks if a node has a neigbor node  
4. removeNode - removes the edge to it's neighbor node.
5. getInfo  – returns the info of the node.
6. setInfo – sets the info of the node 
7. getTag – returns the tag of the node 
8. setTag - sets the tag of the node

## Graph_DS class methods: 
-----
1. getNode – returns a node the graph contains with a specific key. O(1)
2. hasEdge – checks if there is  an edge between 2 nodes. O(1)
3. addNode – Adds a node to the graph O(1)
4. connect – connects an edge between 2 nodes O(1)
5. getV() - returns a collection of all the nodes in the graph O(1)
6. getV(node_id) - returns a collection of all the adjacent nodes of a node with the node_id O(1)
7. removeNode -  removes a node from the graph and all its edges O(n)
8. removeEdge – Removes an edge between 2 given nodes from the graph O(1)
9. nodeSize – Returns the total number of nodes in the graph O(1)
10. edgeSize – returns the total number of edges in the graph O(1)
11. getMC – returns the total number of changes made in the graph O(1)

## Graph_Algo class methods: 
-----
1. init - Initializes a graph that the class of the algorithms will perform on. O(1)
2. copy - makes a deep copy of the graph O(V+E)
3. isConnected - checks if there is a path from every 2 nodes in the graph , traversing the graph using BFS starting from an arbitary node marking every node and checking in the end if all the nodes in the graph were marked O(V+E)
4. shortestPathDist() - returns the number of edges in the shortest path between 2 given nodes (src,dest) , returns -1 if there is no path , traversing the graph starting from src using BFS and marking every reachable node tag in the graph with his distance from src. O(V+E)
5. shortestPath() - return the shortest path between src node and dest node using BFS algorithm, traversing the graph and mark its info as "White" to indicate this node is not visited yet and "Grey" indicates the node is already visited. The tag of each node in the graph is used to mark the distance between the source node to all the nodes in the graph. O(V+E). 
