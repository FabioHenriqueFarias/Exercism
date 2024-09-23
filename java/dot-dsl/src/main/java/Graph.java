import java.util.*;

public class Graph {

    Map<String, String> attributes;
    List<Node> nodes;
    List<Edge> edges;

    public Graph() {
        this.attributes = new HashMap<>();
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Graph(Map<String, String> attributes) {
        this.attributes = attributes != null ? new HashMap<>(attributes) : new HashMap<>();
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public Collection<Edge> getEdges() {
        return edges;
    }

    public Graph node(String name) {

        Node node = new Node(name);
        nodes.add(node);

        return this;
    }

    public Graph node(String name, Map<String, String> attributes) {

        Node node = new Node(name, attributes);

        if (!nodes.contains(node)) {
            nodes.add(node);
        }

        return this;
    }

    public Graph edge(String start, String end) {

        Edge edge = new Edge(start, end);
        edges.add(edge);

        return this;
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {

            Edge edge = new Edge(start, end, attributes);

            if (!edges.contains(edge)) {
                edges.add(edge);
            }

            return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
