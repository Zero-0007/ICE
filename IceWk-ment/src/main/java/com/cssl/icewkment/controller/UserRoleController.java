package com.cssl.icewkment.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.icewkment.commin.vo.UserNameVO;
import com.cssl.icewkment.entity.Role;
import com.cssl.icewkment.entity.User;
import com.cssl.icewkment.mapper.RoleMapper;
import com.cssl.icewkment.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/UserRole")
public class UserRoleController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @ApiOperation(value = "获取全部角色信息")
    @GetMapping("/getAllUserRole")
    public List<Role> getAllUserRole() {
        QueryWrapper<Role> Rolewrapper = new QueryWrapper<>();
        Rolewrapper.select();
        return roleMapper.selectList(Rolewrapper);
    }

    @ApiOperation(value = "获取全部用户名称")
    @GetMapping("/getAllUserName")
    public List<UserNameVO> getAllUserName() {
        List<UserNameVO> result = new ArrayList<>();

        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.select("username");
        UserNameVO userNameVO = null;
        List<User> users = userMapper.selectList(wrapper);
        for (User user1 : users) {
            userNameVO = new UserNameVO();
            BeanUtils.copyProperties(user1, userNameVO);
            result.add(userNameVO);
        }
        return result;
    }
}
