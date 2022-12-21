package cn.cxyfyf.base.service.sys.impl;

import cn.cxyfyf.base.controller.to.SysUserTo;
import cn.cxyfyf.base.domain.SysUser;
import cn.cxyfyf.base.framework.utils.BeanConvertUtil;
import cn.cxyfyf.base.framework.utils.SecurityUtils;
import cn.cxyfyf.base.framework.web.domain.AjaxResult;
import cn.cxyfyf.base.framework.web.page.TableSupport;
import cn.cxyfyf.base.mapper.SysUserMapper;
import cn.cxyfyf.base.service.sys.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 用户信息表Service业务层处理
 *
 * @author fengyingfeng
 * @date 2022-11-01
 */
@RequiredArgsConstructor
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private final SysUserMapper mapper;

    /**
     * 分页列表查询
     * @param to to
     * @return 分页列表
     */
    @Override
    public Page<SysUser> selectListByPage(SysUserTo to) {
        Page<SysUser> page = TableSupport.getPage();
        SysUser entity = BeanConvertUtil.convert(to, SysUser.class);
        return mapper.selectListByPage(page, entity);
    }

    /**
     * 根据ID获取详细信息
     * @param id id
     * @return 详细信息
     */
    @Override
    public AjaxResult getInfo(Long id) {
        return AjaxResult.success(this.getById(id));
    }

    /**
     * 新增
     * @param to to
     * @return result
     */
    @Override
    public AjaxResult add(SysUserTo to) {
        SysUser entity = BeanConvertUtil.convert(to, SysUser.class);
        return AjaxResult.success(this.save(entity));
    }

    /**
     * 修改
     * @param to to
     * @return result
     */
    @Override
    public AjaxResult edit(SysUserTo to) {
        SysUser entity = BeanConvertUtil.convert(to, SysUser.class);
        return AjaxResult.success(this.updateById(entity));
    }

    /**
     * 根据ID修改状态
     * @param id id
     * @param status 状态
     * @return result
     */
    @Override
    public AjaxResult editStatus(Long id, String status) {
        UpdateWrapper<SysUser> wrapper = new UpdateWrapper<>();
        wrapper.set("status", status);
        wrapper.set("update_by", SecurityUtils.getUserId());
        wrapper.set("update_time", LocalDateTime.now());
        wrapper.eq("id", id);
        return AjaxResult.success(this.update(wrapper));
    }

    /**
     * 根据ID逻辑删除
     * @param id id
     * @return result
     */
    @Override
    public AjaxResult delete(Long id) {
        UpdateWrapper<SysUser> wrapper = new UpdateWrapper<>();
        wrapper.set("del_falg", 2);
        wrapper.set("update_by", SecurityUtils.getUserId());
        wrapper.set("update_time", LocalDateTime.now());
        wrapper.eq("id", id);
        return AjaxResult.success(this.update(wrapper));
    }

}