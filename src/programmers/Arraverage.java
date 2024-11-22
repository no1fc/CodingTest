package programmers;

/*
정수 배열 numbers가 매개변수로 주어집니다.
numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요.

배열의 값을 모두 더한 다음
배열의 개수 만큼 나눠준다.

numbers	                                        result
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]	                5.5
[89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]	94.0
 */
import java.util.Arrays;
public class Arraverage {
    private static double solution(int[] numbers) {
        double answer = 0;
        double arrsum = Arrays.stream(numbers).sum();
        int arrlength = numbers.length;
        return answer = arrsum / arrlength;
    }

    public static void main(String[] args) {
        double result = Arraverage.solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(result);
    }

}
