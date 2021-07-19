import controller.GroupController;
import controller.ItemController;
import controller.dto.GroupDTO;
import controller.dto.ItemDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArgumentInput {

    private GroupController groupController;
    private ItemController itemController;
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public ArgumentInput() {
        groupController = new GroupController();
        itemController = new ItemController();
    }

    public void inputGroupsAndItems() {
        try {
            inputGroup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inputGroup() throws IOException {
        System.out.println("Enter : input group details ");
        System.out.println("Input items : continue");
        String flag = bufferedReader.readLine();

        while (!flag.equals("continue")) {

            System.out.print("Please input group id : ");
            int id = Integer.parseInt(bufferedReader.readLine());

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
