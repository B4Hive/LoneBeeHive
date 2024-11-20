package br.b4hive;

import java.awt.*;

public class Terminal {
    private static boolean active = false;
    private static char [][] visibleSpace;

    public static void init(MapGrid map) {
        visibleSpace = new char[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(map.get(new Point(i,j)).getEntity() == null)
                    visibleSpace[i][j] = map.get(new Point(i,j)).getGroundType().charAt(0);
                else
                    visibleSpace[i][j] = map.get(new Point(i,j)).getEntity().getName().charAt(0);
            }
        }
        active = true;
    }
    public static void draw(Point p) {
        if (!active) {
            System.out.println("Error: Terminal is not active");
            return;
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" ");
                System.out.print(visibleSpace[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
