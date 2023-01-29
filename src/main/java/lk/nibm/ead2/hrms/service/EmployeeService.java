package lk.nibm.ead2.hrms.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import lk.nibm.ead2.hrms.db.Database;
import lk.nibm.ead2.hrms.model.Employee;

public class EmployeeService {
	
	public boolean insert(Employee employee) throws SQLException {
		String sql = "INSERT INTO public.employee(FirstName,LastName,Designation,Email,Telephone,Age) VALUES(?,?,?,?,?,?)";
		Database db = Database.getDatabase();
		PreparedStatement ps = db.getPreparedStatement(sql);
		ps.setString(1, employee.getFirstname());
		ps.setString(2, employee.getLastname());
		ps.setString(3, employee.getDesignation());
		ps.setString(4, employee.getEmail());
		ps.setString(5, employee.getTelephone());
		ps.setLong(6, employee.getAge());
		int status = ps.executeUpdate();
		ps.close();
		return status > 0;
	}

}
