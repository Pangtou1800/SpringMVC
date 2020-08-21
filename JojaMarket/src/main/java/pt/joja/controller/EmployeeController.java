package pt.joja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pt.joja.dao.DepartmentDao;
import pt.joja.dao.EmployeeDao;
import pt.joja.domain.Employee;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工
     *
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String getEmps(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "list";
    }

    /**
     * 去员工添加页面，带去所有部门信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/toAddPage")
    public String toAddPage(Model model) {
        model.addAttribute("departs", departmentDao.getDepartments());
        model.addAttribute("newEmp", new Employee());
        return "add";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String getEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departs", departmentDao.getDepartments());
        return "edit";
    }

    @ModelAttribute
    public void prepareEmp(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("employee", employeeDao.get(id));
        }
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public String editEmp(@PathVariable("id") Integer id, Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
