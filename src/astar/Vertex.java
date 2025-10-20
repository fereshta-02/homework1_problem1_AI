package astar;

public class Vertex {
    private int id;
    private int cellId;

    public Vertex(int id, int cellId) {
        this.id = id;
        this.cellId = cellId;
    }

    public int getId() { return id; }
    public int getCellId() { return cellId; }

    public int[] getCoordinates() {
        int x = cellId / 10;
        int y = cellId % 10;
        return new int[]{x, y};
    }

    @Override
    public String toString() {
        return "Vertex{" + "id=" + id + ", cellId=" + cellId + "}";
    }
}

