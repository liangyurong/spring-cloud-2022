package com.kuang.springcloud.dao;

import com.kuang.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface DeptDao {

    // 增加一个部门
    boolean addDept(Dept dept);

    // 根据id查询部门
    Dept queryById(Long id);

    // 查询所有部门
    List<Dept> queryAll();


}
