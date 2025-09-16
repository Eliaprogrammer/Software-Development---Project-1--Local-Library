package librarysytemproject;

import java.util.*;
import java.io.*;

/**
 * Elia Schwartz
 * September 14, 2025.
 * CEN 3024C - 14877 Software Development 1
 * LibrarySystem.java
 * This class holds all the method and actions librarians do to operate and access data in the system.
 */

public class LibrarySystem {
    //Creating a List storing patrons objects
    List<Patron> listPatrons = new ArrayList<>();

    //Creating objects of Patron
    Patron libraryMember = new Patron();

    //Scanner object to get input from the user
    Scanner options = new Scanner(System.in);

    /**
     * Method: MenuOption
     * Parameter: None
     * return: void
     * This method allow the user to choose an action on the computer
     */

    public void menuOptions(){

        System.out.println("Choose from the following menu options: ");
        System.out.println("1. Add Patron From File");
        System.out.println("2. Remove Patron");
        System.out.println("3. Display All Patrons");
        System.out.println("4. Add Patron From Command Line");
        System.out.println("5. Return Home");

        String selectOption = options.nextLine();

        switch(selectOption){
            case "1":
               addPatron();
               break;
            case "2":
               removePatron();
               break;
            case "3":
                displayPatron();
                break;
            case "4":
                commandLine();
                break;
            case "5":
                returnHome();
                break;
            default:
                System.out.println("Invalid option");
        }

    }

    /**
     * Method: addPatron
     * Parameter: None
     * return: void
     * This method allow the user to addi patrons from a text file the user select
     */
    public void addPatron(){
        try{
            System.out.println("You are adding patrons from a file");
            //Reading/opening in the file
            File patronFile = new File("C:\\Users\\Owner\\OneDrive\\Desktop\\patrons.txt");
            //Review the file text
            Scanner fileReader = new Scanner(patronFile);
            //Checks that if the file is not present throw an exception
            if(!(patronFile.exists())){
                throw new IOException();
            }
            //fileReader.read();
            //Has more than one line prints the context of each line
            while(fileReader.hasNextLine()){
               String patronString = fileReader.nextLine();
               String [] parts = patronString.split("-");

                String id = parts[0];
                String name = parts[1];
                String address = parts[2];
                double fine = Double.parseDouble(parts[3]);
                Patron patron = new Patron(id, name, address, fine, 0);
                listPatrons.add(patron);
            }

            displayPatron();

            //Return to the computer lock screen or menu options
            returnHome();

        }
        catch (IOException ex){
            System.out.println("Upload was unsuccessful to add patron(s).");
        }
    }

    /**
     * Method: removePatron
     * Parameter: None
     * return: void
     * This method allow the user to remove patrons from the list in system
     */
    public void removePatron(){

        System.out.println("What is the id number you would like to remove patron(s)?");
        String selectOption = options.nextLine();

            for (Patron member : listPatrons) {
                if (member.getIdNumber().equals(selectOption)) {
                    System.out.println(member);
                    break;
                }

            }


        System.out.println("Confirm Deletion: Yes or No");
        String isDeleted = options.nextLine();

        if(isDeleted.equals("Yes")){
            for(Patron member : listPatrons){
                if(member.getIdNumber().equals(selectOption));{
                    listPatrons.remove(member);
                    System.out.println("You are deleting patron(s) from the system");
                }

            }

        }

        while(isDeleted.equals("No")){
            System.out.println("Enter a different ID Number");
            selectOption = options.nextLine();
            for(Patron member: listPatrons){
                if(member.getIdNumber().equals(selectOption)){
                    System.out.println(member);
                    break;
                }

            }

            System.out.println("Confirm Deletion of ID Number: Yes or No");
            selectOption = options.nextLine();
            break;
        }

        displayPatron();

        returnHome();
    }

    /**Method: displayPatron
     * parameter: None
     * return: void
     * A method use to display all the patrons in the list
     */
    public void displayPatron(){

        for(Patron member: listPatrons){
            System.out.println(member);
        }

        if(listPatrons.isEmpty()){
            System.out.println("No Patron Found");
        }

        returnHome();

    }


