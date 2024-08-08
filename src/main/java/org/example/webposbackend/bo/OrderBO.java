package org.example.webposbackend.bo;

import org.example.webposbackend.dto.OrderDTO;

import java.sql.SQLException;

public interface OrderBO {
    void placeOrder(OrderDTO order) throws SQLException;
}
