package hu.ak_akademia.mss.model;

import java.time.LocalDate;

public class Reservation {
    private int reservationID;
    private int clientId;
    private int doctorId;
    private LocalDate date;
    private int centerId;
    private int roomId;
    private int areaOfExpertisesId;
    private boolean booked;
    private boolean completed;
    private boolean cancelled;
    private int medicalRecordIds;
    private int billIds;

    public Reservation() {
    }

    public Reservation(int reservationID, int clientId,int doctorId, LocalDate date, int centerId, int roomId, int areaOfExpertisesId, boolean booked, boolean completed, boolean cancelled, int medicalRecordIds, int billIds ) {
        this.reservationID = reservationID;
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.date = date;
        this.centerId = centerId;
        this.roomId = roomId;
        this.areaOfExpertisesId = areaOfExpertisesId;
        this.booked = booked;
        this.completed = completed;
        this.cancelled = cancelled;
        this.medicalRecordIds = medicalRecordIds;
        this.billIds = billIds;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
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

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getAreaOfExpertisesId() {
        return areaOfExpertisesId;
    }

    public void setAreaOfExpertisesId(int areaOfExpertisesId) {
        this.areaOfExpertisesId = areaOfExpertisesId;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public int getMedicalRecordIds() {
        return medicalRecordIds;
    }

    public void setMedicalRecordIds(int medicalRecordIds) {
        this.medicalRecordIds = medicalRecordIds;
    }

    public int getBillIds() {
        return billIds;
    }

    public void setBillIds(int billIds) {
        this.billIds = billIds;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Reservation)) return false;
        if (!super.equals(object)) return false;

        Reservation that = (Reservation) object;

        if (getReservationID() != that.getReservationID()) return false;
        if (getClientId() != that.getClientId()) return false;
        if (getDoctorId() != that.getDoctorId()) return false;
        if (getCenterId() != that.getCenterId()) return false;
        if (getRoomId() != that.getRoomId()) return false;
        if (getAreaOfExpertisesId() != that.getAreaOfExpertisesId()) return false;
        if (isBooked() != that.isBooked()) return false;
        if (isCompleted() != that.isCompleted()) return false;
        if (isCancelled() != that.isCancelled()) return false;
        if (getMedicalRecordIds() != that.getMedicalRecordIds()) return false;
        if (getBillIds() != that.getBillIds()) return false;
        if (!getDate().equals(that.getDate())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getReservationID();
        result = 31 * result + getClientId();
        result = 31 * result + getDoctorId();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getCenterId();
        result = 31 * result + getRoomId();
        result = 31 * result + getAreaOfExpertisesId();
        result = 31 * result + (isBooked() ? 1 : 0);
        result = 31 * result + (isCompleted() ? 1 : 0);
        result = 31 * result + (isCancelled() ? 1 : 0);
        result = 31 * result + getMedicalRecordIds();
        result = 31 * result + getBillIds();
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationID +
                ", clientId=" + clientId +
                ", doctorId=" + doctorId +
                ", date=" + date +
                ", centerId=" + centerId +
                ", roomId=" + roomId +
                ", areaOfExpertisesId=" + areaOfExpertisesId +
                ", booked=" + booked +
                ", completed=" + completed +
                ", cancelled=" + cancelled +
                ", medicalRecordIds=" + medicalRecordIds +
                ", billIds=" + billIds +
                '}';
    }
}
