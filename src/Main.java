import java.util.Scanner;

public class Main {

    public  static void press(){
        Scanner input=new Scanner(System.in);
        System.out.print("Press Enter Key To Continues.....!!");
        input.nextLine();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice=0;
        int floor=0;
        int room=0;
        String ownerName = "";

        String condo[][]= new String[0][]; // floor , room
        boolean floorValid=false;
        boolean roomValid=false;
        do {
            System.out.println("");
            System.out.println("+++++++++++++++[Set-Up-The-Condo]+++++++++++++++");
            System.out.print("=>> Enter The Condo Floor : ");
             floor = input.nextInt();
            if (floor > 0) {
                floorValid = true;
                System.out.print("=>> Enter The Condo Room  : ");
                room = input.nextInt();
                if (room > 0) {

                    roomValid = true;
                    //condo set up
                    condo = new String[floor][room];
                    System.out.println("---------------------------------------------------");
                    System.out.println("Good Job !! Successfully You set up  the condo  ");
                    System.out.println("---------------------------------------------------");

                    //(condition) if 1 no s && if 2 up have s
                    if (floor == 1) {
                        System.out.println("Floor : [" + floor + "] floor");
                    } else {
                        System.out.println("Floor : [" + floor + "] floors");
                    }
                    if (room == 1) {
                        System.out.println("Floor : [" + room + "] room");
                    } else {
                        System.out.println("Room  : [" + room + "] rooms");
                    }
                    System.out.println("Total Condo Room   : [" + (floor * room) + "] Rooms");
                }
                else {
                    System.out.println("-------------------------------------X------------------------------------");
                    System.out.println("\t\tEnter Again the number of  Room cant be Zero OR Negative !!");
                    System.out.println("-------------------------------------X------------------------------------");
                }

            }
            else {
                System.out.println("-------------------------------------X------------------------------------");
                System.out.println("\t\tEnter Again the number of  Floor cant be Zero OR Negative !!");
                System.out.println("-------------------------------------X------------------------------------");

            }
        }
        while (!floorValid || !roomValid);
            do {
                System.out.println("");
                System.out.println("[<====================WELCOME TO OUR CONDO====================>]");
                System.out.println("1.Customer Buy  Condo");
                System.out.println("2.Customer Sell Condo back");
                System.out.println("3.Search Condo Information");
                System.out.println("4.Display Condo Information");
                System.out.println("5.Exist");
                System.out.println("------------------------------------");
                System.out.print("Please Choose Option from (1--5) :");
                choice = input.nextInt();

                first: switch (choice) {
                    case 1: //insert buying room to array index
                        int floorChoice=0;
                        int roomChoice = 0;
                        boolean inputValid=false;
                        int buyingOption = 0;


                        do{
                            System.out.println("-------------------------Customer-Buy-Condo-------------------------");
                            System.out.print("=>>Enter Number of Floor you want ( 1-" + floor + " ) : ");
                            floorChoice= input.nextInt();
                            if (floorChoice>0 && floorChoice<=floor){
                                System.out.print("=>>Enter Number of Room you want ( 1-" + room + " )\" : ");
                                roomChoice = input.nextInt();
                                input.nextLine();
                                if(roomChoice>0 && roomChoice<=room){
                                    if (condo[floorChoice-1][roomChoice-1]==null){
                                        roomValid=true;
                                        inputValid=true;
                                        System.out.print("=>>Enter Owner Name :");
                                        ownerName = input.nextLine();
                                        condo[floorChoice - 1][roomChoice - 1] = ownerName; //add owner into index
                                        System.out.println("---------------------------------------------------");
                                        System.out.println("congratulations !! U have Your Own Condo ");
                                        System.out.println("---------------------------------------------------");
                                    }else{
                                        System.out.println("==================================================");
                                        System.out.println("Room is Unavailable PLease Input  another room !!");
                                        System.out.println("==================================================");
                                        roomValid=false;

                                    }

                                }else{
                                    System.out.println("========================================================================");
                                    System.out.println(" Room Number is invalid, " + "Please Enter Again! [1-" + room +"]");
                                    System.out.println("========================================================================");

                                    roomValid =false;
                                }

                            } else{
                                System.out.println(" Floor Number is invalid, " + "Please Enter Again! [1-" + floor + "]");
                                floorValid =false;
                            }


                        }while(!inputValid);
                        press();

                        break;
                    case 2:
                        System.out.println("----------------- Selling the Condo Back -----------------");
                        System.out.print("-> Enter the floor you want to sell : ");
                        floorChoice = input.nextInt();
                        System.out.print("-> Enter the room you want to sell : ");
                        roomChoice = input.nextInt();

                        if(floorChoice > 0 && floorChoice <= floor && roomChoice > 0 && roomChoice <= room){
                            if(condo[floorChoice-1][roomChoice-1] != null){
                                System.out.println(">> Selected Condo Information :");
                                System.out.println("==========================================================================");

                                System.out.println("Floor : " + floorChoice + "   " + " Room : " + roomChoice +
                                        "    Belong to : " + ownerName);
                                System.out.println("==========================================================================");

                                System.out.print("Enter 1 to confirm and 0 to cancel : ");
                                int option = input.nextInt();
                                if(option == 1){
                                    condo[floorChoice-1][roomChoice-1] = null;
                                    System.out.println("==========================================================================");
                                    System.out.println("Congratulations, you have successfully sold the condo ...");
                                    System.out.println("==========================================================================");

                                }else if(option == 0){
                                    System.out.println("=============================================");
                                    System.out.println("You have cancelled to sell the condo.");
                                    System.out.println("=============================================");

                                }else {
                                    System.out.println("=============================================");
                                    System.out.println("Please Input Again (1 or 0) :");
                                    System.out.println("=============================================");

                                }
                            }else{
                                System.out.println("=============================================================");
                                System.out.println("You Cannot Sell The Condo!! It Not Your.....");
                                System.out.println("=============================================================");

                            }
                        }else{
                            System.out.println("=============================================================");
                            System.out.println("Problem!!! Floor and room is Not in Our System.");
                            System.out.println("=============================================================");

                        }
                        press();
                        break;

                     case 3:
                        String searchOwner;
                        System.out.println("----------------------------Search-Condo-Information-----------------------------");
                        System.out.print("Enter Owner Name to Search:");
                        input.nextLine();
                        searchOwner= input.nextLine();
                         for (int row = 0; row < condo.length; row++)
                        {
                            for (int col = 0; col < condo[row].length; col++) {
                                if (condo[row][col]!=null && searchOwner.equals(condo[row][col])){
                                    System.out.println("====================================================================================");
                                    System.out.println("Owner By : " +condo[row][col] +"  Floor :"+( row+1 )+"  Room No :" +(col+1));
                                    System.out.println("====================================================================================");
                                    press();
                                    break first;
                                }

                            }
                        }
                         System.out.println("=========================================");
                         System.out.println("Our System Don't have this name !");
                         System.out.println("=========================================");


                         break;

                    case 4:
                        System.out.println("-------------------------Display All Condo -------------------------");
                        System.out.println("=====================================================================");
                        for (int row = condo.length-1; row >= 0; row--)
                        {
                            System.out.print("Floor [" + (row +1) + "] :");
                            for (int col = 0; col < condo[row].length; col++) {
                                System.out.print("["+condo[row][col]+"]" + "  ");
                            }
                            System.out.println();
                        }
                        System.out.println("=====================================================================");
                        press();

                        break;
                    case 5:
                        System.out.println("==================================");
                        System.out.println("Thank You For Coming ><");
                        System.out.println("==================================");
                        break;
                    default:
                        System.out.println("==================================");
                        System.out.println(" Invalid Numbers Try Again!!");
                        System.out.println("==================================");

                }

            }while (choice!=5);

    }
}