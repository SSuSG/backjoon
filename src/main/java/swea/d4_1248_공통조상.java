package swea;

import java.util.Scanner;

public class d4_1248_공통조상 {
    static int v;
    static int e;
    static Node[] nodeArray;
    static boolean isVisit[];
    static int findNum1;
    static int findNum2;
    static int size;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            v = sc.nextInt();
            e = sc.nextInt();
            findNum1 = sc.nextInt();
            findNum2 = sc.nextInt();
            nodeArray = new Node[v+1];
            isVisit = new boolean[v+1];

            for (int i = 1; i <= v ; i++) {
                nodeArray[i] = new Node(i);
            }

            //트리 생성
           for (int i = 1; i <= e; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                if(nodeArray[parent].leftChildIdx == 0)
                    nodeArray[parent].leftChildIdx = child;
                else
                    nodeArray[parent].rightChildIdx = child;
                nodeArray[child].parentIdx = parent;
            }

           int commonParent = 1;
           while(true){
                if(findNum1 != 1){
                    int parent = nodeArray[findNum1].parentIdx;
                    if(!isVisit[parent]){
                        isVisit[parent] = true;
                        findNum1 = parent;
                    }else{
                        commonParent = parent;
                        break;
                    }
                }
               if(findNum2 != 1){
                   int parent = nodeArray[findNum2].parentIdx;
                   if(!isVisit[parent]){
                       isVisit[parent] = true;
                       findNum2 = parent;
                   }else{
                       commonParent = parent;
                       break;
                   }
               }
           }
            size = 0;
           getTreeSize(nodeArray[commonParent]);

            System.out.println("#" + test_case + " " + commonParent + " " + size);
        }
    }

    public static void getTreeSize(Node node){
        size++;
        if(node.leftChildIdx != 0)
            getTreeSize(nodeArray[node.leftChildIdx]);
        if(node.rightChildIdx != 0)
            getTreeSize(nodeArray[node.rightChildIdx]);
    }

    public static class Node{
        int data;
        int parentIdx;
        int leftChildIdx;
        int rightChildIdx;

        public Node(int data) {
            this.data = data;
            this.parentIdx = 0;
            this.leftChildIdx = 0;
            this.rightChildIdx = 0;
        }
    }
}
