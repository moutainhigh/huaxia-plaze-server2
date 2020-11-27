package com.huaxia.plaze.modules.tongdun.service;

import com.huaxia.plaze.datasource.service.DataSourceCountService;
import com.huaxia.plaze.modules.tongdun.domain.MulBorInfo;

public interface MultipleBorrowService extends DataSourceCountService {
	
	int save(MulBorInfo mulBorInfo);
	
}
