package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class bk_9017 {

    public static void main(String[] args) throws IOException {

        // 테스트 케이스 수 // (200)
        // 전체 인원(6 ~ 1000)
        // 팀 번호(1000)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 각 팀에 6명이 들어온 팀 구분
            Map<Integer, Integer> teamCnt = new HashMap<>();
            for (Integer i : list) {
                teamCnt.putIfAbsent(i, 0);
                teamCnt.put(i, teamCnt.get(i) + 1);
            }

            HashSet<Integer> availTeam = new HashSet<>();
            for (Map.Entry<Integer, Integer> entry : teamCnt.entrySet()) {
                if(teamCnt.getOrDefault(entry.getKey(), 0) == 6) availTeam.add(entry.getKey());
            }

            Map<Integer, List<Integer>> teamScore = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : teamCnt.entrySet()) {
                teamScore.put(entry.getKey(), new ArrayList<>());
            }

            int winningTeam = -1;
            int winScore = Integer.MAX_VALUE;
            int score = 0;

            // 완주 점수 계산
            for (int i = 0; i < list.length; i++) {
                if(availTeam.contains(list[i])) score++;
                else continue;

                List<Integer> item = teamScore.get(list[i]);
                item.add(score);
                if(item.size() == 4){
                    int sum = getSum(item);

                    if(sum < winScore) winScore = sum;
                }
            }

            // 점수비교
            for (Map.Entry<Integer, List<Integer>> entry : teamScore.entrySet()) {
                int sum = getSum(entry.getValue());
                if(winScore < sum) availTeam.remove(entry.getKey());
            }

            // 동일점수 경우
            int fiveScore = Integer.MAX_VALUE;
            for (Integer i : availTeam) {
                if(teamScore.get(i).get(4) < fiveScore) {
                    winningTeam = i;
                    fiveScore = teamScore.get(i).get(4);
                }
            }

            sb.append(winningTeam).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int getSum(List<Integer> entry) {
        int sum = entry.stream()
                .limit(4)
                .reduce(0, Integer::sum);
        return sum;
    }
}
