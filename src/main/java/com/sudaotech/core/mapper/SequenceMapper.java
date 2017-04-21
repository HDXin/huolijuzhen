package com.sudaotech.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.sudaotech.core.dao.entity.Sequence;

public interface SequenceMapper {
    @Insert({
        "insert into ${tableName} ()",
        "values ()"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="sequence.sequenceId", before=false, resultType=Long.class)
    Long insert(@Param("sequence") Sequence sequence, @Param("tableName") String tableName);

//    @Insert({
//        "insert into ${tableName} (type)",
//        "values (#{sequence.type,jdbcType=VARCHAR})"
//    })
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="sequence.sequenceId", before=false, resultType=Long.class)
//    int insertWith(@Param("sequence") Sequence sequence, @Param("tableName") String tableName);

    @Insert({
        "insert into sequence(type, serial) (select type, max(serial)+1 from sequence where type = #{type})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="sequenceId", before=false, resultType=Long.class)
    int insertWithType(Sequence sequence);
    
    @Select({
        "select serial from sequence where sequenceId=${sequenceId}"
    })
    Long getSerialBySequenceId(@Param("sequenceId") Long sequenceId);
}