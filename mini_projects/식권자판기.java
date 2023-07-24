//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package 미니프로젝트;

import java.util.Scanner;

public class 식권자판기 {
    public 식권자판기() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] money = new int[]{50000, 10000, 5000, 1000, 500, 100};
        int[] charges = new int[]{1, 1, 1, 1, 5, 10};
        int tickets = 5;
        int price = 3200;

        while(true) {
            label94:
            while(true) {
                System.out.println("[1]관리자 ");
                System.out.println("[2]사용자");
                System.out.print("메뉴 선택: ");
                int sel = sc.nextInt();
                int totalMoney;
                int chargeMoney;
                int buy;
                if (sel == 1) {
                    while(true) {
                        while(true) {
                            System.out.println("1) 식권 충전");
                            System.out.println("2) 잔돈 충전");
                            System.out.println("3) 뒤로 가기");
                            System.out.print("메뉴 선택 : ");
                            totalMoney = sc.nextInt();
                            if (totalMoney == 1) {
                                System.out.print("식권을 몇개 추가하시겠습니까 : ");
                                chargeMoney = sc.nextInt();
                                tickets += chargeMoney;
                                System.out.println("식권이" + chargeMoney + "장 추가되었습니다.");
                            } else if (totalMoney == 2) {
                                System.out.print("잔돈 충전 : ");
                                chargeMoney = sc.nextInt();
                                buy = 0;
                                int idx = false;

                                for(int resultMoney = false; buy < 6; ++buy) {
                                    if (chargeMoney / money[buy] != 0) {
                                        charges[buy] += chargeMoney / money[buy];
                                        chargeMoney %= money[buy];
                                        if (chargeMoney == 0) {
                                            break;
                                        }
                                    }
                                }
                            } else if (totalMoney == 3) {
                                continue label94;
                            }
                        }
                    }
                } else if (sel == 2) {
                    while(true) {
                        while(true) {
                            do {
                                while(true) {
                                    totalMoney = 0;
                                    System.out.println("식권 가격: " + price);
                                    if (tickets != 0) {
                                        System.out.println("식권 : " + tickets + " 매");
                                    } else {
                                        System.out.print("식권이 매진되었습니다 ㅠ ㅠ");
                                    }

                                    System.out.println("=========== 잔  돈 ============");
                                    System.out.print("50000원: " + charges[0] + "개");
                                    System.out.print(" 10000원: " + charges[1] + "개");
                                    System.out.print(" 5000원 : " + charges[2] + "개");
                                    System.out.println();
                                    System.out.print("1000원 : " + charges[3] + "개 ");
                                    System.out.print("500원: " + charges[4] + "개 ");
                                    System.out.print("100원: " + charges[5] + "개 ");
                                    System.out.println();
                                    System.out.println("1) 구입");
                                    System.out.println("2) 뒤로가기");
                                    System.out.print("메뉴 선택 : ");
                                    chargeMoney = sc.nextInt();
                                    if (chargeMoney == 1) {
                                        break;
                                    }

                                    if (chargeMoney == 2) {
                                        continue label94;
                                    }
                                }
                            } while(tickets <= 0);

                            System.out.print("입금 금액을 입력 : ");

                            while(true) {
                                System.out.println("[0] 50000원 [1] 10000원 [2] 5000원 [3] 1000원 [4] 500원 [5] 100원 [6] 종료");
                                buy = sc.nextInt();
                                if (buy == 6) {
                                    System.out.println("입금 완료된 금액 : " + totalMoney);
                                    System.out.println("구매가능한 식권 개수 : " + tickets);
                                    System.out.print("구매 매수 입력 : ");
                                    buy = sc.nextInt();
                                    if (buy > tickets) {
                                        System.out.println("구매하실 수 있는 식권이 부족합니다.");
                                        break;
                                    }

                                    if (buy <= tickets) {
                                        if (totalMoney - buy * 3200 < 0) {
                                            System.out.println("입금하신 금액이 부족합니다.");
                                        } else {
                                            int restMoney = totalMoney - 3200 * buy;
                                            tickets -= buy;
                                            System.out.println("잔돈은 " + restMoney + "원 입니다.");

                                            for(int i = 0; i < charges.length; ++i) {
                                                if (charges[i] > 0 && restMoney / money[i] > 0) {
                                                    int count = false;

                                                    while(restMoney != 0) {
                                                        int count = restMoney / money[i];
                                                        if (count <= charges[i]) {
                                                            charges[i] -= count;
                                                            restMoney %= money[i];
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }

                                totalMoney += money[buy];
                                int var10002 = charges[buy]++;
                            }
                        }
                    }
                }
            }
        }
    }
}
