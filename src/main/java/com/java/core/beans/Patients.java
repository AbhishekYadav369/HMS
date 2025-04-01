package com.java.core.beans;

 public class Patients {
        private  String firstName;
        private  String middleName;
        private  String lastName;
        private  String gFirstName;
        private  String gLastName;
        private  String number;
        private  String medicalHistory;

        public Patients(String firstName, String middleName, String lastName, String gFirstName, String gLastName, String number, String medicalHistory) {
            this.firstName=firstName;
            this.middleName=middleName;
            this.lastName=lastName;
            this.gFirstName = gFirstName;
            this.gLastName =gLastName;
            this.number=number;
            this.medicalHistory=medicalHistory;

        }

        public  String getMedicalHistory() { return medicalHistory;}
     public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory;}

        public  String getNumber() { return number;}
        public void setNumber(String number) {  this.number = number;}

        public  String getMiddleName() { return middleName;}
     public void setMiddleName(String middleName) { this.middleName = middleName;}

        public  String getFirstName() { return firstName;}
     public void setFirstName(String firstName) { this.firstName = firstName;}

     public void setLastName(String lastName) { this.lastName = lastName;}
     public  String getLastName() { return lastName;}

     public void setGarFirstName(String gFirstName) { this.gFirstName = gFirstName;}
     public  String getGarFirstName() { return gFirstName;}

     public  String getGarLastName() { return gLastName;}
     public void setGarLastName(String gLastName) { this.gLastName = gLastName;}


     @Override
     public String toString() {
         return "Patients{" + ", firstName='" + firstName + '\'' +
                 ", middleName='" + middleName + '\'' + ", lastName='" + lastName + '\'' +
                 ", GarFirstName='" + gFirstName + '\'' + ", GarLastName='" + gLastName + '\'' +
                 ", number='" + number + '\'' + ", medicalHistory='" + medicalHistory + '\'' + '}';
     }
 }




