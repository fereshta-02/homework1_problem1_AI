import astar.AStarAnalyzer;
import astar.Graph;
import astar.SearchResult;
import util.InputParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] filenames = {"astar_small.txt", "astar_medium.txt"};

        for (String filename : filenames) {
            System.out.println("==== Fayl: " + filename + " ====");
            try {
                InputParser.ParseResult parseResult = InputParser.parseFile(filename);
                Graph g = parseResult.graph;
                Integer s = parseResult.source;
                Integer d = parseResult.destination;

                if (s == null || d == null) {
                    System.out.println("Xəta: Başlanğıc və ya məqsəd tapılmadı!");
                    continue;
                }

                AStarAnalyzer analyzer = new AStarAnalyzer(g, s, d);
                List<SearchResult> results = analyzer.runAllModes();
                analyzer.printResults(results);

            } catch (Exception e) {
                System.out.println("Faylı oxumada xəta: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println("\n"); // Fayllar arasında boş sətir
        }
        }
}
