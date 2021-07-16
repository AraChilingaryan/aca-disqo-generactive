import repository.container.Database;
import service.GroupService;

import java.io.IOException;

public class EntryPoint {

    public static void main(String[] args) throws IOException {
        ArgumentInput argumentInput = new ArgumentInput();
        argumentInput.inputGroupsAndItems();
        GroupService groupService = new GroupService();
        Database.saveToDatabase(groupService.createFinalGroups(argumentInput.getGroupList(), argumentInput.getItemList()));
        Database.getGroupList().forEach(System.out :: println);

    }
}
