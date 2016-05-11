/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author sachithra sahan
 */
public class Medicine {
    private int treatmentID;
    private int patientID;
    private ArrayList<String> madicineType,dosage;

    /**
     * @return the treatmentID
     */
    public int getTreatmentID() {
        return treatmentID;
    }

    /**
     * @param treatmentID the treatmentID to set
     */
    public void setTreatmentID(int treatmentID) {
        this.treatmentID = treatmentID;
    }

    /**
     * @return the patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * @return the madicineType
     */
    public ArrayList<String> getMadicineType() {
        return madicineType;
    }

    /**
     * @param madicineType the madicineType to set
     */
    public void setMadicineType(ArrayList<String> madicineType) {
        this.madicineType = madicineType;
    }

    /**
     * @return the dosage
     */
    public ArrayList<String> getDosage() {
        return dosage;
    }

    /**
     * @param dosage the dosage to set
     */
    public void setDosage(ArrayList<String> dosage) {
        this.dosage = dosage;
    }
    
    
}
