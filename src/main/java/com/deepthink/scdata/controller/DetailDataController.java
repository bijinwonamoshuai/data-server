package com.deepthink.scdata.controller;


import com.deepthink.scdata.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@Api(value = "DetailData", description = "学生行为数据上报下载接口")
@RestController
@RequestMapping("/api")
public class DetailDataController {

    private final DetCountDetailDao detCountDetailDao;
    private final ActionDetailDao actionDetailDao;

    @Autowired
    public DetailDataController(DetCountDetailDao detCountDetailDao, ActionDetailDao actionDetailDao) {
        this.detCountDetailDao = detCountDetailDao;
        this.actionDetailDao = actionDetailDao;
    }

    @ApiOperation("Get Det Count Data")
    @GetMapping("/getDetData")
    public DetCountDetail findDetDataById(@RequestParam(value = "id", required = true) Long id) {
        return detCountDetailDao.findById(id);
    }


    @ApiOperation("根据班级号查询当前课程及老师信息")
    @GetMapping("/getCoureDesc")
    public TeacherAndcourseVO getCouserAndTeacherByCid(@RequestParam(value = "id", required = true) Long tid) {
        //一个班级id号下有多门课程，先拿到课程集合
        List<Course> course = actionDetailDao.getCouserById(tid);
        TeacherAndcourseVO teacho = new TeacherAndcourseVO();
        teacho.setStatus(1);
        //判断拿到课程对象是否为空，如果不为空，再判断当前时段是否有课程，否则直接反回status为1
        A: if (course != null) {
            for (int i = 0; i < course.size(); i++) {
                Long start = course.get(i).getStartTime().getTime();
                Long end = course.get(i).getEndTime().getTime();
                Long temp = System.currentTimeMillis();
                if ((temp.longValue() > start.longValue()) && (temp.longValue() < end.longValue())) {
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date begin=course.get(i).getStartTime();
                    String begine=sdf.format(begin);
                    Date stop=course.get(i).getEndTime();
                    String stope=sdf.format(stop);
                    Date date=new Date();
                    SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
                    String week=dateFm.format(date);
                    teacho.setWeek(week);
                    teacho.setStartTime(begine);
                    teacho.setEndTime(stope);
                    teacho.setCourseid(course.get(i).getCourid());
                    teacho.setTeacherid(course.get(i).getTeacherid());
                    //teacho.setTeacherid();
                    //获取课程名
                   // String cname = course.get(i).getCname();
                    //一个课程可能有多个老师教，所以根据班级号与课程名共同获取唯一的教师名
                    //String tname = actionDetailDao.getTnameByIdAndCname(tid,cname);
                    teacho.setStatus(0);
                    //teacho.setTname(tname);
                   // teacho.setCname(cname);
                    break A;
                } else {
                    teacho.setStatus(1);
                }
            }
        }
            return teacho;
    }




    @ApiOperation("Get Lastest Det Count")
    @GetMapping("/getLastestDetCount")
    public Integer findLastestDetCount(){
        return detCountDetailDao.findLastest();
    }

    @ApiOperation("Upload Det Count Data")
    @PostMapping("/addDetCountData")
    public int insertDetCountDetail(@RequestBody DetCountDetail detCountDetail) {
        int ret = detCountDetailDao.insert(detCountDetail);
        return ret;
    }

    @ApiOperation("Upload Det Count Data List")
    @PostMapping("/addDetCountDataList")
    public int insertDetCountDetail(@RequestBody List<DetCountDetail> detCountDetails) {
        int ret = detCountDetailDao.insertBatch(detCountDetails);
        return ret;
    }

    @ApiOperation("Upload Action Data List")
    @PostMapping("/addActionDataList")
    public int insertActionDataList(@RequestBody List<ActionDetail> actionDetails) {
        int ret = actionDetailDao.insertBatch(actionDetails);
//        System.out.print(ret);
        return ret;
    }

    @ApiOperation("Get Lastest Action Data ")
    @GetMapping("/getLastActionData")
    public List<ActionDetail> findActionDataById(){
        return actionDetailDao.findLastest();
    }

    @ApiOperation("Get Lastest Action Time ")
    @GetMapping("/getLastActionTime")
    public List<ActionTimeSummary> getLastActionTime(){
        return actionDetailDao.getLastestActionTime();
    }

    /**
     * @author luoyong
     * @date 2018/7/25-20:35
     * 以下是用来统一处理非法请求跳转到异常页面
     */
    @ApiOperation("运行时异常")
    @ExceptionHandler({ RuntimeException.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(RuntimeException exception) {
        ModelAndView m = new ModelAndView();
        m.setViewName("error");
        return m;
    }
    @ApiOperation("异常跳转页面")
    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        ModelAndView m = new ModelAndView();
        m.setViewName("error");
        return m;
    }

}
