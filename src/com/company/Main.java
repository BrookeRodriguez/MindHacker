package com.company;
import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard  = new Scanner(System.in);

        ArrayList<String> wordList = new ArrayList<String>();

        String[] wordArray;

        String word = "test";
        String solvedWord = "";
        String request = "";

        int randomNum = (int)(Math.random() * 370099);
        int guesses = 0;

        boolean isplaying = true;
        boolean hasWon = false;
        boolean hasLost = false;

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("/Users/rodrigub/IdeaProjects/MindHacker/words_alpha.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Not found");
            e.printStackTrace();
        }

        DataInputStream data_input = new DataInputStream(inputStream);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));
        String str_line;

        try {
            while ((str_line = buffer.readLine()) != null)
            {
                str_line = str_line.trim();
                if ((str_line.length()!=0))
                {
                    wordList.add(str_line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        wordArray = (String[])wordList.toArray(new String[wordList.size()]);

        /*
        for(int i = 0; i < wordArray.length; i++) {
            System.out.println(wordArray[i]);
        }
        */

        while (isplaying)
        {
            System.out.println("What difficulty setting do you want to use by typing the corresponding number:");
            System.out.println("1: Very Easy (<4 words)");
            System.out.println("2: Easy (4 words)");
            System.out.println("3: Medium (6 words)");
            System.out.println("4: Hard (8 words)");
            System.out.println("5: Very Hard (10 words)");
            System.out.println("6: Impossible (>10 words)");
            System.out.print(">");

            request = keyboard.next();

            if (request.equals("1"))
            {
                while (!(wordArray[randomNum].length() < 4))
                {
                    randomNum = randomNum = (int)(Math.random() * wordArray.length);
                }

                word = wordArray[randomNum];
            }

            else if (request.equals("2"))
            {
                while (!(wordArray[randomNum].length() == 4))
                {
                    randomNum = randomNum = (int)(Math.random() * wordArray.length);
                }

                word = wordArray[randomNum];
            }

            else if (request.equals("3"))
            {
                while (!(wordArray[randomNum].length() == 6))
                {
                    randomNum = randomNum = (int)(Math.random() * wordArray.length);
                }

                word = wordArray[randomNum];
            }

            else if (request.equals("4"))
            {
                while (!(wordArray[randomNum].length() == 8))
                {
                    randomNum = randomNum = (int)(Math.random() * wordArray.length);
                }

                word = wordArray[randomNum];
            }

            else if (request.equals("5"))
            {
                while (!(wordArray[randomNum].length() == 10))
                {
                    randomNum = randomNum = (int)(Math.random() * wordArray.length);
                }

                word = wordArray[randomNum];
            }

            else
            {
                while (!(wordArray[randomNum].length() > 10))
                {
                    randomNum = randomNum = (int)(Math.random() * wordArray.length);
                }

                word = wordArray[randomNum];
            }

            for (int i = 0; i < word.length(); i++)
            {
                solvedWord += "_ ";
            }

            System.out.println("You have four guesses to try.");
            System.out.println("Every correct letter will display.");
            System.out.println("Every incorrect letter will appear as an underscore.");

            while (!(hasWon) && !(hasLost))
            {
                System.out.println("The unknown word:" + solvedWord);
                System.out.println("Guess your word here: ");
                System.out.print(">");

                solvedWord = "";

                request = keyboard.next().toLowerCase();

                for (int i = 0; i < request.length();)
                {
                    if (request.charAt(i) == word.charAt(i))
                    {
                        solvedWord += (request.substring(i, i + 1) + " ");
                    }

                    else
                    {
                        solvedWord += "_ ";
                    }
                }

                guesses++;

                if (request.equals(word))
                {
                    hasWon = true;
                }

                else if (guesses > 3)
                {
                    hasLost = true;
                }

                else
                {
                    System.out.println("You have " + (4 - guesses) + " tries left.");
                }

            }

            if (hasWon)
            {
                System.out.println("Congrats! You Won! Do you want to play again? ('y' or 'n')");
                System.out.print(">");

                if (request.equals("n"))
                {
                    isplaying = false;
                }
            }

            else
            {
                System.out.println("You Lost! Do you want to play again? ('y' or 'n')");
                System.out.print(">");

                if (request.equals("n"))
                {
                    isplaying = false;
                }
            }
        }
    }
}
