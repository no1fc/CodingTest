package programmers;

public class NumCount {
    public static int solution1(int[] array, int n) {
        int answer = 0;
        for(int i=0; i<array.length; i++){
            if(array[i]==n){
                answer++;
            }

        }
        return answer;
    }
    public static int solution(int[] array, int n) {
        int answer = 0;
        for(int i : array){
            answer += (i==n) ? 1 : 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(NumCount.solution(new int[] {1, 1, 2, 3, 4, 5}, 1));
    }
}
