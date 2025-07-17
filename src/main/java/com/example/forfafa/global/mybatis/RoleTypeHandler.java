package com.example.forfafa.global.mybatis;
import com.example.forfafa.domain.user.model.Role;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class RoleTypeHandler extends BaseTypeHandler<Role> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Role role, JdbcType jdbcType) throws SQLException {
        ps.setString(i, role.name());
    }

    @Override
    public Role getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Role.valueOf(rs.getString(columnName));
    }

    @Override
    public Role getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Role.valueOf(rs.getString(columnIndex));
    }

    @Override
    public Role getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Role.valueOf(cs.getString(columnIndex));
    }
}