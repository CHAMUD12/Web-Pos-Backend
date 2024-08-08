package org.example.webposbackend.bo;

import org.example.webposbackend.dao.OrderDAO;
import org.example.webposbackend.dto.ItemDTO;
import org.example.webposbackend.dto.OrderDTO;

import java.sql.SQLException;

public class OrderBOIMPL implements OrderBO {
    private final OrderDAO orderDAO;

    public OrderBOIMPL(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    @Override
    public void placeOrder(OrderDTO order) throws SQLException {
        if (!orderDAO.checkCustomerExists(order.getCustomerId())) {
            throw new SQLException("Customer ID not found");
        }

        for (ItemDTO item : order.getItems()) {
            int availableQty = orderDAO.getItemQuantity(item.getCode());
//            if (availableQty < item.getQty()) {
//                throw new SQLException("Insufficient stock for item " + item.getCode());
//            }
            int itemQty = Integer.parseInt(item.getQty());
            if (availableQty < itemQty) {
                throw new SQLException("Insufficient stock for item " + item.getCode());
            }
        }

        orderDAO.saveOrder(order);

        for (ItemDTO item : order.getItems()) {
            orderDAO.saveOrderItem(order.getOrderId(), item);
            orderDAO.updateItemQuantity(item);
        }
    }
}
