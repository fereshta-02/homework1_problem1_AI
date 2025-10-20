package astar;

import java.util.List;
import java.util.ArrayList;

public class AStarAnalyzer {
    private Graph graph; private int source,destination;
    private AStarSolver solver;

    public AStarAnalyzer(Graph graph,int source,int destination){
        this.graph=graph; this.source=source; this.destination=destination;
        solver = new AStarSolver(graph);
    }

    public List<SearchResult> runAllModes(){
        List<SearchResult> res=new ArrayList<>();
        SearchResult ucs = solver.solve(source,destination,(n,g,gr)->Heuristic.zero(n,g,gr));
        res.add(new SearchResult(ucs.getOptimalCost(), ucs.getPath(), ucs.getExpanded(), ucs.getPushes(), ucs.getMaxFrontier(), ucs.getRuntimeSeconds(), "UCS"));
        SearchResult euc = solver.solve(source,destination,(n,g,gr)->Heuristic.euclidean(n,g,gr));
        res.add(new SearchResult(euc.getOptimalCost(), euc.getPath(), euc.getExpanded(), euc.getPushes(), euc.getMaxFrontier(), euc.getRuntimeSeconds(), "A* Euclidean"));
        SearchResult manh = solver.solve(source,destination,(n,g,gr)->Heuristic.manhattan(n,g,gr));
        res.add(new SearchResult(manh.getOptimalCost(), manh.getPath(), manh.getExpanded(), manh.getPushes(), manh.getMaxFrontier(), manh.getRuntimeSeconds(), "A* Manhattan"));
        return res;
    }

    public void printResults(List<SearchResult> results){
        for(SearchResult r: results) System.out.println(r);
    }
}

