package com.foreverhappy.mall.service.impl;

import com.foreverhappy.mall.domain.UserDO;
import com.foreverhappy.mall.repository.UserRepository;
import com.foreverhappy.mall.service.UserService;
import com.foreverhappy.mall.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuyuchuan
 * @date 2021/1/7
 */
@Service
public class UserServiceImpl implements UserService {
    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserVo> getUserList() {
        List<UserDO> all = userRepository.findAll();
        return all.stream().map((item) -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(item, userVo);
            return userVo;
        }).collect(Collectors.toList());
    }
}
