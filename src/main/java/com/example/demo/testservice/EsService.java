package com.example.demo.testservice;

import java.util.List;
import java.util.Map;

public interface EsService {
    public void add();

    public void insertBatch();

    public void update();

    public List<Map<String, Object>> get();

    public void delete();
}
