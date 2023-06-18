package hu.ak_akademia.mss.model;

public class EmailSubject {
    private int subjectId;
    private String subjectName;
    private String subjectDescription;

    public EmailSubject() {
    }

    public EmailSubject(int subjectId, String subjectName, String subjectDescription) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectDescription = subjectDescription;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof EmailSubject)) return false;
        if (!super.equals(object)) return false;

        EmailSubject that = (EmailSubject) object;

        if (getSubjectId() != that.getSubjectId()) return false;
        if (!getSubjectName().equals(that.getSubjectName())) return false;
        if (!getSubjectDescription().equals(that.getSubjectDescription())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSubjectId();
        result = 31 * result + getSubjectName().hashCode();
        result = 31 * result + getSubjectDescription().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Email_subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectDescription='" + subjectDescription + '\'' +
                '}';
    }
}
