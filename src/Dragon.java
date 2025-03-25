import java.util.*;

public class Dragon {
    String nameDragon;
    String jenisDragon;
    String elemenDragon;
    int level = 1;
    int xDragon;
    int yDragon;
    int exp;
    int maximumExp = 20;
    int dayIncubator = 0;
    Boolean selected = false;
    Boolean canBreed = false;

    static Random rnd = new Random();

    public Dragon(String nameDragon, String jenisDragon, int level, int xDragon, int yDragon, int dayIncubator, String elemenDragon) {
        this.nameDragon = nameDragon;
        this.jenisDragon = jenisDragon;
        this.level = level;
        this.xDragon = xDragon;
        this.yDragon = yDragon;
        this.dayIncubator = dayIncubator;
        this.elemenDragon = elemenDragon;
    }

    public void setDragonXY(char[][] map) {
        int dragonX = 0, dragonY = 0;
        do {
            xDragon = rnd.nextInt(21) + 1;
            yDragon = rnd.nextInt(4) + 3;
        } while (map[yDragon][xDragon] != ' ');
        map[yDragon][xDragon] = this.jenisDragon.charAt(0);
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    
    public void cekLevelUp(int kirimExp) {
        this.exp += kirimExp;
        while(this.exp >= maximumExp) {
            level++;
            this.exp -= maximumExp;
            maximumExp *= 2;
        }
        System.out.println("Level " + level + " achieved!");
    }

}
