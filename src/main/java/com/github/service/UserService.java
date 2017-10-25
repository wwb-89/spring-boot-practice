package com.github.service;

import com.github.bean.PageBean;
import com.github.mapper.UserMapper;
import com.github.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by iMiracle on 24/10/2017.
 */
@Service("userService")
public class UserService {

    @Resource
    private UserMapper userMapper;

    /** 使用pagehelper分页
     * @Description: 
     * @author: 
     * @Date: 2017-10-25 09:23:49
     * @param: pageBean
     * @return: void
     */
    public void pagination(PageBean<User> pageBean) {
        PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());//后面跟查询语句
        List<User> users = userMapper.getAllXml();
        pageBean.pagination(users);
    }

}
