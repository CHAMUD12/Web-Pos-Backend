package org.example.webposbackend.dao;

import org.example.webposbackend.dto.ItemDTO;
import org.example.webposbackend.dto.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO {
    void saveOrder(OrderDTO order) throws SQLException;
    void saveOrderItem(String orderId, ItemDTO item) throws SQLException;
    void updateItemQuantity(ItemDTO item) throws SQLException;
    boolean checkCustomerExists(String customerId) throws SQLException;
    int getItemQuantity(String itemCode) throws SQLException;
}
