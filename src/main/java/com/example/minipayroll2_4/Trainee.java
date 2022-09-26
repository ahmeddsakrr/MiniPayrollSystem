package com.example.minipayroll2_4;

public class Trainee extends Employee{
    private String universityName;
    private double GPA;
    private String academicYear;

    public Trainee(String ID, String name, int age, String universityName, double GPA, String academicYear) {
        super(ID, name, age);
        this.universityName = universityName;
        this.GPA = GPA;
        this.academicYear = academicYear;
        this.setSalary(3000.00);
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public double calcSalary() {
        return this.getSalary();
    }

    @Override
    public String toString() {
        return "ID: "+String.format("%-5s",this.getID())
                +"Name: "+String.format("%-10s",this.getName())
                +"Age: " +String.format("%-5s", this.getAge())
                +"University: "+String.format("%-10s",this.getUniversityName())
                +"GPA: "+String.format("%-8s",this.getGPA())
                +"Academic Year: "+String.format("%-10s",this.getAcademicYear())
                +"Salary: "+String.format("%.2f",this.getSalary());
    }
    public String getID() {
        return super.getID();
    }
    public String getName() {
        return super.getName();
    }
    public int getAge() {
        return super.getAge();
    }
    public double getSalary(){
        return 3000.00;
    }

}