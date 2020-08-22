package pt.joja.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pt.joja.dao.DepartmentDao;
import pt.joja.domain.Employee;

public class StringToEmployeeConverter implements Converter<String, Employee> {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public Employee convert(String source) {
        // admin-admin@joja.com-1-101
        if (source == null || source.length() == 0) {
            return null;
        }

        String[] attrs = source.split("-");

        Employee employee = new Employee();
        employee.setLastName(attrs[0]);
        employee.setEmail(attrs[1]);
        employee.setGender(Integer.parseInt(attrs[2]));
        employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(attrs[3])));

        return employee;
    }
}
