package org.example.webposbackend.bo;

import org.example.webposbackend.dto.CustomerDTO;
import org.example.webposbackend.dto.ItemDTO;

import java.sql.Connection;

public interface ItemBO {
    String saveItem(ItemDTO item, Connection connection)throws Exception;
}
