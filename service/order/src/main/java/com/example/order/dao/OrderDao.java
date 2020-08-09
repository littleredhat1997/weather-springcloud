package com.example.order.dao;

import com.example.order.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {

    @Insert("INSERT INTO `order` (id, user_id, product_id, count, money, `status`) VALUES (NULL, #{userId}, #{productId}, #{count}, #{money}, 0);")
    void create(Order order);

    @Update("UPDATE `order` SET status = #{status} WHERE user_id = #{userId};")
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
