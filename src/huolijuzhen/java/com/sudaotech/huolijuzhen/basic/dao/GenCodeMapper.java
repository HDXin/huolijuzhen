package com.sudaotech.huolijuzhen.basic.dao;

import com.sudaotech.huolijuzhen.dao.GenCodeEntityMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/**
 * Created by simon on 16-8-25.
 */
public interface GenCodeMapper extends GenCodeEntityMapper {
	
    @Select({
            "select max(code) from gen_code",
            "where codeType = #{codeType,jdbcType=VARCHAR}  and lastUpdate between #{startTime,jdbcType=TIMESTAMP} and  #{endTime,jdbcType=TIMESTAMP}"
    })
    Long selectMaxCodeByTime(@Param("codeType") String codeType, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Select({
            "select max(code) from gen_code",
            "where codeType = #{codeType,jdbcType=VARCHAR}"
    })
    Long selectMaxCode(@Param("codeType") String codeType);
}
