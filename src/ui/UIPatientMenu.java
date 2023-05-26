package ui;
import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu(){
        int res=0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome "+UIMenu.patientLogged.getName());
            System.out.println("1. Book an Appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            res = Integer.valueOf(sc.nextLine());

            switch (res){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (res!=0);
    }
    private static void showPatientMyAppointments(){
        int res=0;
        do {
            System.out.println(":: My appointments");
            if (UIMenu.patientLogged.getAppointmentDoctors().size()==0){
                System.out.println("Don't have appointments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j=i+1;
                System.out.println(j+". "+
                        "Data: "+UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate()+
                        "Time: "+UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime()+
                        "Doctor: "+UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
                );
            }
            System.out.println("0. Exit");
        }while (res!=0);
    }
    private static void showBookAppointmentMenu(){
        int res=0;
        do {
            System.out.println(":: Book an appointment");
            System.out.println(":: Select date: ");
            /**
             * const doctors=[doctor:[date]];doctors.map(d=>d.date);
             * 1)key=Integer=Index; 2)Value=Doctors;
             *2=Doctor->Map<Integer,Doctor>
            **/
            Map<Integer,Map<Integer, Doctor>> doctors=new TreeMap<>();
            if(UIDoctorMenu.doctorsAvailableAppointments.size()==0){
                System.out.println("Don't have appointments");
                break;
            }
            int k=0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments=UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                Map<Integer,Doctor> doctorAppointments=new TreeMap<>();
                for (int j = 0; j <availableAppointments.size() ; j++) {
                    k++;
                    System.out.println(k+". "+availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j),UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k),doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int resDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer,Doctor> docAvailableSelected=doctors.get(resDateSelected);
            Integer indexDate=0;
            Doctor docSelected=new Doctor("","","");
            for (Map.Entry<Integer,Doctor> doc:
                 docAvailableSelected.entrySet()) {
                indexDate=doc.getKey();
                docSelected=doc.getValue();
            }
            System.out.println(
                    docSelected.getName()+". Date: "
                    +docSelected.getAvailableAppointments().get(indexDate).getDate()
                    +". Time: "+docSelected.getAvailableAppointments().get(indexDate).getTime()
            );
            System.out.println("Confirm your appointment: \n1. Yes\n 2. Change data.");
            res=Integer.valueOf(sc.nextLine());
            if (res==1){
                UIMenu.patientLogged.addAppointmentDoctors(
                        docSelected,
                        docSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        docSelected.getAvailableAppointments().get(indexDate).getTime()
                );
                showPatientMenu();
            }
        }while (res!=0);
    }
}