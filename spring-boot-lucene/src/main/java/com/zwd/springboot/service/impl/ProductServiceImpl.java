package com.zwd.springboot.service.impl;

import com.zwd.springboot.dao.ILuceneDao;
import com.zwd.springboot.entity.PageQuery;
import com.zwd.springboot.entity.Product;
import com.zwd.springboot.mapper.ProductMapper;
import com.zwd.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductMapper mapper;
	
	@Autowired
	private ILuceneDao luceneDao;
	
	@Override
	public Product getProductById(String id) {
		return mapper.getProductById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		return mapper.getAllProduct();
	}

	@Override
	public List<Product> getProductList(PageQuery<Product> pageQuery) {
		return mapper.getProductList(pageQuery);
	}

	@Override
	public void addProduct(Product product) throws IOException {
		mapper.addProduct(product);
		//添加索引
		luceneDao.addProductIndex(product);
	}

	@Override
	public void deleteProductById(String id) throws IOException {
		mapper.deleteProductById(id);
		//删除索引
		luceneDao.deleteProductIndexById(id);
	}

	@Override
	public void updateProductById(Product product) throws IOException {
		mapper.updateProductById(product);
		//更新索引,先删除,在插入
		luceneDao.deleteProductIndexById(product.getId()+"");
		luceneDao.addProductIndex(product);
	}
	
	

}
