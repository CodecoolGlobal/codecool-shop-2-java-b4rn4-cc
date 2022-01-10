package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CustomerDao;
import com.codecool.shop.model.*;

import javax.sql.DataSource;
import java.sql.*;

public class CustomerDaoJdbc implements CustomerDao {

    private DataSource dataSource;

    public CustomerDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Customer customer) {

    }

    @Override
    public Customer find(int id) {
        return null;
    }

    @Override
    public Customer findByEmail(String gotEmail) {
        try (Connection con = dataSource.getConnection()) {
            String query = "SELECT id, name, email, password, address, city, state, zip_code FROM user WHERE email = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, gotEmail);
            ResultSet rs = st.executeQuery();

            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String password = rs.getString(4);
            String address = rs.getString(5);
            String city = rs.getString(6);
            String state = rs.getString(7);
            String zipCode = rs.getString(8);


            Customer customer = new Customer(id, name, email, password, address, city, state, zipCode);

            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
