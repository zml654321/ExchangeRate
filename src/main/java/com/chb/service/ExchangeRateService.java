package com.chb.service;

import com.chb.pojo.ExchangeRate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExchangeRateService {
    //增加一条汇利率记录
    int addExchangeRate(ExchangeRate exchangeRate);
    //删除一条汇利率记录
    int deleteExchangeRateById(int id);
    //更新一条汇利率记录
    int updateExchangeRate(ExchangeRate exchangeRate);
    //查询一条记录
    ExchangeRate queryExchangeRateById(int id);
    //查询全部记录
    List<ExchangeRate> queryAllExchangeRate();
    //根据名称查询记录
    List<ExchangeRate> queryExchangeRateByName(String name);
    //查询利率记录
    List<ExchangeRate> queryByType(String type);
    //更新汇率状态
    int updateERStatusById(int id,String status);
    //根据币种查询
    List<ExchangeRate> queryByCurrency(String status,String type,String currency);
}
