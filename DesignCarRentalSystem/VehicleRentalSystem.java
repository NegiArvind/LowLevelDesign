import java.util.List;

public class VehicleRentalSystem {

    private List<User> userList;
    private List<Store> storeList;

    VehicleRentalSystem(List<User> userList, List<Store> storeList) {
        this.userList = userList;
        this.storeList = storeList;
    }


    public List<Store> getStore(Location location) {
        // filtering stores on the basis of location
        return storeList;
    }

    // add users
    public void addUser(User user) {
        this.userList.add(user);
    }

    //remove users

    public void removeUser(User user){
        this.userList.remove(user);
    }

    // add stores

    public void addStore(Store store) {
        this.storeList.add(store);
    }

    // remove stores
    public void removeStore(Store store){
        this.storeList.remove(store);
    }
}
