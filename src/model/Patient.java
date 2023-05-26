package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    private String birthday;
    private double weight;
    private double height;
    private String blood;
    private ArrayList<AppointmentDoctor> appointmentDoctors=new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses=new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date,String time) {
        AppointmentDoctor appointmentDoctor=new AppointmentDoctor(this,doctor);
        appointmentDoctor.schedulable(date,time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    public Patient(String name, String email){
        super(name, email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Patient");
        System.out.println("Full History Since Birth");
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWeight() {
        return weight+" Kg.";
    }

    public void setWeight(double weight) {
        if (weight<=0.0){
            System.out.println("The Weight is invalid");
        }
        if (weight>0.0){
            this.weight = weight;
        }
    }

    public String getHeight() {
        return height+" Mts.";
    }

    public void setHeight(double height) {
        if (height<=0.0){
            System.out.println("The Height is invalid");
        }
        if (height>0.0){
            this.height = height;
        }
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
