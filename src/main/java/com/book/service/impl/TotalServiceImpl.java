package com.book.service.impl;

import com.book.entity.Total;
import com.book.mapper.TotalMapper;
import com.book.service.TotalService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class TotalServiceImpl implements TotalService {
    @Override
    public Total getTheTotal() {
        try (SqlSession session = MybatisUtil.getSession()) {
            TotalMapper mapper = session.getMapper(TotalMapper.class);
            return  mapper.getTotal();
        }
    }
}
