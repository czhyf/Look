package com.spring.dao;

import com.spring.pojo.PCount;

public interface TypeCountMapper {
    public PCount selectCount(String type);
    public int insertCount(PCount pCount);
    public int updateCount(PCount pCount);
}
