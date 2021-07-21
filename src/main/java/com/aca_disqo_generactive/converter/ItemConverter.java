package com.aca_disqo_generactive.converter;

import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.repository.model.Item;

public interface ItemConverter {

    ItemDTO convert(Item item);

}
