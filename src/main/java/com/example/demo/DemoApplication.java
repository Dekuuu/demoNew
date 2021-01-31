package com.example.demo;

import com.example.demo.entity.User;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
//@EnableSwagger2Doc                  //开启swagger
@EnableScheduling                   //开启定时任务
@EnableAsync                        //开启异步
@MapperScan(value={"com.example.demo.mapper"})      //扫描mapper包
@EnableDiscoveryClient                              //开启nacos服务客户端注册
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

//        函数引用式
//        Stream.of("apple","banana","orange").map(e->e.length()).forEach(e-> System.out.println(e));

//        lambda表达式
//        Stream.of("apple","banana","orange").map(String :: length).forEach(System.out::println);

//        limit(number)，只输出前几个元素
//        Stream.of(1,3,7,4).limit(2).forEach(System.out :: println);

//        filter过滤，筛选符合条件的
//        List<String> list = Stream.of("apple", "banana", "orange", "peer", "lemon").parallel()
//                .filter(e -> !"peer".equals(e))
//                .collect(Collectors.toList());
//        list.stream().forEach(System.out :: println);

//        找最大值，要根据比较器来比较，执行的顺序：先排序，再比较；以下返回的是最小值
//        Optional<Integer> max = Stream.of(1, 100, 23, 98).max((o1, o2) -> o2 - o1);
//        System.out.println(max.get());

//        List<User> list=new ArrayList<User>();
//        List<User> result=new ArrayList<User>();
//        for(int i=0;i<10;i++){
//            User user=new User();
//            user.setAge(i);
//            user.setUserName("name"+i);
//            list.add(user);
//        }
//        修改每个对象触发复杂的方法
//        list.parallelStream().map(user -> {
//            user.setUserName("a");
//            return user;
//        }).forEach(e -> result.add(e));
//        .collect(Collectors.toList()).stream().forEach(System.out :: println)
        /*String str="101";
        char []array=str.toCharArray();
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=(Integer.parseInt(array[i]+""))*(2<<(array.length-2-i));
        }
        System.out.println(2<<-1);
        System.out.println(sum);*/

       /*int number = 21;
        String bytes=toBytes(number);
        if(bytes.contains("101")){
            System.out.println("0 -1");
        }else{
            System.out.println(bytes.split("101").length-1+" "+bytes.indexOf("101"));
        }
    }

    public static String toBytes(int number){
        String str="";
        while(number/2>=0){
            str+=number%2;
            number/=2;
        }
        String result=reverse(str);
        return result;*/
       User u=new User();
       u.setUserName("aaa");
       tt(u);
        System.out.println("名字是"+u.getUserName());
    }

    public static String reverse(String str){
        char []array=str.toCharArray();
        char []result=new char[array.length];
        for(int i=0 ;i<array.length;i++){
            result[array.length-i-1]=array[i];
        }
        return result.toString();
    }

    public static User tt(User user){
        user.setUserName("bbb");
        return user;
    }

}
