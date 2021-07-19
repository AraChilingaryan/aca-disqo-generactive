package service;

import controller.dto.ItemDTO;
import repository.model.Item;

public interface ItemService {

    Item create(ItemDTO itemDto);

}
