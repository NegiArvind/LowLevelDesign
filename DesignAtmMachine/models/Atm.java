package models;

import atmStates.AtmState;
import atmStates.impl.IdleState;

public class Atm {

    private static Atm atmObject = new Atm();

    AtmState currentAtmState;
    private int atmBalance;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;

    // We don't want to allow to create multiple atms
    private Atm() {
    }

    public static Atm getAtmObject() {
        atmObject.setCurrentAtmState(new IdleState());
        return atmObject;
    }

    public AtmState getCurrentAtmState() {
        return currentAtmState;
    }

    public void setCurrentAtmState(AtmState currentAtmState) {
        this.currentAtmState = currentAtmState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductAtmBalance(int withDrawAmount) {
        this.atmBalance = this.atmBalance - withDrawAmount;
    }

    public void deductTwoThousandsNotes(int number) {
        this.noOfTwoThousandNotes = this.noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        this.noOfFiveHundredNotes = this.noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        this.noOfOneHundredNotes = this.noOfOneHundredNotes - number;
    }

    public void printCurrentAtmStatus() {
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);
    }
}
