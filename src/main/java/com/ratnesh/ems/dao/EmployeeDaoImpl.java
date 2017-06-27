package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 31/5/17.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    public Map getBranches() {
     return jdbcTemplate.query("select * from branch", new ResultSetExtractor<Map>() {
        public Map extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Map<Integer, String> branchList = new HashMap<Integer, String>();
            while(resultSet.next()){
                branchList.put(resultSet.getInt("branchId"), resultSet.getString("name") );
            }
            return branchList;
        }
    });
    }

    public Map getDesignation() {
        return jdbcTemplate.query("select * from designation", new ResultSetExtractor<Map>() {
            public Map extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Map<Integer, String> designationList = new HashMap<Integer, String>();
                while(resultSet.next()){
                    designationList.put(resultSet.getInt("designationId"), resultSet.getString("name") );
                }
                return designationList;
            }
        });
    }

    public Integer getEmployeeId() {
        String sql = "SELECT max(empId) FROM employee";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public Boolean insertEmployee(final Employee employee) {
        String sql ="INSERT INTO employee (empId, firstName, lastName, dob, gender, age, maritalStatus, doj, designation, email, mobile, address, branchId,photo) VALUES (?, ?, ?, ?, ?,?,?, ?, ?,?,?,?,?,?)";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {

                preparedStatement.setLong(1,employee.getEmpId());
                preparedStatement.setString(2,employee.getFirstName());
                preparedStatement.setString(3,employee.getLastName());
                preparedStatement.setString(4,employee.getDob());
                preparedStatement.setString(5,employee.getGender());
                preparedStatement.setInt(6,employee.getAge());
                preparedStatement.setString(7,employee.getMaritalStatus());
                preparedStatement.setString(8,employee.getDoj());
                preparedStatement.setString(9,employee.getDesignation());
                preparedStatement.setString(10,employee.getEmail());
                preparedStatement.setString(11,employee.getMobile());
                preparedStatement.setString(12,employee.getAddress());
                preparedStatement.setLong(13,employee.getBranchId());

                String photoName=null;
                if(!employee.getPhoto().getOriginalFilename().isEmpty()){
                    String fileExtention[] = employee.getPhoto().getOriginalFilename().split("\\.");
                    photoName =  employee.getFirstName() +"_"+employee.getEmpId()+ "." + fileExtention[1];
                }

                preparedStatement.setString(14,photoName);
                preparedStatement.execute();

                return true;
            }
        });

    }

    public List<Employee> getEmployees() {
//        List<Employee> employeeList =jdbcTemplate.query("select * from employee", new BeanPropertyRowMapper(Employee.class));

        return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setEmpId(resultSet.getLong("empId"));
            employee.setFirstName(resultSet.getString("firstName"));
            employee.setLastName(resultSet.getString("lastName"));
            employee.setDob(resultSet.getString("dob"));
            employee.setGender(resultSet.getString("gender"));
            employee.setAge(resultSet.getInt("age"));
            employee.setMaritalStatus(resultSet.getString("maritalStatus"));
            employee.setDoj(resultSet.getString("doj"));
            employee.setDesignation(
                jdbcTemplate.query("select name from designation where designationId="+resultSet.getString("designation"), new ResultSetExtractor<String>() {
                    public String extractData(ResultSet result) throws SQLException, DataAccessException {
                       String DesignationName =null;
                        while(result.next()){
                            DesignationName=result.getString("name");
                        }
                        return DesignationName;
                    }
                })
            );

            employee.setEmail(resultSet.getString("email"));
            employee.setMobile(resultSet.getString("mobile"));
            employee.setAddress(resultSet.getString("address"));
            employee.setBranchId(resultSet.getLong("branchId"));
            return employee;
            }
        });

    }

    public Boolean deleteEmployee(final Employee employee) {
        String sql ="DELETE from employee where empId=?";

        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setLong(1,employee.getEmpId());
                boolean test=preparedStatement.execute();
                if (test)
                    return true;
                else
                    return false;
            }
        });
    }


}
