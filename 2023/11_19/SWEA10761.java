import java.util.*;
import java.io.*;
public class SWEA10761 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Queue<current> qu = new LinkedList<>();
            Queue<current> bq = new LinkedList<>();
            Queue<current> oq = new LinkedList<>();

            for(int i = 0; i<n; i++){
                String color =st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(color.equals("B")){
                    bq.offer(new current(color,num));
                }else{
                    oq.offer(new current(color,num));
                }
                qu.offer(new current(color,num));
            }
            int blue = 1;
            int orange = 1;
            int time = 0;
            boolean click;
            while(!qu.isEmpty()){
                time++;
                click = false;
                if(!bq.isEmpty()){
                    if(bq.peek().place > blue){
                        blue++;
                    }else if(bq.peek().place < blue){
                        blue--;
                    }else{
                        if(qu.peek().color.equals("B")){
                            click=true;
                            bq.poll();
                        }
                    }
                }
                if(!oq.isEmpty()){
                    if(oq.peek().place > orange) {
                        orange++;
                    }else if(oq.peek().place < orange) {
                        orange--;
                    }else {
                        if(qu.peek().color.equals("O")) {
                            click = true;
                            oq.poll();
                        }
                    }
                }
                if(click){
                    qu.poll();
                }
            }
            System.out.println("#"+tc+" " +time);
        }
    }
    static class current{
        String color;
        int place;
        public current(String color, int place){
            this.color = color;
            this.place = place;
        }
    }
}
