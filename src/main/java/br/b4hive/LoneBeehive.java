package br.b4hive;

import java.awt.*;

public class LoneBeehive {

    public static void main(String[] args) {
        GameCLI.clear();
        //Tela.main(null);
        MapGrid grid = new MapGrid();
        Terminal.init(grid);
        Terminal.draw(new Point(0,0));
    }

}
