package lesson6.ht;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[] tictac = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
    static boolean isGameFinished = false;
    static boolean isX = true;


    public static void main(String[] args) {
        pVSHardPc();
    }

    private static void pVSpGame() {
        while (!isGameFinished && getCountChar('.') != 0) {
            printScheme();
            Scanner scanner = new Scanner(System.in);
            try {
                int position = scanner.nextInt();

                if (tictac[position] == '.') {
                    tictac[position] = isX == true ? 'X' : 'O';
                    checkWinner(position);
                } else {
                    System.out.println("Your number is already used");
                    printArr();
                    continue;
                }
                isX = !isX;
                printArr();


            } catch (InputMismatchException e) {
                System.out.println("You should enter only numbers");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You should enter numbers between 0 - 8");
                continue;

            }
        }
    }

    private static void pcVSpcGame() {
        while (!isGameFinished && getCountChar('.') != 0) {
            printScheme();
                Random rn = new Random();
                int position = rn.nextInt(9);

                if (tictac[position] == '.') {
                    tictac[position] = isX == true ? 'X' : 'O';
                    checkWinner(position);
                } else {
                    System.out.println("Your number is already used");
                    printArr();
                    continue;
                }
                isX = !isX;
                printArr();

        }
    }

    private static void pVSeasyPc() {
        while (!isGameFinished && getCountChar('.') != 0) {
            if(!isX) {
                printScheme();
            }
            Scanner scanner = new Scanner(System.in);
            try {
                int position;
                if(!isX) {
                     position = scanner.nextInt();
                }else {
                    Random rn = new Random();
                     position = rn.nextInt(8);
                }

                if (tictac[position] == '.') {
                    tictac[position] = isX == true ? 'X' : 'O';
                    checkWinner(position);
                } else {
                    if(!isX) {
                        System.out.println("Your number is already used");
                        printArr();
                    }
                    continue;
                }
                isX = !isX;
                printArr();


            } catch (InputMismatchException e) {
                System.out.println("You should enter only numbers");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You should enter numbers between 0 - 8");
                continue;

            }
        }
    }

    private static void pVSHardPc() {
        int count = 0;
        boolean isFirst = true;
        int [] positions = {0,2,1,5,6,3,4,8,7};
        while (!isGameFinished && getCountChar('.') != 0) {
            if(!isX) {
                printScheme();
            }
            Scanner scanner = new Scanner(System.in);
            try {
                int position;
                if(!isX) {
                    position = scanner.nextInt();
                }else {
                    if(isFirst) {
                        if (tictac[2] == 'O' || tictac[1] == 'O') {
                            positions[1] = 8;
                            positions[2] = 7;
                            positions[7] = 1;
                            positions[8] = 2;
                            isFirst = false;
                        }

                    }

                    position = positions[count];
                    count++;
                }

                if (tictac[position] == '.') {
                    tictac[position] = isX == true ? 'X' : 'O';
                    checkWinner(position);
                } else {
                    if(!isX) {
                        System.out.println("Your number is already used");
                        printArr();
                    }
                    continue;
                }
                isX = !isX;
                printArr();


            } catch (InputMismatchException e) {
                System.out.println("You should enter only numbers");
                continue;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You should enter numbers between 0 - 8");
                continue;

            }
        }
    }


    private static void printArr() {
        System.out.println("Current state of Array is: ");
        for (int i = 0; i < tictac.length; i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            System.out.print(tictac[i]);
        }
        System.out.println();
    }

    private static void printScheme() {
        String ch = isX ? "X" : "O";
        System.out.println("Please enter number of " + ch + " according scheme");
        for (int i = 0; i < tictac.length; i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            System.out.print(i);
        }
        System.out.println();
    }

    private static int getCountChar(char ch) {
        int count = 0;
        for (int i = 0; i < tictac.length; i++) {
            if (ch == tictac[i]) {
                count++;
            }
        }
        return count;
    }

    private static void checkWinner(int number) {
        if (getCountChar('X') < 3) {
            System.out.println("return X " + getCountChar('X'));
            return;
        }

        System.out.println("Before Comparing ");

        if (
                (tictac[0] == tictac[4] && tictac[8] == tictac[0] && tictac[0] == tictac[number]) ||
                        (tictac[0] == tictac[1] && tictac[2] == tictac[1] && tictac[1] == tictac[number]) ||
                        (tictac[0] == tictac[3] && tictac[6] == tictac[0] && tictac[0] == tictac[number]) ||
                        (tictac[1] == tictac[4] && tictac[7] == tictac[1] && tictac[1] == tictac[number]) ||
                        (tictac[2] == tictac[5] && tictac[8] == tictac[2] && tictac[2] == tictac[number]) ||
                        (tictac[3] == tictac[4] && tictac[5] == tictac[3] && tictac[3] == tictac[number]) ||
                        (tictac[6] == tictac[7] && tictac[8] == tictac[6] && tictac[6] == tictac[number]) ||
                        (tictac[2] == tictac[4] && tictac[6] == tictac[2] && tictac[2] == tictac[number])
        ) {
            System.out.println("WE HAVE A WINNER!!!\nPLAYER " + tictac[number] + " WIN");
            isGameFinished = true;
        } else {
            if (getCountChar('.') == 0){
                System.out.println("WE HAVE NO WINNER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                isGameFinished = true;
            }
        }

    }
}
