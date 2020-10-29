package com.chb.dao;

import com.chb.pojo.ExchangeRate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExchangeRateMapper {
    //增加一条汇利率记录
    int addExchangeRate(ExchangeRate exchangeRate);
    //删除一条汇利率记录
    int deleteExchangeRateById(@Param("id") int id);
    //更新一条汇利率记录
    int updateExchangeRate(ExchangeRate exchangeRate);
    //查询一条记录
    ExchangeRate queryExchangeRateById(@Param("id") int id);
    //查询全部记录
    List<ExchangeRate> queryAllExchangeRate();
    //根据名称查询记录
    List<ExchangeRate> queryExchangeRateByName(String name);
}
