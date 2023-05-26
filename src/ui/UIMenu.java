package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {
    public static final String[] MONTHS={"January","February","March","April","May","Jun","July","August","September","October","November","December"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Select the desired option");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    System.out.println("Patient");
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    /***
     * Auth user
     * @param typeUser type 1 == Doctor; type 2 == Patient;
     * */
    public static void authUser(int typeUser){
        ArrayList <Doctor> doctors = new ArrayList<>();
            doctors.add(new Doctor("Jesus","j@j.com","cirugano"));
            doctors.add(new Doctor("luis","l@l.com","psicologo"));
            doctors.add(new Doctor("Jesus","j@j.com","dentista"));

        ArrayList <Patient> patients = new ArrayList<>();
            patients.add(new Patient("leny","l@l.com"));
            patients.add(new Patient("jose","j@j.com"));
            patients.add(new Patient("uriel","u@u.com"));

        boolean emailCorrect=false;

        do {
            System.out.println("Insert your emil: example@domain.com");
            Scanner sc = new Scanner(System.in);
            String email= sc.nextLine();
            if(typeUser==1){
                for (Doctor d: doctors) {
                    if(d.getEmail().equals(email)){
                        emailCorrect=true;
                        doctorLogged=d;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if(typeUser==2){
                for (Patient p: patients) {
                    if(p.getEmail().equals(email)){
                        emailCorrect=true;
                        patientLogged=p;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        }while (!emailCorrect);

    }
    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 3; i++) {
                        System.out.println((i+1)+"."+MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        } while (response != 0);
    }
}
