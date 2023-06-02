import java.util.ArrayList;
import java.util.Scanner;

public class Back {
    static Menu[] menuArr = new Menu[4];
    static Menu[] orderArr = new Menu[2];
    static Product[] burgerArr = new Product[5];
    static Product[] frozenArr = new Product[5];
    static Product[] drinkArr = new Product[5];
    static Product[] beerArr = new Product[2];
    static Cart cart = new Cart();

    static int waiting = 1;


    public static void allMenu() {
        // 메인 메뉴판
        menuArr[0] = new Menu("Burgers         ", "앵거스 비프 통살을 다져만든 버거");
        menuArr[1] = new Menu("Forzen Custard  ", "매장에서 신선하게 만드는 아이스크림");
        menuArr[2] = new Menu("Drinks          ", "매장에서 직접 만드는 음료");
        menuArr[3] = new Menu("Beer            ", "뉴욕 브루클린 브루어리에서 양조한 맥주");

        orderArr[0] = new Menu("Order       ", "장바구니를 확인 후 주문합니다.");
        orderArr[1] = new Menu("Cancel      ", "진행중인 주문을 취소합니다.");

        //burger
        burgerArr[0] = new Product("ShackBurger           ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgerArr[1] = new Product("SmokeShack            ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burgerArr[2] = new Product("Shroom Burger         ", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
        burgerArr[3] = new Product("Cheeseburger          ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgerArr[4] = new Product("Hamburger             ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        //custard
        frozenArr[0] = new Product("Shakes                ", 5.9, "바닐라, 초콜렛, 솔티드 카라멜, 스트로베리, 커피");
        frozenArr[1] = new Product("Shake of the Week     ", 6.5, "특별한 커스터드 플레이버");
        frozenArr[2] = new Product("Red Bean Shake        ", 6.5, "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크");
        frozenArr[3] = new Product("Floats                ", 5.9, "루트 비어, 퍼플 카우, 크림시클");
        frozenArr[4] = new Product("Cups & Cones          ", 4.9, "바닐라, 초콜릿, Flavor of the Week");

        //drink
        drinkArr[0] = new Product("Drinks                ", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드");
        drinkArr[1] = new Product("Fresh Brewed Iced Tea ", 3.4, "직접 유기농 홍자를 우려낸 아이스티");
        drinkArr[2] = new Product("Fifty/Fifty           ", 3.5, "레몬에이드와 아이스티의 만남");
        drinkArr[3] = new Product("Fountain Soda         ", 2.7, "콜라, 사이다, 환타");
        drinkArr[4] = new Product("Abita Root Beer       ", 4.4, "미국식 무알콜 탄산음료");

        //beer
        beerArr[0] = new Product("ShackMeister Ale      ", 9.8, "뉴욕 브루클린 브루어리에서 특별히 양조한 예일 맥주");
        beerArr[1] = new Product("Magpie Brewing Co.    ", 6.8, "");
    }

    //메뉴 출력할때 쓸 예정임
//    1. 메인 메뉴판 화면
//    - 메인 메뉴판이 출력되며 메뉴판에는 상품 메뉴가 출력됩니다.
//    - 상품 메뉴는 간단한 설명과 함께 출력되며 최소 3개 이상 출력됩니다.
//    - 상품 메뉴 아래에는 Order(주문)와 Cancel(주문취소) 옵션을 출력해줍니다.
    public static void mainMenu() {
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 번호를 입력해주세요.");
        System.out.println("\n[ SHAKESHAKCK MENU ]");
        for (int i = 0; i < menuArr.length; i++)
            System.out.println((i+1) + ". " + menuArr[i].getName() + "| " + menuArr[i].getDetail());
        System.out.println("\n[ ORDER MENU ]");
        for (int i = 0; i < orderArr.length; i++)
            System.out.println((i+5) + ". " + orderArr[i].getName() + "| " + orderArr[i].getDetail());
    }

    public static int displayDetail(Product[] Arr) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" \"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
                            "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n" +
                            "\n" +
                            "[ Burgers MENU ]");
        for (int i = 0; i < Arr.length; i++)
            System.out.println((i+1) + ". " + Arr[i].getName() + "| W " + Arr[i].getPrice() + " | " + Arr[i].getDetail());
        int productNumber = sc.nextInt();
        return productNumber;
    }

    public static void productCart(int number , Product[] Arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Arr[number - 1].getName() + "| W " + Arr[number - 1].getPrice() + " | " + Arr[number - 1].getDetail());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                            "1. 확인        2. 취소");
        int yn = sc.nextInt();
        if (yn == 1){
            cart.add(Arr[number-1]);
            System.out.println("장바구니에 추가되었습니다! \n");}
    }

    public static void cartMenu() throws InterruptedException {
        ArrayList<Product> carts = cart.getPdCt();
        System.out.println("아래와 같이 주문 하시겠습니까?\n" +
                            "\n" +
                            "[ Orders ]");
        for (int i = 0; i < carts.size(); i++) {
            System.out.println(carts.get(i).getName() + "| W " + carts.get(i).getPrice() + " | " + carts.get(i).getDetail());
        }
        System.out.println("[ Total ]");
        double total = 0;
        for (int i = 0; i < carts.size(); i++)
            total += carts.get(i).getPrice();
        System.out.println("W " + total);
        System.out.println("1. 주문      2. 메뉴판 \n");

        Scanner sc = new Scanner(System.in);
        int yn = sc.nextInt();
        if (yn == 1) {
            System.out.println("주문이 완료되었습니다!\n" +
                                "\n" +
                                "대기번호는 [" + waiting++ + "] 번 입니다.\n" +
                                "(3초후 메뉴판으로 돌아갑니다.)\n");
            carts.clear();
            Thread.sleep(3000);
        }
    }

    //
    public static void innerMenu(int answer) throws InterruptedException {
        int number = 0;
        switch (answer) {
            case 1:
                number = displayDetail(burgerArr);
                productCart(number,burgerArr);
                break;
            case 2:
                number = displayDetail(frozenArr);
                productCart(number,frozenArr);
                break;
            case 3:
                number = displayDetail(drinkArr);
                productCart(number,drinkArr);
                break;
            case 4:
                number = displayDetail(beerArr);
                productCart(number,beerArr);
                break;
            case 5:
                cartMenu();
                break;
            case 6:
                ArrayList<Product> carts = cart.getPdCt();
                System.out.println("진행하던 주문을 취소하시겠습니까?\n" +
                                    "1. 확인        2. 취소");
                Scanner sc = new Scanner(System.in);
                int yn = sc.nextInt();
                if (yn == 1) {
                    carts.clear();
                    System.out.println("취소를 완료했습니다!");}
                break;
        }
    }
}