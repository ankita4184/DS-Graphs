import java.io.*;
import java.lang.*;
import java.util.*;

public class euler{
    public static void main(String[] args){
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.test();
        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        g2.test();
        Graph g3 = new Graph(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        g3.test();
        Graph g4 = new Graph(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        g4.test();
        Graph g5 = new Graph(3);
        g5.test();
    }
}

class Graph{
    LinkedList<Integer> adjL[];
    Boolean visited[];
    Integer vertex;
    public Graph(){}
    public Graph(int v){
        vertex = v;
        adjL = new LinkedList[vertex];
        visited = new Boolean[vertex];
        Arrays.fill(visited, Boolean.FALSE);
        for(int i = 0; i < vertex; i++)
            adjL[i] = new LinkedList<>();
    }
    public void addEdge(int v1, int v2){
        adjL[v1].add(v2);
        adjL[v2].add(v1);
    }
    private void dfs(int i){
        visited[i] = true;
        Iterator<Integer> it = adjL[i].iterator();
        while(it.hasNext()){
            Integer p = it.next();
            if(visited[p] != true)
                dfs(p);
        }
    } 
    public void test(){
        int i, count = 0;
        for(i = 0; i < vertex; i++)
            if(adjL[i].size() != 0)
                break;
        if(i == vertex)
            System.out.println("no euler");
        else{
            dfs(i);
            for(i = 0; i < vertex; i++){
                if(visited[i] == false && adjL[i].size() > 0)
                    System.out.println("no euler");
            }
            if(i == vertex){
                for(i = 0; i < vertex; i++){
                    if(adjL[i].size() % 2 != 0)
                        count++;
                }
                if(count == 0) System.out.println("euler");
                else if(count == 2) System.out.println("semi euler");
                else System.out.println("no euler");
            }
        }
    }
}
                    
