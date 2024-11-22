package programmers;

import java.util.Scanner;

/*
머쓱이는 친구들과 369게임을 하고 있습니다.
369게임은 1부터 숫자를 하나씩 대며 3, 6, 9가 들어가는 숫자는
숫자 대신 3, 6, 9의 개수만큼 박수를 치는 게임입니다. 머쓱이가 말해야하는 숫자 order가 매개변수로 주어질 때,
머쓱이가 쳐야할 박수 횟수를 return 하도록 solution 함수를 완성해보세요.

입출력 예시
order	result
3	    1
29423	2
 */
public class Game369 {
    private static int solution(int order) {
        int answer = 0;
        //문제 내에 들어오는 값이 정수로 들어오니
        //비교하기 위해 문자열로 값을 변환한다.
        String str = order+"";
        //변환된 값의 길이 만큼 반복하고
        for (int i = 0; i < str.length(); i++) {
            //반복된 값에서 3,6,9 를 찾아 맞으면 count 틀리면 넘어간다.
            answer = str.charAt(i) == '3'? answer+1 : str.charAt(i) == '6'? answer+1 : str.charAt(i) == '9'? answer+1 : answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = Game369.solution(scanner.nextInt());
        System.out.println(result);
    }
}
