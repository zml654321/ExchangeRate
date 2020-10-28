package com.chb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate {
    private int id;
    private String currency;
    private String name;
    private String data;
    private String status;
    private String type;
}
