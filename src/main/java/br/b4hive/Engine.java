package br.b4hive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {
    private static boolean initialized = false;
    private static MapGrid mapGrid;
    private static List<Entity> entities;

    private static void init(){
        mapGrid = new MapGrid();
        entities = new ArrayList<Entity>();
        entities.add(new Entity("@",new Point(0,0)));
        Terminal.init(mapGrid);
        for(Entity e:entities){
            mapGrid.get(e.getPosition()).setEntity(e);
        }
        initialized = true;
    }
    private static void init(MapGrid m, Entity e){
        mapGrid = m;
        entities = new ArrayList<>();
        entities.add(e);
    }
    private static void quit(){
        //save objects on this step
        initialized = false;
        CLI.clear();
        System.out.println("Game quitted");
    }
	private static void turn(){
        Terminal.drawMap(entities.get(0).getPosition(), mapGrid);
        Terminal.drawBar(entities.get(0));
        control(null);
    }
    private static boolean control(String command){
        if(command == null){
            System.out.print("Control: ");
            Scanner in = new Scanner(System.in);
            command = in.nextLine();
        }
        command = command.toLowerCase();
        switch (command){
            case "w":
                move(entities.get(0), 0,-1);
                break;
            case "a":
                move(entities.get(0), -1,0);
                break;
            case "s":
                move(entities.get(0), 0,1);
                break;
            case "d":
                move(entities.get(0), 1,0);
                break;
            case "quit", "q":
                quit();
                return false;
            case "start":
                init();
                break;
            default:
                System.out.println("Invalid input");
                Terminal.wait(3000);
                break;
        }
        return true;
    }
    private static void move(Entity entity, int dx, int dy){
        if(entity == null) return;
        Point p = entity.getPosition().translate(dx,dy);
        for(Entity e:entities){
            if(e.getPosition().equals(p)){
                return;
            }
        }
        mapGrid.get(entity.getPosition()).moveEntity(mapGrid.get(p));
        entity.setPosition(p);
    }

    public static void gameTerminal(){
        do{
            Terminal.drawMainMenu();
            Terminal.drawBar(null);
            if(!control(null)) break;
        }while(!initialized);
        //need to fix above loop so that it won't need to start before quitting
        while(initialized){
            turn();
        }
    }

}