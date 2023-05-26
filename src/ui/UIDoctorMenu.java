package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {
    public static ArrayList<Doctor> doctorsAvailableAppointments=new ArrayList<>();

    public static void showDoctorMenu(){
        int res=0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome "+UIMenu.doctorLogged.getName());
            System.out.println("1. Add available Appointment");
            System.out.println("2. My Scheduled Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            res = Integer.valueOf(sc.nextLine());

            switch (res){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:

                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (res!=0);
    }
    private static void showAddAvailableAppointmentsMenu(){
        int res=0;
        do {
            System.out.println("\n");
            System.out.println(":: Add Available Appointment");
            System.out.println(":: Select Month");

            for (int i = 0; i < 3; i++) {
                int j =  i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            res = Integer.valueOf(sc.nextLine());

            if(res>0 && res<4){
                int monthSelected=res;

                System.out.println(monthSelected + " . " + UIMenu.MONTHS[monthSelected-1]);
                System.out.println(monthSelected+"."+UIMenu.MONTHS[monthSelected-1]);

                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date=sc.nextLine();
                System.out.println("Your date is: " + date+"\n1. Correct\n2. Change date");
                int resDate=Integer.valueOf(sc.nextLine());
                if(resDate==2) continue;

                int resTime=0;
                String time="";

                do {
                    System.out.println("Insert the time available for data: "+date+" [16:00]");
                    time=sc.nextLine();
                    System.out.println("Your time is: " + time+"\n1. Correct\n2. Change date");
                    resTime=Integer.valueOf(sc.nextLine());
                }while (resTime==2);
                UIMenu.doctorLogged.createAppointment(date,time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);
                } else if (res==0) {
                showDoctorMenu();
            }
        }while (res!=0);
    }
    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size()>0 && !doctorsAvailableAppointments.contains(doctor) ){
            doctorsAvailableAppointments.add(doctor);
        }
    }

  /*  private static void showAvailableAppointments(){
        for (int i = 0; i <UIMenu.doctorLogged.getAvailableAppointments().size() ; i++) {
            System.out.println();
        }
        }*/
    }
