package domain;

import bl.HibernateUtil;
import dao.AddressDAO;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("Belarus");
        address.setCity("Grodno");
        address.setStreet("Folush11231");
        address.setPostCode("220006");

        Employee employee = new Employee();
        employee.setFirstName("Vladimir");
        employee.setLastName("Lugom");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1996,Calendar.JANUARY,23);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("123");

        Set<Project> projects = new HashSet<>();
        projects.add(project);

        employee.setProjects(projects);

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);
        HibernateUtil.shutdown();
    }
}
