package com.aca_disqo_generactive.service;

import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.repository.model.Item;

public interface ItemService {

    Item create(ItemDTO itemDto);

}
