import java.util.*;
class Solution {
    HashMap<String, String> hm = new HashMap<>();
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int time = 0;
        hm.put("C#","c");
        hm.put("D#","d");
        hm.put("F#","f");
        hm.put("G#","g");
        hm.put("A#","a");
        hm.put("B#","b");

        for(String s : musicinfos){
            String[] arr = s.split(",");
            String[] st = arr[0].split(":");
            String[] ed = arr[1].split(":");
            int minute = (Integer.parseInt(ed[0])-Integer.parseInt(st[0]))*60 + (Integer.parseInt(ed[1])-Integer.parseInt(st[1]));
            String melody = converting(arr[3]);
            String neo = converting(m);
            String record = "";

            for(int i=0; i<minute; i++){
                record += melody.charAt(i%melody.length());
                if(record.contains(neo)){
                    if(minute > time){
                        answer = arr[2];
                        time = minute;
                    }
                }
            }

        }
        if(answer.isEmpty())
            answer = "(None)";
        return answer;
    }

    String converting(String s){
        String str = "";
        for(int i=0; i<s.length(); i++){
            if(i<s.length()-1 && s.charAt(i+1) == '#'){
                str += hm.get(s.substring(i,i+2));
                i++;
            }
            else
                str += s.charAt(i);
        }
        return str;
    }
}