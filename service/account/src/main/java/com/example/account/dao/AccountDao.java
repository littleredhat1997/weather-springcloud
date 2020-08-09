package com.example.account.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountDao {

    @Update("UPDATE account SET residue = residue - #{money}, used = used + #{money} WHERE user_id = #{userId}")
    boolean decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
