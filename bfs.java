import java.io.*;
import java.lang.*;
import java.util.*;

public class bfs extends graph {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Integer vertex = scan.nextInt();
        graph g = new graph(vertex);
        g.input();
        g.tbfs(2);
    }
}

class graph{
    public LinkedList<Integer> q = new LinkedList();
    public Boolean visited[];
    public LinkedList<Integer> adjL[];
    public Integer vertex;
    public graph(){}
    public graph(int v){
        visited = new Boolean[v];
        Arrays.fill(visited, Boolean.FALSE);
        vertex = v;
        adjL = new LinkedList[v];
        for(int i = 0; i < v; i++)
            adjL[i] = new LinkedList<Integer>();
    }
    public void input(){
        Scanner s = new Scanner(System.in);
        Integer ed = s.nextInt();
        for(int i = 0; i < ed; i++){
            Integer v1 = s.nextInt();
            Integer v2 = s.nextInt();
            addEdge(v1,v2);
        }
    }
    private void addEdge(int v1, int v2){
        adjL[v1].add(v2);
    }
    public void tbfs(int i){
        q.add(i);
        visited[i] = true;
        while(q.size() != 0){
            i = q.poll();
            System.out.print(i+" ");
            Iterator<Integer> it = adjL[i].iterator();
            while(it.hasNext()){
                int p = it.next();
                if(!visited[p]){
                    visited[p] = true;
                    q.add(p);
                }
            }
        }
    }
}


