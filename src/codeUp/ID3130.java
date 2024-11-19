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
따라서, 머리스타일을 확인할 수 있는 총 수는 3 + 0 + 1 + 0 + 1 + 0 = 5이다.
 */
import java.util.Scanner;
public class ID3130 {
    private void ss(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] datas = new int[N];
        for(int i = 0; i < datas.length; i++){
            datas[i] = sc.nextInt();
        }
        // N마리의 소
        // N개의 배열
        // 배열에 소들의 키를 저장

        // index 0 ---->> N 헤어를 확인
        //====================================
        // 0~N 개수를 확인할 수 있고
        // 여러번 반복해야하니 for문을 사용한다.
        //====================================
        int count = 0;
        for (int i = 0; i < N ; i++){
            /*
            ================================
            datas[0]이랑 datas[1]랑 비교하고,
            datas[0]이랑 datas[2]랑 비교하고,
            datas[0]이랑 datas[3]랑 비교하고,
            datas[0]이랑 datas[4]랑 비교하고,
                    반복? 반복문이구나
            =================================

            for while 둘다 동일하다.
            만약 왜 for문을 사용했나?물어보면
            -> 0~N 범위가 있기 때문에 for문을 사용했다.

            왜 while을 사용했나?
               -> 언제 헤어스타일이 끝날지 모르기때문에 while을 사용했다.

               이런식으로 다를 수 있다.
             */
            //for문을 작성할떄
            //2중 for문을 작성한다면 -> 잘못된 코드로 본다.
            // 함수화 시켜서 작성하자.
            for(int j=i+1; j<N;j++){
                //댑스를 줄이기 위해
                if(datas[i] <= datas[j]){
                    break;
                }
                count++;
            }
            /*
            만약 while을 사용한다면 아래와 같이 사용할 수 있다.
            int j=i+1;
            //범위내에 값과 같고 j 는 N보다 작아야한다.//
            while(datas[i]>datas[j] && j<N){
                count++;
                j++;
            }

            */
        }

        // datas[0] > datas[1] 헤어 확인 가능
        // 계속확인가능
        // datas[0] <= datas[1] 헤어 확인 불가능
        // 더 이상 확인할수없음

        //확인횟수를 출력
        System.out.println(count);
    }

    public static void main(String[] args) {
        //출력 변수를 생성
        //문제 제출하니 1024(int)바이트 이상 결과가 있어 long으로 수정
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
