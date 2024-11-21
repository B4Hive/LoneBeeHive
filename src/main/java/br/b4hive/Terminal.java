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
        System.out.println("Position: (" + p.x() + ", " + -p.y() + ")");
    }
    public static void drawMenu(){
        CLI.clear();
        System.out.print(" +-");
        for (int i = 0; i < 7; i++) {
            System.out.print("---");
        }
        System.out.println("-+ ");
        for (int j = 0; j < 7; j++) {
            System.out.print(" | ");
//            switch (j){
//                case 1:
//                    System.out.println("     LoneBeehive     ");
//                    break;
//                case 3:
//                    System.out.println("        Start        ");
//                    break;
//                case 5:
//                    System.out.println("        Leave        ");
//                    break;
//                case 0, 2, 4, 6:
//                    for (int i = 0; i < 7; i++) System.out.print("   ");
//                default:
//                    break;
//            }
            System.out.print(j);
            System.out.println(" | ");
        }
        System.out.print(" +-");
        for (int i = 0; i < 7; i++) {
            System.out.print("---");
        }
        System.out.println("-+ ");
    }
}
