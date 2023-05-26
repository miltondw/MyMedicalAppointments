import model.*;
import ui.UIMenu;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Doctor myFirstDoc=new Doctor("Milton","estrada@e.com","Ciruguía");
        myFirstDoc.createAppointment("24/05/2023","08:00am");
        myFirstDoc.createAppointment("28/05/2023","10:00am");
        myFirstDoc.createAppointment("30/05/2023","01:00pm");
/*
        User userDoc= new Doctor("Carlos","c@c.com","ginecologia");
        userDoc.showDataUser();

        User userNurse=new Nurse("Paola","p@p.com","Nutrición");
        userNurse.showDataUser();

        User userPat= new Patient("karen","k@k.com");
        userPat.showDataUser();

        User user1= new User("user1","u@u.com") {
            @Override
            public void showDataUser() {
                System.out.println("I'm user \n");
                System.out.println("date");
            }
        };

         for (model.Doctor.AvailableAppointment ap:myFirstDoc.getAvailableAppointments()) {
            System.out.println("Date: "+ap.getDate()+"  Time:"+ap.getTime());
            } */

        /*
        Patient myFirstPatient=new Patient("Chirly","chirly@e.com");
        for (Days.Day day:Days.Day.values()) {
            System.out.println(day+":"+day.getSpanish());
        }
        System.out.println(myFirstPatient);
        System.out.println(myFirstDoc);*/


        UIMenu.showMenu();
        /*
        myFirstPatient.setHeight(1.60);
        myFirstPatient.setWeight(65);
        System.out.println(myFirstPatient.getWeight());
        System.out.println(myFirstPatient.getHeight());
         */
    }
}