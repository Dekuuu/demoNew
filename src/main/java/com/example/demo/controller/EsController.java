package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.testservice.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/es/")
@RestController
public class EsController {

    @Autowired
    private EsService esService;
    @RequestMapping(value = "query",method = RequestMethod.GET)
    public List<Map<String, Object>> getData(){
        return esService.get();
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(){
        esService.insertBatch();
        return "";
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete(){
        esService.delete();
        return "";
    }
}
