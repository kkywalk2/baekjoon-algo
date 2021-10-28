package baekjoon;
import java.util.Scanner;

public class Problem1629 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextInt();
        long exp = sc.nextInt();
        long mod = sc.nextInt();
        sc.close();

        System.out.println(caculateModuler(number, exp, mod));
    }

    public static long caculateModuler(long number, long exp, long mod) {
        if(exp == 1) {
            return number % mod;
        }

        long temp = caculateModuler(number, exp / 2, mod);

        // 모듈어의 성질을 알아야 한다.. (a*b) % c = (a%c*b%c)%c
        if(exp % 2 == 0) {
            return temp * temp % mod;
        }else {
            return (temp * temp  % mod) * number % mod;
        }
    }
}
