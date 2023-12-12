package ch.hftm.Strings_verarbeiten;

import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {

        System.out.println("Original Exercise Code");
        originalExercise();
        System.out.println("Solution 1");
        solution1();
        System.out.println("Solution 2");
        solution1();
    }

    public static void originalExercise(){

        String str = "Parse this String";
        ArrayList<String> words = new ArrayList<String>();

        while (str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                if (i == str.length() - 1) {
                    words.add(str.substring(0));
                    str = "";
                    break;
                } else if (str.charAt(i) == ' ') {
                    words.add(str.substring(0, i));
                    str = str.substring(i + 1);
                    break;
                }
            }
        }
        for (String s : words) {
            System.out.println("Word by word: " + s);
        }
    }

    // Solution 1
    public static void solution1(){

        String str = "Parse this String";
        ArrayList<String> words = new ArrayList<String>();

        String[] wordArray = str.split(" ");
        for (String word : wordArray){
            words.add(word);
        }

        for (String word : words) {
            System.out.println("Word by word: " + word);
        }
    }

    // Solution 2
    public static void solution2(){

        String str = "Parse this String";
        ArrayList<String> words = new ArrayList<String>();

        words.addAll(Arrays.asList(str.split(" ")));

        for (String word : words) {
            System.out.println("Word by word: " + word);
        }
    }

}