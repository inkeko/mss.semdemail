package hu.ak_akademia.mss.model;

public class Treatment {
    private int areaOfExpertisesId;
    private String expertiesName;
    private int treatmentLength;
    private int administrationLength;
    private int centerId;
    private int roomId;
    private int price;

    public Treatment() {
    }

    public Treatment(int areaOfExpertisesId, String expertiesName, int treatmentLength, int administrationLength, int centerId, int roomId, int price) {
        this.areaOfExpertisesId = areaOfExpertisesId;
        this.expertiesName = expertiesName;
        this.treatmentLength = treatmentLength;
        this.administrationLength = administrationLength;
        this.centerId = centerId;
        this.roomId = roomId;
        this.price = price;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Treatment)) return false;
        if (!super.equals(object)) return false;

        Treatment that = (Treatment) object;

        if (areaOfExpertisesId != that.areaOfExpertisesId) return false;
        if (treatmentLength != that.treatmentLength) return false;
        if (administrationLength != that.administrationLength) return false;
        if (centerId != that.centerId) return false;
        if (roomId != that.roomId) return false;
        if (price != that.price) return false;
        if (!expertiesName.equals(that.expertiesName)) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + areaOfExpertisesId;
        result = 31 * result + expertiesName.hashCode();
        result = 31 * result + treatmentLength;
        result = 31 * result + administrationLength;
        result = 31 * result + centerId;
        result = 31 * result + roomId;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Area_of_experties{" +
                "areaOfExpertisesId=" + areaOfExpertisesId +
                ", expertiesName='" + expertiesName + '\'' +
                ", treatmentLength=" + treatmentLength +
                ", administrationLength=" + administrationLength +
                ", centerId=" + centerId +
                ", roomId=" + roomId +
                ", price=" + price +
                '}';
    }
}
