package hu.ak_akademia.mss.model;

import java.time.LocalDate;

public class ReservationWarningEmail {
    private int reservationEmailId;
    private String emailSubject;
    private LocalDate date;
    private  String clientName;
    private String clientEmail;
    private String doctorName;
    private  String doctorEmail;
    private String expertiesName;
    private String centerName;
    private int roomNumber;
    private String politeText;

    public ReservationWarningEmail() {
    }

    public ReservationWarningEmail(int reservationEmailId, String emailSubject, LocalDate date, String clientName, String clientEmail, String doctorName, String doctorEmail, String expertiesName, String centerName, int roomNumber, String politeText ) {
        this.reservationEmailId = reservationEmailId;
        this.emailSubject = emailSubject;
        this.date = date;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.doctorName = doctorName;
        this.doctorEmail = doctorEmail;
        this.expertiesName = expertiesName;
        this.centerName = centerName;
        this.roomNumber = roomNumber;
        this.politeText = politeText;
    }

    public int getReservationEmailId() {
        return reservationEmailId;
    }

    public void setReservationEmailId(int reservationEmailId) {
        this.reservationEmailId = reservationEmailId;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getExpertiesName() {
        return expertiesName;
    }

    public void setExpertiesName(String expertiesName) {
        this.expertiesName = expertiesName;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPoliteText() {
        return politeText;
    }

    public void setPoliteText(String politeText) {
        this.politeText = politeText;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ReservationWarningEmail)) return false;
        if (!super.equals(object)) return false;

        ReservationWarningEmail that = (ReservationWarningEmail) object;

        if (getReservationEmailId() != that.getReservationEmailId()) return false;
        if (getRoomNumber() != that.getRoomNumber()) return false;
        if (!getEmailSubject().equals(that.getEmailSubject())) return false;
        if (!getDate().equals(that.getDate())) return false;
        if (!getClientName().equals(that.getClientName())) return false;
        if (!getClientEmail().equals(that.getClientEmail())) return false;
        if (!getDoctorName().equals(that.getDoctorName())) return false;
        if (!getDoctorEmail().equals(that.getDoctorEmail())) return false;
        if (!getExpertiesName().equals(that.getExpertiesName())) return false;
        if (!getCenterName().equals(that.getCenterName())) return false;
        if (!getPoliteText().equals(that.getPoliteText())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getReservationEmailId();
        result = 31 * result + getEmailSubject().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getClientName().hashCode();
        result = 31 * result + getClientEmail().hashCode();
        result = 31 * result + getDoctorName().hashCode();
        result = 31 * result + getDoctorEmail().hashCode();
        result = 31 * result + getExpertiesName().hashCode();
        result = 31 * result + getCenterName().hashCode();
        result = 31 * result + getRoomNumber();
        result = 31 * result + getPoliteText().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Reservation_warning_email{" +
                "reservationEmailId=" + reservationEmailId +
                ", emailSubject='" + emailSubject + '\'' +
                ", date=" + date +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", expertiesName='" + expertiesName + '\'' +
                ", centerName='" + centerName + '\'' +
                ", roomNumber=" + roomNumber +
                ", politeText='" + politeText + '\'' +
                '}';
    }
}
