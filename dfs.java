import java.io.*;
import java.lang.*;
import java.util.*;

public class dfs{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Integer vertex = scan.nextInt();
        graph g = new graph(vertex);
        g.input();
        g.dfs(0);
        g.print();
    }
}

class graph{
    LinkedList<Integer> adjL[];
    Stack<Integer> s;
    Boolean visited[];
    Integer vertex;
    public graph(){}
    public graph(Integer v){
        vertex = v;
        adjL = new LinkedList[vertex];
        s = new Stack<Integer>();
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
    public void dfs(Integer i){
        visited[i] = true;
        s.push(i);
        Iterator it = adjL[i].iterator();
        while(it.hasNext()){
            Integer p = (Integer)(it.next());
            if(visited[p] == false)
                dfs(p);
        }
        
    }
    public void print(){
        while(s.empty() == false){
            System.out.print(s.pop()+" ");
        }
    }
}
