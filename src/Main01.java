public class Main01 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            //n 의 값중 x로 나눈 나머지가 1이 되면
            for (int i = 1; i <= n; i++) {
                if(n%i==1) {
                    answer = i;
                    break;
                }
            }

            //자연수 x를 반환하는 코드를 작성합니다.
            return answer;
        }
    }
    public static void main(String[] args) {
        Main01 m = new Main01();
        Main01.Solution s = m.new Solution();
        int result = s.solution(12);
        System.out.println(result);
    }
}
