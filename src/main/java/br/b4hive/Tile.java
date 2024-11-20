package br.b4hive;

public class Tile {
    private Entity entity;
    //Item drop;
    private String groundType;

    public Tile(){
        //temp code
        String temp = "#%$X";
        char id = temp.charAt( (int) (Math.random()*4) );
        this.groundType = String.valueOf(id);
        this.entity = null;
    }
    public Tile(String groundType){
        this.groundType = groundType;
        this.entity = null;
    }

    public void placeEntity(Entity entity){
        this.entity = entity;
    }
    public Entity getEntity(){
        return entity;
    }
    public void removeEntity(){
        this.entity = null;
    }
    //public Item pickUpItem(){
    //public void dropItem(Item drop){
    public String getGroundType() {
        return groundType;
    }
    public void setGroundType(String groundType) {
        this.groundType = groundType;
    }
}
