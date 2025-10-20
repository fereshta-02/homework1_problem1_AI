package astar;

public class Node implements Comparable<Node> {
    int id;
    double f;

    public Node(int id, double f) {
        this.id = id;
        this.f = f;
    }

    @Override
    public int compareTo(Node other) {
        if (Double.compare(this.f, other.f) != 0)
            return Double.compare(this.f, other.f);
        return Integer.compare(this.id, other.id);
    }
}

