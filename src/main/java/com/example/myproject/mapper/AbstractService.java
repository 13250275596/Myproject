package com.example.myproject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService<R> {
    @Autowired
    protected R mapper;
}
