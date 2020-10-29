package com.chb.service;

import com.chb.dao.ExchangeRateMapper;
import com.chb.pojo.ExchangeRate;

import java.util.List;

public class ExchangeRateServiceImpl implements  ExchangeRateService{

    //service调DAO层：组合Dao
    private ExchangeRateMapper exchangeRateMapper;

    public void setExchangeRateMapper(ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateMapper = exchangeRateMapper;
    }

    public int addExchangeRate(ExchangeRate exchangeRate) {
        return exchangeRateMapper.addExchangeRate(exchangeRate);
    }

    public int deleteExchangeRateById(int id) {
        return exchangeRateMapper.deleteExchangeRateById(id);
    }

    public int updateExchangeRate(ExchangeRate exchangeRate) {
        return exchangeRateMapper.updateExchangeRate(exchangeRate);
    }

    public ExchangeRate queryExchangeRateById(int id) {
        return exchangeRateMapper.queryExchangeRateById(id);
    }

    public List<ExchangeRate> queryAllExchangeRate() {
        return exchangeRateMapper.queryAllExchangeRate();
    }

    public List<ExchangeRate> queryExchangeRateByName(String name) {
        return exchangeRateMapper.queryExchangeRateByName(name);
    }

}
