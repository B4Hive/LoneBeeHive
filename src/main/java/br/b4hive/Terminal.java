package br.b4hive;

public class Terminal {
    private static boolean active = false;
    private static char [][] visibleSpace;

    public static void init(MapGrid mapGrid) {
        visibleSpace = new char[7][7];
        active = true;
    }
    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
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
    public static void drawMap(Point p, MapGrid map) {
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
        //System.out.println("Position: (" + p.x() + ", " + -p.y() + ")");
    }
    public static void drawMainMenu(){
        CLI.clear();

        System.out.print(" +-");
        for (int i = 0; i < 7; i++) System.out.print("---");
        System.out.println("-+ ");

        for (int j = 0; j < 7; j++) {
            System.out.print(" | ");
            if(j==1) System.out.print("     LoneBeehive     ");
            else if(j==3) System.out.print("        Start        ");
            else if(j==5) System.out.print("        Quit         ");
            else for (int i = 0; i < 7; i++) System.out.print("   ");
            System.out.println(" | ");
        }

        System.out.print(" +-");
        for (int i = 0; i < 7; i++) System.out.print("---");
        System.out.println("-+ ");
    }
    public static void drawBar(Entity e){
        System.out.print(" +-");
        for (int i = 0; i < 7; i++) System.out.print("---");
        System.out.println("-+ ");
        StringBuilder position = new StringBuilder();

        System.out.print(" | ");
        if(e!=null) position = new StringBuilder(String.format("  X: %4d | Y: %4d  ", e.getPosition().x(), e.getPosition().y()));
        else position.append(" ".repeat(21));
        System.out.print(position);
        System.out.println(" | ");

        //|123456789012345678901|
        //|  x | x | x | x | x  |
        //|  HP: xxx | EP: xxx  |

        System.out.print(" +-");
        for (int i = 0; i < 7; i++) System.out.print("---");
        System.out.println("-+ ");

    }
}
