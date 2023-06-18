package hu.ak_akademia.mss.model;

public class WarningPopUp {
    private int popUpId;
    private String popUpName;
    private String politeText;

    public WarningPopUp() {
    }

    public WarningPopUp(int popUpId, String popUpName, String politeText) {
        this.popUpId = popUpId;
        this.popUpName = popUpName;
        this.politeText = politeText;
    }

    public int getPopUpId() {
        return popUpId;
    }

    public void setPopUpId(int popUpId) {
        this.popUpId = popUpId;
    }

    public String getPopUpName() {
        return popUpName;
    }

    public void setPopUpName(String popUpName) {
        this.popUpName = popUpName;
    }

    public String getPoliteText() {
        return politeText;
    }

    public void setPoliteText(String politeText) {
        this.politeText = politeText;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof WarningPopUp)) return false;
        if (!super.equals(object)) return false;

        WarningPopUp that = (WarningPopUp) object;

        if (getPopUpId() != that.getPopUpId()) return false;
        if (!getPopUpName().equals(that.getPopUpName())) return false;
        if (!getPoliteText().equals(that.getPoliteText())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getPopUpId();
        result = 31 * result + getPopUpName().hashCode();
        result = 31 * result + getPoliteText().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Waring_Pop_up{" +
                "popUpId=" + popUpId +
                ", popUpName='" + popUpName + '\'' +
                ", politeText='" + politeText + '\'' +
                '}';
    }
}
