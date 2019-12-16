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
        res.setText("Dette er den korteste rejse: " + resultForShortestDistance()+ " \n" +
                "Dette er den hurtigste rejse: " + resultForShortestTime() + " \n" +
                "Dette er den mest CO2-venlige rejse: " + resultForMinimumCo2() + " \n" +
                "Den rejse med mindst CO2 udleder: " + Co2InKg() + " Kg. CO2");
    }


    public String resultForShortestDistance()
    {
        String nameForRoute = "";
        Controller graph = new Controller();
        Dijkstra g = graph.makeGraph();

        Vertex end = g.getVertex(travelTo.getText());
        Vertex start = g.getVertex(travelFrom.getText());

        Pair<Double, Map<Vertex, Vertex>> result = g.shortestDistance(start, end);
        Vertex current = end;

        ArrayList<Vertex> Path = new ArrayList<>();
        Path.add(end);

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
        Dijkstra g = TestGraph.makeGraph();

        Vertex end = g.getVertex(travelTo.getText());
        Vertex start = g.getVertex(travelFrom.getText());

        Pair<Double, Map<Vertex, Vertex>> result = g.shortestTime(start, end);
        Vertex current = end;
        ArrayList<Vertex> Path = new ArrayList<>();
        Path.add(end);

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
        Controller graph = new Controller();
        Dijkstra g = graph.makeGraph();

        Vertex end = g.getVertex(travelTo.getText());
        Vertex start = g.getVertex(travelFrom.getText());

        Pair<Double, Map<Vertex, Vertex>> result = g.minimumCo2(start, end);
        Vertex current = end;
        ArrayList<Vertex> Path = new ArrayList<>();
        Path.add(end);

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


    public Double Co2InKg()
    {

        Controller graph = new Controller();
        Dijkstra g = graph.makeGraph();

        Vertex end = g.getVertex(travelTo.getText());
        Vertex start = g.getVertex(travelFrom.getText());

        Pair<Double, Map<Vertex, Vertex>> result = g.minimumCo2(start, end);
        Vertex current = end;
        ArrayList<Vertex> Path = new ArrayList<>();
        Path.add(end);

        while((current != start) && (result.getValue().get(current) != null))
        {
            current = result.getValue().get(current);
            Path.add(0, current);
        }

        return result.getKey();
    }


    public Dijkstra makeGraph()
    {
        Dijkstra myDijkstra = new Dijkstra();

        final Vertex Berlin = myDijkstra.addVertex("Berlin");
        final Vertex Copenhagen = myDijkstra.addVertex("Copenhagen");
        final Vertex London = myDijkstra.addVertex("London");
        final Vertex Bangkok = myDijkstra.addVertex("Bangkok");
        final Vertex Auckland = myDijkstra.addVertex("Auckland");
        final Vertex Denpasar = myDijkstra.addVertex("Denpasar");
        final Vertex Dubai = myDijkstra.addVertex("Dubai");
        final Vertex Sydney = myDijkstra.addVertex("Sydney");

        myDijkstra.newEdge(Copenhagen, Berlin, 0.356, 1, 0.356);
        myDijkstra.newEdge(Copenhagen, London, 0.957, 4, 0.957);
        myDijkstra.newEdge(Copenhagen, Dubai, 4.828, 12, 4.828);
        myDijkstra.newEdge(Bangkok, Sydney, 7.547, 4, 7.547);
        myDijkstra.newEdge(Bangkok, Denpasar, 2.979, 6, 2.979);
        myDijkstra.newEdge(Auckland, Bangkok, 9.685, 20, 9.685);
        myDijkstra.newEdge(Auckland, Denpasar, 6.745, 9, 6.745);
        myDijkstra.newEdge(Auckland, Sydney, 2.159, 5, 2.159);
        myDijkstra.newEdge(Auckland, London, 18.362, 12, 18.362);
        myDijkstra.newEdge(Denpasar, Dubai, 7.508, 9, 7.508);
        myDijkstra.newEdge(Denpasar, Sydney, 4.629, 4, 4.629);
        myDijkstra.newEdge(Berlin, London, 0.931,6,0.921);
        myDijkstra.newEdge(Berlin, Copenhagen, 0.356, 4, 0.356);
        myDijkstra.newEdge(Dubai, Sydney, 12.067, 10, 12.067);
        myDijkstra.newEdge(Dubai, Auckland, 14.222, 16, 14.222);
        myDijkstra.newEdge(Dubai, Denpasar, 7.508, 8, 7.508);
        myDijkstra.newEdge(Sydney, London, 17.018, 23, 17.018);
        myDijkstra.newEdge(Sydney, Dubai, 12.067, 12, 12.067);
        myDijkstra.newEdge(London, Copenhagen, 0.957, 6, 0.957);
        myDijkstra.newEdge(London, Bangkok,  9.545, 8,  9.545);

        return myDijkstra;
    }


    public class Dijkstra
    {
        private ArrayList<Vertex> Vertices = new ArrayList<>();


        public Vertex addVertex(String name)
        {
            Vertex newVertex = new Vertex(name);
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


        public void newEdge(Vertex from, Vertex to, double dist, double time, double co2)
        {
            Edge newEdge = new Edge(from, to);
            newEdge.distance = dist;
            newEdge.time = time;
            newEdge.co2 = co2;
        }


        public Pair<Double, Map<Vertex, Vertex> > minimumCo2(Vertex start, Vertex end)
        {
            Map<Vertex, Vertex> predecessorMap = new HashMap<>();
            Map<Vertex,Double> verticesMap = new HashMap<>();
            Map<Vertex, Double> TMap = new HashMap<>();

            for(Vertex v: Vertices)
            {
                verticesMap.put(v,1000.0);
                TMap.put(v,1000.0);
                predecessorMap.put(v, null);
            }

            verticesMap.put(start, 0.0);
            TMap.put(start, 0.0);

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

            return new Pair<Double, Map<Vertex, Vertex>>(verticesMap.get(end), predecessorMap);
        }

        public Pair<Double, Map<Vertex, Vertex> > shortestTime(Vertex start, Vertex end)
        {
            Map<Vertex, Vertex> predecessorMap = new HashMap<>();
            Map<Vertex,Double> verticesMap = new HashMap<>();
            Map<Vertex, Double> TMap = new HashMap<>();


            for(Vertex v: Vertices)
            {
                verticesMap.put(v,1000.0);
                TMap.put(v,1000.0);
                predecessorMap.put(v, null);
            }

            verticesMap.put(start, 0.0);
            TMap.put(start, 0.0);

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

        public Pair<Double, Map<Vertex, Vertex> > shortestDistance(Vertex start, Vertex end)
        {
            Map<Vertex, Vertex> predecessorMap = new HashMap<>();
            Map<Vertex,Double> verticesMap = new HashMap<>();
            Map<Vertex, Double> TMap = new HashMap<>();


            for(Vertex v: Vertices)
            {
                verticesMap.put(v,1000.0);
                TMap.put(v,1000.0);
                predecessorMap.put(v, null);
            }

            verticesMap.put(start, 0.0);
            TMap.put(start, 0.0);

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


        public Vertex getMinimum(Map<Vertex, Double> minimumTMap)
        {
            Map.Entry<Vertex, Double> minimumVertex = null;
            for (Map.Entry<Vertex,Double> entry : minimumTMap.entrySet())
            {
                if (minimumVertex == null || minimumVertex.getValue() > entry.getValue())
                {
                    minimumVertex = entry;
                }
            }

            return minimumVertex.getKey();
        }
    }

    public class Vertex
    {
        String Name;
        ArrayList<Edge> outEdges = new ArrayList<>();

        public  Vertex(String name)
        {
            Name=name;
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
        Double distance = (double) 0;
        Double time = (double) 0;
        Double co2 = (double) 0;


        private Vertex getToVertex()
        {
            return toVertex;
        }


        private Edge(Vertex from, Vertex to)
        {
            fromVertex = from;
            toVertex = to;
            fromVertex.addOutEdge(this);
            toVertex.addOutEdge(this);
        }
    }
}