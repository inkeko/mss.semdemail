package hu.ak_akademia.mss.model;

public class PoliteText {
    private int politeText;
    private String politeTextName;
    private String text;

    public PoliteText() {
    }

    public PoliteText(int politeText, String politeTextName, String text) {
        this.politeText = politeText;
        this.politeTextName = politeTextName;
        this.text = text;
    }

    public int getPoliteText() {
        return politeText;
    }

    public void setPoliteText(int politeText) {
        this.politeText = politeText;
    }

    public String getPoliteTextName() {
        return politeTextName;
    }

    public void setPoliteTextName(String politeTextName) {
        this.politeTextName = politeTextName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PoliteText)) return false;
        if (!super.equals(object)) return false;

        PoliteText that = (PoliteText) object;

        if (getPoliteText() != that.getPoliteText()) return false;
        if (!getPoliteTextName().equals(that.getPoliteTextName())) return false;
        if (!getText().equals(that.getText())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getPoliteText();
        result = 31 * result + getPoliteTextName().hashCode();
        result = 31 * result + getText().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Polite_text{" +
                "politeText=" + politeText +
                ", politeTextName='" + politeTextName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
