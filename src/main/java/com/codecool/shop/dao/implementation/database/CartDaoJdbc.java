package com.codecool.shop.dao.implementation.database;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class CartDaoJdbc implements CartDao {
    private DataSource dataSource;

    public CartDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Cart cart) {
        try(Connection con = dataSource.getConnection()){
            String query = "INSERT INTO cart (user_id, payed) VALUES (?, ?)";
            PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, cart.getUserId());
            st.setBoolean(2, cart.isPayed());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            cart.setId(rs.getInt(1));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addToCart(Product product) {

    }

    @Override
    public void deleteFromCart(int index) {

    }

    @Override
    public List<Product> reviewCart() {
        return null;
    }
}
