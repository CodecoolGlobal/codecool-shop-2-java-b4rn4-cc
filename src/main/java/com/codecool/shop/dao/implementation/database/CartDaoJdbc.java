package com.codecool.shop.dao.implementation.database;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoJdbc implements CartDao {
    private DataSource dataSource;
    private Cart cart;

    public CartDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Cart cart) {

    }

    @Override
    public void addToCart(Product product) {
        try (Connection con = dataSource.getConnection()) {
            String query = "INSERT INTO product_in_cart (cart_id, product_id) VALUES (?, ?)";
            PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, cart.getId());
            st.setInt(2, product.getId());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void cartWithSingInUser(int searchedUserId) {
        try (Connection con = dataSource.getConnection()) {
            String query = "SELECT id, user_id, payed  FROM cart WHERE user_id = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, searchedUserId);

            ResultSet rs = st.executeQuery();
            List<Cart> carts = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                int userId = rs.getInt(2);
                boolean payed = rs.getBoolean(3);
                Cart cart = new Cart(id, userId, payed);
                carts.add(cart);
            }
            for (Cart cart : carts) {
                if (!cart.isPayed()) {
                    this.cart = cart;
                }
            }
            this.cart = createCart(searchedUserId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cart createCart(int userId) {
        try (Connection con = dataSource.getConnection()) {
            String query = "INSERT INTO cart (user_id, payed) VALUES (?, ?)";
            PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, userId);
            st.setBoolean(2, false);

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            Cart cart = new Cart(id, userId, false);
            return cart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteFromCart(int index) {

    }

    @Override
    public List<Product> reviewCart() {
        try (Connection con = dataSource.getConnection()) {
            String query = "SELECT product_id FROM product_in_cart WHERE cart_id = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, cart.getId());

            ResultSet rs = st.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                ProductDaoJdbc productDaoJdbc = new ProductDaoJdbc(dataSource);
                Product product = productDaoJdbc.find(rs.getInt(1));
                products.add(product);
            }
            return products;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
