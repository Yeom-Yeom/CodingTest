import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    static LocalTime videoTime;
    static LocalTime posTime;
    static LocalTime opStartTime;
    static LocalTime opEndTime;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        String[] videoLen = video_len.split(":");
        String[] posSplit = pos.split(":");
        String[] opStart = op_start.split(":");
        String[] opEnd = op_end.split(":");
        videoTime = getTime(videoLen);
        posTime = getTime(posSplit);
        opStartTime = getTime(opStart);
        opEndTime = getTime(opEnd);

        skipOp();

        for(String command : commands){
            if(command.equals("prev")){
                moveToPrev();
            }else{
                moveToNext();
            }
            skipOp();
        }
        return posTime.format(DateTimeFormatter.ofPattern("mm:ss"));
    }

    private static void moveToNext(){
        posTime = posTime.plusSeconds(10);
        if(posTime.isAfter(videoTime)){
            posTime = videoTime;
        }
    }

    private static void moveToPrev(){
        int minute = posTime.getMinute();
        int second = posTime.getSecond();

        if (minute == 0 && second < 10){
            posTime = LocalTime.of(0,0,0);
            return;
        }
        posTime = posTime.minusSeconds(10);
    }

    private static void skipOp(){
        if(!posTime.isBefore(opStartTime) && !posTime.isAfter(opEndTime)){
            posTime = opEndTime;
        }
    }

    private static LocalTime getTime(String[] split){
        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);
        return LocalTime.of(0,min,sec);
    }

}