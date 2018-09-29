package com.cheney.springcloud.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long deptno;
    private String dname;
    //来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一信息被存储到不同数据库
    private String db_source;
    
    public Dept(String dname) {
        this.dname = dname;
    }
}
