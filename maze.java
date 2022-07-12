import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class test2 {
    static LinkedList<position> path = new LinkedList<position>();
    static ArrayList<String> option = new ArrayList<String>();
    static int [][] maze = new int[11][11];


    public static void main(String[] args) {

        int count = 0;
        boolean done = false;
        position p = new position(0,0);
        path.push(p);
do {
     //start position
    int y = path.peek().y;  //check value for y in position
    int x = path.peek().x;
    maze[y][x] = 1;

    generateMaze(y,x);
    option.clear();
    count++;

    if (path.size() <= 1)
    {
        System.out.println("no path");
        break;
    }
}while (done != true);
        {
            System.out.println("completed");
        }

    }

    public static void generateMaze(int y, int x)
    {

        checkDirection(y,x);
        String SelectedPath = RandomPath();
        MovedPath(SelectedPath,y,x);
    }

    public static void checkDirection(int y, int x)
    {
        boolean havePath = false;


            if (isValid(y-1,x) == true && isNull(y-1,x) == true)
            {
                option.add("up");
                havePath = true;

            }
             if (isValid(y+1,x) == true && isNull(y+1,x) == true)
            {
                option.add("down");
                havePath = true;
            }
             if (isValid(y,x-1) == true && isNull(y,x-1) == true)
            {
                option.add("left");
                havePath = true;
            }
             if (isValid(y,x+1) == true && isNull(y,x+1) == true)
            {
                option.add("right");
                havePath = true;
            }

             if(havePath == false){
                 option.add("none");
             }

            System.out.println(option);


    }

    public static String RandomPath()
    {
        Random r = new Random();

        int random_path = r.nextInt(option.size());
        String selectedPath = option.get(random_path);
        System.out.println("selected path : " + selectedPath);

        return selectedPath;
    }

    public static void MovedPath( String selectedPath, int y, int x)
    {
        switch (selectedPath)
        {
            case "up":
                path.push(new position(y-1, x));
                System.out.println("moved up \n");
                maze[y-1][x] = 1;
                break;

            case "down":
                path.push(new position(y+1, x));
                System.out.println("moved down \n");
                maze[y+1][x] = 1;
                break;

            case "left":
                path.push(new position(y, x-1));
                System.out.println("moved left \n");
                maze[y][x-1] = 1;
                break;

            case "right":
                path.push(new position(y, x+1));
                System.out.println("moved right \n");
                maze[y][x+1] = 1;
                break;

            case "none":
                path.pop();
                System.out.println("backtrack");
                break;
        }

    }


    public static boolean isValid(int y, int x)
    {
        if (y < 0 ||  x < 0 || y >= maze.length || x >= maze[y].length)   //length is not zero base so the length is 3
        {
            System.out.println("out bound\n");
            return false;
        }
//        System.out.println("is valid true");
        return  true;
    }

    public static boolean isNull(int y, int x)
    {
        if (maze[y][x] != 1)
        {
//            System.out.println("ada kosong");
            return true;
        }else if (maze[y][x] == 1)
            System.out.println("maze have value \n");
        return false;
    }

}
