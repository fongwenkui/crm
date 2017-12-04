package com.java.service;

import java.util.List;

import com.java.dao.BaseDictDao;
import com.java.domain.BaseDict;

public interface BaseDictService extends BaseService<BaseDict> {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
