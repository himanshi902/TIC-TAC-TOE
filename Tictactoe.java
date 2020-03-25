import java.util.Scanner;
import java.util.Random;
public class Tictactoe {
    public static void show(String [][] play_board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(play_board[i][j]);
                if(j<2)
                    System.out.print("|");

           }
            System.out.print("\n");
        }
    }
    public static boolean check(String[][] play_board, String hehe,String name)
    {
        int fu=0;
        for(int i=0;i<3;i++)
        {
            if(play_board[i][0].equals(hehe)&&play_board[i][1].equals(hehe)&&play_board[i][2].equals(hehe))
            fu=1;
            if(play_board[0][i].equals(hehe)&&play_board[1][i].equals(hehe)&&play_board[2][i].equals(hehe))
                fu=1;
        }
        if(play_board[0][0].equals(hehe)&&play_board[1][1].equals(hehe)&&play_board[2][2].equals(hehe))
            fu=1;
        if(play_board[0][2].equals(hehe)&&play_board[1][1].equals(hehe)&&play_board[2][0].equals(hehe))
            fu=1;
        if(fu==1)
        {
            show(play_board);
            System.out.printf("Congratulations!!%s you won.Now give me party:",name);
            return true;
        }
        else
          return false;
    }
    public static void human_play(String[][] play_board,String smbl,String name)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s enter position",name);
        int pos=input.nextInt();
        play_board[pos/3][pos%3]= smbl;

    }
    public static void machine_play(String[][] play_board,String smbl)
    {
        int pos;
        Random rand= new Random();
        do {
            pos = (rand.nextInt(9)) ;
        }while(play_board[pos/3][pos%3].equals("O")||play_board[pos/3][pos%3].equals("X"));
        play_board[pos/3][pos%3] = smbl;
    }
     public static void play_with_machine(String[][] play_board)
     {
         Scanner input = new Scanner(System.in);
         System.out.println("Enter your name");
         String player1= input.nextLine();
         show(play_board);
         int count=0;
         while(true) {
             if (count > 8)
                 break;
             human_play(play_board, "O", player1);
             count++;
             if (check(play_board, "O", player1))
                 return;

             if (count > 8)
                 break;
             machine_play(play_board, "X");
             count++;
             if (check(play_board, "X", "MACHINE"))
                 return;
             show(play_board);

         }
         System.out.println("IT'S A DRAW:(");

     }
    private static void play_with_human(String[][] play_board)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of player 1");
        String player1= input.nextLine();
        System.out.println("Enter name of player 2");
        String player2= input.nextLine();
        show(play_board);
        int count=0;
        while(true)
        {
            if(count>8)
                break;
            human_play(play_board,"O",player1);
            count++;
            if(check(play_board,"O",player1))
                return;
            show(play_board);

            if(count>8)
                break;
            human_play(play_board,"X",player2);
            count++;
            if(check(play_board,"X",player2))
                return;
            show(play_board);

        }
        System.out.println("IT'S A DRAW:(");
    }

    public static void play(int n,String[][] play_board)
    {
        if(n==0)
            play_with_machine(play_board);
        else
            play_with_human(play_board);
    }

    public static void main(String [] args)
    {
        System.out.println("WELCOME TO TIC TAC TOE WORLD!!");
        System.out.println("Choose your opponent \nType 0 for MACHINE and 1 for HUMAN as your opponent");
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        String[][] play_board = new String[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                play_board[i][j]= String.valueOf(((i*3)+j));
            }
        }
        play(n,play_board);

    }
}