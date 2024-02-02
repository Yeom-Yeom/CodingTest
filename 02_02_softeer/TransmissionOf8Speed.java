import java.util.*;
public class TransmissionOf8Speed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for(int i=0; i<8; i++){
            arr[i] = sc.nextInt();
        }
        boolean ascendingCheck = false, descendingCheck = false;
        for(int i=0; i<8; i++){
            if(arr[i] == i+1){
                ascendingCheck = true;
            }
            else{
                ascendingCheck = false;
                break;
            }
        }
        for(int i=0; i<8; i++){
            if(arr[i] == 8-i){
                descendingCheck = true;
            }else{
                descendingCheck = false;
                break;
            }
        }
        if(ascendingCheck) System.out.println("ascending");
        else if(descendingCheck) System.out.println("descending");
        else System.out.println("mixed");
    }
}

/**
 * 문제 해석
 * 1~8의 값을 넣을 배열을 하나 만든다. 크기는 8
 * 이 배열의 원소들을 비교하여 ascending 인지 descending 인지를 판별한다.
 * 둘 다 아니라면 mixed 가 된다.
 **/
