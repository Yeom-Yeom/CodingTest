import java.util.*;
import java.io.*;
public class XmarksTheSpot {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String t = st.nextToken();

            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)=='X' || s.charAt(j)=='x'){
                    sb.append(t.charAt(j));
                }
            }
        }
        System.out.println(sb.toString().toUpperCase());
    }
}

/**
 * 문제 해석
 * 주어진 입력 N개의 문자열 쌍 (S,T)가 존재한다.
 * S의 문자열에서 'x' 또는 'X'가 존재하는 위치를 P라고 한다.
 * T의 P 위치를 읽으면 된다. 단, 소문자는 대문자로 변경한다.
 * 주어진 N 만큼 반복문 수행
 * 각각에서 S의 길이만큼 반복문 수행 (각 쌍에 대해서 S,T의 길이는 동일)
 * 모든 문자를 소문자에서 대문자로 바꾸면 되므로 추후에 수행
 * S에서 x,X의 위치를 찾아 그 위치에 해당하는 T의 값을 StringBuilder에 추가
 * StringBuilder.toString().toUpperCase() 를 통해 문자열로 변경 후 대문자로 바꿔준다.
 **/