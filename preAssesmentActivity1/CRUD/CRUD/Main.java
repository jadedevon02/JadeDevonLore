package CRUD;

import java.util.Scanner;
import java.util.*;
import java.time.*;

class User {
    String code;
    String peri;
    String periType;
    String name;

    User(String code, String peri, String periType, String name) {
        this.code = code;
        this.peri = peri;
        this.periType = periType;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getPeri() {
        return peri;
    }

    public String getperiType() {
        return periType;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Code : " + code + ", Peripheral: " + peri + ", Peripheral Type: " + periType + ", Name of Employee: "
                + name;
    }

}

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int choice;
        String autoCode;
        ArrayList<User> coll = new ArrayList<User>();
        Scanner user = new Scanner(System.in);
        Scanner userInt = new Scanner(System.in);
        Iterator<User> i = coll.iterator();
        String code;

        do {
            System.out.print("""
                    ---- MENU ----
                    1. Add Record
                    2. Display/View Record
                    3. Edit/Update Record
                    4. Delete Record
                    5. Report
                    6. Exit
                    Enter your choice :
                    """);
            choice = user.nextInt();
            if (choice > 6) {
                System.out.println("YOU MUST ENTER A VALID NUMBER!!");
            }
            if (choice <= 0) {
                System.out.println("YOUR MUST ENTER A VALID NUMBER!!");

            }
            String name, emp, type;
            switch (choice) {
                case 1:

                    System.out.print("Component Name(if double word put _ in between): ");
                    name = user.next().toUpperCase();
                    System.out.print("Peripheral Type input/output : ");
                    type = user.next().toUpperCase();
                    ;
                    System.out.print("Add peripheral to Employee (if none type N/A) : ");
                    emp = user.next().toUpperCase();
                    ;
                    System.out.println("");

                    Year yearNow = Year.now();
                    code = yearNow + "-" + codeGenerator();
                    System.out.println("-----------------------------------------");
                    System.out.println("Record Saved!, Your code is : " + code);
                    System.out.println("-----------------------------------------");
                    coll.add(new User(code, name, type, emp));

                    break;
                case 2:
                    System.out.println("-----------------------------------------");
                    System.out.println("""
                            1. View all peripherals
                            2. View available peripherals
                            3. View not available peripherals
                            4. View all input devices
                            5. View all output devices
                            6. View all input/output  devices
                            7. View all employees
                            Enter your choice : """);
                    int in = userInt.nextInt();
                    if (in == 1) {
                        for (User list : coll) {
                            System.out.println("-------------------------------");
                            System.out.println("Code : " + list.getCode());
                            System.out.println("Component name : " + list.getPeri());
                            System.out.println("Peripheral Type : " + list.getperiType());
                            System.out.println("Employee : " + list.getName());
                            System.out.println("-------------------------------");
                        }
                        if(coll.isEmpty()){
                            System.out.println("-------------------------------");
                            System.out.println("NO RECORDS FOUND!!");
                            System.out.println("-------------------------------");

                        }
                    }
                    if (in == 2) {
                        for (User list : coll) {
                            if (list.getName().equals("N/A")) {
                                System.out.println( "-------------------------------------------------------------------------------------------------");
                                System.out.println("Code : " + list.getCode());
                                System.out.println("Available Peripheral are: " + list.getPeri());
                                System.out.println("Peripheral Type : " + list.getperiType());
                                System.out.println("Assigned to Employee: " + list.getName());
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            }
                            if(!list.getName().equals("N/A")){
                                System.out.println("------------------------------");
                                System.out.println("NO AVAILABLE PERIPHERALS!!");
                                System.out.println("------------------------------");
                            }
                           

                        }
                    }
                    if (in == 3) {
                        for (User list : coll) {
                            if (!list.getName().equals("N/A")) {
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------");
                                System.out.println("---------NOT AVAILABLE------------");
                                System.out.println("Code : " + list.getCode());
                                System.out.println("Not Available Peripheral are: " + list.getPeri());
                                System.out.println("Peripheral Type : " + list.getperiType());
                                System.out.println("Employee : " + list.getName());
                                System.out.println(
                                        "-------------------------------------------------------------------------------------------------");

                            }
                        }

                    }
                    if (in == 4) {

                        for (User list : coll) {
                            if (list.getperiType().equals("INPUT")) {
                                System.out.println("-----------------------------");
                                System.out.println("Code : " + list.getCode());
                                System.out.println("Component Name : " + list.getPeri());
                                System.out.println("Input Devices : " + list.getperiType());
                                System.out.println("-----------------------------");

                            }

                        }
                    }
                    if (in == 5) {
                        for (User list : coll) {
                            if (list.getperiType().equals("OUTPUT")) {
                                System.out.println("-----------------------------");
                                System.out.println("Code : " + list.getCode());
                                System.out.println("Component Name : " + list.getPeri());
                                System.out.println("Input Devices : " + list.getperiType());
                                System.out.println("-----------------------------");

                            }
                            if (!list.getperiType().equals("OUTPUT")) {
                                System.out.println("------------------------------");
                                System.out.println("NO AVAILABLE OUTPUT PERIPHERALS!!");
                                System.out.println("------------------------------");
                            }
                            


                        }

                    }
                    if (in == 6) {
                        for (User list : coll) {
                            System.out.println("-------------------------------");
                            System.out.println("Code : " + list.getCode());
                            System.out.println("Component name : " + list.getPeri());
                            System.out.println("Peripheral Type : " + list.getperiType());
                            System.out.println("Employee : " + list.getName());
                            System.out.println("-------------------------------");
                        }

                    }
                    if (in == 7) {
                        for (User list : coll) {
                            System.out.println("----------------------");
                            System.out.println("Code : " + list.getCode());
                            System.out.println("Employee Name : " + list.getName());
                            System.out.println("----------------------");

                        }
                    }
                    break;

                case 3:
                    boolean codeFound = false;
                    System.out.println("Enter Code to Update : ");
                    String codeUpdate = userInt.next();
                    System.out.println(" ");
                    i = coll.iterator();
                    while (i.hasNext()) {
                        User u = i.next();
                        if (u.getCode().equalsIgnoreCase(codeUpdate)) {
                            codeFound = true;
                            System.out.println("Enter new Component Type : ");
                            name = user.next();
                            System.out.println("Enter new Peripheral Type : ");
                            type = user.next();
                            System.out.println("Enter new Employee name to assigned : ");
                            emp = user.next();
                            coll.set(0, new User(codeUpdate, name, type, emp));

                            System.out.println("--------------------------------------");
                            System.out.println("NEW RECORD, RECORDED!!");
                            System.out.println("--------------------------------------");

                        }

                    }
                    if (!codeFound) {
                        System.out.println("Code not Found in the list!!");
                    }
                break;

                case 4 :
                    boolean found = false;
                    System.out.println("Enter Code to Delete : ");
                    String codeDel = userInt.next();
                    System.out.println(" ");
                    i = coll.iterator();
                    while (i.hasNext()) {
                        User u = i.next();
                        if (u.getCode().equalsIgnoreCase(codeDel)) {
                            i.remove();
                            found = true;

                        }
                    }
                    if (!found) {
                        System.out.println("Code not Found in the list!!");
                    } 
                    else {
                        System.out.println("--------------------------------------");
                        System.out.println("Code Deleted Successfully!");
                        System.out.println("--------------------------------------");

                    }

                    break;

                case 5:
                    System.out.println("""
                            1. Number of available peripherals
                            2. Number of assigned peripherals
                            3. Number of input device
                            4. Number of output device
                            5. Number of employees with peripherals assigned
                            Enter your choice:  """);
                    in = userInt.nextInt();

                    if (in == 1) {
                        for (User list : coll) {
                            if (list.getName().equals("N/A")) {
                                System.out.println("-------------------------------");
                                System.out.println("Code : " + list.getCode());
                                System.out.println("Available Peripheral are: " + list.getPeri());
                                System.out.println("Peripheral Type : " + list.getperiType());
                                System.out.println("Employee name : " + list.getName());
                                System.out.println("-------------------------------");
                            }
                            if (!list.getName().equals("N/A")) {
                                System.out.println("-------------------------------");
                                System.out.println("NO AVAILABLE PERIPHERALS!!");
                                System.out.println("-------------------------------");

                            }

                        }

                    }

                    if (in == 2) {
                        for (User list : coll) {
                            if (!list.getName().equals("N/A")) {
                                System.out.println("-------------------------------");
                                System.out.println("Code : " + list.getCode());
                                System.out.println("Component name : " + list.getPeri());
                                System.out.println("Peripheral Type : " + list.getperiType());
                                System.out.println("Employee : " + list.getName());
                                System.out.println("-------------------------------");

                            }
                        }

                    }
                    if (in == 3) {
                        for (User list : coll) {
                            if (list.getperiType().equals("INPUT")) {
                                System.out.println("-----------------------------");
                                System.out.println("Code : " + list.getCode());
                                System.out.println("Component Name : " + list.getPeri());
                                System.out.println("Peripheral Type : " + list.getperiType());
                                System.out.println("-----------------------------");

                            }

                        }

                    }
                    if (in == 4) {
                        for (User list : coll) {
                            if (list.getperiType().equals("OUTPUT")) {
                                System.out.println("-----------------------------");
                                System.out.println("Code : " + list.getCode());
                                System.out.println("Component Name : " + list.getPeri());
                                System.out.println("Peripheral Type : " + list.getperiType());
                                System.out.println("-----------------------------");

                            }
                            if (!list.getName().equals("OUTPUT")) {
                                System.out.println("-------------------------------");
                                System.out.println("NO AVAILABLE OUTPUT PERIPHERALS!!");
                                System.out.println("-------------------------------");

                            }
                        }

                    }
                    if (in == 5) {
                        for (User list : coll) {
                            if (!list.getName().equals("N/A")) {
                                System.out.println("-------------------------------");
                                System.out.println("Code : " + list.getCode());
                                System.out.println("Component name : " + list.getPeri());
                                System.out.println("Peripheral Type : " + list.getperiType());
                                System.out.println("Employee : " + list.getName());
                                System.out.println("-------------------------------");

                            }
                        }

                    }

                    if (in <= 0) {
                        System.out.println("-------------------------------");
                        System.out.println("ENTER A VALID CHOICE!!");
                        System.out.println("-------------------------------");

                    }
                    if (in >= 6) {
                        System.out.println("-------------------------------");
                        System.out.println("ENTER A VALID CHOICE!!");
                        System.out.println("-------------------------------");

                    }

                    break;

                case 6:
                    System.out.println("----------------------------------");
                    System.out.println("YOU EXITED THE PROGRAM!!");
                    System.out.println("YOU EXITED THE PROGRAM!!");
                    System.out.println("YOU EXITED THE PROGRAM!!");
                    System.out.println("----------------------------------");

                    choice = 6;
            }
        } while (choice != 6);

    }

    public static int code = 1;

    public static String codeGenerator() {
        String codeGen = String.format("%04d", code++);
        return codeGen;
    }
}
