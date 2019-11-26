package sample;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller
{
    @FXML
    TextField travelFrom;
    @FXML
    TextField travelTo;
    @FXML
    TextArea res;

    @FXML
    public void routeHandler()
    {
        res.setText("This is the shortest route: " + resultForShortestDistance()+ " \n" +
                "This is the most time efficient route: " + resultForShortestTime() + " \n" +
                "This is most green route: " + resultForMinimumCo2());
    }

    public String resultForShortestDistance()
    {
        String nameForRoute = "";
        Controller graph = new Controller();
        Graph thisGraph = graph.makeGraph();

        Vertex end = thisGraph.getVertex(travelTo.getText());
        Vertex start = thisGraph.getVertex(travelFrom.getText());

        Pair<Integer, Map<Vertex, Vertex>> result = thisGraph.shortestDistance(start, end);
        Vertex current = end;

        ArrayList<Vertex> Path = new ArrayList<>();
        Path.add(end);


        System.out.println("This is the shortest path for time: ");

        while((current != start) && (result.getValue().get(current) != null))
        {
            current = result.getValue().get(current);
            Path.add(0, current);
        }

        for (Vertex vertex : Path)
        {
            System.out.print(vertex.Name);
            if (!vertex.Name.equals(start.Name))
            {
                nameForRoute = nameForRoute + " --> " + vertex.Name;
            }

            else
            {
                nameForRoute = vertex.Name;
            }
        }

        return nameForRoute;
    }

    public String resultForShortestTime()
    {
        String nameForRoute = "";
        Controller TestGraph = new Controller();
        Graph g = TestGraph.makeGraph();
        Vertex end = g.getVertex(travelTo.getText());
        Vertex start = g.getVertex(travelFrom.getText());
        Pair<Integer, Map<Vertex, Vertex>> result = g.shortestTime(start, end);
        Vertex current = end;
        ArrayList<Vertex> Path = new ArrayList<>();
        Path.add(end);


        System.out.println("This is the shortest path for time: ");

        while((current != start) && (result.getValue().get(current) != null))
        {
            current = result.getValue().get(current);
            Path.add(0, current);
        }

        for (Vertex vertex : Path)
        {
            System.out.print(vertex.Name);
            if (!vertex.Name.equals(start.Name))
            {
                nameForRoute = nameForRoute + " --> " + vertex.Name;
            }

            else
            {
                nameForRoute = vertex.Name;
            }
        }

        return nameForRoute;
    }

    public String resultForMinimumCo2()
    {
        String nameForRoute = "";
        Controller TestGraph = new Controller();
        Graph g = TestGraph.makeGraph();
        Vertex end = g.getVertex(travelTo.getText());
        Vertex start = g.getVertex(travelFrom.getText());
        Pair<Integer, Map<Vertex, Vertex>> result = g.minimumCo2(start, end);
        Vertex current = end;
        ArrayList<Vertex> Path = new ArrayList<>();
        Path.add(end);


        System.out.println("This is the shortest path for time: ");

        while((current != start) && (result.getValue().get(current) != null))
        {
            current = result.getValue().get(current);
            Path.add(0, current);
        }

        for (Vertex vertex : Path)
        {
            System.out.print(vertex.Name);
            if (!vertex.Name.equals(start.Name))
            {
                nameForRoute = nameForRoute + " --> " + vertex.Name;
            }

            else
            {
                nameForRoute = vertex.Name;
            }
        }

        return nameForRoute;
    }

    public Graph makeGraph()
    {
        Graph myGraph = new Graph();

        final Vertex Berlin = myGraph.addVertex("Berlin");
        final Vertex Copenhagen = myGraph.addVertex("Copenhagen");
        final Vertex London = myGraph.addVertex("London");
        final Vertex Bangkok = myGraph.addVertex("Bangkok");
        final Vertex Auckland = myGraph.addVertex("Auckland");
        final Vertex Denpasar = myGraph.addVertex("Denpasar");
        final Vertex Dubai = myGraph.addVertex("Dubai");
        final Vertex Sydney = myGraph.addVertex("Sydney");

        myGraph.newEdge(Copenhagen, Berlin, 356/100, 1, 356/100);
        myGraph.newEdge(Copenhagen, London, 957/100, 4, 957/100);
        myGraph.newEdge(Copenhagen, Dubai, 4828/100, 6, 4828/100);

        myGraph.newEdge(Bangkok, Sydney, 7547/100, 9, 7547/100);
        myGraph.newEdge(Bangkok, Denpasar, 2979/100, 4, 2979/100);

        myGraph.newEdge(Auckland, Bangkok, 9685/100, 12, 9685/100);
        myGraph.newEdge(Auckland, Denpasar, 6745/100, 9, 6745/100);
        myGraph.newEdge(Auckland, Sydney, 2159/100, 3, 2159/100);
        myGraph.newEdge(Auckland, London, 18362/100, 25, 18362/100);

        myGraph.newEdge(Denpasar, Dubai, 7508/100, 9, 7508/100);
        myGraph.newEdge(Denpasar, Sydney, 4629/100, 6, 4629/100);

        myGraph.newEdge(Berlin, London, 931/100,2,921/100);
        myGraph.newEdge(Berlin, Copenhagen, 356/100, 1, 356/100);

        myGraph.newEdge(Dubai, Sydney, 12067/100, 13, 12067/100);
        myGraph.newEdge(Dubai, Auckland, 14222/100, 16, 14222/100);
        myGraph.newEdge(Dubai, Denpasar, 7508/100, 9, 7508/100);

        myGraph.newEdge(Sydney, London, 17018/100, 23, 17018/100);
        myGraph.newEdge(Sydney, Dubai, 12067/100, 14, 12067/100);

        myGraph.newEdge(London, Copenhagen, 957/100, 2, 957/100);
        myGraph.newEdge(London, Bangkok,  9545/100, 11,  9545/100);


        return myGraph;
    }

    public class Graph
    {
        private ArrayList<Vertex> Vertices = new ArrayList<>();

        public Vertex addVertex(String id)
        {
            Vertex newVertex = new Vertex(id);
            Vertices.add(newVertex);
            return newVertex;
        }

        public Vertex getVertex(String name)
        {
            for(Vertex vertex : Vertices )
            {

                if (vertex.Name.equals(name))
                {
                    return vertex;
                }
            }
            return null;
        }

        public void newEdge(Vertex from, Vertex to, int dist, int time, int co2)
        {
            Edge newEdge = new Edge(from, to);
            newEdge.distance = dist;                                                                                        // newEdge.distance bliver defineret til at være lig dist.
            newEdge.time = time;                                                                                            // newEdge.time bliver defineret til at være lig time.
            newEdge.co2 = co2;

        }

        public Pair<Integer, Map<Vertex, Vertex> > minimumCo2(Vertex start, Vertex end)
        {
            Map<Vertex, Vertex> predecessorMap = new HashMap<>();
            Map<Vertex,Integer> verticesMap = new HashMap<>();
            Map<Vertex, Integer> TMap = new HashMap<>();

            for(Vertex v: Vertices)
            {
                verticesMap.put(v,1000);
                TMap.put(v,1000);
                predecessorMap.put(v, null);
            }

            verticesMap.put(start, 0);
            TMap.put(start, 0);

            for (int i = 0; i < Vertices.size() ; i++)
            {
                Vertex current = getMinimum(TMap);

                for (int j = 0; j < current.getOutEdges().size(); j++)
                {
                    if (verticesMap.get(current) + current.getOutEdges().get(j).co2 <
                            verticesMap.get(current.getOutEdges().get(j).getToVertex()))

                    {
                        verticesMap.put(current.getOutEdges().get(j).getToVertex(), verticesMap.get(current) +
                                current.getOutEdges().get(j).co2);

                        TMap.put(current.getOutEdges().get(j).getToVertex(), verticesMap.get(current) +
                                current.getOutEdges().get(j).co2);

                        predecessorMap.put(current.getOutEdges().get(j).getToVertex(),current);
                    }
                }
                TMap.remove(current);
            }
            return (new Pair<> (verticesMap.get(end), predecessorMap));
        }

        public Pair<Integer, Map<Vertex, Vertex> > shortestTime(Vertex start, Vertex end)
        {
            Map<Vertex, Vertex> predecessorMap = new HashMap<>();
            Map<Vertex,Integer> verticesMap = new HashMap<>();
            Map<Vertex, Integer> TMap = new HashMap<>();

            for(Vertex v: Vertices)
            {
                verticesMap.put(v,1000);
                TMap.put(v,1000);
                predecessorMap.put(v, null);
            }

            verticesMap.put(start, 0);
            TMap.put(start, 0);

            for (int i = 0; i < Vertices.size() ; i++)
            {
                Vertex current = getMinimum(TMap);

                for (int j = 0; j < current.getOutEdges().size(); j++)
                {
                    if (verticesMap.get(current) + current.getOutEdges().get(j).time <
                            verticesMap.get(current.getOutEdges().get(j).getToVertex()))

                    {
                        verticesMap.put(current.getOutEdges().get(j).getToVertex(), verticesMap.get(current) +
                                current.getOutEdges().get(j).time);

                        TMap.put(current.getOutEdges().get(j).getToVertex(), verticesMap.get(current) +
                                current.getOutEdges().get(j).time);

                        predecessorMap.put(current.getOutEdges().get(j).getToVertex(),current);
                    }
                }
                TMap.remove(current);
            }
            return (new Pair<> (verticesMap.get(end), predecessorMap));
        }

        public Pair<Integer, Map<Vertex, Vertex> > shortestDistance(Vertex start, Vertex end)
        {
            Map<Vertex, Vertex> predecessorMap = new HashMap<>();
            Map<Vertex,Integer> verticesMap = new HashMap<>();
            Map<Vertex, Integer> TMap = new HashMap<>();

            for(Vertex v: Vertices)
            {
                verticesMap.put(v,1000);
                TMap.put(v,1000);
                predecessorMap.put(v, null);
            }

            verticesMap.put(start, 0);
            TMap.put(start, 0);

            for (int i = 0; i < Vertices.size() ; i++)
            {
                Vertex current = getMinimum(TMap);

                for (int j = 0; j < current.getOutEdges().size(); j++)
                {
                    if (verticesMap.get(current) + current.getOutEdges().get(j).distance <
                            verticesMap.get(current.getOutEdges().get(j).getToVertex()))

                    {
                        verticesMap.put(current.getOutEdges().get(j).getToVertex(), verticesMap.get(current) +
                                current.getOutEdges().get(j).distance);

                        TMap.put(current.getOutEdges().get(j).getToVertex(), verticesMap.get(current) +
                                current.getOutEdges().get(j).distance);

                        predecessorMap.put(current.getOutEdges().get(j).getToVertex(),current);
                    }
                }
                TMap.remove(current);
            }
            return (new Pair<> (verticesMap.get(end), predecessorMap));
        }

        public Vertex getMinimum(Map<Vertex,Integer> minimumTMap)
        {
            Map.Entry<Vertex, Integer> minimumVertex = null;                                                                // Vi sætter vores minimumVertex til at være lig med null da den skal være null så der ikke bliver tilføjet noget til de værdier den skal tjekke
            for (Map.Entry<Vertex,Integer> entry : minimumTMap.entrySet())                                                  // For hver entry der er i vores entrySet, kører vi vores if statement
            {
                if (minimumVertex == null || minimumVertex.getValue() > entry.getValue())                                   // Hvis vores entry er større end den næste positions værdi...
                {
                    minimumVertex = entry;                                                                                  // ...sæt den opdaterede minimumVertex lig med entry.
                }
            }

            return minimumVertex.getKey();                                                                                  //Returnere den Vertex, for hvilken værdi der er mindst
        }
    }

    public class Vertex
    {
        String Name;
        ArrayList<Edge> outEdges = new ArrayList<>();

        public  Vertex(String id)
        {
            Name=id;
        }

        public void addOutEdge(Edge outEdge)
        {
            outEdges.add(outEdge);

        }

        public ArrayList<Edge> getOutEdges()
        {
            return outEdges;
        }
    }

    public class Edge
    {
        private Vertex fromVertex;
        private Vertex toVertex;
        int distance=0;
        int time=0;
        int co2 =0;

        private Vertex getToVertex()
        {
            return toVertex;
        }

        private Edge(Vertex from, Vertex to){
            fromVertex = from;
            toVertex = to;
            fromVertex.addOutEdge(this);
            toVertex.addOutEdge(this);
        }
    }
}