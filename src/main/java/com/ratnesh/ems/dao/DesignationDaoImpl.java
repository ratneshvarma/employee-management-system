package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Branch;
import com.ratnesh.ems.model.Designation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
public class DesignationDaoImpl implements  DesignationDao{
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    public Boolean insertDesignation(final Designation designation) {
        String sql ="INSERT INTO designation (designation, description) VALUES (?,?)";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {

                preparedStatement.setString(1,designation.getDesignation());
                preparedStatement.setString(2,designation.getDescription());
                preparedStatement.execute();


                return true;
            }
        });

    }

    public List<Designation> getDesignations() {
        return jdbcTemplate.query("select * from designation", new RowMapper<Designation>() {
            public Designation mapRow(ResultSet resultSet, int i) throws SQLException {
                Designation designation = new Designation();
                designation.setDesignationId(resultSet.getLong("designationId"));
                designation.setDesignation(resultSet.getString("designation"));
                designation.setDescription(resultSet.getString("description"));;
                return designation;
            }
        });

    }

    public Boolean deleteDesignation(final Designation designation) {
        String sql ="DELETE from designation where designationId=?";

        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setLong(1,designation.getDesignationId());
                boolean test=preparedStatement.execute();
                if (test)
                    return true;
                else
                    return false;
            }
        });
    }

    public Boolean updateDesignation(final Designation designation) {
        String sql ="UPDATE designation SET designation=?, description=? where designationId=?";

        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {

                preparedStatement.setString(1,designation.getDesignation());
                preparedStatement.setString(2,designation.getDescription());
                preparedStatement.setLong(3,designation.getDesignationId());
                preparedStatement.execute();

                return true;
            }
        });
    }

    public Designation getDesignationForUpdate(Designation designation) {
        return jdbcTemplate.queryForObject("select * from designation where designationId=?",new Object[] { designation.getDesignationId() }, new RowMapper<Designation>() {
            public Designation mapRow(ResultSet resultSet, int i) throws SQLException {
                Designation designation1 = new Designation();
                designation1.setDesignationId(resultSet.getLong("designationId"));
                designation1.setDesignation(resultSet.getString("designation"));
                designation1.setDescription(resultSet.getString("description"));
                return designation1;
            }
        });
    }

}
