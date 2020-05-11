package com.saimuga.abp.fileupload.domain.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.saimuga.abp.fileupload.domain.Product;

public class FiletoDomainMapper implements FieldSetMapper<Product>{

	@Override
	public Product mapFieldSet(FieldSet fieldSet) throws BindException {
		System.out.println("cxf ProductFieldSetMapper starts ");
		Product product = new Product();
		product.setId(fieldSet.readString("PRODUCT_ID"));
		product.setName(fieldSet.readString("NAME"));
		product.setDescription(fieldSet.readString("DESCRIPTION"));
		product.setPrice(fieldSet.readBigDecimal("PRICE"));
		System.out.println("cxf ProductFieldSetMapper ends ");
		return product;
	}

	

}
