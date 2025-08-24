package org.example;

import org.openqa.selenium.WebDriver;

public class Computer {

    public Computer(WebDriver driver, String motherBoard, int numberOfCores, int numberOfSsd) {
        this.driver = driver;
        this.motherBoard = motherBoard;
        this.numberOfCores = numberOfCores;
        this.numberOfSsd = numberOfSsd;
    }

    public Computer(WebDriver driver, String motherBoard, int numberOfCores) {
        this.driver = driver;
        this.motherBoard = motherBoard;
        this.numberOfCores = numberOfCores;
    }

    protected WebDriver driver;

    private String motherBoard;
    private int numberOfCores;
    private int numberOfSsd;

    public int getNumberOfSsd() {
        return numberOfSsd;
    }

    public void setNumberOfSsd(int numberOfSsd) {
        this.numberOfSsd = numberOfSsd;
    }

    public String getMotherBorad() {
        return motherBoard;
    }

    public void setMotherBorad(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

void printPrivateFields() {
        System.out.println("Motherboard: " + motherBoard);
        System.out.println("Number of Cores: " + numberOfCores);
}

    public void Computer(int numberOfCores, int numberOfSsd) {
        int summ = numberOfCores + numberOfSsd;
        System.out.println(summ);



    }



/*    int ssd = 500;
    int ram = 100;

    Computer() {
        System.out.println("I'm constructor in a class.");
    }

    Computer(int newSsd, int newRam) {
        this.ssd = newSsd;
        this.ram = newRam;
    }

    void printState() {
        System.out.println("SSD: " + ssd);
        System.out.println("RAM: " + ram);
    }

    Computer(int ssd) {
        this.ssd = ssd;
    }*/


}
