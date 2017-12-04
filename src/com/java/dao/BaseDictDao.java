package com.java.dao;

import java.util.List;

import javax.annotation.Resource;

import com.java.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
