package com.itcast.zwd.springboot.mapper;

import com.itcast.zwd.springboot.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 随风逐梦
 * @create 2019-11-05 13:53
 */
@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

}
