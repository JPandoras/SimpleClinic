package app.springboot.simpleclinic.models;

import javax.persistence.*;

@Entity
@Table(name = "medication_detail")
public class MedicationDetail {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    private Medication medicationId;

    @ManyToOne
    private Medicine medicineId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Medication getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Medication medicationId) {
        this.medicationId = medicationId;
    }

    public Medicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Medicine medicineId) {
        this.medicineId = medicineId;
    }

    @Override
    public String toString() {
        return "MedicationDetail{" +
                "id='" + id + '\'' +
                ", medicationId=" + medicationId +
                ", medicineId=" + medicineId +
                '}';
    }
}
