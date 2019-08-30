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
	 * 模糊查询
	 */
	public List<Employee> select(String keyword){
		List<Employee> EmployeeList = employeeMapper.select(keyword);
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
	public int updateById(String id,Employee employee) {
		int result =  employeeMapper.updateById(id,employee);	
        return result;
	}
	
	/*
	 * 删除
	 */
	public int deleteById(String id) {
		int result = employeeMapper.deleteById(id);	
        return result;
	}
	
	

}
