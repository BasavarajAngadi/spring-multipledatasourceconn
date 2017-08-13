package com.braj.derby.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.braj.derby.entity.Employee;
/**
* Repository  connect to database to provide data.
* @author  Basavaraj Angadi
* @version 1.0 
*/

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	Employee findById(Long id);

}
