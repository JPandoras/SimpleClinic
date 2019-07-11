package app.springboot.simpleclinic.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medication")
public class Medication {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatment_id", referencedColumnName = "id")
    private Treatment treatmentId;

    @Column(name = "notes")
    private String notes;

    //private Pharmacy onDuty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Treatment getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Treatment treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /*public Pharmacy getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(Pharmacy onDuty) {
        this.onDuty = onDuty;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id='" + id + '\'' +
                ", treatmentId=" + treatmentId +
                ", notes='" + notes + '\'' +
                ", onDuty=" + onDuty +
                '}';
    }*/
}
