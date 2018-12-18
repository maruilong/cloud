package com.xinyuan.elasticsearch;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddDataDTO implements Serializable {

    private JSONObject jsonObject;

    private String index;

    private String type;
}
