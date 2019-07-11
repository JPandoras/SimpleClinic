package app.springboot.simpleclinic.models;

import javax.persistence.*;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    private Doctor doctorId;

    @ManyToOne
    private Patient patientId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "id='" + id + '\'' +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                '}';
    }
}
