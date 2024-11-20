package codeUp;
/*
문제 4) 탑 (초등 4)

KOI 통신연구소는 레이저를 이용한 새로운 비밀 통신 시스템 개발을 위한 실험을 하고 있다.
실험을 위하여 일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고,
각 탑의 꼭대기에 레이저 송신기를 설치하였다. 모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평행하게
수평 직선의 왼쪽 방향으로 발사하고, 탑의 기둥 모두에는 레이저 신호를 수신하는 장치가 설치되어 있다.
하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다.

예를 들어 높이가 6, 9, 5, 7, 4인 다섯 개의 탑이 수평 직선에 일렬로 서 있고,
모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자.
그러면, 높이가 4인 다섯 번째 탑에서 발사한 레이저 신호는 높이가 7인 네 번째 탑이 수신을 하고,
높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인
두 번째 탑이 수신을 한다. 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는
어떤 탑에서도 수신을 하지 못한다.

탑들의 개수 N과 탑들의 높이가 주어질 때, 각 각의 탑에서 발사한 레이저 신호를 어느 탑에서
수신하는지를 알아내는 프로그램을 작성하라.
 */

import java.util.Scanner;
import java.util.Stack;

public class ID4654 {

    //====================================================================================================
    //강사님 풀이

    //N 제곱에서 -> N
    // 일반 for까지 시간복잡도를 줄일 수 있다.

    //개발자 코딩은 이중for문 작성 ㄱㅊ

    private static void test(){
        int N=5;
        int[] array = {6,9,5,7,4};
        int[] result = arrayList(N,array);
        for(int i : result){}
    }

    private static int[] arrayList(int n, int[] tower) {
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<int[]>();
        // {탑의 높이, 탑의 위치} 를 저장 하기 위해 == DTO, 배열을 저장한다.

        for(int i = 0; i < n; i++){// 시간복잡도 O(n) == 이미 반복문 1개는 반드시 사용해야한다.
            // 1) 현재비교대상이 되는 탑보다 높은 탑이 스택에 있나? <- (나보다 높은 탑이 있나?)
            while(!stack.isEmpty() && stack.peek()[0] < tower[i]){
                //스택에 저장된 데이터가 있을때
                //저장된 높이가 현재 나보다 작으면
                //스택에서 제거
                stack.pop();
            }
            // 2) 신호를 받을 탑이 없다면 0을 저장 <- (result로 0 저장)
            //      탑이 있으면 위치정보 저장
            if(stack.isEmpty()){
                result[i] = 0;
            }
            else{
                result[i] = stack.peek()[1] + 1;
            }
            // 3) 현재비교대상이었던 탑은 다음 비교대상이됨
            //      ==> 스택에 저장해야함
            stack.push(new int[]{tower[i], i});
        }

        return result;
    }

    //====================================================================================================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //출력할 배열을 생성
        int[] result = new int[n];
        // 입력받을 배열을 생성
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        //입력 받은 개수 -1
        for (int i = n - 1; i >= 0; i--) {
            //각 값을 비교하기 위해 i - 1
            for (int j = i - 1; j >= 0; j--) {
                //배열 값이 크다면
                if (array[j] > array[i]) {
                    //해당 배열에 개수를 추가하여 저장
                    result[i] = j + 1; // 1-based 인덱스 저장
                    break;
                }
            }
            if (result[i] == 0) {
                result[i] = 0; // 수신하는 탑이 없는 경우 0 저장
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
