package model;

public class Days {
    public enum Day {
        MONDAY("Lunes"),
        TUESDAY("Jueves"),
        FRIDAY("Viernes"),
        SATURDAY("Sábado"),
        SUNDAY("Domingo");

        public String spanish;
        Day(String s) {
            spanish = s;
        }

        public String getSpanish() {
            return spanish;
        }
    }

}
