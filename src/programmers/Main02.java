package programmers;

public class Main02 {
    class Solution {
        public double solution(int[] arr) {
            double answer = 0;
            //정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
            int arrLength = arr.length;
            for (int i = 0; i < arrLength; i++) {
                answer += arr[i];
            }
            answer /= arrLength;
            return answer;
        }
    }

    public static void main(String[] args) {
        Main02 m = new Main02();
        Main02.Solution s = m.new Solution();
        System.out.println(s.solution(new int[] {1,2,3,4}));
    }

}
