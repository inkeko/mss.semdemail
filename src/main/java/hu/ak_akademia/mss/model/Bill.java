package hu.ak_akademia.mss.model;

import java.time.LocalDate;

public class Bill {
    private int billId;
    private int clientId;
    private int doctorId;
    private LocalDate date;
    private int areaOfExperitisesIds;
    private int amount;
    private boolean paid;

    public Bill() {
    }

    public Bill(int billId, int clientId, int doctorId, LocalDate date, int areaOfExperitisesIds, int amount, boolean paid) {
        this.billId = billId;
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.date = date;
        this.areaOfExperitisesIds = areaOfExperitisesIds;
        this.amount = amount;
        this.paid = paid;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getClientId() {
        return clientId;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Bill)) return false;
        if (!super.equals(object)) return false;

        Bill bill = (Bill) object;

        if (getBillId() != bill.getBillId()) return false;
        if (getClientId() != bill.getClientId()) return false;
        if (getDoctorId() != bill.getDoctorId()) return false;
        if (getAreaOfExperitisesIds() != bill.getAreaOfExperitisesIds()) return false;
        if (getAmount() != bill.getAmount()) return false;
        if (isPaid() != bill.isPaid()) return false;
        if (!getDate().equals(bill.getDate())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getBillId();
        result = 31 * result + getClientId();
        result = 31 * result + getDoctorId();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getAreaOfExperitisesIds();
        result = 31 * result + getAmount();
        result = 31 * result + (isPaid() ? 1 : 0);
        return result;
    }

    @Override
    public java.lang.String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", clientId=" + clientId +
                ", doctorId=" + doctorId +
                ", date=" + date +
                ", areaOfExperitisesIds=" + areaOfExperitisesIds +
                ", amount=" + amount +
                ", paid=" + paid +
                '}';
    }
}
