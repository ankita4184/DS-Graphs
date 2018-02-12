import java.io.*;
import java.lang.*;
import java.util.*;

public class cycleDir extends graph{
    public static void main(String[] args){
        graph g = new graph(5);
        g.addEdge(0,1); g.addEdge(1,2); g.addEdge(2,3); g.addEdge(3,4); g.addEdge(4,1);
        for(int i = 0; i < 5; i++){
            Arrays.fill(g.visited, Boolean.FALSE);
           if(g.cycle(i,i)){
                    System.out.println("cycle starting from "+i); 
                }
                else
                    System.out.println("no cycle starting from "+i);
            }
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
            adjL[i] = new LinkedList<Integer>();
    }
    public void addEdge(int v1, int v2){
        adjL[v1].add(v2);
    }
    public Boolean cycle(int node, int parent){
        visited[node] = true;
        Iterator<Integer> it = adjL[node].iterator();
        while(it.hasNext()){
            int p = it.next();
            System.out.println(p+" "+parent);
            if(visited[p] == false){
                if(cycle(p, parent) == true)
                    return true;
            }
            else if(p == parent)
                return true;
        }
        return false;
    }
}
