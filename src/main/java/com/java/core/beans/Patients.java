package com.java.core;

 class Patients {
        private  String firstName;
        private  String middleName;
        private  String lastName;
        private  String gardianFname;
        private  String gardianLname;
        private  String address;
        private  String number;
        private  String medicalHistory;

        public Patients(String firstName,String middleName,String lastName,String gardianFname,String gardianLname,String address,String number,String medicalHistory) {
            this.firstName=firstName;
            this.middleName=middleName;
            this.lastName=lastName;
            this.gardianFname=gardianFname;
            this.address=address;
            this.gardianLname=gardianLname;
            this.number=number;
            this.medicalHistory=medicalHistory;

        }
        public  String getLastName() { return lastName;}

        public  String getMedicalHistory() { return medicalHistory;}

        public  String getGardianFname() { return gardianFname;}

        public  String getNumber() { return number;}

        public  String getAddress() { return address;}

        public  String getGardianLname() { return gardianLname;}

        public  String getMiddleName() { return middleName;}

        public  String getFirstName() { return firstName;}

     public void setAddress(String address) { this.address = address;}

     public void setFirstName(String firstName) { this.firstName = firstName;}

     public void setGardianFname(String gardianFname) { this.gardianFname = gardianFname;}

     public void setGardianLname(String gardianLname) { this.gardianLname = gardianLname;}

     public void setLastName(String lastName) { this.lastName = lastName;}

     public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory;}

     public void setMiddleName(String middleName) { this.middleName = middleName;}

     public void setNumber(String number) {  this.number = number;}

     @Override
     public String toString() {
         return "Patients{" +
                 "address='" + address + '\'' +
                 ", firstName='" + firstName + '\'' +
                 ", middleName='" + middleName + '\'' +
                 ", lastName='" + lastName + '\'' +
                 ", gardianFname='" + gardianFname + '\'' +
                 ", gardianLname='" + gardianLname + '\'' +
                 ", number='" + number + '\'' +
                 ", medicalHistory='" + medicalHistory + '\'' +
                 '}';
     }
 }




