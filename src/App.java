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
        
        int menuCtr = 1;
        int menuOption = 1;
        String menuAwal;

        ArrayList<User> user = new ArrayList<>();
        
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

                    System.out.println("=== Login ===");
                    System.out.print("Username: ");
                    username = scanS.nextLine();
                    System.out.print("Password");
                    password = scanS.nextLine();
                    
                    for(int i = 0; i < user.size(); i++){
                        if(username != user.get(i).getUsername()){
                            adaUsn = true;
                        }
                        if(adaUsn && password == user.get(i).getPassword()){
                            isUsnPwTrue = true;
                        }
                    }

                    if(!adaUsn){
                        System.out.println("Username tidak terdaftar.");
                    }

                    if(!isUsnPwTrue){
                        System.out.println("Username dan password salah!");
                    }

                    if(adaUsn && isUsnPwTrue){
                        System.out.println("Berhasil login!");
                        System.out.println("Day 1, Welcome " + username);
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
                        if(username == user.get(i).getUsername()){
                            System.out.println("Username sudah terdaftar!");
                            isRegist = false;
                        }
                    }
    
                    if(confirmPassword == password){
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
