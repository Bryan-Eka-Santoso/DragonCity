import java.util.*;

public class App {
    static void displayMenu(int menuCtr){
        if(menuCtr == 1){
            System.out.println("=== Dragon City ===");
            System.out.println("| > Login         |");
            System.out.println("|   Register      |");
            System.out.println("|   Exit          |");
            System.out.println("===================");
            System.out.print(">> ");
        } else if(menuCtr == 2){
            System.out.println("=== Dragon City ===");
            System.out.println("|   Login         |");
            System.out.println("| > Register      |");
            System.out.println("|   Exit          |");
            System.out.println("===================");
            System.out.print(">> ");
        } else if(menuCtr == 3){
            System.out.println("=== Dragon City ===");
            System.out.println("|   Login         |");
            System.out.println("|   Register      |");
            System.out.println("| > Exit          |");
            System.out.println("===================");
            System.out.print(">> ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        Random rand = new Random();

        int menuDetailDragon;
        int menuShop;
        int menuCtr = 1;
        int menuOption = 1;
        String menuAwal;

        String keyGame;
        int x = 11;
        int y = 4;
        Boolean isGetBerry = false;

        ArrayList<User> user = new ArrayList<>();
        user.add(new User("123", "123", "123"));

        String[] jenisDragon = {"Infernos", "Azurith", "Verdalis"};
        String[] elemenDragon = {"Fire", "Water", "Flora"};

        char[][] worldMap = {
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', },
            {'|', ' ', ' ', ' ', ' ', '|', ' ', 'B', ' ', '|', ' ', 'S', ' ', '|', ' ', 'H', ' ', '|', ' ', ' ', ' ', ' ', '|', },
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', },
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', },
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', },
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', },
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', },
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', },
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', }
        };
        
        do {
            do {
                displayMenu(menuCtr);
                
                menuAwal = scanS.nextLine();
                if(menuAwal.equals("s") && menuCtr < 3){
                    menuCtr++;
                } else if(menuAwal.equals("w") && menuCtr > 1){
                    menuCtr--;
                }
            } while (menuAwal.equals("w") && menuAwal.equals("s") && !menuAwal.isEmpty());
            
            if(!menuAwal.equals("w") && !menuAwal.equals("s") && !menuAwal.isEmpty()){
                System.out.println("Invalid Input");
            }

            if(menuAwal.isEmpty() && menuCtr == 1){
                menuOption = 1;
            } else if(menuAwal.isEmpty() && menuCtr == 2){
                menuOption = 2;
            } else if(menuAwal.isEmpty() && menuCtr == 3){
                menuOption = 3;
            }

            if(menuAwal.isEmpty()){
                if(menuOption == 1){
                    String username, password;
                    Boolean isLogin;
                    Boolean adaUsn = false;
                    Boolean isUsnPwTrue = false;
                    int indexPlayer = 0;

                    System.out.println("=== Login ===");
                    System.out.print("Username: ");
                    username = scanS.nextLine();
                    System.out.print("Password: ");
                    password = scanS.nextLine();
                    
                    for(int i = 0; i < user.size(); i++){
                        if(username.equals(user.get(i).getUsername())){
                            adaUsn = true;
                            indexPlayer = i;
                        }
                        if(password.equals(user.get(indexPlayer).getPassword())){
                            isUsnPwTrue = true;
                        }
                    }
                    
                    if(!adaUsn){
                        System.out.println("Username tidak terdaftar.");
                    } else if(!isUsnPwTrue){
                        System.out.println("Username dan password salah!");
                    }

                    if(adaUsn && isUsnPwTrue){
                        System.out.println("Berhasil login!");
                        char[][] map = new char[9][23];
                        for (int i = 0; i < worldMap.length; i++) {
                            for (int j = 0; j < worldMap[0].length; j++) {
                                map[i][j] = worldMap[i][j];
                            }
                        }
                        for (Dragon dragon : user.get(indexPlayer).listDragon) {
                            dragon.setDragonXY(map);
                        }
                        do {
                            map[y][x] = 'P';
                            System.out.println("===================");
                            System.out.println("Day " + user.get(indexPlayer).getDay() + ", Welcome " + user.get(indexPlayer).getName());
                            System.out.println("===================");
                            System.out.println("Incubator");
                            if(user.get(indexPlayer).incubatorProgress.size() > 0){
                                System.out.println(user.get(indexPlayer).incubatorProgress.get(0).jenisDragon + " (" + user.get(indexPlayer).incubatorProgress.get(0).dayIncubator + "/4)");
                            } else {
                                System.out.println("- Empty -");
                            }
                            System.out.println("===================");
                            System.out.println("Coin\t: " + user.get(indexPlayer).getCoin() + "G");
                            System.out.println("Berry\t: " + user.get(indexPlayer).getBerry());
                            for(int i = 0; i < map.length; i++){
                                for(int j = 0; j < map[0].length; j++){
                                    System.out.print(map[i][j]);
                                }
                                System.out.println();
                            }
                            System.out.print(">> ");
                            keyGame = scanS.nextLine();
    
                            if(keyGame.equals("w") && (map[y-1][x] == ' ' || map[y-1][x] == 'S' || map[y-1][x] == 'B' || map[y-1][x] == 'H' || map[y-1][x] == 'I' || map[y-1][x] == 'A' || map[y-1][x] == 'V')){
                                map[y][x] = ' ';
                                y--;
                            } else if(keyGame.equals("a") && (map[y][x-1] == ' ' || map[y][x-1] == 'S' || map[y][x-1] == 'B' || map[y][x-1] == 'H' || map[y][x-1] == 'I' || map[y][x-1] == 'A' || map[y][x-1] == 'V')){
                                map[y][x] = ' ';
                                x--;
                            } else if(keyGame.equals("s") && (map[y+1][x] == ' ' || map[y+1][x] == 'S' || map[y+1][x] == 'B' || map[y+1][x] == 'H' || map[y+1][x] == 'I' || map[y+1][x] == 'A' || map[y+1][x] == 'V')){
                                map[y][x] = ' ';
                                y++;
                            } else if(keyGame.equals("d") && (map[y][x+1] == ' ' || map[y][x+1] == 'S' || map[y][x+1] == 'B' || map[y][x+1] == 'H' || map[y][x+1] == 'I' || map[y][x+1] == 'A' || map[y][x+1] == 'V')){
                                map[y][x] = ' ';
                                x++;
                            }

                            char symbolPosition = map[y][x];
                            
                            if(map[y][x] == 'S'){
                                do {
                                    System.out.println("== Choose a Dragon ==");
                                    System.out.println("Your Coin: " + user.get(indexPlayer).getCoin() + "G");
                                    System.out.println("1. Infernos - Fire");
                                    System.out.println("2. Azurith - Water");
                                    System.out.println("3. Verdalis - Flora");
                                    System.out.println("0. Exit");
                                    do {
                                        System.out.print(">> ");
                                        menuShop = scanI.nextInt();
                                    } while (menuShop < 0 || menuShop > 3);

                                    if(menuShop == 0){
                                        break;
                                    } else if(user.get(indexPlayer).getCoin() < 50){
                                        System.out.println("Your coins aren't enough");
                                    } else {
                                        Boolean isNameOke = false;

                                        System.out.println(jenisDragon[menuShop-1] + " acruiqed");
                                        do {
                                            System.out.print("Name your " + jenisDragon[menuShop-1] + " (Max 10 chars): ");
                                            String nameDragon = scanS.nextLine();

                                            Boolean isUniqueName = user.get(indexPlayer).cekNamaDragon(indexPlayer, nameDragon);
                                            
                                            if(nameDragon.length() < 11 && isUniqueName){
                                                Dragon newDragon = new Dragon(nameDragon, jenisDragon[menuShop-1], 1, 1, 1, 0, elemenDragon[menuShop-1]);
                                                user.get(indexPlayer).addDragon(newDragon);
                                                newDragon.setDragonXY(map);
                                                break;
                                            } else if(!isUniqueName){
                                                System.out.println("Name already taken!");
                                            } else {
                                                System.out.println("Max 10 chars!");
                                            }
                                        } while(!isNameOke);
                                        int coinAfterBuy = user.get(indexPlayer).getCoin() - 50;
                                        user.get(indexPlayer).setCoin(coinAfterBuy);
                                    }
                                } while (menuShop != 0);
                                if(keyGame.equals("w")){
                                    y++;
                                    map[y-1][x] = symbolPosition;
                                } else if(keyGame.equals("a")){
                                    x++;
                                    map[y][x-1] = symbolPosition;
                                } else if(keyGame.equals("s")){
                                    y--;
                                    map[y+1][x] = symbolPosition;
                                } else if(keyGame.equals("d")){
                                    x--;
                                    map[y][x+1] = symbolPosition;
                                }
                            } else if(map[y][x] == 'B'){
                                if(isGetBerry == false){
                                    int plusBerry = user.get(indexPlayer).getBerry() + 50;
                                    user.get(indexPlayer).setBerry(plusBerry);
                                    System.out.println("You got 50 berries");
                                    isGetBerry = true;
                                } else {
                                    System.out.println("Berry already taken");
                                }
                                if(keyGame.equals("w")){
                                    y++;
                                    map[y-1][x] = symbolPosition;
                                } else if(keyGame.equals("a")){
                                    x++;
                                    map[y][x-1] = symbolPosition;
                                } else if(keyGame.equals("s")){
                                    y--;
                                    map[y+1][x] = symbolPosition;
                                } else if(keyGame.equals("d")){
                                    x--;
                                    map[y][x+1] = symbolPosition;
                                }
                            } else if(map[y][x] == 'H'){
                                int nextDay = user.get(indexPlayer).getDay() + 1;
                                user.get(indexPlayer).setDay(nextDay);
                                System.out.println("You rest for the day");
                                if(user.get(indexPlayer).incubatorProgress.size() != 0){
                                    user.get(indexPlayer).incubatorProgress.get(0).dayIncubator++;
                                }
                                isGetBerry = false;
                                if(keyGame.equals("w")){
                                    y++;
                                    map[y-1][x] = symbolPosition;
                                } else if(keyGame.equals("a")){
                                    x++;
                                    map[y][x-1] = symbolPosition;
                                } else if(keyGame.equals("s")){
                                    y--;
                                    map[y+1][x] = symbolPosition;
                                } else if(keyGame.equals("d")){
                                    x--;
                                    map[y][x+1] = symbolPosition;
                                }
                                if(user.get(indexPlayer).incubatorProgress.size() != 0){
                                    user.get(indexPlayer).cekIncubator(map);
                                }
                            } else if(map[y][x] == 'I' || map[y][x] == 'A' || map[y][x] == 'V'){
                                int iDragon = 0;
                                int menuMatchD = 0;
                                do {
                                    for (int i = 0; i < user.get(indexPlayer).listDragon.size(); i++) {
                                        if(user.get(indexPlayer).listDragon.get(i).xDragon == x && user.get(indexPlayer).listDragon.get(i).yDragon == y){
                                            iDragon = i;
                                            user.get(indexPlayer).listDragon.get(i).selected = true;
                                            user.get(indexPlayer).incubatorMatch.add(user.get(indexPlayer).listDragon.get(i));
                                            break;
                                        }
                                    }
                                    System.out.println("====================");
                                    System.out.println(user.get(indexPlayer).listDragon.get(iDragon).nameDragon + " (" + user.get(indexPlayer).listDragon.get(iDragon).jenisDragon + ")");
                                    System.out.println("====================");
                                    System.out.println("Level: " + user.get(indexPlayer).listDragon.get(iDragon).level);
                                    System.out.println("Exp: " + user.get(indexPlayer).listDragon.get(iDragon).exp + "/" + user.get(indexPlayer).listDragon.get(iDragon).maximumExp);
                                    System.out.println("====================");
                                    System.out.println("1. Feed");
                                    System.out.println("2. Match this Dragon");
                                    System.out.println("0. Exit");
                                    do {                                      
                                        System.out.print(">> ");
                                        menuDetailDragon = scanI.nextInt();
                                    } while (menuDetailDragon < 0 || menuDetailDragon > 2);

                                    if(menuDetailDragon == 1){
                                        String inputFeed;
                                        Boolean isPlus = true;
                                        int amountFeed = 10;
                                        do {
                                            if(isPlus){
                                                System.out.println("Choose an amount to feed");
                                                System.out.println("===============");
                                                System.out.println("| " + amountFeed + " | <+> - |");
                                                System.out.println("===============");
                                            } else {
                                                System.out.println("Choose an amount to feed");
                                                System.out.println("===============");
                                                System.out.println("| " + amountFeed + " | + <-> |");
                                                System.out.println("===============");
                                            }

                                            System.out.print(">> ");
                                            inputFeed = scanS.nextLine();
                                            if(inputFeed.equals("a")){
                                                isPlus = true;
                                            } else if(inputFeed.equals("d")){
                                                isPlus = false;
                                            } else if(inputFeed.isEmpty()){
                                                if(isPlus && amountFeed < 90){
                                                    amountFeed += 10;
                                                }
                                                if(!isPlus && amountFeed > 10){
                                                    amountFeed -= 10;
                                                }
                                            } else if(inputFeed.equals("e")){
                                                if(amountFeed > user.get(indexPlayer).getBerry()){
                                                    System.out.println("Your berry isn't enough");
                                                } else {
                                                    System.out.println(amountFeed);
                                                    user.get(indexPlayer).berry -= amountFeed;
                                                    user.get(indexPlayer).listDragon.get(iDragon).cekLevelUp(amountFeed);
                                                    System.out.println("Your dragon has been fed");
                                                    break;
                                                }
                                            }
                                        } while(!inputFeed.equals("e"));
                                    } else if(menuDetailDragon == 2){
                                        do {
                                            Boolean isMatch = false;
                                            System.out.println("===============================");
                                            System.out.println("|      Select Two Dragons     |");
                                            System.out.println("===============================");
                                            System.out.printf("| %-12s |", "1st Dragon");
                                            System.out.printf(" %-12s |\n", "2nd Dragon");
                                            System.out.printf("| %-12s |", user.get(indexPlayer).listDragon.get(iDragon).nameDragon);
                                            System.out.printf(" %-12s |\n", "-");
                                            System.out.println("===============================");
                                            for(int i = 0; i < user.get(indexPlayer).listDragon.size(); i++){
                                                if(user.get(indexPlayer).listDragon.get(i).selected == false){
                                                    System.out.println((i+1) + ". " + user.get(indexPlayer).listDragon.get(i).nameDragon + " (" + user.get(indexPlayer).listDragon.get(i).jenisDragon + ")");
                                                } else {
                                                    System.out.println((i+1) + ". " + user.get(indexPlayer).listDragon.get(i).nameDragon + " (" + user.get(indexPlayer).listDragon.get(i).jenisDragon + ") <selected>");
                                                }
                                            }

                                            do {          
                                                System.out.print(">> ");
                                                menuMatchD = scanI.nextInt();
                                            } while (menuMatchD < 1 || menuMatchD > user.get(indexPlayer).listDragon.size());
                                            if(user.get(indexPlayer).listDragon.get(menuMatchD-1).jenisDragon != "Infernos" && user.get(indexPlayer).listDragon.get(menuMatchD-1).jenisDragon != "Azurith" && user.get(indexPlayer).listDragon.get(menuMatchD-1).jenisDragon != "Verdalis"){
                                                if(user.get(indexPlayer).listDragon.get(menuMatchD-1).jenisDragon == user.get(indexPlayer).listDragon.get(iDragon).jenisDragon){
                                                    user.get(indexPlayer).listDragon.get(menuMatchD-1).selected = true;
                                                    user.get(indexPlayer).incubatorMatch.add(user.get(indexPlayer).listDragon.get(menuMatchD-1));
                                                    isMatch = true;
                                                } else {
                                                    System.out.println("You cannot match this dragon");
                                                }
                                            } else if(user.get(indexPlayer).listDragon.get(menuMatchD-1).selected == false){
                                                user.get(indexPlayer).listDragon.get(menuMatchD-1).selected = true;
                                                user.get(indexPlayer).incubatorMatch.add(user.get(indexPlayer).listDragon.get(menuMatchD-1));
                                                isMatch = true;
                                            } else {
                                                System.out.println("You already selected this dragon");
                                            }

                                            if(isMatch){
                                                System.out.println("===============================");
                                                System.out.println("|      Select Two Dragons     |");
                                                System.out.println("===============================");
                                                System.out.printf("| %-12s |", "1st Dragon");
                                                System.out.printf(" %-12s |\n", "2nd Dragon");
                                                System.out.printf("| %-12s |", user.get(indexPlayer).listDragon.get(iDragon).nameDragon);
                                                System.out.printf(" %-12s |\n", user.get(indexPlayer).listDragon.get(menuMatchD-1).nameDragon);
                                                System.out.println("===============================");
                                                for(int i = 0; i < user.get(indexPlayer).listDragon.size(); i++){
                                                    if(user.get(indexPlayer).listDragon.get(i).selected == false){
                                                        System.out.println((i+1) + ". " + user.get(indexPlayer).listDragon.get(i).nameDragon + " (" + user.get(indexPlayer).listDragon.get(i).jenisDragon + ")");
                                                    } else {
                                                        System.out.println((i+1) + ". " + user.get(indexPlayer).listDragon.get(i).nameDragon + " (" + user.get(indexPlayer).listDragon.get(i).jenisDragon + ") <selected>");
                                                    }
                                                }
                                                Boolean isYes;
                                                String inputSelection;
                                                System.out.print("Confirm your selection? (y/n): ");
                                                inputSelection = scanS.nextLine();

                                                if(user.get(indexPlayer).incubatorProgress.size() == 0){
                                                    isYes = true;
                                                } else {
                                                    isYes = false;
                                                }

                                                if(inputSelection.equals("y") && isYes){
                                                    String nameNewDragonInc;
                                                    int randDominan = rand.nextInt(2);

                                                    if(user.get(indexPlayer).incubatorMatch.get(0).jenisDragon == user.get(indexPlayer).incubatorMatch.get(1).jenisDragon){
                                                        nameNewDragonInc = user.get(indexPlayer).incubatorMatch.get(0).jenisDragon;
                                                    } else {
                                                        if(randDominan == 0){
                                                            String name1 = user.get(indexPlayer).incubatorMatch.get(0).jenisDragon;
                                                            String name2 = user.get(indexPlayer).incubatorMatch.get(1).jenisDragon;
                                                            String name1Substr = name1.length() > 3 ? name1.substring(0, name1.length() - 3) : name1;
                                                            String name2Substr = name2.length() >= 3 ? name2.substring(name2.length() - 3) : name2;
                                                            nameNewDragonInc = name1Substr + name2Substr;
                                                        } else {
                                                            String name1 = user.get(indexPlayer).incubatorMatch.get(1).jenisDragon;
                                                            String name2 = user.get(indexPlayer).incubatorMatch.get(0).jenisDragon;
                                                            String name1Substr = name1.length() > 3 ? name1.substring(0, name1.length() - 3) : name1;
                                                            String name2Substr = name2.length() >= 3 ? name2.substring(name2.length() - 3) : name2;
                                                            nameNewDragonInc = name1Substr + name2Substr;
                                                        }
                                                    }

                                                    Dragon dragonInc = new Dragon(nameNewDragonInc, nameNewDragonInc, 1, 1, 1, 0, user.get(indexPlayer).incubatorMatch.get(randDominan).elemenDragon);
                                                    System.out.println("New Dragon Created!");
                                                    System.out.println("Incubating " + nameNewDragonInc + " Eg...");

                                                    // for(int i = 0; i < user.get(indexPlayer).incubatorMatch.size(); i++){
                                                    //     System.out.println(user.get(indexPlayer).incubatorMatch.get(i).jenisDragon);
                                                    // }

                                                    user.get(indexPlayer).incubatorProgress.add(dragonInc);
                                                    user.get(indexPlayer).incubatorMatch.clear();
                                                    break;
                                                } else if(!isYes){
                                                    System.out.println("The incubator is occupied, come back later");
                                                    for(int i = 0; i < user.get(indexPlayer).listDragon.size(); i++){
                                                        if(user.get(indexPlayer).listDragon.get(indexPlayer).selected == true){
                                                            user.get(indexPlayer).listDragon.get(i).selected = false;
                                                        }
                                                    }
                                                    user.get(indexPlayer).incubatorMatch.clear();
                                                    break;
                                                } else {
                                                    if(!inputSelection.equals("n")){
                                                        System.out.println("Invalid input!");
                                                    } else {
                                                        System.out.println("Match Cancelled");
                                                    }
                                                    user.get(indexPlayer).listDragon.get(iDragon).selected = false;
                                                    user.get(indexPlayer).listDragon.get(menuMatchD-1).selected = false;

                                                    user.get(indexPlayer).incubatorMatch.clear();
                                                    break;
                                                }
                                            }
                                        } while (menuMatchD != 0);
                                        user.get(indexPlayer).listDragon.get(iDragon).selected = false;
                                        user.get(indexPlayer).listDragon.get(menuMatchD-1).selected = false;
                                    }
                                } while (menuDetailDragon != 0);
                                user.get(indexPlayer).listDragon.get(iDragon).selected = false;
                                user.get(indexPlayer).listDragon.get(menuMatchD-1).selected = false;
                                
                                if(keyGame.equals("w")){
                                    y++;
                                    map[y-1][x] = symbolPosition;
                                } else if(keyGame.equals("a")){
                                    x++;
                                    map[y][x-1] = symbolPosition;
                                } else if(keyGame.equals("s")){
                                    y--;
                                    map[y+1][x] = symbolPosition;
                                } else if(keyGame.equals("d")){
                                    x--;
                                    map[y][x+1] = symbolPosition;
                                }
                            }
                        } while (!keyGame.equals("l") && !keyGame.equals("i"));
                        x = 11;
                        y = 4;
                    }

                } else if(menuOption == 2){
                    String name, username, password, confirmPassword;
                    Boolean isRegist = true;
    
                    System.out.println("=== Register ===");
                    System.out.print("Name: ");
                    name = scanS.nextLine();
                    System.out.print("Username: ");
                    username = scanS.nextLine();
                    System.out.print("Password: ");
                    password = scanS.nextLine();
                    System.out.print("Confirm Password: ");
                    confirmPassword = scanS.nextLine();
    
                    for(int i = 0; i < user.size(); i++){
                        if(username.equals(user.get(i).getUsername())){
                            System.out.println("Username sudah terdaftar!");
                            isRegist = false;
                        }
                    }

                    if(confirmPassword.equals(password)){
                        isRegist = true;
                    } else {
                        System.out.println("Password harus sama!");
                    }
    
                    if(isRegist){
                        User baru = new User(name, username, password);
                        user.add(baru);
                        System.out.println("Berhasil registrasi!");
                    }
                }
            }
        } while(menuOption != 3);
    }
}
