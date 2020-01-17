package depthfFirst;

public class AcyclicDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Vertice[] vertices = new Vertice[numCourses];
        for(int i=0;i<numCourses;i++){
            vertices[i] = new Vertice(i,1);
        }
        //new 1,active 2,finished 3,build graph
        for(int i=0;i<prerequisites.length;i++){
            int prerequisity = prerequisites[i][1];
            int takeCourse = prerequisites[i][0];
            Vertice temp = vertices[takeCourse];
            while((temp.next)!=null){
                temp = temp.next;
            }
            temp.next = new Vertice(prerequisity,1);
        }

        for(int i=0;i<numCourses;i++){
            if(vertices[i].status==1){
                if(isAcyclicDFS(vertices[i],vertices)==false)
                    return false;
            }
        }
        return true;
    }

    boolean isAcyclicDFS(Vertice vertice,Vertice[] vertices){
        vertices[vertice.value].status=2;
        for(Vertice temp = vertice.next;temp!=null;temp=temp.next){
            if(vertices[temp.value].status==2)
                return false;
            else if(vertices[temp.value].status==1){
                if(isAcyclicDFS(vertices[temp.value],vertices)==false)
                    return false;
            }
        }
        vertices[vertice.value].status = 3;
        return true;
    }

    class Vertice{
        int value;

        int status;

        Vertice next;

        Vertice(int value,int status){
            this.value = value;
            this.status = status;
        }
    }
}
