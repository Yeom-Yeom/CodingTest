import java.util.*;
import java.io.*;
public class BOJ28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> d = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String command = br.readLine();
            if(command.length() > 2){
                String[] split = command.split(" ");
                switch(split[0]){
                    case "1" :
                        d.addFirst(Integer.parseInt(split[1]));
                        break;
                    case "2":
                        d.addLast(Integer.parseInt(split[1]));
                        break;
                }
            }else{
                switch (command){
                    case "3":
                        if(d.isEmpty()) bw.write("-1\n");
                        else bw.write(d.pollFirst() + "\n");
                        break;
                    case "4":
                        if(d.isEmpty()) bw.write("-1\n");
                        else bw.write(d.pollLast()+"\n");
                        break;
                    case "5":
                        bw.write(d.size()+"\n");
                        break;
                    case "6":
                        if(d.isEmpty()) bw.write("1\n");
                        else bw.write("0\n");
                        break;
                    case "7":
                        if(d.isEmpty()) bw.write("-1\n");
                        else bw.write(d.getFirst()+"\n");
                        break;
                    case "8":
                        if(d.isEmpty()) bw.write("-1\n");
                        else bw.write(d.getLast()+"\n");
                        break;
                }
            }
        }
        bw.flush();
    }
}
