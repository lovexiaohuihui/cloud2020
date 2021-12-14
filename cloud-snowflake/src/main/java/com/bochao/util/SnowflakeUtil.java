package com.bochao.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 生成雪花id工具类
 * @author 吴军杰
 * */
@Slf4j
@Component
public class SnowflakeUtil {

    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct
    public void init() {
        try{
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的id:" + workerId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("当前机器id获取失败");
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long getSnowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long getSnowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
}
