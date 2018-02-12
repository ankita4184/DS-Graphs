import java.io.*;
import java.lang.*;
import java.util.*;

public class bipartite{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int vertex = scan.nextInt();
        graph g = new graph(vertex);
         g.addEdge(1,5); g.addEdge(1,6); g.addEdge(1,7);  g.addEdge(2,6); g.addEdge(3,7);
        for(int i = 0; i < vertex; i++){
            if(g.check(i) == false){
                vertex  = -1; break;
            }
        }
        if(vertex == -1) System.out.println("not bi");
        else System.out.println("bi");
    }
}

class graph{
    LinkedList<Integer> adjL[];
    Integer color[];
    Boolean visited[];
    Integer v;
    public graph(){}
    public graph(int vertex){
        v = vertex;
        visited = new Boolean[v];
        Arrays.fill(visited, Boolean.FALSE);
        color = new Integer[v];
        Arrays.fill(color, -1);
        adjL = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adjL[i] = new LinkedList<>();
        }
    }
    public void addEdge(int v1, int v2){
        adjL[v1].add(v2);
        adjL[v2].add(v1);
    }
    public Boolean check(int node){
        if(color[node] == -1)
            color[node] = 1;
        Iterator<Integer> it = adjL[node].iterator();
        while(it.hasNext()){
            Integer p = it.next();
            if(color[p] == -1)
                color[p] = 1 ^ color[node];
            else if(color[p] == color[node])
                return false;
        }
        return true;
    }
}
