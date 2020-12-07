import java.util.Scanner;
public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite varios números até -1");
        int acc = 0;
        while(true){
            int a = scanner.nextInt();
            if(a == -1)
                break;
            acc += a;
        }
        System.out.println(acc);
        scanner.close();
    }
}
