package com.zwd.springboot.service.impl;

import com.zwd.springboot.dao.ILuceneDao;
import com.zwd.springboot.entity.PageQuery;
import com.zwd.springboot.entity.Product;
import com.zwd.springboot.mapper.ProductMapper;
import com.zwd.springboot.service.ILuceneService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LuceneServiceImpl implements ILuceneService {

	@Autowired
	private ILuceneDao luceneDao;

	@Autowired
	private ProductMapper mapper;

	@Override
	public void synProductCreatIndex() throws IOException {
		// 获取所有的productList
		List<Product> allProduct = mapper.getAllProduct();
		// 再插入productList
		luceneDao.createProductIndex(allProduct);
	}

	@Override
	public PageQuery<Product> searchProduct(PageQuery<Product> pageQuery) throws IOException, ParseException, InvalidTokenOffsetsException {
		return luceneDao.searchProduct(pageQuery);
	}

}
