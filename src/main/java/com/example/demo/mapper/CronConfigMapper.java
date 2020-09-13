package com.example.demo.mapper;

import com.example.demo.entity.CronConfig;
import org.springframework.data.repository.query.Param;

public interface CronConfigMapper {
    public String queryCronSwitchByKey(@Param("key") String key);

    public String queryCronTimeByKey(@Param("key") String key);
}
