package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.atguigu.ggkt.vod.service.ChapterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author ljj
 * @since 2022-07-21
 */
@RestController
@RequestMapping("/admin/vod/chapter")
//@CrossOrigin
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    // 大纲列表（章节和小节列表）
    @ApiOperation("大纲列表")
    @GetMapping("getNestedTreeList/{courseId}")
    public Result getTreeList(@PathVariable("courseId") Long courseId){
        List<ChapterVo> list = chapterService.getTreeList(courseId);
        return Result.ok(list);
    }

    // 添加章节
    @ApiOperation("添加章节")
    @PostMapping("save")
    public Result save(@RequestBody Chapter chapter){
        chapterService.save(chapter);
        return Result.ok();
    }

    //修改-根据id查询
    @ApiOperation("根据id查询章节")
    @GetMapping("get/{id}")
    public Result get(@PathVariable("id") Long id){
        Chapter chapter = chapterService.getById(id);
        return Result.ok(chapter);
    }

    //修改-最终实现
    @ApiOperation("修改章节")
    @PostMapping("update")
    public Result update(@RequestBody Chapter chapter){
        chapterService.updateById(chapter);
        return Result.ok();
    }

    //删除章节
    @ApiOperation("修改章节")
    @DeleteMapping("remove/{id}")
    public Result delete(@PathVariable("id") Long id){
        chapterService.removeById(id);
        return Result.ok();
    }
}

