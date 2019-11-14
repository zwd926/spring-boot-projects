package com.zwd.springboot.service;

import com.zwd.springboot.entity.PageQuery;
import com.zwd.springboot.entity.Product;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;

import java.io.IOException;

public interface ILuceneService {
	/**
	 * 启动后将同步Product表,并创建index
	 * @throws IOException 
	 */
	public void synProductCreatIndex() throws IOException;

	public PageQuery<Product> searchProduct(PageQuery<Product> pageQuery) throws IOException, ParseException, InvalidTokenOffsetsException;
}
