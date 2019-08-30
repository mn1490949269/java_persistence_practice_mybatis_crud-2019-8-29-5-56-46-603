package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Employee;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Test
	public void selectAllTest() {
		//given
		jdbcTemplate.execute("insert into employee values('1','zhangsan','22')");
		//when
		List<Employee> employees = employeeMapper.selectAll();
		
		//then
		assertEquals(1, employees.size());
	}
	
	@Test
	public void updateTest() {
		//given
		jdbcTemplate.execute("insert into employee values('2','zhangsan','22')");
		String id = "2";
		Employee employee = new Employee("2", "zhangsan", "25");
		
		//when
		employeeMapper.updateById(id,employee);
		
		//then
		assertEquals("25", employee.getAge());
	}
	
	@Test
	public void insertTest() {
		//given
		Employee employee = new Employee("3", "lisi", "24");
		//when
		employeeMapper.insert(employee);
	    int count = JdbcTestUtils.countRowsInTable(jdbcTemplate,"employee" );
		
		//then
		assertEquals(1, count);
	}
	
	
	
	

}
