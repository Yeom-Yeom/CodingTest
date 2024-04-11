package Prepare_Samsung;

import java.util.*;
public class CodeTree_RabbitAndRace {
    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // 구조체 Rabbit을 정리해 관리
    static class Rabbit implements Comparable<Rabbit>{
        int x, y,cnt,id;
        public Rabbit(int x, int y, int cnt, int id){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.id = id;
        }

        // 이동할 토끼를 결정하기 위해 정렬함수를 만들어준다.
        public int compareTo(Rabbit rb){
            if(this.cnt != rb.cnt) // 현재까지 총 점프 횟수가 적은 토끼
                return this.cnt-rb.cnt;
            if(this.x+this.y != rb.x+rb.y) // 현재 서있는 행 + 열 번호가 작은 토끼
                return (this.x+this.y) - (rb.x+rb.y);
            if(this.x!=rb.x) // 행 번호가 작은 토끼
                return this.x-rb.x;
            if(this.y!=rb.y) // 열 번호가 작은 토끼
                return this.y-rb.y;
            return this.id-rb.id; // 고유번호가 작은 토끼
        }
    }

    public static final int MAX_N = 2000;
    public static int n,m,p;

    // 각 토끼의 id를 기록
    public static int[] id = new int[MAX_N+1];

    // 각 토끼의 이동거리를 기록
    public static int[] dist = new int[MAX_N+1];

    // 각 토끼의 점프 횟수를 기록
    public static int[] jumpCnt = new int[MAX_N+1];

    // 각 토끼의 점수를 기록
    public static long[] res = new long[MAX_N+1];

    // 각 토끼의 현재 위치를 기록
    public static Pair[] point = new Pair[MAX_N+1];

    // 각 토끼의 id를 인덱스 번호로 변환해준다.
    public static HashMap<Integer, Integer> idToIdx = new HashMap<>();

    // 각각의 경주에서 토끼가 달렸는지 여부를 기록해준다.
    public static boolean[] isRunned = new boolean[MAX_N+1];

    // 하나를 제외한 모든 토끼의 점수를 더하는 쿼리를 편하게 하기 위해
    // totalSum이라는 변수를 추가
    public static long totalSum;

    // 가장 긴 위치를 판단하기 위해 정렬함수를 하나 더 만들어준다
    public static boolean cmp(Rabbit a, Rabbit b){
        if(a.x+a.y != b.x+b.y) return a.x+a.y<b.x+b.y;
        if(a.x != b.x) return a.x<b.x;
        if(a.y != b.y) return a.y<b.y;
        return a.id < b.id;
    }

    // 경주 시작 준비 쿼리를 처리
    public static void init(Scanner sc){
        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();
        for(int i=1; i<=p; i++){
            id[i] = sc.nextInt();
            dist[i] = sc.nextInt();
            idToIdx.put(id[i], i);
            point[i] = new Pair(1,1);
        }
    }

    // 토끼를 위로 이동
    public static Rabbit getUpRabbit(Rabbit curRabbit, int dis){
        Rabbit upRabbit = curRabbit;
        dis %= 2 * (n-1);

        if(dis >= upRabbit.x-1){
            dis -= (upRabbit.x-1);
            upRabbit.x = 1;
        }else{
            upRabbit.x -= dis;
            dis = 0;
        }

        if(dis>=n-upRabbit.x){
            dis-=(n-upRabbit.x);
            upRabbit.x = n;
        }else{
            upRabbit.x += dis;
            dis = 0;
        }
        upRabbit.x -= dis;
        return upRabbit;
    }

    // 토끼를 아래로 이동
    public static Rabbit getDownRabbit(Rabbit curRabbit, int dis){
        Rabbit downRabbit = curRabbit;
        dis %= 2*(n-1);

        if(dis>= n-downRabbit.x){
            dis -= (n-downRabbit.x);
            downRabbit.x = n;
        }
        else{
            downRabbit.x += dis;
            dis = 0;
        }

        if(dis>=downRabbit.x-1){
            dis -= (downRabbit.x-1);
            downRabbit.x = 1;
        }
        else{
            downRabbit.x -= dis;
            dis = 0;
        }
        downRabbit.x += dis;
        return downRabbit;
    }

    // 토끼를 왼쪽으로 이동
    public static Rabbit getLeftRabbit(Rabbit curRabbit, int dis){
        Rabbit leftRabbit = curRabbit;
        dis %= 2*(m-1);

        if(dis >= leftRabbit.y-1){
            dis -= (leftRabbit.y-1);
            leftRabbit.y = 1;
        }
        else{
            leftRabbit.y -= dis;
            dis = 0;
        }

        if(dis>=m-leftRabbit.y){
            dis-=(m-leftRabbit.y);
            leftRabbit.y = m;
        }
        else{
            leftRabbit.y += dis;
            dis = 0;
        }
        leftRabbit.y -= dis;

        return leftRabbit;
    }

    // 토끼를 오른쪽으로 이동
    public static Rabbit getRightRabbit(Rabbit curRabbit, int dis){
        Rabbit rightRabbit = curRabbit;
        dis %= 2*(m-1);

        if(dis>= m-rightRabbit.y){
            dis -= (m- rightRabbit.y);
            rightRabbit.y = m;
        }
        else{
            rightRabbit.y += dis;
            dis=0;
        }

        if(dis >= rightRabbit.y -1){
            dis -= (rightRabbit.y-1);
            rightRabbit.y = 1;
        }else{
            rightRabbit.y -= dis;
            dis = 0;
        }

        rightRabbit.y += dis;
        return rightRabbit;
    }

