package hu.ak_akademia.mss.model;

public class Room {
   private int roomId;
   private  String roomName;
   private int roomNumber;
   private  int areaOfExpertisesIds;
   private int appointmentsIds;
   private int equipmentsIds;

    public Room() {
    }

    public Room(int roomId, String roomName, int roomNumber, int areaOfExpertisesIds, int appointmentsIds, int equipmentsIds) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.areaOfExpertisesIds = areaOfExpertisesIds;
        this.appointmentsIds = appointmentsIds;
        this.equipmentsIds = equipmentsIds;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getAreaOfExpertisesIds() {
        return areaOfExpertisesIds;
    }

    public void setAreaOfExpertisesIds(int areaOfExpertisesIds) {
        this.areaOfExpertisesIds = areaOfExpertisesIds;
    }

    public int getAppointmentsIds() {
        return appointmentsIds;
    }

    public void setAppointmentsIds(int appointmentsIds) {
        this.appointmentsIds = appointmentsIds;
    }

    public int getEquipmentsIds() {
        return equipmentsIds;
    }

    public void setEquipmentsIds(int equipmentsIds) {
        this.equipmentsIds = equipmentsIds;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Room)) return false;
        if (!super.equals(object)) return false;

        Room room = (Room) object;

        if (getRoomId() != room.getRoomId()) return false;
        if (getRoomNumber() != room.getRoomNumber()) return false;
        if (getAreaOfExpertisesIds() != room.getAreaOfExpertisesIds()) return false;
        if (getAppointmentsIds() != room.getAppointmentsIds()) return false;
        if (getEquipmentsIds() != room.getEquipmentsIds()) return false;
        if (!getRoomName().equals(room.getRoomName())) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getRoomId();
        result = 31 * result + getRoomName().hashCode();
        result = 31 * result + getRoomNumber();
        result = 31 * result + getAreaOfExpertisesIds();
        result = 31 * result + getAppointmentsIds();
        result = 31 * result + getEquipmentsIds();
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomNumber=" + roomNumber +
                ", areaOfExpertisesIds=" + areaOfExpertisesIds +
                ", appointmentsIds=" + appointmentsIds +
                ", equipmentsIds=" + equipmentsIds +
                '}';
    }
}
