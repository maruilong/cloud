package com.xinyuan.circle.common.web;

import com.xinyuan.circle.common.service.Order;
import com.xinyuan.circle.common.service.PageBean;
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
