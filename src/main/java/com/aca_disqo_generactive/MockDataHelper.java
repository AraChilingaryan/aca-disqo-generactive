package com.aca_disqo_generactive;

import com.aca_disqo_generactive.controller.GroupController;
import com.aca_disqo_generactive.controller.ItemController;
import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.converter.ItemConverter;
import com.aca_disqo_generactive.utils.ApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MockDataHelper {
    private final static ApplicationContext applicationContext = ApplicationContext.getInstance();
    private final static GroupController groupController = applicationContext.getGroupController();
    private final static ItemController itemController = applicationContext.getItemController();
    private final static ItemConverter itemConverter = applicationContext.getItemConverter();

    public static void run() {
        GroupDTO group1 = new GroupDTO(1, 0, "Root");
        GroupDTO group2 = new GroupDTO(2, 1, "SubRoot");
        GroupDTO group3 = new GroupDTO(3,0,"SubRoot1");

       // itemDTO.setResolution(Resolution.FHD);
        groupController.create(group1);
        groupController.create(group2);
        groupController.create(group3);
        readFromCsv("src/main/resources/item.csv").stream()
                .map(itemConverter::convertFromCSV).collect(Collectors.toList())
                .forEach(itemController::create);
        groupController.get(1).print(1);


    }

    static List<String[]> records = new ArrayList<>();

    private static List<String[]> readFromCsv(final String pathToCSV){
        try (BufferedReader br = new BufferedReader(new FileReader(pathToCSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
