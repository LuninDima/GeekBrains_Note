package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();
    public static char[][] map;
    public static final int size = 9;
    public static final int dotsToWin = 3;
    public static char dotEmpty = '•';
    public static char dotX = 'X';
    public static char dotO = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
       while(true){
           humanTurn();
           printMap();
           if(checkWin(dotX)){
               System.out.println("Вы победили");
               break;
           }
           if(isMapFull()){
               System.out.println("Ничья");
               break;
           }
//           ComputerTurn();
//           printMap();
//           if(checkWin(dotO)){
//               System.out.println("Компьютер победил");
//               break;
//           }
           if(isMapFull()){
               System.out.println("Ничья");
           }
       }
        System.out.println("Игра окончена");

    }

    public static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = dotEmpty;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < size; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        System.out.println();
        }

        public static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        } while (!isCellValid(x, y));
            map[x][y] = dotX;
        }
        public static boolean isCellValid(int x, int y){
        if(x < 0 || x > size || y < 0 || y > size){
            return  false;
        } else if(map[x][y] == dotEmpty) {
            return true;
        }
        return false;
        }
    public static void ComputerTurn(){
        int x, y;
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);

        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[x][y] = dotO;
    }
    public static boolean checkWin(char symb) {
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < i + 2; j++) {
                if(j + 1 < size){
                    if(map[i][i - i] == symb && map[i][j] == symb && map[i][j+ 1] == symb) return true;
                    if(map[i - i][i] == symb && map[j][i] == symb && map[j + 1][i] == symb) return true;
                    if (map[i][i] == symb && map[j][j] == symb && map[j + 1][j + 1] == symb) return true;
                    if (map[j + 1][i] == symb && map[j][j] == symb && map[i][j + 1] == symb) return true;
            }
        }

        }
        return false;
    }
//        for (int i = 0; i < size; i++) {
//            if (map[i][size - 3] == symb && map[i][size - 2] == symb && map[i][size - 1] == symb) return true;
//            if (map[size - 3][i] == symb && map[size - 2][i] == symb && map[size - 1][i] == symb) return true;
//            if (map[i][i] == symb && map[size - 2][size - 2] == symb && map[size - 1][size - 1] == symb) return true;
//            if (map[i][size - 3] == symb && map[size - 2][size - 2] == symb && map[size - 3][i] == symb) return true;
//        }
//        return false;
//    }


//        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
//        return false;
//    }
        public static boolean isMapFull() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (map[i][j] == dotEmpty) {
                        return false;
                    }
                }

            }
            return false;
        }
    }