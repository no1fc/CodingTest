package codeUp;

/*
당신의 상관은 당신이 작년에 회사의 실적에 얼마나 도움이 되었는지 횟수를 세었다.
불행히도 당신의 상관은 때때로 횟수를 틀리게 읽는다.

다행히도 당신의 상관은 잘못된 숫자를 읽은 것을 인식하면 ‘zero’라고 말한다.
이는 ‘직전의 숫자는 무시한다’는 것을 의미한다.

불행히고 당신의 상관은 실수를 반복할 수 있고, 매 실수 마다 ‘zero’라고 말한다.

예를 들면 당신의 상관이
‘One, three, five, four, zero, zero, seven, zero, zero, six’ 라고 말한 것은
7을 의미하는 것인데 다음의 표를 보면 알 수 있다.
*/

import java.util.Scanner;
import java.util.Stack;

public class ID3117 {

    //강사님 풀이
    private void arrays(){
        //N 크기 만큼의 스택 공간 형성
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        //※ ctrl C,V =>> 반복문
        //※ while VS for
        for(int i = 0; i < N; i++){
            int data = sc.nextInt();
            if(data != 0){
                stack.push(data);
            }
            else {
                stack.pop();
            }
        }
        //N 개의 데이터를 입력받는다.
        // 0이 아니라면 그냥 스택에 저장
        // 0이면 데이터 제거

        int total = 0;
        // 마지막에 스택에 남아 있는 모든데이터 총합
        for (int v: stack){
            total+=v;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {

        //배열 생성
        int result[] = {};
        //현재 배열 count 변수 생성
        int count = 0;
        //총합 변수 생성
        int total = 0;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        result = new int[n];
        for (int i : result) {
            n = scanner.nextInt();
            //만약 0이 아니면 count+1 0이면 count-1
            result[(n == 0) ? --count:count++] = n;
        }
        scanner.close();

        // 총합을 구함
        for(int a : result){
            total += a;
        }
        //총합 출력
        System.out.println(total);
    }
}
