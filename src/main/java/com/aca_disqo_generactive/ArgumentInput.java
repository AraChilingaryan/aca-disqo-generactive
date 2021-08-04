package com.aca_disqo_generactive;

import com.aca_disqo_generactive.context.ApplicationContext;
import com.aca_disqo_generactive.controller.GroupController;
import com.aca_disqo_generactive.controller.ItemController;
import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.exception.NoSuchFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArgumentInput {

    private final static ApplicationContext applicationContext = new ApplicationContext();
    private GroupController groupController;
    private ItemController itemController;
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public ArgumentInput() {
        this(applicationContext.getGroupController(), applicationContext.getItemController());
    }

    private ArgumentInput(GroupController groupController, ItemController itemController) {
        this.groupController = groupController;
        this.itemController = itemController;
    }

    public void inputGroupsAndItems() {
        try {
            inputGroup();
        } catch (IOException e) {
            throw new NoSuchFileException(e);
        }
    }

    private void inputGroup() throws IOException {
        System.out.println("Enter : input group details ");
        System.out.println("Input items : continue");
        String flag = null;
        try {
            flag = bufferedReader.readLine();
        } catch (IOException e) {
            throw new NoSuchFileException(e);
        }

        while (!flag.equals("continue")) {

            System.out.print("Please input group id : ");
            int id = 0;
            try {
                id = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                throw new NoSuchFileException(e);
            }

            System.out.print("Please input group parentId : ");
            String inputParentId = bufferedReader.readLine();
            int parentId = 0;
            if (!inputParentId.equals("")) {
                parentId = Integer.parseInt(inputParentId);
            }

            System.out.print("Please input name of group : ");
            String name = bufferedReader.readLine();

            createGroupDTOFrom(id, parentId, name);
            System.out.println();

            System.out.println("Enter : input group details ");
            System.out.println("Input items : continue");
            flag = bufferedReader.readLine();
        }
        inputItem();
    }

    private void inputItem() throws IOException {
        String flag = bufferedReader.readLine();
        while (!flag.equals("exit")) {

            System.out.print("Please input item id : ");
            int id = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Please input item price : ");
            int price = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Please input item currency : ");
            String currency = bufferedReader.readLine();

            System.out.print("Please input groupId : ");
            int groupId = bufferedReader.read();

            System.out.print("Please input type of group : ");
            System.out.println("1 : Generactive " + "/n" + " 2 : Stock");
            int itemType = bufferedReader.read();

            System.out.println("Enter : input item details ");
            System.out.println("Exit : exit");

            itemController.create(createItemDTOFrom(id, groupId, price, currency, itemType));

            flag = bufferedReader.readLine();
        }
    }

    private GroupDTO createGroupDTOFrom(int id, int parentId, String name) {
        GroupDTO groupDTO = new GroupDTO(id, parentId, name);
        return groupDTO;
    }

    private ItemDTO createItemDTOFrom(int id, int groupId, int price, String currency, int itemType) {
        return new ItemDTO(id, price, currency, groupId, itemType);
    }
}
