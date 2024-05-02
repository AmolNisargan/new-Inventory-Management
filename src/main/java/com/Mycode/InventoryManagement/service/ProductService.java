package com.Mycode.InventoryManagement.service;

import java.util.List;

import com.Mycode.InventoryManagement.dto.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> getProducts();

	public void saveProduct(ProductDTO theProduct);

	public ProductDTO getProducts(int theId);

	public void deleteProduct(int theId);

}
