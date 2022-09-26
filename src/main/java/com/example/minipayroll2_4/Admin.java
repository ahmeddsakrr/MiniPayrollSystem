package com.example.minipayroll2_4;

import java.util.ArrayList;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin() {}
    public boolean AddEngineer(ArrayList<Employee> list,String name,String ID, String position,
                            double working_hours,int age){
        boolean found=false;
        if(list.size()!=0)
            for(Employee employee:list){
                if (employee.getID().equals(ID) && employee instanceof Engineer) {
                    found = true;
                    break;
                }
            }
        while (found){
            return false;
        }
        list.add(new Engineer(ID, name, age, working_hours, position));
        return true;
    }
    public boolean editEngineer(ArrayList<Employee> list,String idselection,int select,String edited){
        boolean quit=false;
        boolean found=false;
        int index=0;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getID().equals(idselection) && list.get(i) instanceof Engineer){
                index=i;
                found=true;
            }
        }
        if (found){
                String position=null;
                switch (select){
                    case 1:
                        String ID=edited;
                        boolean isThere =false;
                        for(Employee employee:list){
                            if (employee.getID().equals(ID) && employee instanceof Engineer) {
                                isThere = true;
                                break;
                            }
                        }
                        if (isThere){
                            return false;
                        }
                        list.get(index).setID(ID);
                        return true;
                    case 2:

                        String Name=edited;
                        list.get(index).setName(Name);
                        return true;
                    case 3:
                        int age= Integer.parseInt(edited);
                        list.get(index).setAge(age);
                        return true;
                    case 4:
                        position=edited;
                        ((Engineer) list.get(index)).updatepos(position);
                        return true;
                    case 5:
                        double hours= Double.parseDouble(edited);
                        ((Engineer)list.get(index)).setWorking_hours(hours);
                        return true;
                }

        }else {
            return false;
        }
        return false;
    }
    public boolean checkEngineer(ArrayList<Employee> list,String id){
        for (Employee employee:list){
            if (employee instanceof Engineer&& employee.getID().equals(id)) return true;
        }
        return false;
    }
    public boolean removeEngineer(ArrayList<Employee> list,String idselection){
        for (int i=0;i< list.size();i++){
            if (list.get(i).getID().equals(idselection) && list.get(i) instanceof Engineer){
                list.remove(i);
                return true;
            }
        }
            return false;
    }
    public ArrayList<Employee> printEngineers(ArrayList<Employee> list){
        ArrayList<Employee> list2=new ArrayList<>();
        for (Employee employee : list) {
            if (employee instanceof Engineer) {
                double salary = employee.calcSalary();
                list2.add(employee);
            }
        }
        return list2;
    }
    public String calcSalary(ArrayList<Employee> list,String idselection){
        boolean found=false;
        for (int i=0;i< list.size();i++){
            if (list.get(i).getID().equals(idselection) && list.get(i) instanceof Engineer){
                double salary= (list.get(i).calcSalary());
                return String.format("%.2f",salary);
            }
        }
        return null;
    }
    public boolean AddTrainee(ArrayList<Employee> list,String name, String ID, String UniversityName, double GPA, int age, String AcademicYear){
        if(list.size()!=0)
            for(Employee employee:list){
                if (employee.getID().equals(ID) && employee instanceof Trainee) {
                    return false;
                }
            }
        list.add(new Trainee(ID,name,age,UniversityName,GPA,AcademicYear));
        return true;
    }
    public boolean checkTrainee(ArrayList<Employee> list, String id){
        for (Employee employee:list){
            if (employee instanceof Trainee&& employee.getID().equals(id)) return true;
        }
        return false;
    }
    public boolean editTrainee(ArrayList<Employee> list,String idselection,int select,String edited){
        boolean found=false;
        int index=0;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getID().equals(idselection) && list.get(i) instanceof Trainee){
                index=i;
                found=true;
                break;
            }
        }
        if (found){
                switch (select){
                    case 1:
                        String ID=edited;
                        boolean isThere =false;
                        for(Employee employee:list){
                            if (employee.getID().equals(ID) && employee instanceof Trainee) {
                                isThere = true;
                                return false;
                            }
                        }
                        list.get(index).setID(ID);
                        return true;
                    case 2:
                        String Name= edited;
                        list.get(index).setName(Name);
                        return true;
                    case 3:
                        int age= Integer.parseInt(edited);
                        list.get(index).setAge(age);
                        return true;
                    case 4:
                        String name= edited;
                        ((Trainee) list.get(index)).setUniversityName(name);
                        return true;
                    case 5:
                        double gpa= Double.parseDouble(edited);
                        ((Trainee) list.get(index)).setGPA(gpa);
                        return true;
                    case 6:
                        String year= edited;
                        ((Trainee) list.get(index)).setAcademicYear(year);
                        return true;
                }
        }else{
            return false;
        }
        return false;
    }
    public boolean removeTrainee(ArrayList<Employee> list,String idselection){
        for (int i=0;i< list.size();i++){
            if (list.get(i).getID().equals(idselection) && list.get(i) instanceof Trainee){
                list.remove(i);
                return true;
            }
        }
            return false;
    }
    public ArrayList<Employee> printTrainees(ArrayList<Employee> list){
        ArrayList<Employee> list2=new ArrayList<>();
        for (Employee employee : list) {
            if (employee instanceof Trainee) {
                double salary = employee.calcSalary();
                list2.add(employee);
            }
        }
        return list2;

    }
    public boolean checklist(ArrayList<Employee> list){
        if (list.size()==0){
            return false;
        }else
            return true;
    }
    public void printMenu(){
        System.out.println("A- Add new Engineer");
        System.out.println("B- Edit existing Engineer");
        System.out.println("C- Delete Engineer");
        System.out.println("D- Calculate Salary");
        System.out.println("E- View All Engineers with all their data and salaries");
        System.out.println("F- Add new Trainee");
        System.out.println("G- Edit Existing Trainee");
        System.out.println("H- Delete Trainee");
        System.out.println("I- View all Trainees with all their data and salaries");
        System.out.println("Q- Quit");
        System.out.println("Enter your selection: ");
    }
}

