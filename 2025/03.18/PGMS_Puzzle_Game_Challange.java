import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1; // 최소 숙련도
        int right = 100_000; // 최대 숙련도
        int answer = right; // 최적의 숙련도를 저장

        while (left <= right) {
            int mid = (left + right) / 2; // 현재 탐색할 숙련도
            long sum_times = 0; // 현재 숙련도로 풀이 시 소요 시간
            long prev_time = 0; // 이전 퍼즐 소요 시간

            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= mid) {
                    // 숙련도가 퍼즐 난이도 이상이면 정상 해결
                    sum_times += times[i];
                } else {
                    // 숙련도가 부족하여 틀린 경우
                    int fail_count = diffs[i] - mid; // 틀리는 횟수
                    sum_times += (long) (times[i] + prev_time) * fail_count + times[i];
                }

                // 제한 시간을 초과하면 더 높은 level 필요
                if (sum_times > limit) {
                    left = mid + 1;
                    break;
                }

                prev_time = times[i]; // 이전 퍼즐의 시간 저장
            }

            // 현재 숙련도로 해결 가능하면 저장 후 더 낮은 숙련도로도 가능한지 확인
            if (sum_times <= limit) {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}