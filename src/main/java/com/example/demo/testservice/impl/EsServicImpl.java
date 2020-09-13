package com.example.demo.testservice.impl;

import com.example.demo.entity.EsEntity;
import com.example.demo.entity.UserEs;
import com.example.demo.testservice.EsService;
import com.example.demo.utils.EsUtil;
import io.netty.util.concurrent.CompleteFuture;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
@Slf4j
public class EsServicImpl implements EsService {
    @Autowired
    private RestClient restClient;
//    添加@Qualifier，声明executor的bean对象
    @Autowired
    @Qualifier(value = "asyncServiceExecutor")
    private Executor executor;
    @Override
    public void add() {
        String Id = null;
        String index = "user";
        String id = "10001";
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("id", "10001")
                    .field("name", "张三")
                    .field("age", "28")
                    .field("country", "中国")
                    .field("addr", "广东深圳")
                    .field("data", "2020-01-15 20:47:20")
                    .field("birthday", "1992-01-01")
                    .endObject();
            Id = EsUtil.addData(builder, index, id);
        } catch (IOException e) {
            log.error("索引:{},id:{},添加数据失败", index, id);
        }
    }

    @Override
    public void insertBatch() {
        String index = "user";
        List<EsEntity> entityList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            String s = Integer.toString(i + 1);
            UserEs userEs = new UserEs();
            EsEntity esEntity = new EsEntity();
            userEs.setAge(12);
            userEs.setBirthdate(new Date());
            userEs.setUserName("asd");
            esEntity.setData(userEs);
            esEntity.setId(s);
            entityList.add(esEntity);
        }
//        线程异步添加
        CompletableFuture.runAsync(() -> {
            EsUtil.insertBatch(index, entityList);
        },executor);
    }

    @Override
    public void update() {

    }

    @Override
    public List<Map<String, Object>> get() {
        List<Map<String, Object>> list = new ArrayList<>();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        String[] fields = {"userName", "age", "birthdate"};
        //需要返回和不返回的字段，可以是数组也可以是字符串
        sourceBuilder.fetchSource(fields, null);
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        //添加查询条件
        builder.must(QueryBuilders.matchQuery("userName", "asd"));
        list = EsUtil.SearchDataPage("user", 1, 100, sourceBuilder, builder);
        return list;
    }

    @Override
    public void delete() {
        String index = "user";
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("age", "12");
        EsUtil.deleteByQuery(index, queryBuilder);
    }
}
