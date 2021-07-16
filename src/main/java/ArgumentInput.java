import repository.model.Group;
import repository.model.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArgumentInput {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final List<Group> groupList;
    private final List<Item> itemList;

    public ArgumentInput() {
        groupList = new ArrayList<>();
        itemList = new ArrayList<>();
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public List<Item> getItemList() {
        return itemList;
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

            createGroupFrom(id, parentId, name);
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
            double price = Double.parseDouble(bufferedReader.readLine());

            System.out.print("Please input item currency : ");
            String currency = bufferedReader.readLine();

            System.out.print("Please input groupId : ");
            String name = bufferedReader.readLine();


            System.out.println("Enter : input item details ");
            System.out.println("Exit : exit");

            flag = bufferedReader.readLine();
        }
    }

    private void createGroupFrom(int id, int parentId, String name) {
        if (parentId != 0) {
            final Group group = new Group(id, name);
            groupList.add(group);
        } else {
            final Group group = new Group(id, name, parentId);
            groupList.add(group);
        }
    }

    private void createItemFrom(int id, int groupId, double price, String currency) {
        final Item item = new Item(id, groupId, price, currency);
        this.itemList.add(item);
    }


}
