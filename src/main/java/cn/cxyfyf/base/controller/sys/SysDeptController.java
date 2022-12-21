package cn.cxyfyf.base.controller.sys;

import cn.cxyfyf.base.controller.to.SysDeptTo;
import cn.cxyfyf.base.controller.vo.SysDeptVo;
import cn.cxyfyf.base.domain.SysDept;
import cn.cxyfyf.base.framework.utils.BeanConvertUtil;
import cn.cxyfyf.base.framework.utils.StringUtils;
import cn.cxyfyf.base.framework.web.controller.BaseController;
import cn.cxyfyf.base.framework.web.domain.AjaxResult;
import cn.cxyfyf.base.framework.web.page.TableDataInfo;
import cn.cxyfyf.base.service.sys.ISysDeptService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 部门表Controller
 *
 * @author fengyingfeng
 * @date 2022-11-01
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/base/dept")
public class SysDeptController extends BaseController
{
    private final ISysDeptService service;

    /**
     * 查询部门表分页列表
     * @param to to
     * @return AjaxResult
     */
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody SysDeptTo to){
        Page<SysDept> page = service.selectListByPage(to);
        // 转换为vo用来数据传输
        List<SysDeptVo> vos = BeanConvertUtil.convert(page.getRecords(), SysDeptVo.class);
        return pageToDataTable(page.getTotal(), vos);
    }

    /**
     * 获取部门表详细信息
     * @param id
     * @return AjaxResult
     */
    @GetMapping("/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return service.getInfo(id);
    }

    /**
     * 新增部门表
     * @param to to
     * @return AjaxResult
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody SysDeptTo to){
        SysDeptTo.judgeParam(to, "id,parentId,ancestors,deptName,orderNum,leader,phone,email,status,delFlag,createBy,createTime,updateBy,updateTime");
        return service.add(to);
    }

    /**
     * 修改部门表
     * @param to id
     * @return AjaxResult
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody SysDeptTo to){
        SysDeptTo.judgeParam(to, "id,parentId,ancestors,deptName,orderNum,leader,phone,email,status,delFlag,createBy,createTime,updateBy,updateTime");
        return service.edit(to);
    }

    /**
     * 根据ID修改状态
     * @param id id
     * @param status status
     * @return AjaxResult
     */
    @PutMapping("/edit/{id}/{status}")
    public AjaxResult edit(@PathVariable Long id, @PathVariable String status){
        if (Objects.isNull(id)) return AjaxResult.error("参数异常！");
        if (StringUtils.isEmpty(status)) return AjaxResult.error("参数异常！");
        return service.editStatus(id, status);
    }

    /**
     * 根据ID逻辑删除（批量和单个）
     * @param id id
     * @return AjaxResult
     */
    @DeleteMapping("/delete/{id}")
    public AjaxResult delete(@PathVariable Long id){
        if (Objects.isNull(id)) return AjaxResult.error("参数异常！");
        return service.delete(id);
    }
}
