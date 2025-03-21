import java.util.*;
class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        String[][] map = new String[storage.length+2][storage[0].length()+2];

        for(int i=0; i<storage.length+2; i++){
            for(int j=0; j<storage[0].length()+2; j++){
                if(i==0 || j==0 || i==storage.length+1 || j==storage[0].length()+1)
                    map[i][j] = " ";
            }
        }

        for(int i=1; i<=storage.length; i++){
            for(int j=1; j<=storage[0].length(); j++){
                map[i][j] = String.valueOf(storage[i-1].charAt(j-1));
            }
        }

        for(int i=0; i<requests.length; i++){
            if(requests[i].length()==1){
                bfs(map, requests[i]);
            }else{
                for(int x=0; x<map.length; x++){
                    for(int y=0; y<map[0].length; y++){
                        if(map[x][y].equals(String.valueOf(requests[i].charAt(0)))){
                            map[x][y] = " ";
                        }
                    }
                }
            }
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(!map[i][j].equals(" ")) answer++;
            }
        }

        return answer;
    }

    void bfs(String[][] map, String target){
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        Queue<Node> q = new LinkedList<>();
        boolean[][] isAccessable = new boolean[map.length][map[0].length];
        boolean[][] outside = new boolean[map.length][map[0].length];

        q.offer(new Node(0,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            int nx = now.x;
            int ny = now.y;

            for(int i=0; i<4; i++){
                int x = nx+dx[i];
                int y = ny+dy[i];

                if(x>=0 && x<map.length && y>=0 && y<map[0].length && !outside[x][y] && map[x][y].equals(" ")){
                    outside[x][y] = true;
                    q.offer(new Node(x,y));
                }
            }
        }
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j].equals(target)){
                    int nx = i;
                    int ny = j;
                    for(int k=0; k<4; k++){
                        int x = nx+dx[k];
                        int y = ny+dy[k];
                        if(outside[x][y]){
                            isAccessable[nx][ny] = true;
                        }
                    }
                }
            }
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(isAccessable[i][j]){
                    map[i][j] = " ";
                }
            }
        }
    }
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}