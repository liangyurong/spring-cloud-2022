package com.kuang.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

// 有参构造方法已经写了
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    // 主键
    private Long deptno;

    // 部门名称
    private String dname;

    // 同一个信息，可能存在于不同的数据库
    private String dbSource;

    public Dept(String dname) {
        this.dname = dname;
    }
}
