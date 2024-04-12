package Prepare_Samsung;

import java.util.*;

public class CodeTree_Bread {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isSame(Pair p) {
            return this.x == p.x && this.y == p.y;
        }
    }

    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final Pair EMPTY = new Pair(-1, -1);
    public static final int DIR_NUM = 4;
    public static final int MAX_M = 30;
    public static final int MAX_N = 15;

    public static int n, m;

    // 0이면 빈 칸, 1이면 베이스 캠프, 2라면 아무도 갈 수 없는 곳
    public static int[][] grid = new int[MAX_N][MAX_N];

    // 편의점 목록을 관리
    public static Pair[] cvsList = new Pair[MAX_M];

    // 현재 사람들의 위치를 관리
    public static Pair[] people = new Pair[MAX_M];

    // 현재 시간을 기록
    public static int currT;

    public static int[] dx = new int[]{-1, 0, 0, 1};
    public static int[] dy = new int[]{0, -1, 1, 0};

    // for bfs
    public static int[][] step = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];

    // (x,y)가 격자 내에 있는 좌표인지를 판단
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    // (x,y)로 이동이 가능한지 판단
    public static boolean canGo(int x, int y) {
        return inRange(x, y) && !visited[x][y] && grid[x][y] != 2;
    }

    // startPos를 시작으로 하는 BFS를 진행
    // 시작점으로부터의 최단 거리 결과는 step 배열에 기록
    public static void bfs(Pair startPos) {
        // visited, step 값을 전부 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
                step[i][j] = 0;
            }
        }

        // 초기 위치를 넣어준다.
        Queue<Pair> q = new LinkedList<>();
        int sx = startPos.x, sy = startPos.y;
        q.add(startPos);
        visited[sx][sy] = true;
        step[sx][sy] = 0;

        // BFS를 진행
        while (!q.isEmpty()) {
            // 가장 앞에 원소를 골라준다.
            Pair curPos = q.poll();

            // 인접한 칸을 보며 아직 방문하지 않은 칸을 큐에 넣어준다.
            int x = curPos.x, y = curPos.y;
            for (int i = 0; i < DIR_NUM; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    step[nx][ny] = step[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    // 시뮬레이션을 진행
    public static void simulate() {
        // Step 1. 격자 안에 있는 사람들에 한하여 편의점 방향을 향해 1칸 움직인다.
        for (int i = 0; i < m; i++) {
            if (people[i] == EMPTY || people[i].isSame(cvsList[i])) {
                continue;
            }

            // 원래는 현재 위치에서 편의점 위치까지의 최단 거리를 구해줘야 한다.
            // 다만 최단거리가 되기 위한 그 다음 위치를 구하기 위해서는
            // 거꾸로 편의점 위치를 시작으로 현재 위치까지 오는 최단 거리를 구해주는 것이 필요하다
            // 따라서 편의점 위치를 시작으로 하는 BFS를 진행
            bfs(cvsList[i]);

            int px = people[i].x, py = people[i].y;
            // 현재 위치에서 상좌우하 중 최단거리 값이 가장 작은 곳을 고르면
            // 그 곳으로 이동하는 것이 최단거리 대로 이동하는 것이 된다.
            // 그러한 위치 중 상좌우하 우선순위대로 가장 적절한 곳을 골라준다.
            int minDist = INT_MAX;
            int minX = -1, minY = -1;
            for (int j = 0; j < DIR_NUM; j++) {
                int nx = px + dx[j], ny = py + dy[j];
                if (inRange(nx, ny) && visited[nx][ny] && minDist > step[nx][ny]) {
                    minDist = step[nx][ny];
                    minX = nx;
                    minY = ny;
                }
            }

            // 우선순위가 가장 높은 위치로 한 칸 움직여준다.
            people[i] = new Pair(minX, minY);
        }

        // Step 2. 편의점에 도착한 사람에 한하여
        // 앞으로 이동 불가능하다는 표시로
        // grid값을 2로 바꿔준다.
        for (int i = 0; i < m; i++) {
            if (people[i].isSame(cvsList[i])) {
                int px = people[i].x, py = people[i].y;
                grid[px][py] = 2;
            }
        }

        // Step 3. 현재 시간 curT에 대해 curT <= m을 만족한다면
        // t번 사람이 베이스 캠프로 이동.

        // curT가 m보다 크다면 패스
        if (currT > m) {
            return;
        }

        // Step 3-1. 편의점으로부터 가장 가까운 베이스 캠프를 고르기 위해
        // 편의점을 시작으로 하는 BFS를 진행
        bfs(cvsList[currT - 1]);

        // Step 3-2. 편의점에서 가장 가까운 베이스 캠프를 선택
        // i,j가 증가하는 순으로 돌리기 때문에
        // 가장 가까운 베이스 캠프가 여러 가지여도
        // 알아서 (행,열) 우선순위대로 골라진다.
        int minDist = INT_MAX;
        int minX = -1, minY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문 가능한 베이스 캠프 중
                // 거리가 가장 가까운 위치를 찾아준다.
                if (visited[i][j] && grid[i][j] == 1 && minDist > step[i][j]) {
                    minDist = step[i][j];
                    minX = i;
                    minY = j;
                }
            }
        }

        // 우선순위가 가장 높은 베이스 캠프로 이동ㅎ란다.
        people[currT - 1] = new Pair(minX, minY);
        // 해당 베이스캠프는 아픙로 이동이 불가능한 칸임을 표시
        grid[minX][minY] = 2;

    }

    // 전부 편의점에 도착했는지를 확인한다
    public static boolean end() {
        // 단 한사람이라도
        // 편의점에 도착하지 못했다면
        // 아직 끝나지 않은 것
        for (int i = 0; i < m; i++) {
            if (!people[i].isSame(cvsList[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i=0 ;i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            cvsList[i] = new Pair(x-1, y-1);
        }

        // 초기 사람들은 격자 밖에 있으므로
        // 위치를 EMPTY로 놓는다.
        for(int i=0; i<m; i++){
            people[i] = EMPTY;
        }

        // 1분에 한번씩 시뮬레이션을 진행
        while(true){
            currT++;
            simulate();
            if(end()) break;
        }
        System.out.println(currT);
    }
}
