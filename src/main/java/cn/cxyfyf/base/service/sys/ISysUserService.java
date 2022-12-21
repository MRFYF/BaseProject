package cn.cxyfyf.base.service.sys;

import cn.cxyfyf.base.controller.to.SysUserTo;
import cn.cxyfyf.base.domain.SysUser;
import cn.cxyfyf.base.framework.web.domain.AjaxResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户信息表Service接口
 * 
 * @author fengyingfeng
 * @date 2022-11-01
 */
public interface ISysUserService extends IService<SysUser>{

    /**
     * 查询用户信息表分页列表
     * @param to to
     * @return 分页列表
     */
    Page<SysUser> selectListByPage(SysUserTo to);

    /**
     * 根据ID获取详细信息
     * @param id id
     * @return 详细信息
     */
    AjaxResult getInfo(Long id);

    /**
     * 新增用户信息表
     * @param to to
     * @return result
     */
    AjaxResult add(SysUserTo to);

    /**
     * 修改用户信息表
     * @param to to
     * @return result
     */
    AjaxResult edit(SysUserTo to);

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
