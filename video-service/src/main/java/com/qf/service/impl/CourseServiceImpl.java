package com.qf.service.impl;

import com.qf.dao.CourseMapper;
import com.qf.dao.VideoMapper;
import com.qf.pojo.Course;
import com.qf.pojo.CourseExample;
import com.qf.pojo.Video;
import com.qf.service.CourseService;
import com.qf.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseMapper.selectByExample(null);
    }

    @Override
    public Course findById(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Course> findSubjectId(Integer id) {

        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andSubjectIdEqualTo(id);
        List<Course> courses = courseMapper.selectByExample(example);
        return courses;
    }

    @Override
    public Course findVideoById(Integer id) {

        return courseMapper.findVideoById(id);
    }
}
