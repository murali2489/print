/**
 * 
 */
package com.saimuga.abp.fileupload.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.saimuga.abp.fileupload.domain.Product;



/**
 * @author acogoluegnes
 *
 */
public class ProductJdbcItemWriter implements ItemWriter<Product> {
	
	private static final String INSERT_PRODUCT = "insert into product (id,name,description,price) values(?,?,?,?)";
	
	private static final String UPDATE_PRODUCT = "update product set name=?, description=?, price=? where id = ?";
	
	private JdbcTemplate jdbcTemplate;
	
	public ProductJdbcItemWriter(DataSource dataSource) {
		System.out.println("cxf");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends Product> items) throws Exception {
		System.out.println("cxf ProductJdbcItemWriter starts ");
		for(Product item : items) {
			int updated = jdbcTemplate.update(UPDATE_PRODUCT,
				item.getName(),item.getDescription(),item.getPrice(),item.getId()
			);
			if(updated == 0) {
				jdbcTemplate.update(
					INSERT_PRODUCT,
					item.getId(),item.getName(),item.getDescription(),item.getPrice()
				);	
			}								
			System.out.println("cxf ProductJdbcItemWriter ends ");
		}
	}

}
