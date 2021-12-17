package com.secretsanta.secret;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.io.*;

@RestController
public class SecretSanta {
    @GetMapping("/SecretSanta")
    public static void SecretSanta() throws InterruptedException, IOException{
        //file reader
        FileReader file = new FileReader("names.txt");
        BufferedReader reader = new BufferedReader(file);

        FileReader wordFile = new FileReader("secretwords.txt");
        BufferedReader wordReader = new BufferedReader(wordFile);
        

        //secret word handling
        Scanner input = new Scanner(System.in);
        for(int i =0; i< 1000; i++)
        {
            System.out.println();
        }
        System.out.println("HO! HO! HO!");
        Thread.sleep(1800);
        System.out.println("THIS YEAR I HAVE SPRAINED MY ANKLE AND MY FAVORITE REINDEAR CAUGHT COVID-19!");
        Thread.sleep(4000);
        System.out.println("SO I NEED YOU TO BE THE LUCKY SOUL TO GIVE THE GIFTS OUT FOR ME!!!!");
        Thread.sleep(3800);
        System.out.println("WOULD YOU LOVE TO BE THE GREAT SOUL TO HELP ME? (Y/N)" );
        String question = input.nextLine().toLowerCase();
        if(question.equals("y"))
        {
            System.out.println("HO! HO! HO! IM GLAD YOU CAN HELP ME AND THE DEAR MRS. CLAUS OUT THIS YEAR!");
            Thread.sleep(2000);
        }
        else
        {
            System.out.println("NO HO! HO! HO!'ING FOR YOU THEN!");
            return;
        }
        System.out.println("TELL ME YOUR FAVORITE CHRISTMAS WORD AND I WILL SEE TO IT THAT YOU CAN HO AROUND JUST LIKE ME!");

        String secretWord = input.nextLine().toLowerCase();

        //list of names
        ArrayList<String> namesList = new ArrayList<String>();
        ArrayList<String> recepientList = new ArrayList<String>();
        ArrayList<String> temp;
        ArrayList<String> secretWordsList = new ArrayList<String>();

        Random rand = new Random(42069);
        int randomNum;
        String nameFile;
        while((nameFile = reader.readLine()) != null)
        {
            namesList.add(nameFile);
        }

        String word;
        while((word = wordReader.readLine()) != null)
        {
            secretWordsList.add(word);
        }

        for(String santa : namesList)
        {
            temp = new ArrayList<String>();
            for(String recipient : namesList)
            {
                if(!recepientList.contains(recipient))
                {
                    temp.add(recipient);
                }
            }
            temp.remove(santa);
            randomNum = rand.nextInt(temp.size());
            recepientList.add(temp.get(randomNum));
        }

        int santaID = 0;
        if(secretWord.equals("admin"))
        {
            admin(namesList, secretWordsList);
        }
        if(secretWordsList.contains(secretWord))
        {
            santaID = secretWordsList.indexOf(secretWord);
        }
        else
        {
            Thread.sleep(1000);
            System.out.println("HO! HO! HO! YOU OBVIOUSLY DONT GET TO HO!");
            return;
        }
        System.out.println();
        Thread.sleep(1000);
        getResult(namesList,recepientList, santaID);

    }
    public static void getResult(ArrayList<String> namesList, ArrayList<String> recepientList, int ID)
    {
        
        System.out.println("GLAD YOU ARE TRULY IN THE CHRISTMAS SPIRIT , " + namesList.get(ID) + ", YOU HAVE GROWN QUITE A BIT SINCE I'VE LAST SEEN YOU! HO! HO! HO!\nYOU GET TO HO! HO! HO! FOR " + recepientList.get(ID) + " THIS YEAR!");
    }
    public static void admin(ArrayList<String> namesList, ArrayList<String> wordList)
    {
        for(int i = 0; i < namesList.size(); i++)
        {
            System.out.println("Santa: " + namesList.get(i) + "     Word:" + wordList.get(i));
        }
    }
}
