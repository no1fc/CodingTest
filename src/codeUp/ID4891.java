package codeUp;

/*

코이 초등학교에 새로 부임하신 교장선생님은 어린 학생들의 행복감과 학생들의 성적 차이 관계를 알아보기로 했다.

그래서 이전 성적을 조사하여 학생들의 시험 점수 차이 변화를 알아보려고 한다.

예를 들어서
2016년 학생 8명의 점수가 다음과 같다고 하자.

27,35,92,75,42,53,29,87

그러면 가장 높은 점수는
92점이고 가장 낮은 점수는
27점이므로 점수의 최대 차이는 65이다.

한편 2017년 학생 8명의 점수가 다음과 같았다.

85,42,79,95,37,11,72,32

이때 가장 높은 점수는
95점이고 가장 낮은 점수는
11점이므로 점수의 최대 차이는 84이다.
N명 학생들의 점수가 주어졌을 때, 가장 높은 점수와 가장 낮은 점수의 차이를 구하는 프로그램을 작성하시오.

 */

import java.util.Arrays;
import java.util.Scanner;

public class ID4891 {

    //강사님 풀이
    public void total() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] score = new int[n];
        for(int i = 0; i < n; i++){
            score[i] = scanner.nextInt();
        }
        int max = Arrays.stream(score).max().getAsInt();
        int min = Arrays.stream(score).min().getAsInt();
        System.out.println(max - min);
    }

    public static void main(String[] args) {
        //score 배열을 생성
        int[] score = {};
        //최대값 변수 생성
        int max = 0;
        //최소값 변수 생성
        int min = 0;

        //값을 입력 받기 위해
        Scanner scanner = new Scanner(System.in);
        System.out.println("학생 인원을 입력해주세요");
        int n = scanner.nextInt();
        //입력받은 값이 2이상 1000 이하 이면 실행
        if(2 <= n && n <= 1000){
            System.out.println(n+"명의 학생 점수를 입력해주세요");
            score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = scanner.nextInt();
            }
            //Scanner 종료
            scanner.close();
            //첫 기준 값을 추가
            max = score[0];
            min = score[0];
            //score 만큼 for문을 돌려줍니다.
            for (int i = 1; i < score.length; i++) {
                //배열값이 max 값보다 크다면
                if (score[i] > max) {
                    //max 값 변경
                    max = score[i];
                    System.out.println("max["+max+"]");
                }
                //배열값이 min 값보다 작다면
                if (score[i] < min) {
                    //min 값을 변경합니다.
                    min = score[i];
                    System.out.println("min["+min+"]");
                }
            }
            System.out.println(max - min);
        }
        else{
            System.out.println("잘못된 값이 입력되었습니다. 입력값["+n+"]");
        }

    }
}
