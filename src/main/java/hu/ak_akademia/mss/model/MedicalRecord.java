package hu.ak_akademia.mss.model;

import java.time.LocalDate;

public class MedicalRecord {
    private int medical_recordId;
    private int clientId;
    private int doctorId;
    private LocalDate date;
    private int areaOfExperitisesIds;
    private String comment;
    private int medical_presciptionsIds;

    public MedicalRecord() {
    }

    public MedicalRecord(int medical_recordId, int clientId, int doctorId, LocalDate date, int areaOfExperitisesIds, String comment, int medical_presciptionsIds  ) {
        this.medical_recordId = medical_recordId;
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.date = date;
        this.areaOfExperitisesIds = areaOfExperitisesIds;
        this.comment = comment;
        this.medical_presciptionsIds = medical_presciptionsIds;
    }

    public int getMedical_recordId() {
        return medical_recordId;
    }

    public void setMedical_recordId(int medical_recordId) {
        this.medical_recordId = medical_recordId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAreaOfExperitisesIds() {
        return areaOfExperitisesIds;
    }

    public void setAreaOfExperitisesIds(int areaOfExperitisesIds) {
        this.areaOfExperitisesIds = areaOfExperitisesIds;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getMedical_presciptionsIds() {
        return medical_presciptionsIds;
    }

    public void setMedical_presciptionsIds(int medical_presciptionsIds) {
        this.medical_presciptionsIds = medical_presciptionsIds;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MedicalRecord)) return false;
        if (!super.equals(object)) return false;

        MedicalRecord that = (MedicalRecord) object;

        if (getMedical_recordId() != that.getMedical_recordId()) return false;
        if (getClientId() != that.getClientId()) return false;
        if (getDoctorId() != that.getDoctorId()) return false;
        if (getAreaOfExperitisesIds() != that.getAreaOfExperitisesIds()) return false;
        if (getMedical_presciptionsIds() != that.getMedical_presciptionsIds()) return false;
        if (!getDate().equals(that.getDate())) return false;
        if (!getComment().equals(that.getComment())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getMedical_recordId();
        result = 31 * result + getClientId();
        result = 31 * result + getDoctorId();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getAreaOfExperitisesIds();
        result = 31 * result + getComment().hashCode();
        result = 31 * result + getMedical_presciptionsIds();
        return result;
    }

    @Override
    public String toString() {
        return "Medical_record{" +
                "medical_recordId=" + medical_recordId +
                ", clientId=" + clientId +
                ", doctorId=" + doctorId +
                ", date=" + date +
                ", areaOfExperitisesIds=" + areaOfExperitisesIds +
                ", comment='" + comment + '\'' +
                ", medical_presciptionsIds=" + medical_presciptionsIds +
                '}';
    }
}
