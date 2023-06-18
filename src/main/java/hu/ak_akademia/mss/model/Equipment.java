package hu.ak_akademia.mss.model;

import java.time.LocalDate;

public class Equipment {
    private  int equipmentId;
    private boolean active;
    private String name;
    private  String description;
    private LocalDate dateOfEntry;

    public Equipment() {
    }

    public Equipment(int equipmentId, boolean active, String name, String description, LocalDate dateOfEntry  ) {
        this.equipmentId = equipmentId;
        this.active = active;
        this.name = name;
        this.description = description;
        this.dateOfEntry = dateOfEntry;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Equipment)) return false;
        if (!super.equals(object)) return false;

        Equipment equipment = (Equipment) object;

        if (getEquipmentId() != equipment.getEquipmentId()) return false;
        if (isActive() != equipment.isActive()) return false;
        if (!getName().equals(equipment.getName())) return false;
        if (!getDescription().equals(equipment.getDescription())) return false;
        if (!getDateOfEntry().equals(equipment.getDateOfEntry())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getEquipmentId();
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getDateOfEntry().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateOfEntry=" + dateOfEntry +
                '}';
    }
}