    // 경주를 진행
    public static void startRound(Scanner sc){
        int k = sc.nextInt();
        int bonus = sc.nextInt();
        PriorityQueue<Rabbit> rabbitPq = new PriorityQueue<>();

        for(int i=1; i<=p; i++){
            isRunned[i] = false;
        }

        // 우선 p마리의 토끼들을 전부 priority queue에 넣어준다.
        for(int i=1; i<=p; i++){
            Rabbit newRabbit = new Rabbit(point[i].x, point[i].y, jumpCnt[i], id[i]);
            rabbitPq.add(newRabbit);
        }

        // 경주를 k회 진행
        while(k-->0){
            // 우선순위가 가장 높은 토끼를 priority queue에서 뽑아온다.
            Rabbit curRabbit = rabbitPq.poll();

            // 해당 토끼를 상,하,좌,우 4개의 방향으로 이동시킨다.
            // 각각의 방향으로 이동시킨 후 최종 위치를 구하고
            // 가장 시작점으로부터 멀리 있는 위치를 찾아준다.
            int dis = dist[idToIdx.get(curRabbit.id)];
            Rabbit nextRabbit = new Rabbit(curRabbit.x, curRabbit.y, curRabbit.cnt, curRabbit.id);
            nextRabbit.x = 0;
            nextRabbit.y = 0;

            // 토끼를 위로 이동
            Rabbit upRabbit = getUpRabbit(new Rabbit(curRabbit.x, curRabbit.y, curRabbit.cnt, curRabbit.id),dis);
            // 지금까지의 도착지들보다 더 멀리 갈 수 있다면 도착지를 갱신
            if(cmp(nextRabbit, upRabbit)) nextRabbit = upRabbit;

            // 토끼를 아래로 이동
            Rabbit downRabbit = getDownRabbit(new Rabbit(curRabbit.x, curRabbit.y, curRabbit.cnt, curRabbit.id),dis);
            // 지금까지 도착지들보다 더 멀리 갈 수 있다면 도착지를 갱신
            if(cmp(nextRabbit, downRabbit)) nextRabbit = downRabbit;

            // 토끼를 왼쪽으로 이동
            Rabbit leftRabbit = getLeftRabbit(new Rabbit(curRabbit.x, curRabbit.y, curRabbit.cnt, curRabbit.id),dis);
            // 지금까지의 도착지들보다 더 멀리 갈 수 있다면 도착지를 갱신
            if(cmp(nextRabbit, leftRabbit)) nextRabbit = leftRabbit;

            // 토끼를 오른쪽으로 이동
            Rabbit rightRabbit = getRightRabbit(new Rabbit(curRabbit.x, curRabbit.y, curRabbit.cnt, curRabbit.id), dis);
            // 지금까지의 도착지들보다 더 멀리갈 수 있다면 도착지를 갱신
            if(cmp(nextRabbit,rightRabbit)) nextRabbit = rightRabbit;

            // 토끼의 점프 횟수를 갱신해주고, priority queue 에 다시 집어넣는다.
            nextRabbit.cnt++;
            rabbitPq.add(nextRabbit);

            // 실제 point, jumCnt 배열에도 값을 갱신해준다.
            int nextIdx = idToIdx.get(nextRabbit.id);
            point[nextIdx] = new Pair(nextRabbit.x, nextRabbit.y);
            jumpCnt[nextIdx]++;

            // 토끼가 달렸는지 여부를 체크해준다.
            isRunned[nextIdx] = true;

            // 토끼가 받는 점수는 (현재 뛴 토끼)만 (r+c)만큼 점수를 빼주고,
            // 모든 토끼(totalSum)에게 (r+c)만큼 점수를 더해준다.
            // 최종적으로 i번 토끼가 받는 점수는 res[i] + totalSum이 된다.
            res[nextIdx] -= (nextRabbit.x+nextRabbit.y);
            totalSum += (nextRabbit.x + nextRabbit.y);
        }

        // 보너스 점수를 받을 토끼를 찾는다.
        // 이번 경주때 달린 토끼 중 가장 멀리있는 토끼를 찾는다.
        Rabbit bonusRabbit = new Rabbit(0,0,0,0);
        while(!rabbitPq.isEmpty()){
            Rabbit curRabbit = rabbitPq.poll();

            // 달리지 않은 토끼는 스킵
            if(!isRunned[idToIdx.get(curRabbit.id)]) continue;

            if(cmp(bonusRabbit, curRabbit))
                bonusRabbit = curRabbit;
        }

        // 해당 토끼에게 bonus만큼 점수를 추가해준다.
        res[idToIdx.get(bonusRabbit.id)] += bonus;
    }

    // 이동거리를 변경
    public static void powerUp(Scanner sc){
        int id = sc.nextInt();
        int t = sc.nextInt();

        int idx = idToIdx.get(id);

        dist[idx] *= t;
    }

    // 최고의 토끼를 선정
    public static void printRes(){
        long ans = 0;
        for(int i=1; i<=p; i++){
            ans = Math.max(ans, res[i]+totalSum);
        }
        System.out.print(ans);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-->0){
            int query = sc.nextInt();
            if(query == 100){
                init(sc);
            }
            if(query == 200){
                startRound(sc);
            }
            if(query == 300){
                powerUp(sc);
            }
            if(query==400){
                printRes();
            }
        }
    }
}
