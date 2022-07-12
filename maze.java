import java.util.LinkedList;
import java.util.Random;

public class test {
    static int [][] maze = new int[4][4];
    static int [][] optionArray = new int[2][2];
    // 0 = wall
    //  1 = path
    //  2 = destination

    static String choice;
    static int x, y;
    static LinkedList<position> path = new LinkedList<position>();

    public static void main(String[] args) {
        position p = new position(0,0);
        path.push(p); //add a stack of first position



        while (true)
        {
             y = path.peek().y;  //check value for y in position
             x = path.peek().x;

            maze[y][x] = 1;

            PositionChoice(y,x);



            if (path.size() <= 1)
                {
                    System.out.println("no path");
                    return;
                }


        }



    }

    public static boolean isNull(int y, int x)
    {
        if (maze[y][x] != 1)
        {
//            System.out.println("ada kosong");
            return true;
        }else if (maze[y][x] == 1)
            System.out.println("maze have value \n");
        PositionChoice(y,x);
        return false;
    }

    public static boolean isValid(int y, int x)
    {
        if (y < 0 || y >= maze.length || x < 0 || x >= maze.length)   //length is not zero base so the length is 3
        {
            System.out.println("out bound\n");
            return false;
        }
//        System.out.println("is valid true");
        return  true;
    }

    public static String PositionChoice(int y, int x)
    {
        boolean decision = false;

       do {
           Random position = new Random();

           int number = 0;

           number = 1+ position.nextInt(4);
           System.out.println("number is " + number);

           switch (number)
           {
               case 1:
                   choice = "UP";
                   if (isValid(y-1, x) == true && isNull(y-1, x) == true)
                   {
                       System.out.println("choice = " + choice);
                       path.push(new position(y-1, x));
                       System.out.println("moved up \n");
                       maze[y-1][x] = 1;
                       decision = true;
                       break;
                   }
                   optionArray[0][0] = 1;
                   continue;


               case 2:
                   choice = "DOWN";
                   if (isValid(y+1, x) == true && isNull(y+1, x) == true )
                   {
                       System.out.println("choice = " + choice);
                       path.push(new position(y+1, x));
                       System.out.println("moved down \n");
                       maze[y+1][x] = 1;
                           decision = true;
                           break;
                   }
                   optionArray[0][1] = 1;
                   continue;

               case 3:
                   choice = "LEFT";
                   if (isValid(y, x-1) == true && isNull(y, x-1) == true)
                   {
                       System.out.println("choice = " + choice);
                       path.push(new position(y, x-1));
                       System.out.println("moved left \n");
                       maze[y][x-1] = 1;
                       decision = true;
                       break;
                   }
                   optionArray[1][0] = 1;
                   continue;
               case 4:
                   choice = "RIGHT";
                   if (isValid(y, x+1) == true && isNull(y, x+1) == true)
                   {
                       System.out.println("choice = " + choice);
                       path.push(new position(y, x+1));
                       System.out.println("moved right \n");
                       maze[y][x+1] = 1;
                       decision = true;
                       break;
                   }
                   optionArray[1][1] = 1;
                   continue;

           }

           if (optionArray[0][0] == 1 && optionArray[0][1] == 1 && optionArray[1][0] == 1 && optionArray[1][1] == 1)
           {
               path.pop();
               System.out.println("backtrack");
               continue;
           }


       }while (decision != true);

       return choice;
    }

    public static void validation()
    {


    }
}
