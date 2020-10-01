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
    private Scanner scanner = new Scanner(System.in);
    
    public void run(){
        System.out.println("--- Работа со строкой ---");
        System.out.println("---------------------------------------------");
        boolean repeat = true;
        do{
            System.out.println("Список задач: ");
            System.out.println("0. Закончить программу");
            System.out.println("1. посчитать количество слов в строке");
            System.out.println("2. найти указанную строку в исходной строке");
            System.out.println("3. заменить искомую строку на указанную");
            System.out.println("4. удалить все теги из html строки");
            System.out.println("5. удалить указанный тег из html строки");
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println("Выберите номер задачи: ");
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("Вы выбрали: 1. посчитать количество слов в строке");
                    System.out.println("Введите исходную строку (latin): ");
                    String str = scanner.nextLine();
                    System.out.println("В строке слов: " + this.getCountWords(str));
                    break;
                case "2":
                    System.out.println("Вы выбрали: 2. найти указанную строку в исходной строке");
                    System.out.println("Введите исходную строку (latin): ");
                    str = scanner.nextLine();
                    int n = this.searchSubString(str);
                    if(n >= 0){
                        System.out.println("Срока есть в позиции: " + n);
                    }else{
                        System.out.println("Сроки нет");
                    }
                    break;
                case "3":
                    System.out.println("Вы выбрали: 3. заменить искомую строку на указанную");
                    System.out.println("Введите исходную строку (latin): ");
                    str = scanner.nextLine();
                    System.out.println("Результат: " + this.replaceString(str));
                    break;
                case "4":
                    System.out.println("Вы выбрали: 4. удалить все теги из html строки");
                    //используйте строку <!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0"><title>Document</title></head><body>This is a text</body></html>
                    System.out.println("Введите исходную строку (latin): ");
                    str = scanner.nextLine();
                    System.out.println("Результат: " + this.deleteTegsFromHtml(str));

                    break;
                case "5":
                    System.out.println("Вы выбрали: 5. удалить указанный тег из html строки");
                    System.out.println("Введите исходную строку (latin): ");
                    str = scanner.nextLine();
                    System.out.println("Результат: " + this.deleteOneTegFromHtml(str));

                    break;
                default:
                    System.out.println("Нет такой задачи");
            }
        }while(repeat);
        
    }
    private int getCountWords(String str){
         if(str.isEmpty()) {
            return 0;
        }
        String[] arrStr = str.split(" ");
        return arrStr.length;
    }
    private int searchSubString(String str){
        System.out.println("Введите искомую строку (latin): ");
        String subStr = scanner.nextLine();
        int n = str.toLowerCase().indexOf(subStr.toLowerCase());
        return n;
    }

    private String replaceString(String str) {
        System.out.println("Введите искомую строку (latin): ");
        String subStr = scanner.nextLine();
        System.out.println("На что заменить (latin): ");
        String replaceStr = scanner.nextLine();
        StringBuilder sb = new StringBuilder(str);
        int firstIndex = str.indexOf(subStr);
        int endIndex = firstIndex + subStr.length();
        sb.replace(firstIndex, endIndex, replaceStr);
        return sb.toString();
    }

    private String deleteTegsFromHtml(String str) {
        StringBuilder sb = new StringBuilder(str);
        while(sb.indexOf("<") >= 0){
            int indexOpenTag = sb.indexOf("<");
            int indexCloseTag = sb.indexOf(">");
            sb.replace(indexOpenTag, indexCloseTag+1, " ");
        }  
        return sb.toString();
    }

    private String deleteOneTegFromHtml(String str) {
        System.out.println("Укажите какой тег удалить (без угловых скобок): ");
        String tag = scanner.nextLine();
        StringBuilder sb = new StringBuilder(str);
        String tagBegin = "<"+tag;
        String tagEnd = "</"+tag;
        while(sb.indexOf(tagBegin) >= 0){
            int indexOpenTag = sb.indexOf(tagBegin);
            int indexOpenTagEnd = sb.indexOf(">",indexOpenTag);
           // int indexCloseTag = indexOpenTag + indexOpenTagClose+1;
            sb.replace(indexOpenTag, indexOpenTagEnd+1, "");
            int indexCloseTag = sb.indexOf(tagEnd);
            if(indexCloseTag >=0){
                int indexCloseTagEnd = sb.indexOf(">",indexCloseTag);
                sb.replace(indexCloseTag, indexCloseTagEnd+1, "");
            }
        }  
        return sb.toString();
    }
}
