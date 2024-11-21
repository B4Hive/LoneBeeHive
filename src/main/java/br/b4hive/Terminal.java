package br.b4hive;

import java.awt.*;

public class Terminal {
    private static boolean active = false;
    private static char [][] visibleSpace;
    private static MapGrid map;

    public static void init(MapGrid mapGrid) {
        visibleSpace = new char[7][7];
        map = mapGrid;
        active = true;
    }
    private static void fillVisibleSpace(Point p){
        for (int i = (int)p.getX()-3; i <= (int)p.getY()+3; i++) {
            for (int j = (int)p.getY()-3; j <= (int)p.getY()+3; j++) {
                if(map.get(new Point(i,j)).getEntity() == null)
                    visibleSpace[i+3][j+3] = map.get(new Point(i,j)).getGroundType().charAt(0);
                else
                    visibleSpace[i+3][j+3] = map.get(new Point(i,j)).getEntity().getName().charAt(0);
            }
        }
    }
    public static void draw(Point p) {
        if (!active) {
            System.out.println("Error: Terminal is not active");
            return;
        }
        CLI.clear();
        fillVisibleSpace(p);
        System.out.print(" +-");
        for (int i = 0; i < 7; i++) {
            System.out.print("---");
        }
        System.out.println("-+ ");
        for (int i = 0; i < 7; i++) {
            System.out.print(" | ");
            for (int j = 0; j < 7; j++) {
                System.out.print(" ");
                System.out.print(visibleSpace[i][j]);
                System.out.print(" ");
            }
            System.out.println(" | ");
        }
        System.out.print(" +-");
        for (int i = 0; i < 7; i++) {
            System.out.print("---");
        }
        System.out.println("-+ ");
    }
    
}
