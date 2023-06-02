import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

    while(true) {
        //메뉴와 오더 출력
        Back.allMenu();
        Back.mainMenu();
        int answer = sc.nextInt();

        //메뉴 출력
        Back.innerMenu(answer);
    }
    }
}
