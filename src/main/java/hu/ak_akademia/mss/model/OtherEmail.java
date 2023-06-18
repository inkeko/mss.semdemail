package hu.ak_akademia.mss.model;

import java.time.LocalDate;

public class OtherEmail {
    private int otherEmailId;
    private String emailSubject;
    private LocalDate date;
    private String clientName;
    private String clientEmail;
    private  String politeText;

    public OtherEmail() {
    }

    public OtherEmail(int otherEmailId, String emailSubject, LocalDate date, String clientName, String clientEmail, String politeText) {
        this.otherEmailId = otherEmailId;
        this.emailSubject = emailSubject;
        this.date = date;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.politeText = politeText;
    }

    public int getOtherEmailId() {
        return otherEmailId;
    }

    public void setOtherEmailId(int otherEmailId) {
        this.otherEmailId = otherEmailId;
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

    public String getPoliteText() {
        return politeText;
    }

    public void setPoliteText(String politeText) {
        this.politeText = politeText;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof OtherEmail)) return false;
        if (!super.equals(object)) return false;

        OtherEmail that = (OtherEmail) object;

        if (getOtherEmailId() != that.getOtherEmailId()) return false;
        if (!getEmailSubject().equals(that.getEmailSubject())) return false;
        if (!getDate().equals(that.getDate())) return false;
        if (!getClientName().equals(that.getClientName())) return false;
        if (!getClientEmail().equals(that.getClientEmail())) return false;
        if (!getPoliteText().equals(that.getPoliteText())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getOtherEmailId();
        result = 31 * result + getEmailSubject().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getClientName().hashCode();
        result = 31 * result + getClientEmail().hashCode();
        result = 31 * result + getPoliteText().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Other_email{" +
                "otherEmailId=" + otherEmailId +
                ", emailSubject='" + emailSubject + '\'' +
                ", date=" + date +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", politeText='" + politeText + '\'' +
                '}';
    }
}
