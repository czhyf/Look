package com.spring.srvice;

import com.spring.dao.TypeCountMapper;
import com.spring.pojo.PCount;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("PCountService")
public class PCountService {
    @Resource
    private TypeCountMapper typeCountMapper;

    //查询数据
    public PCount selectCount(String type){
       return  typeCountMapper.selectCount(type);
    }
    
    //更新数据
    public int update(PCount pcount) {
    	return typeCountMapper.updateCount(pcount);
    }
}
