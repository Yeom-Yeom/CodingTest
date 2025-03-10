public class PGMS_Self_TikTakToe {
    public static void main(String[] args) {

    }

    public int solution(String[] board){
        int Ocnt = 0;
        int Xcnt = 0;

        for(int i=0; i<3; i++){
            Ocnt += countChar(board[i], 'O');
            Xcnt += countChar(board[i], 'X');
        }

        if(Xcnt > Ocnt){
            return 0;
        }
        if(Ocnt > Xcnt+1){
            return 0;
        }
        if(hasWin(board,'O')){
            if(Ocnt == Xcnt){
                return 0;
            }
        }
        if(hasWin(board,'X')){
            if(Ocnt == Xcnt+1){
                return 0;
            }
        }
        return 1;
    }
    private static int countChar(String str, char ch){
        return str.length() - str.replace(String.valueOf(ch),"").length();
    }

    private static boolean hasWin(String[] board, char ch){
        for(int i=0; i<3; i++){
            if(board[i].charAt(0) == ch
            && board[i].charAt(1) == ch
            && board[i].charAt(2) == ch){
                return true;
            }
        }

        for(int i=0; i<3; i++){
            if(board[0].charAt(i)==ch
            && board[1].charAt(i)==ch
            && board[2].charAt(i) ==ch){
                return true;
            }
        }

        if(board[0].charAt(0)==ch && board[1].charAt(1)==ch && board[2].charAt(2) == ch){
            return true;
        }
        if(board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0)==ch){
            return true;
        }
        return false;
    }
}

/**
 * 풀이 과정
 * 1. O의 개수와 X의 개수를 센다. - countChar()
 * - replace 함수를 사용하여 문자열의 길이 변화를 계산한다.
 * - 기존 문자열 길이와 replace 한 문자열 길이의 차이만큼 O 또는 X가 존재한다.
 * 2. 4가지 경우의 규칙 위반을 검사한다.
 * - X가 O보다 많을 경우
 *  - O가 선공이므로 규칙 위반이다.
 * - O가 X보다 2개 이상 많을 경우
 *  - O가 선공이므로 규칙 위반이다.
 * - O가 완성되었을 때 X가 O와 같은 경우
 *  - O가 완성되고 종료되지 않았으므로 규칙 위반
 * - X가 완성되었을 때 O가 X보다 1개 많은 경우
 *  - X가 완성되고 종료되지 않았으므로 규칙 위반
 * 3. 규칙 위반이 발생했으면 0을, 발생하지 않았으면 1을 반환.
 **/
