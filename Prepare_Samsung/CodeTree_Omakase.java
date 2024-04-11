import java.util.*;
public class CodeTree_Omakase {
    public static int L,Q;
    static class Query{
        public int cmd, t, x, n;
        public String name;

        public Query(int cmd, int t, int x, String name,int n){
            this.cmd = cmd;
            this.t = t;
            this.x = x;
            this.n = n;
            this.name = name;
        }
    }

    // 명령들을 관리
    public static List<Query> queries = new ArrayList<>();

    // 등장한 사람 목록 관리
    public static Set<String> names = new HashSet<>();

    // 각 사람마다 주어진 초밥 명령만을 관리
    public static Map<String, List<Query>> p_queries = new HashMap<>();

    // 각 사람마다 입장 시간 관리
    public static Map<String, Integer> entry_time = new HashMap<>();

    // 각 손님의 위치 관리
    public static Map<String, Integer> position = new HashMap<>();

    // 각 사람마다 퇴장 시간 관리
    public static Map<String, Integer> exit_time = new HashMap<>();

    public static boolean cmp(Query q1, Query q2){
        if(q1.t != q2.t)
            return q1.t < q2.t;
        return q1.cmd < q2.cmd;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input
        L = sc.nextInt();
        Q = sc.nextInt();
        for(int i=0; i<Q; i++){
            int cmd = -1;
            int t = -1, x = -1, n = -1;
            String name = "";
            cmd = sc.nextInt();
            if(cmd == 100){
                t = sc.nextInt();
                x = sc.nextInt();
                name = sc.next();
            }
            else if(cmd == 200){
                t = sc.nextInt();
                x = sc.nextInt();
                name = sc.next();
                n = sc.nextInt();
            }
            else{
                t = sc.nextInt();
            }

            queries.add(new Query(cmd, t, x, name, n));

            // 사람별 주어진 초밥 목록 관리
            if(cmd == 100)
                p_queries.computeIfAbsent(name, k -> new ArrayList<>()).add(new Query(cmd, t, x, name, n));

            // 손님이 입장한 시간과 위치 관리
            else if(cmd == 200){
                names.add(name);
                entry_time.put(name, t);
                position.put(name,x);
            }
        }

        // 각 사람마다 자신의 이름이 적힌 조헙을 언제 먹게 되는지를 계산하여 해당 정보를 기존 Query에 추가
        for(String name : names){
            // 해당 사람의 퇴장 시간을 관리
            // 이는 마지막으로 먹는 초밥 시간 중 가장 늦은 시간이 된다.
            exit_time.put(name,0);

            for(Query q : p_queries.get(name)){
    ㅌ            // 만약 초밥이 사람이 등장하기 전에 미리 주어진 상황이라면
                int time_to_removed = 0;
                if(q.t < entry_time.get(name)){
                    // entry_time 때의 스시 위치를 구한다.
                    int t_sushi_x = (q.x + (entry_time.get(name)-q.t))%L;
                    // 몇 초가 더 지나야 만나는지를 계산
                    int additional_time = (position.get(name) - t_sushi_x+L)%L;
                    time_to_removed = entry_time.get(name)+additional_time;
                }

                // 초밥이 사람이 등장한 이후에 주어졌다면
                else{
                    // 몇 초가 더 지나야 만나는지를 계산
                    int additional_time = (position.get(name)-q.x+L)%L;
                    time_to_removed = q.t + additional_time;
                }

                // 초밥이 사라지는 시간 중 가장 늦은 시간을 업데이트.
                exit_time.put(name, Math.max(exit_time.get(name), time_to_removed));

                // 초밥이 사라지는 111번 쿼리를 추가
                queries.add(new Query(111, time_to_removed, -1, name, -1));
            }
        }

        // 사람마다 초밥을 마지막으로 먹은 시간 t를 계산하여 그 사람이 해당 t 때 코드트리 오마카세를 떠났다는 Query를 추가한다. (222번 쿼리)
        for(String name : names){
            queries.add(new Query(222, exit_time.get(name), -1, name, -1));
        }

        // 전체 쿼리를 시간순으로 정렬하되 t가 일치한다면 문제 조건상 사진 촹영에 해당하는 300이 가장 늦게 나오도록 cmd 순으로 오름차순 정렬을 함
        queries.sort((q1,q2) -> cmp(q1, q2) ? -1 : 1);

        int people_num = 0, sushi_num = 0;
        for(int i=0 ;i< queries.size(); i++){
            if(queries.get(i).cmd ==100) // add sushi
                sushi_num++;
            else if(queries.get(i).cmd == 111) // remove sushi
                sushi_num--;
            else if(queries.get(i).cmd == 200) // add people
                people_num++;
            else if(queries.get(i).cmd == 222) // remove people
                people_num--;
            else // 사진 촹여시 답을 출력
                System.out.println(people_num + " " +  + sushi_num);
        }
    }
}
