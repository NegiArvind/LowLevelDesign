import enums.ComponentType;
import enums.ComputerType;
import models.AllInOneManufacturer;
import models.GenericManufacturer;
import models.ScreenLessManufacturer;
import services.ComputerBuildService;
import services.PartsCatalog;

public class Client {
    public static void main(String[] args) {
        PartsCatalog partsCatalog = new PartsCatalog(
                "CPU-X1", "RAM-16GB", "PSU-650W", "SCREEN-15.6FHD",
                "GPU-RTX4060"
        );

        ComputerBuildService computerBuildService = new ComputerBuildService(partsCatalog);

        GenericManufacturer genericManufacturer = new GenericManufacturer("Acme Generic #1");
        AllInOneManufacturer allInOneManufacturer = new AllInOneManufacturer("AllInOne Co.");
        ScreenLessManufacturer screenLessManufacturer = new ScreenLessManufacturer("NoScreen Ltd.");

        computerBuildService.addManufacture(genericManufacturer);
        computerBuildService.addManufacture(allInOneManufacturer);
        computerBuildService.addManufacture(screenLessManufacturer);

        System.out.println("Assigned: " + computerBuildService.placeOrder(ComputerType.DESKTOP)); // requires GPU (Screenless ok), PSU (AllInOne not ok)
        System.out.println("Assigned: " + computerBuildService.placeOrder(ComputerType.TABLET));  // has Screen (Screenless not ok), no PSU (AllInOne ok)
        System.out.println("Assigned: " + computerBuildService.placeOrder(ComputerType.LAPTOP));  // has Screen and PSU -> only Generic can
        System.out.println("Assigned: " + computerBuildService.placeOrder(ComputerType.SERVER));  // PSU required -> AllInOne not ok

        // Swap a component (affects future builds only)
        computerBuildService.swapPart(ComponentType.GPU, "GPU-RDNA4");
        System.out.println("Assigned: " + computerBuildService.placeOrder(ComputerType.DESKTOP));

        computerBuildService.removeManufacture(allInOneManufacturer.getId());
        System.out.println("Manufacturers now: " + computerBuildService.listManufacturers());
    }
}
