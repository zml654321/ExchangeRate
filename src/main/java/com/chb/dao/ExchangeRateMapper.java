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
    //查询利率记录
    List<ExchangeRate> queryByType(String type);
    //更新汇率状态
    int updateERStatusById(@Param("id")int id,@Param("status")String status);
    //根据币种查询
    List<ExchangeRate> queryByCurrency(@Param("type") String type,@Param("currency") String currency);
    //根据名称名称查询记录
    List<ExchangeRate> queryByName(@Param("name") String name,@Param("type") String type);
    //存储数据替换显示数据，并将存储数据清空
    int updateERDataById(@Param("id") int id);
}
