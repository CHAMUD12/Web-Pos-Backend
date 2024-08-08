package org.example.webposbackend.dao;

import org.example.webposbackend.dto.CustomerDTO;
import org.example.webposbackend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;

public sealed interface ItemDAO permits ItemDAOImpl {
    String saveItem(ItemDTO item, Connection connection) throws SQLException;
}
