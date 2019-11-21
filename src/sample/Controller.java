package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static javafx.collections.FXCollections.observableArrayList;


public class Controller {
    TrainModel m = TrainModel.getInstance();                                                                            // make a model object when you create the controller
    ObservableList list = FXCollections.observableArrayList();

    @FXML
    TextField travelFrom;
    @FXML
    TextField travelTo;
    @FXML
    TextArea res;

    @FXML
    public void routeHandler(ActionEvent e)
    {
        res.setText("This is the shortest route: " + resultForShortestDistance()+ " \n" +
                "This is the most time efficient route: " + resultForShortestTime() + " \n" +
                "This is most green route: " + resultForLessCo2());
    }




    public String resultForShortestDistance()
    {

        // Create graph
        String nameForDistRoute = "";
        Controller TestGraph = new Controller();
        DijkstraPathFinding g = TestGraph.MakeSmallGraph();

        Vertex end = null;
        switch (travelTo.getText())
        {
            case "A" : end = g.getVertex("A");
            break;

            case "B" : end = g.getVertex("B");
                break;

            case "C" : end = g.getVertex("C");
                break;

            case "D" : end = g.getVertex("D");
                break;

            case "E" : end = g.getVertex("E");
                break;

            case "F" : end = g.getVertex("F");
                break;
        }

        Vertex start = null;
        switch (travelFrom.getText())
        {
            case "A" : start = g.getVertex("A");
                break;

            case "B" : start = g.getVertex("B");
                break;

            case "C" : start = g.getVertex("C");
                break;

            case "D" : start = g.getVertex("D");
                break;

            case "E" : start = g.getVertex("E");
                break;

            case "F" : start = g.getVertex("F");
                break;
        }



        Pair<Integer, Map<Vertex, Vertex>> resultsForDist = g.ShortestDistance(start, end);

        Vertex currentDist = end;
        ArrayList<Vertex> PathDist = new ArrayList<>();
        PathDist.add(end);


        System.out.println("This is the shortest path for distance: ");

        while ((currentDist != start) && (resultsForDist.getValue().get(currentDist) != null))
        {
            currentDist = resultsForDist.getValue().get(currentDist);
            PathDist.add(0, currentDist);
        }

        for (Vertex vertex : PathDist)
        {
            System.out.print(vertex.Name);
            if (vertex.Name != start.Name)
            {
                nameForDistRoute = nameForDistRoute + " --> " + vertex.Name;
            }

            else
            {
                nameForDistRoute = vertex.Name;
            }

        }
       return nameForDistRoute;
    }


    public String resultForShortestTime()
    {
        // Create graph
        String nameForTimeRoute = "";
        Controller TestGraph = new Controller();
        DijkstraPathFinding g = TestGraph.MakeSmallGraph();

        Vertex end = null;
        switch (travelTo.getText())
        {
            case "A" : end = g.getVertex("A");
                break;

            case "B" : end = g.getVertex("B");
                break;

            case "C" : end = g.getVertex("C");
                break;

            case "D" : end = g.getVertex("D");
                break;

            case "E" : end = g.getVertex("E");
                break;

            case "F" : end = g.getVertex("F");
                break;
        }

        Vertex start = null;
        switch (travelFrom.getText())
        {
            case "A" : start = g.getVertex("A");
                break;

            case "B" : start = g.getVertex("B");
                break;

            case "C" : start = g.getVertex("C");
                break;

            case "D" : start = g.getVertex("D");
                break;

            case "E" : start = g.getVertex("E");
                break;

            case "F" : start = g.getVertex("F");
                break;
        }

        Pair<Integer, Map<Vertex, Vertex>> resultsForTime = g.ShortestTime(start, end);
        Vertex currentTime = end;
        ArrayList<Vertex> PathTime = new ArrayList<>();
        PathTime.add(end);


        System.out.println("This is the shortest path for time: ");

        while((currentTime != start) && (resultsForTime.getValue().get(currentTime) != null))
        {
            currentTime = resultsForTime.getValue().get(currentTime);
            PathTime.add(0, currentTime);
        }

        for (Vertex vertex : PathTime)
        {
            System.out.print(vertex.Name);
            if (vertex.Name != start.Name)
            {
                nameForTimeRoute = nameForTimeRoute + " --> " + vertex.Name;
            }

            else
            {
                nameForTimeRoute = vertex.Name;
            }
        }

        return nameForTimeRoute;
    }

