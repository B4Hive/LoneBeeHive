package br.b4hive;

import java.awt.*;
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
	private static void Turn(){
        Terminal.draw(entities.get(0).getPosition(), mapGrid);
        control();
    }
    private static void control(){
        System.out.println();
        System.out.print("Control: ");
        Scanner in = new Scanner(System.in);
        char ch = in.nextLine().charAt(0);
        Point p = entities.get(0).getPosition();
        switch (ch){
            case 'w':
                move(entities.get(0), p.translate(0,-1));
                break;
            case 'a':
                move(entities.get(0), p.translate(-1,0));
                break;
            case 's':
                move(entities.get(0), p.translate(0,1));
                break;
            case 'd':
                move(entities.get(0), p.translate(1,0));
                break;
            case 'q':
                System.out.println("quit");
                initialized = false;
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
    private static void move(Entity entity, Point p){
        for(Entity e:entities){
            if(e.getPosition().equals(p)){
                return;
            }
        }
        mapGrid.get(entity.getPosition()).moveEntity(mapGrid.get(p));
        entity.setPosition(p);
    }

    public static void game(){
        init();
        while(initialized){
            Turn();
        }
    }
}