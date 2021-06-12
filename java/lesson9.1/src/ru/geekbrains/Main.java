package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        int result = 0;

        String[][] arrayTrue = {{"2","2","2","2"},{"2","2","2","2"}};
        String[][] arrayError = {{"1","2","2","4","3"},{"3","4","5","1"}};
        String[][] arrayErrorData = {{"2","2","3","4",},{"1","2","dd3","5"}};


        try {
            result = 0;
            result = analyze(arrayTrue);
        } catch(MyArraySizeException e){
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Сумма массива "+String.valueOf(result));
            System.out.println(" ");
        }

        try {
            result = 0;
            result = analyze(arrayError);
        } catch(MyArraySizeException e){
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Сумма массива "+String.valueOf(result));
            System.out.println(" ");
        }


        try {
            result = 0;
            result = analyze(arrayErrorData);
        } catch(MyArraySizeException e){
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Сумма массива "+String.valueOf(result));

        }


    }

    public static int analyze(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int summ = 0;
        int value = 0;
        int row = 0;
        int cell = 0;

        if(array.length != 2 || array[0].length != 4 || array[1].length != 4) {
            throw new MyArraySizeException();
        }

        for(int i=1;i<3;i++){
            row = i;
            for(int c=1;c<5;c++){
                cell = c;
                try{
                    value = Integer.parseInt(array[i-1][c-1]);
                    summ += value;
                } catch (IllegalArgumentException e){
                    String message = "в "+String.valueOf(row)+" ряду, "+String.valueOf(cell)+" ячейке";
                    throw new MyArrayDataException(message);
                }
            }
        }

        return summ;
    }
    }

