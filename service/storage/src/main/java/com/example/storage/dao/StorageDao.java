package com.example.storage.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageDao {

    @Update("UPDATE storage SET used = used + #{count}, residue = residue - #{count} WHERE product_id = #{productId}")
    boolean decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
