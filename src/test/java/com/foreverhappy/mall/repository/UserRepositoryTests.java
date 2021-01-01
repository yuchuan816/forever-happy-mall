package com.foreverhappy.mall.repository;

import com.foreverhappy.mall.domain.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author liuyuchuan
 * @date 2020/12/29 上午11:55
 * @date 2020/12/29
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Resource
    UserRepository userRepository;

    @Test
    public void testAdd() {
        UserDO userDO = new UserDO();
        userDO.setSex(1);
        userDO.setUserName("liuyuchuan");
        userRepository.save(userDO);

        userDO.setId(null);
        userDO.setUserName("liuyuchuan");
        userRepository.save(userDO);

        userDO.setId(null);
        userDO.setUserName("liuyuchuan1");
        userRepository.save(userDO);

        userDO.setId(null);
        userDO.setUserName("liuyuchuan2");
        userRepository.save(userDO);

        userDO.setId(null);
        userDO.setUserName("liuyuchuan3");
        userRepository.save(userDO);

        userDO.setId(null);
        userDO.setUserName("liuyuchuan4");
        userRepository.save(userDO);


        userDO.setId(null);
        userDO.setUserName("liuyuchuan5");
        userRepository.save(userDO);
    }

    @Test
    public void testDelete() {
//        Optional<UserDO> option = userRepository.findById(2);
//
//        option.ifPresent((UserDO user) -> {
//            userRepository.delete(user);
//        });

        userRepository.deleteAll();
    }

    @Test
    public void testUpdate() {
        Optional<UserDO> user = userRepository.findFirstById(7);

        user.ifPresent((item) -> {
            item.setSex(1);
            item.setUserName("yuchuan");
            userRepository.save(item);
        });
    }



    @Test
    public void testFind() {
//        UserDO userDO = new UserDO();
//        userDO.setSex(1);
//        Example<UserDO> example = Example.of(userDO);
//        List<UserDO> users = userRepository.findAll(example);

//        Optional<UserDO> optional=userRepository.findById(1);
//        optional.ifPresent(user -> System.out.println(user.getUserName()));

//        Optional<UserDO> optional = userRepository.findUserNameById(7);
//        optional.ifPresent(user -> System.out.println(user.getUserName()));

//        Sort.TypedSort<UserDO> sort = Sort.sort(UserDO.class);
//        Slice<UserDO> users = userRepository.findByUserName("liuyuchuan", PageRequest.of(0, 2, sort.by(UserDO::getId).descending()));

    }
}
