package org.example.webposbackend.dao;

import org.example.webposbackend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class ItemDAOImpl implements ItemDAO {
    public static final String SAVE_ITEM = "INSERT INTO items (code, description, price, qty) VALUES (?, ?, ?, ?)";

    @Override
    public String saveItem(ItemDTO item, Connection connection) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(SAVE_ITEM)) {
            ps.setString(1, item.getCode());
            ps.setString(2, item.getDescription());
            ps.setString(3, item.getPrice());
            ps.setString(4, item.getQty());
            if (ps.executeUpdate() != 0) {
                return "Item saved successfully";
            } else {
                return "Failed to save Item";
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
