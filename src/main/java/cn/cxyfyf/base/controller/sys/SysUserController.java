package cn.cxyfyf.base.controller.sys;

import cn.cxyfyf.base.controller.to.SysUserTo;
import cn.cxyfyf.base.controller.vo.SysUserVo;
import cn.cxyfyf.base.domain.SysUser;
import cn.cxyfyf.base.framework.utils.BeanConvertUtil;
import cn.cxyfyf.base.framework.utils.StringUtils;
import cn.cxyfyf.base.framework.web.controller.BaseController;
import cn.cxyfyf.base.framework.web.domain.AjaxResult;
import cn.cxyfyf.base.framework.web.page.TableDataInfo;
import cn.cxyfyf.base.service.sys.ISysUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 用户信息表Controller
 *
 * @author fengyingfeng
 * @date 2022-11-01
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/base/user")
public class SysUserController extends BaseController
{
    private final ISysUserService service;

    /**
     * 查询用户信息表分页列表
     * @param to to
     * @return AjaxResult
     */
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody SysUserTo to){
        Page<SysUser> page = service.selectListByPage(to);
        // 转换为vo用来数据传输
        List<SysUserVo> vos = BeanConvertUtil.convert(page.getRecords(), SysUserVo.class);
        return pageToDataTable(page.getTotal(), vos);
    }

    /**
     * 获取用户信息表详细信息
     * @param id
     * @return AjaxResult
     */
    @GetMapping("/getInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return service.getInfo(id);
    }

    /**
     * 新增用户信息表
     * @param to to
     * @return AjaxResult
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody SysUserTo to){
        SysUserTo.judgeParam(to, "deptId,loginName,userName,userType,email,phonenumber,sex,avatar");
        return service.add(to);
    }

    /**
     * 修改用户信息表
     * @param to id
     * @return AjaxResult
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody SysUserTo to){
        SysUserTo.judgeParam(to, "id,deptId,loginName,userName,userType,email,phonenumber,sex,avatar");
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
