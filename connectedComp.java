import java.io.*;
import java.lang.*;
import java.util.*;

public class connectedComp{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Integer vertex = scan.nextInt();
        graph g = new graph(vertex);
        g.input();
        System.out.println(g.connected());
    }
}

class graph{
    LinkedList<Integer> adjL[];
    Boolean visited[];
    Integer vertex;
    public graph(){}
    public graph(Integer v){
        vertex = v;
        adjL = new LinkedList[vertex];
        visited = new Boolean[vertex];
        Arrays.fill(visited, Boolean.FALSE);
        for(int i = 0; i < v; i++)
            adjL[i] = new LinkedList<Integer>();
    }
    public void input(){
        Scanner s = new Scanner(System.in);
        Integer ed = s.nextInt();
        Integer v1, v2;
        for(int i = 0; i < ed; i++){
            v1 = s.nextInt();
            v2 = s.nextInt();
            addEdge(v1, v2);
        }
    }
    private void addEdge(int v1, int v2){   
        adjL[v1].add(v2);
        adjL[v2].add(v1);
    }
    private void dfs(int i){
        visited[i] = true;
        Iterator it = adjL[i].iterator();
        while(it.hasNext()){
            Integer p = (Integer)it.next();
            if(visited[p] == false)
                dfs(p);
        }
    }
    public int connected(){
        int comp = 0;
        for(int i = 0; i < vertex; i++){
            if(visited[i] == false){
                dfs(i);
                comp++;
            }
        }
        return comp;
    }
}
