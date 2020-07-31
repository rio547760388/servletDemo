package org.rio.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.rio.bean.Menus;
import org.rio.bean.Users;
import org.rio.mapper.MenusMapper;
import org.rio.mapper.UsersMapper;
import org.rio.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mloong
 * @version 0.0.1
 * <p></p>
 * @since 2020/7/31
 **/
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private MenusMapper menusMapper;

    @Override
    public Users findById(Long id) {
        menusMapper.selectList(new QueryWrapper<Menus>());

        return usersMapper.selectByPrimaryKey(id);
    }
}
