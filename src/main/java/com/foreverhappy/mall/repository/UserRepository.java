package com.foreverhappy.mall.repository;

import com.foreverhappy.mall.domain.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author liuyuchuan
 * @date 2020/12/29
 */

@Repository
public interface UserRepository extends JpaRepository<UserDO, Integer> {

    @Transactional
    void deleteByUserName(String userName);

    Optional<UserDO> findFirstById(Integer id);
    Optional<UserDO> findUserNameById(Integer id);
    Optional<UserDO> findTop2ByUserName(String userName);
    List<UserDO> findByUserName(String userName, Sort sort);
    Page<UserDO> findByUserName(String userName, Pageable pageable);
}
