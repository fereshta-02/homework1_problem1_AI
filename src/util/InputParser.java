package util;

import astar.Graph;
import java.io.*;
import java.util.*;

public class InputParser {
    public static class ParseResult {
        public Graph graph; public Integer source; public Integer destination;
        public ParseResult(Graph g, Integer s, Integer d){ graph=g; source=s; destination=d; }
    }

    public static ParseResult parseFile(String filename) throws IOException{
        Graph g = new Graph();
        Integer s = null, d = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line=reader.readLine())!=null){
                line=line.trim();
                if(line.isEmpty()||line.startsWith("#")) continue;
                String[] p = line.split(",");
                String cmd = p[0].trim();
                switch(cmd){
                    case "Vertex": g.addVertex(Integer.parseInt(p[1].trim()), Integer.parseInt(p[2].trim())); break;
                    case "Edge": g.addEdge(Integer.parseInt(p[1].trim()), Integer.parseInt(p[2].trim()), Double.parseDouble(p[3].trim())); break;
                    case "Source": s=Integer.parseInt(p[p.length-1].trim()); break;
                    case "Destination": d=Integer.parseInt(p[p.length-1].trim()); break;
                }
            }
        }
        return new ParseResult(g,s,d);
    }
}

