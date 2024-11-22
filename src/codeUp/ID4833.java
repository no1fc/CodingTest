package codeUp;

import java.util.Scanner;
import java.util.Stack;

/*
여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위 로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하 여 쇠막대기들을 자른다.
쇠막대기와 레이저의 배 치는 다음 조건을 만족한다.

- 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.

- 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완 전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.

- 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.

- 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.

아래 그림은 위 조건을 만족하는 예를 보여준다. 수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치, 수직으로 그려진 점선 화살표는 레이저의 발사 방향이다.


이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있 다.

(a) 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘ ( ) ’ 으로 표현된다. 또한, 모든 ‘ ( ) ’는 반드 시 레이저를 표현한다.

(b) 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오 른쪽 끝은 닫힌 괄호 ‘ ) ’ 로 표현된다.

위 예의 괄호 표현은 그림 위에 주어져 있다.

쇠막대기는 레이저에 의해 몇 개의 조각으로 잘려 지는데, 위 예에서 가장 위에 있는 두 개의 쇠막 대기는 각각 3개와 2개의 조각으로 잘려지고,
이 와 같은 방식으로 주어진 쇠막대기들은 총 17개 의 조각으로 잘려진다.

쇠막대기와 레이저의 배치를 나타내는 괄호 표현 이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수 를 구하는 프로그램을 작성하시오.
*/
public class ID4833 {
    //================================================================
    //강사님 풀이
    private static int test(String input){
        int result = 0;
        //Stack은 컬렉션 프레임워크이기 때문에 제네릭이 필수로 필요하다.
        //char 형식을 넣어야하지만 원시타입이기 때문에.
        //Character 로 제네릭에 등록해야한다.
        Stack<Character> stack = new Stack<Character>();
        //쇠 막대기 문제를 풀때 ) 괄호로 레이저 구분이 가능하다.
        //연산자가 함수보다 연산속도가 빠르기 때문에
        // 연산자를 사용하는 것이 좋다.

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            if(c=='('){
                //레이저인지, 막대기인지 현재는 파악이 불가능하다.
                //스택에 저장해서 확인해준다.
                stack.push(c);
            }
            else{
                stack.pop();// 레이저 짝꿍 ( 를 먼저 제거
                if(input.charAt(i-1) == '('){
                    //()레이저
                    // 현재 스택에 저장된 막대기 수 만큼 조각이 나온다.
                    result += stack.size();
                }
                else{
                    //))막대기
                    //조각 1개만 추가하면된다.
                    result++;
                }
            }
        }

        return result;
    }
    //================================================================
    public static void main(String[] args) {
//        stackArray("()(((()())(())()))(())");
//        stackArray2();
        String input = "()(((()())(())()))(())";
        int result = test(input);
        System.out.println(result);
    }

    private static void stackArray(String laser){
        int count = 0;
        Stack<String> st = new Stack<String>();

        for(int i = 0; i < laser.length(); i++){
            if(laser.charAt(i) == '('){
                st.push("(");
            }
            else{
                if(st.peek().equals("(")){
                    st.pop();
                    count += st.size();
                }
                else{
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static void stackArray2(){
        //레이저 배치를 받기 위해 배열을 생성.
        Stack<String> st = new Stack<String>();
        Stack<String> st2 = new Stack<String>();
        int count = 0;

        Scanner sc = new Scanner(System.in);

        //괄호의 개수를 받음
        int n = sc.nextInt();

        //받은 개수 만큼 괄호를 받습니다.
        for(int i = 0; i < n; i++){
            st.push(sc.nextLine());
        }

        //전체 배열로 값에서 괄호를 확인한다.
        //(괄호가 맞다면 배열에 추가한다.
        //만약 아니라면 이전 괄호를 확인한다.
        //이전 괄호가 (라면 레이저
        //이전에 추가한 (괄호 개수를 더한다.
        //아니라면 레이저가 아닌 닫는 )괄호
        //하나만 추가한다.

        for(int i = 0; i < st.size(); i++){
            if(st.get(i).equals("(")){
                st2.push("(");
            }
            else{
                if(st2.peek().equals("(")){
                    st2.pop();
                    count += st2.size();
                }
                else{
                    st.pop();
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
