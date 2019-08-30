package tws.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import tws.service.EmployeeService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    
    @GetMapping("/EmployeeDto/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeWithDesc(@PathVariable String id) {
        
    	return ResponseEntity.ok(employeeService.getEmployeeWithDesc(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> selectAll
        (@RequestParam(required = false) int page,
         @RequestParam(required = false) int pageSize) {
    
        return ResponseEntity.ok(employeeService.selectAll());
    }
    @GetMapping("/{keyword}")
    public ResponseEntity<List<Employee>> select(@PathVariable String keyword) {
    
        return ResponseEntity.ok(employeeService.select(keyword));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> selectById(@PathVariable String id) {
    	return ResponseEntity.ok(employeeService.selectById(id));
    }
    
    @PostMapping
    public ResponseEntity<Employee> insert(@RequestBody Employee employee){
    	Employee employeeRes = employeeService.insert(employee);
    	return ResponseEntity.created(URI.create("/employees"+employeeRes.getId())).build();  	
    }
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateById(@PathVariable String id,@RequestBody Employee employee) {
    	int res =  employeeService.updateById(id,employee);
    	return ResponseEntity.ok(res);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> updateById(@PathVariable String id) {
    	int res =  employeeService.deleteById(id);
    	return ResponseEntity.ok(res);
    }
    

}
