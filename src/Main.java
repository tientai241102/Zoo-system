import com.codegym.main.MainActivity;
import com.codegym.service.AnimalService;
import com.codegym.service.CageService;
import com.codegym.service.EmployeeService;
import com.codegym.service.VisitorService;

public class Main {

    AnimalService animalService = new AnimalService();

    EmployeeService employeeService = new EmployeeService();

    CageService cageService = new CageService();

    VisitorService visitorService = new VisitorService();

    public static void main(String[] args) {

        MainActivity mainActivity = MainActivity.getInstanceMainActivity();
        mainActivity.showMainActivity();
    }

}