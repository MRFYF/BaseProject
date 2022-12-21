package cn.cxyfyf.base.service.sys;

import cn.cxyfyf.base.controller.to.SysDeptTo;
import cn.cxyfyf.base.domain.SysDept;
import cn.cxyfyf.base.framework.web.domain.AjaxResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 部门表Service接口
 * 
 * @author fengyingfeng
 * @date 2022-11-01
 */
public interface ISysDeptService extends IService<SysDept>{

    /**
     * 查询部门表分页列表
     * @param to to
     * @return 分页列表
     */
    Page<SysDept> selectListByPage(SysDeptTo to);

    /**
     * 根据ID获取详细信息
     * @param id id
     * @return 详细信息
     */
    AjaxResult getInfo(Long id);

    /**
     * 新增部门表
     * @param to to
     * @return result
     */
    AjaxResult add(SysDeptTo to);

    /**
     * 修改部门表
     * @param to to
     * @return result
     */
    AjaxResult edit(SysDeptTo to);

    /**
     * 根据ID修改状态
     * @param id id
     * @param status 状态值
     */
    AjaxResult editStatus(Long id, String status);

    /**
     * 根据ID逻辑删除
     * @param id id
     */
    AjaxResult delete(Long id);


}
