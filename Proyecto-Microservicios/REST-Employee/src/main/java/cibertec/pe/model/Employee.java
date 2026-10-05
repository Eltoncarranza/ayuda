package cibertec.pe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_Empl;
    private String nom_Empl;
    private float suel_Empl;

    public Employee() {
    }

    public Employee(String nom_Empl, float suel_Empl) {
        this.nom_Empl = nom_Empl;
        this.suel_Empl = suel_Empl;
    }

    public int getCod_Empl() {
        return cod_Empl;
    }

    public void setCod_Empl(int cod_Empl) {
        this.cod_Empl = cod_Empl;
    }

    public String getNom_Empl() {
        return nom_Empl;
    }

    public void setNom_Empl(String nom_Empl) {
        this.nom_Empl = nom_Empl;
    }

    public float getSuel_Empl() {
        return suel_Empl;
    }

    public void setSuel_Empl(float suel_Empl) {
        this.suel_Empl = suel_Empl;
    }
}
