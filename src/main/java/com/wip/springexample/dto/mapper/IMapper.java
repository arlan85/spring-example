package com.wip.springexample.dto.mapper;

public interface IMapper <I,O> {
    O map(I in);
}
