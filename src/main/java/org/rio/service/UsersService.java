package org.rio.service;

import org.rio.bean.Users;

/**
 * @author Mloong
 * @version 0.0.1
 * <p></p>
 * @since 2020/7/31
 **/
public interface UsersService {

    Users findById(Long id);
}
