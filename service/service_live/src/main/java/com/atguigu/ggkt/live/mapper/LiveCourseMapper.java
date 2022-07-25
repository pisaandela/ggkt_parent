package com.atguigu.ggkt.live.mapper;

import com.atguigu.ggkt.model.live.LiveCourse;
import com.atguigu.ggkt.vo.live.LiveCourseVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 直播课程表 Mapper 接口
 * </p>
 *
 * @author ljj
 * @since 2022-07-25
 */
@Repository
public interface LiveCourseMapper extends BaseMapper<LiveCourse> {

    List<LiveCourseVo> findLatelyList();
}
