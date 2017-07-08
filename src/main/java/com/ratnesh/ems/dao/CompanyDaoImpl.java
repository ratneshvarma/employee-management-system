package com.ratnesh.ems.dao;

import com.ratnesh.ems.model.Branch;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ratnesh on 8/7/17.
 */
public class CompanyDaoImpl implements  CompanyDao{
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    public Boolean insertBranch(final Branch branch) {
        String sql ="INSERT INTO branch (name, address) VALUES (?,?)";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {

                preparedStatement.setString(1,branch.getName());
                preparedStatement.setString(2,branch.getAddress());
                preparedStatement.execute();


                return true;
            }
        });

    }

    public List<Branch> getBranches() {
        return jdbcTemplate.query("select * from branch", new RowMapper<Branch>() {
            public Branch mapRow(ResultSet resultSet, int i) throws SQLException {
                Branch branch = new Branch();
                branch.setBranchId(resultSet.getLong("branchId"));
                branch.setName(resultSet.getString("name"));
                branch.setAddress(resultSet.getString("address"));;
                return branch;
            }
        });

    }

    public Boolean deleteBranch(final Branch branch) {
        String sql ="DELETE from branch where branchId=?";

        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setLong(1,branch.getBranchId());
                boolean test=preparedStatement.execute();
                if (test)
                    return true;
                else
                    return false;
            }
        });
    }

    public Boolean updateBranch(final Branch branch) {
        String sql ="UPDATE branch SET name=?, address=? where branchId=?";

        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {

                preparedStatement.setString(1,branch.getName());
                preparedStatement.setString(2,branch.getAddress());
                preparedStatement.setLong(3,branch.getBranchId());
                preparedStatement.execute();

                return true;
            }
        });
    }

    public Branch getBranchForUpdate(Branch branch) {
        return jdbcTemplate.queryForObject("select * from branch where branchId=?",new Object[] { branch.getBranchId() }, new RowMapper<Branch>() {
            public Branch mapRow(ResultSet resultSet, int i) throws SQLException {
                Branch branch1 = new Branch();
                branch1.setBranchId(resultSet.getLong("branchId"));
                branch1.setName(resultSet.getString("name"));
                branch1.setAddress(resultSet.getString("address"));
                return branch1;
            }
        });
    }

}
