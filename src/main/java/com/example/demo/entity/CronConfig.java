package com.example.demo.entity;

import lombok.Data;

/**
 * 定时任务配置信息
 */
@Data
public class CronConfig {
    private int id;
    private String key;
    private String switchOn;
    private String excuteTime;
    private String description;
}
