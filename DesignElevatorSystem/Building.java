import java.util.List;

public class Building {

    private List<Floor> floorList;

    Building(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public void addFloor(Floor floor) {
        floorList.add(floor);
    }

    public void removeFloor(Floor floor) {
        floorList.remove(floor);
    }

    public List<Floor> getFloorList() {
        return this.floorList;
    }

}
