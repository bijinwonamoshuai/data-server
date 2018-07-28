package com.deepthink.scdata.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DetCountDetailDao{

    @Select("SELECT * FROM `test`.`det_count_detail` WHERE id = #{id}")
    DetCountDetail findById(Long id);

    @Insert("INSERT INTO `test`.`det_count_detail` (class_id,course_id,year,month,day,second,det_count) " +
            "VALUES(#{class_id},#{course_id},#{year},#{month},#{day},#{second},#{det_count})")
    int insert(DetCountDetail detCountDetail);

    @Insert("<script>"+
            "INSERT INTO `test`.`det_count_detail` (class_id,course_id,year,month,day,second,det_count) VALUES" +
            "<foreach collection=\"list\" item=\"dataone\" separator=\",\">" +
            "(#{dataone.class_id},#{dataone.course_id},#{dataone.year},#{dataone.month},#{dataone.day},#{dataone.second},#{dataone.det_count})" +
            "</foreach ></script>")
    int insertBatch(List<DetCountDetail> detCountDetails);


    @Select("select det_count from `test`.`det_count_detail` where second=(select max(second) from `test`.`det_count_detail`)")
    Integer findLastest();
}
