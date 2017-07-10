package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Salary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ratnesh on 10/7/17.
 */
public class SalaryDaoImpl implements SalaryDao {
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;
    public Map getEmployeeList() {
        return jdbcTemplate.query("select * from employee", new ResultSetExtractor<Map>() {
            public Map extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Map<Integer, String> employeeList = new HashMap<Integer, String>();
                while(resultSet.next()){
                    employeeList.put(resultSet.getInt("empId"), resultSet.getString("firstName")+"  "+resultSet.getString("lastName") +" ("+ resultSet.getInt("empId") +")   " );
                }
                return employeeList;
            }
        });
    }

    public Boolean insertSalary(final Salary salary) {
        String sql ="INSERT INTO salary (empId, salary, paymentDate, description) VALUES (?,?,?,?)";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {

                preparedStatement.setLong(1,salary.getEmpId());
                preparedStatement.setLong(2,salary.getSalary());
                preparedStatement.setString(3,salary.getPaymentDate());
                preparedStatement.setString(4,salary.getDescription());
                preparedStatement.execute();

                return true;
            }
        });
    }

    public List<Salary> getSalaries() {
        return jdbcTemplate.query("select * from salary", new RowMapper<Salary>() {
            public Salary mapRow(ResultSet resultSet, int i) throws SQLException {
                Salary salary = new Salary();
                salary.setSalaryId(resultSet.getLong("salaryId"));
                salary.setEmployeeName(
                        jdbcTemplate.query("select firstName,lastName from employee where empId="+resultSet.getLong("empId"), new ResultSetExtractor<String>() {
                            public String extractData(ResultSet result) throws SQLException, DataAccessException {
                                String empName =null;
                                while(result.next()){
                                    empName=result.getString("firstName")+" "+result.getString("lastName");
                                }
                                return empName;
                            }
                        })
                );
                salary.setEmpId(resultSet.getLong("empId"));
                salary.setSalary(resultSet.getLong("salary"));
                salary.setPaymentDate(resultSet.getString("paymentDate"));
                salary.setDescription(resultSet.getString("description"));;
                return salary;
            }
        });

    }

    public Boolean deleteSalary(final Salary salary) {
        String sql ="DELETE from salary where salaryId=?";

        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setLong(1,salary.getSalaryId());
                boolean test=preparedStatement.execute();
                if (test)
                    return true;
                else
                    return false;
            }
        });
    }

    public Boolean updateSalary(final Salary salary) {
        String sql ="UPDATE salary SET empId=?, salary=?, paymentDate=?, description=? where salaryId=?";

        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {

                preparedStatement.setLong(1,salary.getEmpId());
                preparedStatement.setLong(2,salary.getSalary());
                preparedStatement.setString(3,salary.getPaymentDate());
                preparedStatement.setString(4,salary.getDescription());
                preparedStatement.setLong(5,salary.getSalaryId());
                preparedStatement.execute();

                return true;
            }
        });
    }

    public Salary getSalaryForUpdate(Salary salary) {
        return jdbcTemplate.queryForObject("select * from salary where salaryId=?",new Object[] { salary.getSalaryId() }, new RowMapper<Salary>() {
            public Salary mapRow(ResultSet resultSet, int i) throws SQLException {
                Salary salary1 = new Salary();
                salary1.setSalaryId(resultSet.getLong("salaryId"));
                salary1.setEmpId(resultSet.getLong("empId"));
                salary1.setSalary(resultSet.getLong("salary"));
                salary1.setPaymentDate(resultSet.getString("paymentDate"));
                salary1.setDescription(resultSet.getString("description"));
                return salary1;
            }
        });
    }
}
