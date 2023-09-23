// 133 Clone Graph
// Given a reference of a node in a connected undirected graph.

// Return a deep copy (clone) of the graph.

// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// DFS, visited records prevent duplicate
class Solution {
    HashMap <Node,Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        // if empty graph or one node graph
        if (node == null){
            return null;
        }     

        // if traversed, get back that cloned node add to neighbors list
        if (visited.containsKey(node)){
            return visited.get(node);
        }  

        // clone and add it to visited
        Node pointer = new Node(node.val);
        visited.put(node, pointer);




        // traverse and build neighbors list
        for( Node neighbor: node.neighbors){
            pointer.neighbors.add(cloneGraph(neighbor));
        }

        return pointer;

    }
}


//BFS, set queue and update neighbors list



class Solution {
    HashMap <Node,Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }

        // if (node.neighbors.size() == 0){
        //     return null;
        // }

        Node pointer = new Node(node.val);
        visited.put(node, pointer);

        ArrayList<Node> queue = new ArrayList<>();

        queue.add(node);

        while(!queue.isEmpty()){
            Node tmp = queue.remove(0);

            for (Node neighbor: tmp.neighbors){
                if (!visited.containsKey(neighbor)){
                    
                    Node clone = new Node(neighbor.val);
                    visited.put(neighbor, clone);
                    queue.add(neighbor);
                }
                visited.get(tmp).neighbors.add(visited.get(neighbor));
            }
        }

        return pointer;

    }
}
