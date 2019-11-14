package com.zwd.springboot.controller;

import com.zwd.springboot.entity.PageQuery;
import com.zwd.springboot.entity.Product;
import com.zwd.springboot.entity.ResultBean;
import com.zwd.springboot.service.ILuceneService;
import com.zwd.springboot.utils.ResultUtil;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/product/search")
public class ProductSearchController {
	
	@Autowired
	private ILuceneService service;
	/**
	 * {
	 "pageInfo":{"pageNum":1,"pageSize":5},
	 "results":[{}],
	 "queryParam":{"searchKeyStr":""},
	 "params":{"category":"童装会场"}
	 }
	 * @param pageQuery
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/searchProduct")
	private ResultBean<PageQuery<Product>> searchProduct(@RequestBody PageQuery<Product> pageQuery) throws Exception {
		PageQuery<Product> pageResult= service.searchProduct(pageQuery);
		return ResultUtil.success(pageResult);
	}
	
}
