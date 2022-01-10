package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbc implements ProductDao {
    private DataSource dataSource;

    public ProductDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> getAll() {
        try (Connection con = dataSource.getConnection()){
            String query = "SELECT product.id, product.name, description, price, currency, category.name, supplier.name FROM product" +
                    " LEFT JOIN category ON product.category_id = category.id" +
                    " LEFT JOIN supplier ON product.supplier_id = supplier.id";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            List<Product> results = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                BigDecimal price = rs.getBigDecimal(4);
                String currency = rs.getString(5);
                String category = rs.getString(6);
                String supplierName = rs.getString(7);
                ProductCategory productCategory = new ProductCategory(category, "Hardver", "");
                Supplier supplier = new Supplier(supplierName, "");

                Product product = new Product(name, price, currency, description, productCategory, supplier);
                product.setId(id);

                results.add(product);
            }
            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getBy(Supplier supplier, List<Product> data) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
