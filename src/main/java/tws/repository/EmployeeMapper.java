package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.dto.EmployeeDto;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();

	void insert(@Param("employee") Employee employee);

	Employee selectById(@Param("id") String id);

	Employee updateById(@Param("id") String id, @Param("employee") Employee employee);

	Employee deleteById(@Param("id") String id);
	EmployeeDto  getEmployeeWithDesc(@Param("id") String id);
}
