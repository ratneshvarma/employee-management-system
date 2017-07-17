package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Branch;
import com.ratnesh.ems.model.Designation;
import com.ratnesh.ems.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 31/5/17.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Map getBranches() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Branch> branches=  session.createQuery("from Branch").list();
        Map<Integer, String> branchList = new HashMap<Integer, String>();
        for (Branch branch: branches){
            branchList.put(branch.getBranchId().intValue(), branch.getName());
        }
        System.out.println("Branch List: "+ branchList);
        return branchList;
    }

    public Map getDesignation() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Designation> designations=  session.createQuery("from Designation").list();
        Map<Integer, String> designationList = new HashMap<Integer, String>();
        for (Designation designation: designations){
            designationList.put(designation.getDesignationId().intValue(), designation.getDescription());
        }
        System.out.println("Designa List: "+ designationList);
        return designationList;
    }
//
//    public Integer getEmployeeId() {
//        String sql = "SELECT max(empId) FROM employee";
//        return jdbcTemplate.queryForObject(sql, Integer.class);
//    }

    public Boolean insertEmployee(Employee employee) {
//        String sql ="INSERT INTO employee (empId, firstName, lastName, dob, gender, age, maritalStatus, doj, designation, email, mobile, address, branchId,photo) VALUES (?, ?, ?, ?, ?,?,?, ?, ?,?,?,?,?,?)";
//        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
//            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
//
//                preparedStatement.setLong(1,employee.getEmpId());
//                preparedStatement.setString(2,employee.getFirstName());
//                preparedStatement.setString(3,employee.getLastName());
//                preparedStatement.setString(4,employee.getDob());
//                preparedStatement.setString(5,employee.getGender());
//                preparedStatement.setInt(6,employee.getAge());
//                preparedStatement.setString(7,employee.getMaritalStatus());
//                preparedStatement.setString(8,employee.getDoj());
//                preparedStatement.setString(9,employee.getDesignation());
//                preparedStatement.setString(10,employee.getEmail());
//                preparedStatement.setString(11,employee.getMobile());
//                preparedStatement.setString(12,employee.getAddress());
//                preparedStatement.setLong(13,employee.getBranchId());
//
//                String photoName=null;
//                if(!employee.getPhoto().getOriginalFilename().isEmpty()){
//                    String fileExtention[] = employee.getPhoto().getOriginalFilename().split("\\.");
//                    photoName =  employee.getFirstName() +"_"+employee.getEmpId()+ "." + fileExtention[1];
//                }
//
//                preparedStatement.setString(14,photoName);
//                preparedStatement.execute();
//
//
//                return true;
//            }
//        });
        Session session=this.sessionFactory.getCurrentSession();
        session.save(employee);
        return true;
    }

    public List<Employee> getEmployees() {
//
//        return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {
//            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
//            Employee employee = new Employee();
//            employee.setEmpId(resultSet.getLong("empId"));
//            employee.setFirstName(resultSet.getString("firstName"));
//            employee.setLastName(resultSet.getString("lastName"));
//            employee.setDob(resultSet.getString("dob"));
//            employee.setGender(resultSet.getString("gender"));
//            employee.setAge(resultSet.getInt("age"));
//            employee.setMaritalStatus(resultSet.getString("maritalStatus"));
//            employee.setDoj(resultSet.getString("doj"));
//            employee.setDesignation(
//                jdbcTemplate.query("select designation from designation where designationId="+resultSet.getString("designation"), new ResultSetExtractor<String>() {
//                    public String extractData(ResultSet result) throws SQLException, DataAccessException {
//                       String DesignationName =null;
//                        while(result.next()){
//                            DesignationName=result.getString("designation");
//                        }
//                        return DesignationName;
//                    }
//                })
//            );
//
//            employee.setEmail(resultSet.getString("email"));
//            employee.setMobile(resultSet.getString("mobile"));
//            employee.setAddress(resultSet.getString("address"));
//            employee.setBranchId(resultSet.getLong("branchId"));
//            return employee;
//            }
//        });
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        return employeeList;
    }

    public Boolean deleteEmployee(Employee employee) {
//        String sql ="DELETE from employee where empId=?";
//
//        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
//            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
//                preparedStatement.setLong(1,employee.getEmpId());
//                boolean test=preparedStatement.execute();
//                if (test)
//                    return true;
//                else
//                    return false;
//            }
//        });
        Session session=this.sessionFactory.getCurrentSession();
        employee= (Employee) session.load(Employee.class, employee.getEmpId());
        if(employee!=null)
            session.delete(employee);
        return true;
    }

    public Employee getEmployeeForUpdate(Employee employee) {
//        return jdbcTemplate.queryForObject("select * from employee where empId=?",new Object[] { employee.getEmpId() }, new RowMapper<Employee>() {
//            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
//                Employee employee1 = new Employee();
//                employee1.setEmpId(resultSet.getLong("empId"));
//                employee1.setFirstName(resultSet.getString("firstName"));
//                employee1.setLastName(resultSet.getString("lastName"));
//                employee1.setDob(resultSet.getString("dob"));
//                employee1.setGender(resultSet.getString("gender"));
//                employee1.setAge(resultSet.getInt("age"));
//                employee1.setMaritalStatus(resultSet.getString("maritalStatus"));
//                employee1.setDoj(resultSet.getString("doj"));
//                employee1.setDesignation(resultSet.getString("designation"));
//
//                employee1.setEmail(resultSet.getString("email"));
//                employee1.setMobile(resultSet.getString("mobile"));
//                employee1.setAddress(resultSet.getString("address"));
//                employee1.setBranchId(resultSet.getLong("branchId"));
//                employee1.setImageName(resultSet.getString("photo"));
//                return employee1;
//            }
//        });
        Session session=this.sessionFactory.getCurrentSession();
        Employee employee1= (Employee) session.get(Employee.class, employee.getEmpId());
        return  employee1;
    }

    public Boolean updateEmployee(Employee employee) {
//        String sql=null;
//        if(!employee.getPhoto().getOriginalFilename().isEmpty())
//            sql ="UPDATE employee SET firstName=?, lastName=?, dob=?, gender=?, age=?, maritalStatus=?, doj=?, designation=?, email=?, mobile=?, address=?, branchId=?,photo=? where empId=?";
//        else
//            sql ="UPDATE employee SET firstName=?, lastName=?, dob=?, gender=?, age=?, maritalStatus=?, doj=?, designation=?, email=?, mobile=?, address=?, branchId=? where empId=?";
//
//        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
//            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
//
//                preparedStatement.setString(1,employee.getFirstName());
//                preparedStatement.setString(2,employee.getLastName());
//                preparedStatement.setString(3,employee.getDob());
//                preparedStatement.setString(4,employee.getGender());
//                preparedStatement.setInt(5,employee.getAge());
//                preparedStatement.setString(6,employee.getMaritalStatus());
//                preparedStatement.setString(7,employee.getDoj());
//                preparedStatement.setString(8,employee.getDesignation());
//                preparedStatement.setString(9,employee.getEmail());
//                preparedStatement.setString(10,employee.getMobile());
//                preparedStatement.setString(11,employee.getAddress());
//                preparedStatement.setLong(12,employee.getBranchId());
//
//                String photoName=null;
//                if(!employee.getPhoto().getOriginalFilename().isEmpty()){
//                    String fileExtention[] = employee.getPhoto().getOriginalFilename().split("\\.");
//                    photoName =  employee.getFirstName() +"_"+employee.getEmpId()+ "." + fileExtention[1];
//                }
//               if(!employee.getPhoto().getOriginalFilename().isEmpty()) {
//                   preparedStatement.setString(13, photoName);
//                   preparedStatement.setLong(14,employee.getEmpId());
//               }
//               else{
//                preparedStatement.setLong(13,employee.getEmpId());
//               }
//
//               preparedStatement.execute();
//
//                    return true;
//            }
//        });
        Session session=this.sessionFactory.getCurrentSession();
        session.update(employee);
        return true;
    }



}
