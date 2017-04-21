package com.sudaotech.core.enums.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import com.sudaotech.core.enums.PlatformSource;

public class PlatformSourceHandler implements TypeHandler<PlatformSource> {

    @Override
    public PlatformSource getResult(ResultSet rs, String column) throws SQLException {
        return PlatformSource.codeOf(rs.getInt(column));
    }

    @Override
    public PlatformSource getResult(ResultSet rs, int i) throws SQLException {
        return PlatformSource.codeOf(rs.getInt(i));
    }

    @Override
    public PlatformSource getResult(CallableStatement cs, int i) throws SQLException {
        return PlatformSource.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, PlatformSource param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
