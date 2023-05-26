package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    String speciality;

    public Doctor(String name,String email,String speciality){
        super(name, email);
        this.speciality=speciality;
    }
    public void showName(){
        System.out.println("The doc is: "+super.getName()+" and your id is: "+super.getId());
    }

    ArrayList<AvailableAppointment> availableAppointments= new ArrayList<>();
    /**
     * Description: Add Appointment
     * @param date Date [dd/mm/yyyy]
     * @param time time 00:00 pm or am Appointment
     */
    public void createAppointment(String date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString()+ "Speciality: " + speciality;
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cross Red");
        System.out.println("Department: Cancerology");
    }

    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }

        public Date getDate(String Date) {
            return date;
        }

        public String getDate() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return super.toString()+"Date: "+date+", Time: "+time;
        }
    }
}
