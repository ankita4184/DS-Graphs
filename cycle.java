import java.io.*;
import java.util.*;
import java.lang.*;

public class cycle{
    public static void main(String[] args){
        graph g = new graph(5);
        g.addEdge(0,1); g.addEdge(0,2); g.addEdge(0,3);  g.addEdge(4,3);
        if(g.findCycle(0, -1)) System.out.println("cycle detected");
        else System.out.println("cycle not detected");
    }
}

class graph{
    LinkedList<Integer> adjL[];
    Boolean visited[];
    Integer vertex;
    public graph(){}
    public graph(int v){
        vertex = v;
        visited = new Boolean[vertex];
        Arrays.fill(visited, Boolean.FALSE);
        adjL = new LinkedList[vertex];
        for(int i = 0; i < vertex; i++)
            adjL[i] = new LinkedList<>();
    }
    public void addEdge(int v1, int v2){
        adjL[v1].add(v2);
        adjL[v2].add(v1);
    }
    public Boolean findCycle1(int node, int parent){
        visited[node] = true;
        Boolean b;
        Iterator<Integer> it = adjL[node].iterator();
        while(it.hasNext()){
            Integer p = it.next();
            if(visited[p] == true && p != parent)
                return true;
            else if(visited[p] != true){
                if(findCycle1(p, node))
                    return true;
            }
        }
      return false;
        
    }
    public Boolean findCycle(int node, int parent){
        for(int i = 0; i < vertex; i++){
            if(visited[i] == false)
                if(findCycle1(i, -1))
                    return true;
        }
        return false;
    }
}

                    
