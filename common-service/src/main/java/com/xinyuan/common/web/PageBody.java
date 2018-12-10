package com.xinyuan.common.web;

import com.xinyuan.c.common.web.Conditions;
import com.xinyuan.common.service.Order;
import com.xinyuan.common.service.PageBean;
import com.xinyuan.common.web.Conditions;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author hzx
 * @Description:
 * @date 2018/4/917:48
 */
@Data
public class PageBody {

    private PageBean pageBean;

    private ArrayList<Conditions> conditions;

    private Order order;
}
