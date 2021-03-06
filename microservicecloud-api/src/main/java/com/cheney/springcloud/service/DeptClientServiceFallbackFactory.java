package com.cheney.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cheney.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            
            @Override
            public List<Dept> list() {
                return null;
            }
            
            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该ID: " + id + "没有对应的信息，consumer客户端提供的降级信息，此刻服务provider已经关闭").setDb_source("no this database in MySQL");
            }
            
            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }

}
