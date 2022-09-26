package com.example.minipayroll2_4;

public class Engineer extends Employee {
    private double working_hours;
    private Grade grade;

    public Engineer(String ID, String name, int age, double working_hours,String position) {
        super(ID, name, age);
        this.working_hours = working_hours;
        grade=new Grade(position);
        switch (position){
            case "Manager":
                this.grade.setPay_rate(44.38);
                this.grade.setTax_rate(0.30);
                break;
            case "Team Leader":
                this.grade.setPay_rate(35.60);
                this.grade.setTax_rate(0.26);
                break;
            case "Team Member":
                this.grade.setPay_rate(29.05);
                this.grade.setTax_rate(0.24);
                break;
        }
    }

    public double getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(double working_hours) {
        this.working_hours = working_hours;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public void updatepos(String position){
        this.grade.setPosition(position);
        switch (position){
            case "Manager":
                this.grade.setPay_rate(44.38);
                this.grade.setTax_rate(0.30);
                break;
            case "Team Leader":
                this.grade.setPay_rate(35.60);
                this.grade.setTax_rate(0.26);
                break;
            case "Team Member":
                this.grade.setPay_rate(29.05);
                this.grade.setTax_rate(0.24);
                break;
        }
    }


    @Override
    public double calcSalary() {
        double income=this.working_hours*this.grade.getPay_rate()*30;
        double taxes=this.grade.getTax_rate()*income;
        this.setSalary(income-taxes);
        return income-taxes;
    }

    @Override
    public String toString() {
        return "ID: "+String.format("%-5s",this.getID())+"Name: "+String.format("%-10s",this.getName())
                +"Age: " +String.format("%-5s", this.getAge())
                +"Position: "+String.format("%-15s",this.grade.getPosition())+
                "Working Hours: "+String.format("%-10s", this.getWorking_hours())
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
    public String getPosition() {
        return this.grade.getPosition();
    }
    public double getSalary(){
        return this.calcSalary();
    }
}
