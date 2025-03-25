import java.util.*;

public class User {
    Scanner scanI = new Scanner(System.in);
    Scanner scanS = new Scanner(System.in);
    Random rand = new Random();

    int day = 1;
    int coin = 100;
    int berry = 40;
    String name;
    protected String username;
    protected String password;

    ArrayList<Dragon> listDragon = new ArrayList<>();
    ArrayList<Dragon> incubatorMatch = new ArrayList<>();
    ArrayList<Dragon> incubatorProgress = new ArrayList<>();

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getBerry() {
        return berry;
    }

    public void setBerry(int berry) {
        this.berry = berry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Dragon> getListDragon() {
        return listDragon;
    }

    public void setListDragon(ArrayList<Dragon> listDragon) {
        this.listDragon = listDragon;
    }

    public void addDragon(Dragon dragon) {
        listDragon.add(dragon);
        System.out.println("Dragon " + dragon.jenisDragon + " successfully added.");
    }
    
    public Boolean cekNamaDragon(int indexPlayer, String nameDragon) {
        Boolean isUniqueName = true;
        for (int i = 0; i < listDragon.size(); i++) {
            if (nameDragon.equals(listDragon.get(i).nameDragon)){
                isUniqueName = false;
                break;
            }
        }
        return isUniqueName;
    }
    
    public void cekIncubator(char[][] map){
        if(incubatorProgress.get(0).dayIncubator >= 4){
            System.out.println("Your " + incubatorProgress.get(0).nameDragon + " Egg Hatched!");
            Boolean isNameOke = false;
            Boolean isUniqueName;
    
            do {
                System.out.print("Name your " + incubatorProgress.get(0).nameDragon + " (Max 10 chars): ");
                String newNameDragon = scanS.nextLine();
                isUniqueName = true;
    
                for (int i = 0; i < listDragon.size(); i++) {
                    if (newNameDragon.equals(listDragon.get(i).nameDragon)){
                        isUniqueName = false;
                        break;
                    }
                }
    
                if (newNameDragon.length() < 11 && isUniqueName) {
                    Dragon newDragon = new Dragon(newNameDragon, incubatorProgress.get(0).jenisDragon, 1, 1, 1, 0, incubatorProgress.get(0).elemenDragon);
                    addDragon(newDragon);
                    newDragon.setDragonXY(map);
                    isNameOke = true;
                } else if (!isUniqueName) {
                    System.out.println("Name already taken!");
                } else {
                    System.out.println("Max 10 chars!");
                }
    
            } while (!isNameOke);
            incubatorProgress.clear();
        }
    }
    
}