    public String resultForLessCo2()
    {
        String nameForCo2Route = "";
        Controller TestGraph = new Controller();
        DijkstraPathFinding g = TestGraph.MakeSmallGraph();


        Vertex end = null;
        switch (travelTo.getText())
        {
            case "A" : end = g.getVertex("A");
                break;

            case "B" : end = g.getVertex("B");
                break;

            case "C" : end = g.getVertex("C");
                break;

            case "D" : end = g.getVertex("D");
                break;

            case "E" : end = g.getVertex("E");
                break;

            case "F" : end = g.getVertex("F");
                break;
        }

        Vertex start = null;
        switch (travelFrom.getText())
        {
            case "A" : start = g.getVertex("A");
                break;

            case "B" : start = g.getVertex("B");
                break;

            case "C" : start = g.getVertex("C");
                break;

            case "D" : start = g.getVertex("D");
                break;

            case "E" : start = g.getVertex("E");
                break;

            case "F" : start = g.getVertex("F");
                break;
        }

        Pair<Integer, Map<Vertex, Vertex>> resultsForLessCo2 = g.LesserCo2(start, end);
        Vertex currentCo2 = end;
        ArrayList<Vertex> PathCo2 = new ArrayList<>();
        PathCo2.add(end);


        System.out.println("This is the shortest path for Co2: ");

        while ((currentCo2 != start) && (resultsForLessCo2.getValue().get(currentCo2) != null))
        {
            currentCo2 = resultsForLessCo2.getValue().get(currentCo2);
            PathCo2.add(0, currentCo2);
        }

        for (Vertex vertex : PathCo2)
        {
            System.out.print(vertex.Name);
            if (vertex.Name != start.Name)
            {
                nameForCo2Route = nameForCo2Route + " --> " + vertex.Name;
            }

            else
            {
                nameForCo2Route = vertex.Name;
            }
        }

        return nameForCo2Route;
    }

    public DijkstraPathFinding MakeSmallGraph()
    {
        DijkstraPathFinding myGraph = new DijkstraPathFinding();

        final Vertex A = myGraph.addVertex("A");
        final Vertex B = myGraph.addVertex("B");
        final Vertex C = myGraph.addVertex("C");
        final Vertex D = myGraph.addVertex("D");
        final Vertex E = myGraph.addVertex("E");
        final Vertex F = myGraph.addVertex("F");

        myGraph.newEdge(A, B, 1, 2, 30);
        myGraph.newEdge(A, C, 5, 1, 22);
        myGraph.newEdge(A, D, 4, 6, 4);
        myGraph.newEdge(B, C, 3, 2, 50);
        myGraph.newEdge(B, D, 2, 3, 15);
        myGraph.newEdge(B, E, 2, 4, 40);
        myGraph.newEdge(C, F, 1, 8, 43);
        myGraph.newEdge(C, E, 2, 2, 22);
        myGraph.newEdge(D, F, 2, 7, 11);
        myGraph.newEdge(E, F, 3, 6, 8);
        myGraph.newEdge(E, A, 2, 8, 2);


        return myGraph;
    }



    public class DijkstraPathFinding
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

