package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream iStream = new FileInputStream(fileName);

        ArrayList<Integer> streamList = new ArrayList<>();
        ArrayList<Integer> resultList = new ArrayList<>();


        //записываем байты в лист
        while (iStream.available() > 0) {
            streamList.add(iStream.read());
        }

        iStream.close();

        //считаем количество каждого байта
        int[] count = new int[streamList.size()];

        for (int i = 0; i < streamList.size(); i++) {
            count[i] = 0;

            for (int j = 0; j < streamList.size(); j++) {
                if (streamList.get(i) == streamList.get(j)) {
                    count[i] ++;
                }
            }
        }

        // определение минимума
        int min = Integer.MIN_VALUE;

        for (int m : count) {
            if (m > min) {
                min = m;
            }
        }

        // собираем байты c минимумом без повторов

        for (int i = 0; i < streamList.size(); i++) {
            if (!resultList.contains(streamList.get(i)) && count[i] == min) {
                resultList.add (streamList.get(i));
            }
        }

        //выводим на экран результат
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i) + " ");
        }


    }
}

