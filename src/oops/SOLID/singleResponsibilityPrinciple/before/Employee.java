package oops.SOLID.singleResponsibilityPrinciple.before;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Models an employee form a business perspective
 */
public abstract class Employee implements TxtSerializable {
    private String firstName;
    private String lastName;
    private int monthlyIncome;
    private int nbHoursPerWeek;

    public Employee(String fullName, int monthlyIncome){
        setMonthlyIncome(monthlyIncome);
        setFullName(fullName);
    }

    public String getEmail() {
        return this.firstName + "." + this.lastName + "@globomanticshr.com";
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " - " + this.monthlyIncome;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        if(monthlyIncome < 0){
            throw new IllegalArgumentException("Income must be positive");
        }
        this.monthlyIncome = monthlyIncome;
    }

    public int getNbHoursPerWeek() {
        return nbHoursPerWeek;
    }

    public void setNbHoursPerWeek(int nbHoursPerWeek) {
        if(nbHoursPerWeek <= 0){
            throw new IllegalArgumentException("Hours must be positive");
        }
        this.nbHoursPerWeek = nbHoursPerWeek;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String setFullName() {
        String[] names = fullName.split(" ");
        this.firstName = names[0];
        if (names.length > 1) {
            this.lastName = names[1];
        } else {
            this.lastName = "";
        }
    }

    public String serializeTxt() {
        StringBuilder sb = new StringBuilder();

        sb.append("### EMPLOYEE RECORD ####");
        sb.append(System.lineSeparator());
        sb.append("NAME: ");
        sb.append(this.getFullName());
        sb.append(System.lineSeparator());
        sb.append("POSITION: ");
        sb.append(this.getClass().getTypeName());
        sb.append(System.lineSeparator());
        sb.append("EMAIL: ");
        sb.append(this.getEmail());
        sb.append(System.lineSeparator());
        sb.append("MONTHLY WAGE: ");
        sb.append(this.getMonthlyIncome());
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