                if (vertex.Name==name)
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
            newEdge.co2 = co2;
            newEdge.time = time;                                                                                            // newEdge.time bliver defineret til at være lig time.
        }



        //Dijkstra for ShortestDistance starter
        public Pair<Integer, Map<Vertex, Vertex> > ShortestDistance(Vertex start, Vertex end)                                // Vi laver en Pair, hvor key er Integer og value er et map med værdierne Vertex og Vertex, kaldet ShortestDistance med parametrene "start" og "end" af typen Vertex.
        {
            Map<Vertex, Vertex> PredecessorMapForDist = new HashMap<>();                                                     // Vi laver en PredecessorMapForDist af typen HashMap der tager to Vertices
            Map<Vertex,Integer> DistanceMap = new HashMap<>();                                                              // Vi laver en DistanceMap af typen HashMap der tager en Vertex og en Integer
            Map<Vertex, Integer> TMap = new HashMap<>();                                                                    // Vi laver en TMap af typen HashMap der tager en Vertex og en Integer.
            // DistanceMap behandler edges mens TMap behandler vertices. TMap er derudover en kopi af DistanceMap

            for(Vertex v: Vertices)                                                                                         // For each løkke. For hver Vertex v kører vi igennem Vertices
            {
                DistanceMap.put(v,1000);                                                                                    //For hver Vertex v, sætter vi 1000 = simulation of infinity
                TMap.put(v,1000);                                                                                           //For hver Vertex v, sætter vi 1000
                PredecessorMapForDist.put(v, null);                                                                         //Anden parameter for PredecessorMapForDist sætter vi til null, grundet vi ikke har været nogen steder endnu i vores graf
            }

            DistanceMap.put(start, 0);                                                                                      //Edges     - De skal opdateres sammen hver gang
            TMap.put(start, 0);                                                                                             //Vertices  - De skal opdateres sammen hver gang

            for (int i = 0; i < Vertices.size() ; i++)                                                                      // Så længe i er mindre en Vertices.size, gør i større med en
            {
                Vertex current = getMinimum(TMap);                                                                          // Vi laver en Vertex der hedder current som vi sætter lig med vores funktion getMin som bliver brugt af TMap


                for (int j = 0; j < current.getOutEdges().size(); j++)                                                      // Så længe at j er mindre end vores nuværende OutEdge størrelse, gør j større med en
                {
                    if (DistanceMap.get(current) + current.getOutEdges().get(j).distance <                                  // hvis vores current vertex + den current outEdge (distance) er mindre end vores næste vertex værdi gør...
                            DistanceMap.get(current.getOutEdges().get(j).getTovertex()))
                    {
                        DistanceMap.put(current.getOutEdges().get(j).getTovertex(), DistanceMap.get(current) +              //... sæt vores næste vertex til at være lig med current vertex + current OutEdge i DistanceMap
                                current.getOutEdges().get(j).distance);

                        TMap.put(current.getOutEdges().get(j).getTovertex(), DistanceMap.get(current) +                     //... sæt vores næste vertex til at være lig med current vertex + current OutEdge i TMap
                                current.getOutEdges().get(j).distance);

                        PredecessorMapForDist.put(current.getOutEdges().get(j).getTovertex(),current);                      //... opdater vores current til at være lig med vores "tidligere" næste vertex værdi
                    }
                }
                TMap.remove(current);                                                                                       //current fjernes fra TMap
            }
            return (new Pair<Integer,Map<Vertex, Vertex>> (DistanceMap.get(end), PredecessorMapForDist));                    // Vores Pair med key DistanceMap.get(end) og value PredecessorMapForDist bliver retuneret her
        }

        public Pair<Integer, Map<Vertex, Vertex> > LesserCo2(Vertex start, Vertex end)                                // Vi laver en Pair, hvor key er Integer og value er et map med værdierne Vertex og Vertex, kaldet ShortestDistance med parametrene "start" og "end" af typen Vertex.
        {
            Map<Vertex, Vertex> PredecessorMapForCo2 = new HashMap<>();                                                     // Vi laver en PredecessorMapForDist af typen HashMap der tager to Vertices
            Map<Vertex,Integer> LesCo2Map = new HashMap<>();                                                              // Vi laver en DistanceMap af typen HashMap der tager en Vertex og en Integer
            Map<Vertex, Integer> TMap = new HashMap<>();                                                                    // Vi laver en TMap af typen HashMap der tager en Vertex og en Integer.


            for(Vertex v: Vertices)                                                                                         // For each løkke. For hver Vertex v kører vi igennem Vertices
            {
                LesCo2Map.put(v,1000);                                                                                    //For hver Vertex v, sætter vi 1000 = simulation of infinity
                TMap.put(v,1000);                                                                                           //For hver Vertex v, sætter vi 1000
                PredecessorMapForCo2.put(v, null);                                                                         //Anden parameter for PredecessorMapForDist sætter vi til null, grundet vi ikke har været nogen steder endnu i vores graf
            }

            LesCo2Map.put(start, 0);                                                                                      //Edges     - De skal opdateres sammen hver gang
            TMap.put(start, 0);                                                                                             //Vertices  - De skal opdateres sammen hver gang

            for (int i = 0; i < Vertices.size() ; i++)                                                                      // Så længe i er mindre en Vertices.size, gør i større med en
            {
                Vertex current = getMinimum(TMap);                                                                          // Vi laver en Vertex der hedder current som vi sætter lig med vores funktion getMin som bliver brugt af TMap


                for (int j = 0; j < current.getOutEdges().size(); j++)                                                      // Så længe at j er mindre end vores nuværende OutEdge størrelse, gør j større med en
                {
                    if (LesCo2Map.get(current) + current.getOutEdges().get(j).co2 <                                  // hvis vores current vertex + den current outEdge (distance) er mindre end vores næste vertex værdi gør...
                            LesCo2Map.get(current.getOutEdges().get(j).getTovertex()))
                    {
                        LesCo2Map.put(current.getOutEdges().get(j).getTovertex(), LesCo2Map.get(current) +              //... sæt vores næste vertex til at være lig med current vertex + current OutEdge i DistanceMap
                                current.getOutEdges().get(j).co2);

                        TMap.put(current.getOutEdges().get(j).getTovertex(), LesCo2Map.get(current) +                     //... sæt vores næste vertex til at være lig med current vertex + current OutEdge i TMap
                                current.getOutEdges().get(j).co2);

                        PredecessorMapForCo2.put(current.getOutEdges().get(j).getTovertex(),current);                      //... opdater vores current til at være lig med vores "tidligere" næste vertex værdi
                    }
                }
                TMap.remove(current);                                                                                       //current fjernes fra TMap
            }
            return (new Pair<Integer,Map<Vertex, Vertex>> (LesCo2Map.get(end), PredecessorMapForCo2));                    // Vores Pair med key DistanceMap.get(end) og value PredecessorMapForDist bliver retuneret her
        }                                                                                                                   // Slut på ShortestDistance



        public Pair<Integer, Map<Vertex, Vertex> > ShortestTime(Vertex start, Vertex end)
        {
            Map<Vertex, Vertex> PredecessorMapForTime = new HashMap<>();
            Map<Vertex,Integer> TimeMap = new HashMap<>();
            Map<Vertex, Integer> TMap = new HashMap<>();

            for(Vertex v: Vertices)
            {
                TimeMap.put(v,1000);
                TMap.put(v,1000);
                PredecessorMapForTime.put(v, null);
            }

            TimeMap.put(start, 0);
            TMap.put(start, 0);

            for (int i = 0; i < Vertices.size() ; i++)
            {
                Vertex current = getMinimum(TMap);

                for (int j = 0; j < current.getOutEdges().size(); j++)
                {
                    if (TimeMap.get(current) + current.getOutEdges().get(j).time <
                            TimeMap.get(current.getOutEdges().get(j).getTovertex()))

                    {
                        TimeMap.put(current.getOutEdges().get(j).getTovertex(), TimeMap.get(current) +
                                current.getOutEdges().get(j).time);

                        TMap.put(current.getOutEdges().get(j).getTovertex(), TimeMap.get(current) +
                                current.getOutEdges().get(j).time);

                        PredecessorMapForTime.put(current.getOutEdges().get(j).getTovertex(),current);
                    }
                }
                TMap.remove(current);
            }
            return (new Pair<Integer,Map<Vertex, Vertex>> (TimeMap.get(end), PredecessorMapForTime));
        }


        public Vertex getMinimum(Map<Vertex,Integer> minimumTMap)                                                           // Vi laver en metode der kan retunere en vertex og kan bruge en map med Vertex og Integer.
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



    class Vertex
    {
        String Name;
        ArrayList<Edge> OutEdges = new ArrayList<>();

        public  Vertex(String id)
        {
            Name=id;
        }

        public void addOutEdge(Edge outedge)
        {
            OutEdges.add(outedge);

        }

        public ArrayList<Edge> getOutEdges()
        {
            return OutEdges;
        }
    }

    //Denne klasse på IKKE ændres!
    class Edge
    {
        private Vertex fromvertex;
        private Vertex tovertex;
        public int distance=0;
        public int time=0;
        public int co2;

        public Vertex getTovertex() {
            return tovertex;
        }

        public Edge(Vertex from, Vertex to){
            fromvertex = from;
            tovertex = to;
            fromvertex.addOutEdge(this);
            //If not directional
            tovertex.addOutEdge(this);
        }
    }
}

class TrainModel{                                                                                                       // is a Singleton!
    private TrainModel()
    {

    }
    static TrainModel inst;

    static TrainModel getInstance()
    {
        if(inst==null)inst=new TrainModel();
        return inst;
    }
}