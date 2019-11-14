package com.zwd.springboot.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zwd.springboot.entity.PageInfo;
import com.zwd.springboot.entity.PageQuery;
import com.zwd.springboot.entity.Product;
import com.zwd.springboot.entity.ResultBean;
import com.zwd.springboot.service.IProductService;
import com.zwd.springboot.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 操作商品的控制层
 * @author yizl
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService service;
	
	@GetMapping("/helloProduct")
	public String helloProduct() {
		return "Hello Product !";
	}
	
	
	@PostMapping("/getProductList")
	public ResultBean<PageQuery<Product>> getProductList(@RequestBody PageQuery<Product> pageQuery) {
		PageInfo pageInfo = pageQuery.getPageInfo();
		Page<Product> page = PageHelper.startPage(pageInfo);
		//也可以使用PageHelper的排序
		//PageHelper.orderBy("id desc");
		List<Product> pList=service.getProductList(pageQuery);
		pageInfo.setTotal(page.getTotal());
		pageQuery.setResults(pList);
		
		return ResultUtil.success(pageQuery);
	}
	
	@PostMapping("/addProduct")
	public ResultBean<Product> addProduct(@RequestBody Product product) throws IOException{
		service.addProduct(product);
		return ResultUtil.success();
	}
	
	@GetMapping("/deleteProductById")
	public ResultBean<Product> deleteProductById(String id) throws IOException{
		service.deleteProductById(id);
		return ResultUtil.success();
	}
	
	@PostMapping("/updateProductById")
	public ResultBean<Product> updateProductById(@RequestBody Product product) throws IOException{
		service.updateProductById(product);
		return ResultUtil.success();
	}
	
}
