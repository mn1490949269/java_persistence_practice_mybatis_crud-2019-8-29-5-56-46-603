package tws.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	/*
	 * desc
	 */
	public EmployeeDto getEmployeeWithDesc(String id) {
		return employeeMapper.getEmployeeWithDesc(id);
	}
	
	/*
	 * 分页查询
	 */
	public List<Employee> selectAll(){
		List<Employee> EmployeeList = employeeMapper.selectAll();
		return EmployeeList;
	}
	
	/*
	 * 主键查询
	 */
	public Employee selectById(String id) {
		Employee employee = new Employee();
        employee = employeeMapper.selectById(id);
        return employee;
	}
	/*
	 * 插入
	 */
	public Employee insert(Employee employee) {
		String id = UUID.randomUUID().toString();
    	employee.setId(id);
    	employeeMapper.insert(employee);	
        return employee;
	}	
	
	/*
	 * 更新
	 */
	public Employee updateById(String id,Employee employee) {
		Employee employeeRes = employeeMapper.updateById(id,employee);	
        return employeeRes;
	}
	
	/*
	 * 删除
	 */
	public Employee deleteById(String id) {
		Employee employeeRes = employeeMapper.deleteById(id);	
        return employeeRes;
	}
	
	

}
