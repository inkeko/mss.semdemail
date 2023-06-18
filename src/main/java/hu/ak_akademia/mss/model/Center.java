package hu.ak_akademia.mss.model;

import java.util.Objects;

public class Center {


    private int centerId;
    private String centerName;
    private int areaOfExpertisesIds;
    private String address;
    private String phoneNumber;
    private String description;

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAreaOfExpertisesIds() {
        return areaOfExpertisesIds;
    }

    public void setAreaOfExpertisesIds(int areaOfExpertisesIds) {
        this.areaOfExpertisesIds = areaOfExpertisesIds;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Center center = (Center) o;

        if (centerId != center.centerId) return false;
        if (areaOfExpertisesIds != center.areaOfExpertisesIds) return false;
        if (!Objects.equals(centerName, center.centerName)) return false;
        if (!Objects.equals(address, center.address)) return false;
        if (!Objects.equals(phoneNumber, center.phoneNumber)) return false;
        return Objects.equals(description, center.description);
    }

    @Override
    public int hashCode() {
        int result = centerId;
        result = 31 * result + (centerName != null ? centerName.hashCode() : 0);
        result = 31 * result + areaOfExpertisesIds;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Center() {
    }


    public Center(int centerId, String centerName, int areaOfExpertisesIds, String address, String phoneNumber, String description) {
        this.centerId = centerId;
        this.centerName = centerName;
        this.areaOfExpertisesIds = areaOfExpertisesIds;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Center{" +
                "centerId=" + centerId +
                ", centerName='" + centerName + '\'' +
                ", areaOfExpertisesIds=" + areaOfExpertisesIds +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
