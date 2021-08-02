package com.cg.onlinetutorfinder.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Util {
	
	@Autowired
	ModelMapper modelMapper;
	
	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	   // return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
		return null;
	}

}
