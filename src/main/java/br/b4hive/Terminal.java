package br.b4hive;

public class Terminal {
    private static boolean active = false;
    private static char [][] visibleSpace;

    public static void init(MapGrid mapGrid) {
        visibleSpace = new char[7][7];
        active = true;
    }
    private static void fillVisibleSpace(Point p, MapGrid map) {
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 7; i++) {
                int pX = p.x() - 3 + i;
                int pY = p.y() - 3 + j;
                Point p1 = new Point(pX, pY);
                if(map.get(p1).getEntity() == null)
                    visibleSpace[i][j] = map.get(p1).getGroundType().charAt(0);
                else
                    visibleSpace[i][j] = map.get(p1).getEntity().getName().charAt(0);
            }
        }
    }
    public static void draw(Point p, MapGrid map) {
        if (!active) {
            System.out.println("Error: Terminal is not active");
            return;
        }
        CLI.clear();
        fillVisibleSpace(p, map);
        System.out.print(" +-");
        for (int i = 0; i < 7; i++) {
            System.out.print("---");
        }
        System.out.println("-+ ");
        for (int j = 0; j < 7; j++) {
            System.out.print(" | ");
            for (int i = 0; i < 7; i++) {
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
        System.out.println("Position: (" + p.x() + ", " + -p.y() + ")");
    }
    
}
