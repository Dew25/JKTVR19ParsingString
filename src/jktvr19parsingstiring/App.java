/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr19parsingstiring;

import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
class App {
    public void run(){
        System.out.println("--- Работа со строкой ---");
        System.out.println("---------------------------------------------");
        System.out.println("Список задач: ");
        System.out.println("1. посчитать количество слов в строке");
        System.out.println("2. найти указанную строку в исходной строке");
        System.out.println("3. заменить искомую строку на указанную");
        System.out.println("4. удалить все теги из html строки");
        System.out.println("5. удалить указанный тег из html строки");
        System.out.println("---------------------------------------------");
        System.out.println("Введите исходную строку: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("---------------------------------------------");
        System.out.println("Выберите номер задачи: ");
        String task = scanner.nextLine();
        switch (task) {
            case "1":
                System.out.println("Вы выбрали: 1. посчитать количество слов в строке");
                System.out.println("В строке слов: " + this.getCountWords(str));
                break;
            case "2":
                System.out.println("Вы выбрали: 2. найти указанную строку в исходной строке");
                
                break;
            case "3":
                System.out.println("Вы выбрали: 3. заменить искомую строку на указанную");
                
                break;
            case "4":
                System.out.println("Вы выбрали: 4. удалить все теги из html строки");
                
                break;
            case "5":
                System.out.println("Вы выбрали: 5. удалить указанный тег из html строки");
                
                break;
            default:
                System.out.println("Нет такой задачи");
        }
        
    }
    private int getCountWords(String str){
         if(str.isEmpty()) {
            return 0;
        }
        String[] arrStr = str.split(" ");
        return arrStr.length;
    }
}
