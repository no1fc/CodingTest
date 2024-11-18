package codeUp;


/*
농부 존의 N마리의 소들이 있다.

소들은 헤어스타일에 예민하기 때문에, 다른 소들의 헤어 스타일을 보고 싶어한다.

i번째 소들의 키가 hi이고, 모든 소들은 일렬로 서 있고 오른쪽으로만 볼 수 있다.

i번째 소가 볼 수 있는 다른 소의 헤어 스타일은 i+1, i+2, .... 이다.

그런데 자기 보다 키가 같거나 큰 소가 있으면 그 다음에 있는 모든 소들의 헤어스타일은 보지 못한다.

예) N=6, H = { 10, 3, 7, 4, 12, 2 }인 경우

          =
 =        =
 =   -    =
 =   =    =        -> 소가 보는 방향
 = - = =  =
 = = = =  = =
10 3 7 4 12 2
1번소는 2, 3, 4소의 머리스타일을 확인할 수 있다.

2번소는 다른 소들의 머리스타일을 확인할 수 없다.

3번소는 4번소의 머리스타일을 확인할 수 있다.

4번소는 다른 소의 머리스타일을 확인할 수 없다.

5번소는 6번소의 머리스타일을 확인할 수 있다.

6번소는 마지막이므로 다른 소의 머리스타일을 확인할 수 없다.
10
999999999
2
999999999
2
999999999
2
999999999
2
999999999
2
따라서, 머리스타일을 확인할 수 있는 총 수는 3 + 0 + 1 + 0 + 1 + 0 = 5이다.
 */
import java.util.Scanner;
public class ID3130 {
    public static void main(String[] args) {
        //출력 변수를 생성
        //첫 문제 제출하니 1024(int)바이트 이상 결과가 있어 long으로 수정
        long result = 0;
        //값을 등록할 배열을 생성
        int[] array = {};

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 0 보다 크고 80000보다 작을때 실행
        if(0 < n && n <= 80000){
            array = new int[n];
            //입력 값 만큼 데이터를 받기
            for (int i=0; i<array.length; i++) {
                array[i] = scanner.nextInt();
            }
            scanner.close();
            //마지막 값은 무조건 볼 수 없기 때문에 -1
            for (int i = 0; i < array.length-1; i++) {
                //이중 for 문으로 값을 확인
                for (int j = i+1; j < array.length; j++) {
                    if(array[i] <= array[j]){
                        break;
                    }
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