    /**
     * method: command line
     * parameter: None
     * return: void
     *The method is used to enter multiple patron details manually
     * */
    public void commandLine(){
        Scanner information = new Scanner(System.in);
        String wantSave;

        System.out.println("How many patrons do you want to enter manually?");
        Scanner numbers = new Scanner(System.in);
        int numPatrons = numbers.nextInt();

        for(int i = 0; i < numPatrons; i++) {
            System.out.println("Enter Patron ID Number");
            boolean isDuplicate;
            String id;

            do {
             id = information.nextLine();
                isDuplicate = false;
                for (Patron p :  listPatrons) {
                    if (p.getIdNumber().equals(id)) {
                        System.out.println(id + " is a duplicate.");
                        System.out.println("Try to enter a different ID Number");
                        isDuplicate = true;
                        break;
                    }
                }
                if (id.length() != 7) {
                    System.out.println(id + " is not a valid ID.");
                    System.out.println("Try to enter a different ID Number");
                }



            } while (id.length() != 7 || isDuplicate);


            libraryMember.setIdNumber(id);
            System.out.println("You have successfully saved the patron's id number to the system: " + id);



            //Going to enter new information

            System.out.println("Enter Patron Name");
            String name = information.nextLine();

            System.out.println("Confirm Save Name: Yes or No");
            wantSave = options.nextLine();

            if(wantSave.equals("Yes")){
                libraryMember.setName(name);
                System.out.println("You have successfully saved a patron's name to the system: " + name);
            }


            while (wantSave.equals("No")) {
                System.out.println("Do you want to change or cancel Patron Name");
                String alterName = information.nextLine();
                if (alterName.equals("change")) {
                    System.out.println("Enter the change Name");
                    name = information.nextLine();
                    libraryMember.setName(name);
                    System.out.println("You have successfully saved a patron's name to the system: " + name);

                }
                else if (alterName.equals("cancel")) {
                    libraryMember.setName(null);
                    System.out.println("You have set the name to nothing");
                }
                System.out.println("Confirm  Yes or No: Y or N");
                wantSave = options.nextLine();
            }



            System.out.println("Enter Patron Address");
            String address = information.nextLine();
            System.out.println("Confirm and save the address: Yes or No");
            wantSave = options.nextLine();
            if(wantSave.equals("Yes")){
                libraryMember.setAddress(address);
                System.out.println("You have successfully saved the patron's address to the system: " + address);
            }

            while (wantSave.equals("No")) {
                System.out.println("Do you want to change or cancel Patron Address");

                if (address.equals("change")) {
                    System.out.println("Enter the change address");
                    address = information.nextLine();
                    libraryMember.setAddress(address);
                    System.out.println("You have successfully saved the patron's address to the system: " + address);
                } else if (address.equals("cancel")) {
                    libraryMember.setAddress(null);
                    System.out.println("You have set the address to nothing");
                }
                System.out.println("Confirm  Yes or No");
                wantSave = options.nextLine();
            }



            System.out.println("Enter fine");
            double fine = information.nextDouble();
            while((fine < 0) || (fine > 250)){
                if (fine < 0) {
                    System.out.println("Fine cannot be a negative number");
                }
                else if (fine > 250) {
                    System.out.println("There is an error in the system. Overdue fines can not be calculated.");
                }

                System.out.println("Reenter Fine");
                fine = information.nextDouble();

            }
            libraryMember.setFines(fine);
            System.out.println("You have successfully saved the patron's fine to the system: " + fine);


            Patron patron = new Patron(id, name, address, fine, 0);
            listPatrons.add(patron);

            //Use as a buffer to get the correct information, unless it does not output accurately
            information.nextLine();

        }


        displayPatron();

        returnHome();

    }

    /**
     * method: return home
     * parameter: None
     * return: void
     * Return to the computer lock screen or menu options
     */

    public void returnHome(){
        Scanner home = new Scanner(System.in);
        System.out.println("Do you want to return home to the menu?");
        String returnHome = home.nextLine();
        if(returnHome.equals("Yes")){
            menuOptions();
        }
        else if(returnHome.equals("No")){
            System.out.println("Welcome To Local Library!");
            System.out.println("Type Enter to continue");
            String homeEnter = options.nextLine();
            if(homeEnter.equals("Enter")){
                menuOptions();
            }
        }
    }
}
