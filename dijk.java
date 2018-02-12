import java.io.*;
import java.lang.*;
import java.util.*;

public class dijk{
    public static void main(String[] args){
        graph g = new graph(7);
        g.addEdge(0,1); g.addEdge(0,2); g.addEdge(1,3); g.addEdge(2,5); g.addEdge(3,4); g.addEdge(4,5); g.addEdge(5,6);
        g.dij();
        g.print();
    }
}

class graph{
    LinkedList<Integer> adjL[];
    Boolean visited[];
    Integer dist[];
    Integer vertex;
    public graph(){}
    public graph(int v){
        vertex = v;
        adjL = new LinkedList[vertex];
        visited = new Boolean[vertex];
        dist = new Integer[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i < vertex; i++)
            adjL[i] = new LinkedList<>();
    }
    public void addEdge(int v1, int v2){
        adjL[v1].add(v2);
        adjL[v2].add(v1);
    }
    public void dij(){
        dist[0] = 0;
        for(int i = 1; i < vertex; i++){
            Arrays.fill(visited, Boolean.FALSE);
            dijks(i);
        }
    }
    private void dijks(int node){
        visited[node] = true;
        Iterator<Integer> it = adjL[node].iterator();
        while(it.hasNext()){
            Integer p = it.next();
            if(dist[p] > dist[node] + 1)
                dist[p] = dist[node] + 1;
           if(visited[p] != true)
                dijks(p);
            visited[p] = true;
        }
    }
    public void print(){
        for(int i = 0; i < vertex; i++)
            System.out.println(dist[i]);
    }
}
            

