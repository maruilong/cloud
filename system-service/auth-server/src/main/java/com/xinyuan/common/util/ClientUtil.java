package com.xinyuan.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 客户端工具类
 *
 * @author
 * @since 2018-03-06
 */
public class ClientUtil {
    /**
     * 获取客户端IP
     *
     * @author 2018-03-18 20:24
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
