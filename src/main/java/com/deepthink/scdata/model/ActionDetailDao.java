package com.deepthink.scdata.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper
public interface ActionDetailDao {
    @Select("SELECT * FROM `test`.`action_detail` WHERE id = #{id}")
    ActionDetail findById(Long id);

    @Select("select * from `test`.`action_detail` where second=(select max(second) from `test`.`action_detail`)")
    List<ActionDetail> findLastest();

    @Insert("<script>"+
            "INSERT INTO `test`.`action_detail` (class_id,student_id,teacher_id,course_id,state,year,month,day,second) VALUES" +
            "<foreach collection=\"list\" item=\"dataone\" separator=\",\">" +
            "(#{dataone.class_id},#{dataone.student_id},#{dataone.teacher_id},#{dataone.course_id},#{dataone.state}," +
            "#{dataone.year},#{dataone.month},#{dataone.day},#{dataone.second})" +
            "</foreach ></script>")
    int insertBatch(List<ActionDetail> actionDetails);

    @Select("SELECT SUM(t3.one_time) AS time,t3.state FROM\n" +
            "(SELECT t1.one_state_count / t2.count*5 AS one_time,t1.second, t1.state FROM " +
            "(SELECT COUNT(1) AS one_state_count, second, state FROM test.action_detail " +
            " GROUP BY second, state) AS t1 JOIN  \n" +
            "(SELECT COUNT(state) AS count,second FROM test.action_detail " +
            " GROUP BY second) AS t2 on t1.second = t2.second) AS t3 GROUP BY t3.state")
    @Results({
            @Result(property = "time",column = "time"),
            @Result(property = "state",column = "state")
    })
    List<ActionTimeSummary> getLastestActionTime();

    /**
     * 根据班级号查找当前课程编号,当前班级有多个课程
     */
    @Select("SELECT cname,startTime,endTime\n" +
            "FROM course c\n" +
            "WHERE c.id IN (SELECT course_id FROM action_detail WHERE class_id=#{tid} GROUP BY course_id HAVING COUNT(course_id)>1)")
     List<Course> getCouserById(Long tid);

    /**
     * 根据课程名和班级编号查找教师名称
     */
    @Select("SELECT t_name FROM teacher t WHERE t.id IN (SELECT  teacher_id FROM action_detail t WHERE t.class_id = #{arg0} AND t.course_id IN(SELECT id FROM course WHERE cname like #{arg1}))")
    String getTnameByIdAndCname(Long id,String cname);
}
