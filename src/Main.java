import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("input.txt"));
        String act = sc.nextLine();
        //System.out.println(act);
        char[] action = act.toCharArray();
        int x = 0;
        int y = 0;

        char direction = 'N';
        ArrayList<Coord> log = new ArrayList<>();
        log.add(new Coord(x, y));
        //System.out.println(log);

        for (int i = 0; i < action.length; i++) {
            if (action[i] == 'L') {
                direction = turnLeft(direction);
            }
            if (action[i] == 'R') {
                direction = turnRight(direction);

            }
            if (action[i] == 'S') {

                if (direction == 'N')
                    y++;
                if (direction == 'E')
                    x++;
                if (direction == 'S')
                    y--;
                if (direction == 'W')
                    x--;
                Coord position = new Coord(x, y);
                //System.out.println(position);
                if (log.contains(position)) {
                   // System.out.println("мы тут были");
                    break;
                }
                else  log.add(position);
            }
        }
        PrintWriter wr =new PrintWriter(new File("output.txt"));
        wr.println(log.size());
        wr.close();


    }

    public static char turnLeft ( char direction){
            switch (direction) {
                case 'N':
                    direction = 'W';
                    break;
                case 'E':
                    direction = 'N';
                    break;
                case 'S':
                    direction = 'E';
                    break;
                case 'W':
                    direction = 'S';
                    break;
            }
            return direction;
        }
        public static char turnRight ( char direction){
            switch (direction) {
                case 'N':
                    direction = 'E';
                    break;
                case 'E':
                    direction = 'S';
                    break;
                case 'S':
                    direction = 'W';
                    break;
                case 'W':
                    direction = 'N';
                    break;
            }
            return direction;

        }
    }

class Coord {
    int x, y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + "; " + y + '}';

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord coord)) return false;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    }













