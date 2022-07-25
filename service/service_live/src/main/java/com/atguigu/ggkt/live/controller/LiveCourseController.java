package com.atguigu.ggkt.live.controller;


import com.atguigu.ggkt.live.service.LiveCourseAccountService;
import com.atguigu.ggkt.live.service.LiveCourseService;
import com.atguigu.ggkt.model.live.LiveCourse;
import com.atguigu.ggkt.model.live.LiveCourseAccount;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.live.LiveCourseConfigVo;
import com.atguigu.ggkt.vo.live.LiveCourseFormVo;
import com.atguigu.ggkt.vo.live.LiveCourseVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 直播课程表 前端控制器
 * </p>
 *
 * @author ljj
 * @since 2022-07-25
 */
@RestController
@RequestMapping("/admin/live/liveCourse")
public class LiveCourseController {

    @Autowired
    private LiveCourseService liveCourseService;

    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") Long limit) {
        Page<LiveCourse> pageParam = new Page<>(page, limit);
        IPage<LiveCourse> pageModel = liveCourseService.selectPage(pageParam);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "直播课程新增")
    @PostMapping("save")
    public Result save(@RequestBody LiveCourseFormVo liveCourseVo) {
        liveCourseService.saveLive(liveCourseVo);
        return Result.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable("id") Long id) {
        liveCourseService.removeLive(id);
        return Result.ok();
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result<LiveCourse> get(@PathVariable("id") Long id) {
        LiveCourse liveCourse = liveCourseService.getById(id);
        return Result.ok(liveCourse);
    }

    @ApiOperation(value = "获取")
    @GetMapping("getInfo/{id}")
    public Result<LiveCourseFormVo> getInfo(@PathVariable("id") Long id) {
        LiveCourseFormVo liveCourseFormVo = liveCourseService.getLiveCourseFormVo(id);
        return Result.ok(liveCourseFormVo);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody LiveCourseFormVo liveCourseVo) {
        liveCourseService.updateLiveById(liveCourseVo);
        return Result.ok();
    }

    @ApiOperation(value = "获取直播账号信息")
    @GetMapping("getLiveCourseAccount/{id}")
    public Result<LiveCourseAccount> getLiveCourseAccount(@PathVariable("id") Long id) {
        LiveCourseAccount liveCourseAccount = liveCourseAccountService.getByLiveCourseId(id);
        return Result.ok(liveCourseAccount);
    }

    @ApiOperation(value = "获取直播配置信息")
    @GetMapping("getCourseConfig/{id}")
    public Result getCourseConfig(@PathVariable("id") Long id) {
        LiveCourseConfigVo liveCourseConfigVo = liveCourseService.getCourseConfig(id);
        return Result.ok(liveCourseConfigVo);
    }

    @ApiOperation(value = "修改配置")
    @PutMapping("updateConfig")
    public Result updateConfig(@RequestBody LiveCourseConfigVo liveCourseConfigVo) {
        liveCourseService.updateConfig(liveCourseConfigVo);
        return Result.ok();
    }

    @ApiOperation(value = "获取最近的直播")
    @GetMapping("findLatelyList")
    public Result findLatelyList() {
        List<LiveCourseVo> list = liveCourseService.findLatelyList();
        return Result.ok(list);
    }
}

