package com.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private int id;
    private String gname;
    private double goprice;
    private double grprice;
    private int gstore;
    private String gpicture;
    private int goodstype_id;
}
