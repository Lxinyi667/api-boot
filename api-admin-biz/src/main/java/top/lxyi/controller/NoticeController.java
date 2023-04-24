package top.lxyi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.lxyi.common.utils.PageResult;
import top.lxyi.common.utils.Result;
import top.lxyi.convert.NoticeConvert;
import top.lxyi.query.NoticeQuery;
import top.lxyi.service.NoticeService;
import top.lxyi.vo.NoticeVO;


import java.util.List;

/**
 * 通知模块接口
 */
@RestController
@RequestMapping("/sys/notice")
@Tag(name = "通知管理")
@AllArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("page")
    @Operation(summary = "通知分页")
    public Result<PageResult<NoticeVO>> page(@ParameterObject @Valid NoticeQuery query){
        PageResult<NoticeVO> page = noticeService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "通知列表")
    public Result<List<NoticeVO>> list() {
        return Result.ok(noticeService.getList());
    }

    @GetMapping("{id}")
    @Operation(summary = "通知信息")
    @PreAuthorize("hasAnyAuthority('sys:notice:info')")
    public Result<NoticeVO> get(@PathVariable("id") Long id) {
        return Result.ok(NoticeConvert.INSTANCE.convert(noticeService.getById(id)));
    }

    @PostMapping
    @Operation(summary = "新增通知")
    @PreAuthorize("hasAnyAuthority('sys:notice:save')")
    public Result<String> save(@RequestBody @Valid NoticeVO vo) {
        noticeService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改通知")
    @PreAuthorize("hasAnyAuthority('sys:notice:update')")
    public Result<String> update(@RequestBody @Valid NoticeVO vo) {
        noticeService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除通知")
    @PreAuthorize("hasAnyAuthority('sys:notice:delete')")
    public Result<String> delete(@PathVariable("id") Long id) {
        noticeService.delete(id);
        return Result.ok();
    }

    @DeleteMapping("batch")
    @Operation(summary = "批量删除通知")
    @PreAuthorize("hasAnyAuthority('sys:notice:delete')")
    public Result<String> deletes(@RequestBody Long[] ids) {
        noticeService.deleteBatch(ids);
        return Result.ok();
    }
}
