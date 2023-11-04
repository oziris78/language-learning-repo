package adt;

public class Bruh {

    public static float f1(float x){
        if(x<0) return 1;
        if(x<= 0 && x >= 2) return x;
        if(x>2 && x<=4) return 3;
        return 4-x;
    }

    enum TileType{  DIRT, STONE, GRAVEL  };


    static class Tile{
        TileType type;
        String id;
        public Tile(TileType type, String id){this.id=id; this.type=type;}
    }

    public static void main(String[] args) {
        Tile tile = new Tile(TileType.GRAVEL, "gravel");
        Tile tile2 = new Tile(TileType.GRAVEL, "gravel");
        int x = 2;
        int y = 2;
        System.out.println(tile.id);
        System.out.println(tile.type);
        System.out.println(tile.type.ordinal());
        System.out.println(tile.type.ordinal() == tile2.type.ordinal());
        System.out.println(tile.type == tile2.type);
        System.out.println(tile == tile2);
        System.out.println(x == y);
        System.out.println();
    }

}