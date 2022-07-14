package testFiles;

public class ReverserNumber {
    public static void main(String[] args) {
        int num = 250, revNum = 0;

        while(num>0){
            int temp = num%10;
            revNum = (revNum * 10) + temp;
            num = num/10;
        }

        System.out.println("Rev Num is :" +revNum);
    }
}
