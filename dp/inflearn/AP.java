package dp.inflearn;

import java.util.*;

public class AP {
    public static int solution(int n, int[] nums) {
        int answer = 0; // 등차수열의 최대 길이
        if(n == 1) { // 길이 1인 수열인 경우
            return 1; // 당연히 최대 길이는 1이므로 리턴
        }
        int dy[][] = new int[n + 1][n + 1]; // dy[i][j] : i번째와 j번째(i < j)가 마지막 두 항인 등차수열의 최대 길이
        Arrays.sort(nums); // nums 배열 오름차순 정렬 (등차 양수만 고려할 수 있음)
        for(int i = 1; i < n; i++) { // i는 1부터 n - 1까지
            for(int j = i + 1; j <= n; j++) { // j는 i+1부터 n까지
                dy[i][j] = 2; // 기본적으로 i번째 j번째 두개는 항상 있기 때문에 2로 초기화

                int pre = 2 * nums[i] - nums[j]; // i번째 항의 앞의 항 찾기
                // ㄴ (i번째 항에서 공차를 빼주면 되는데 nums[i] - (nums[j] - nums[i]) 식을 정리하면 다음과 같이 나옴)

                // O(n) 시간 복잡도 선형 탐색
                int k = 0; // 앞의 항이 몇번째인지 나타내는 인덱스 번호
                for(k = i - 1; k >= 1; k--) { // i-1부터 1번째까지 반복
                    if(nums[k] == pre) { // k번째 nums 숫자가 구했던 앞의 항 값인 경우
                        break; // 해당 k값인 상태로 break
                    }
                } // 만약 k를 찾지 못하면 k가 0으로 유지되는데 dy[k][i]는 dy[0][i]로 0임

                // i번째와 j번째 두개로 이루어진 길이 2와 k번째와 i번째가 마지막 두항이라 여기고 구한 길이에 j번째도 포함하여 +1된 길이 중 최대값을 dy에 저장
                dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1);


                /* 이분 탐색 사용으로 O(log n)으로 찾기
                int left = 1; // nums의 1번째 숫자부터 찾기 위해 인덱스 1
                int right = i - 1; // nums의 i-1번째 숫자까지 찾기 위해 인덱스 i - 1
                int mid = 0;
                while(left < right) {
                    mid = (left + right) / 2;
                    if(nums[mid] < pre) {
                        left = mid + 1;
                    } else if(nums[mid] == pre && nums[right] == pre) {
                        left = mid + 1;
                    } else {
                        right = mid; // 앞의 항이 right번째가 되는 것
                    }
                }
                if(nums[right] == pre) { // 이분탐색으로 앞의 항 찾은 경우
                    dy[i][j] = Math.max(dy[i][j], dy[right][i] + 1); // 값 갱신하기
                }*/

                answer = Math.max(answer, dy[i][j]); // 최대 길이를 구하기 위해 매번 값 비교해서 업데이트
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수의 개수
        int nums[] = new int[n + 1]; // 1번 인덱스부터 수 입력 받을 배열. 0번은 0
        for(int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(AP.solution(n, nums));
    }
}
