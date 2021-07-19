import controller.dto.GroupDTO;
import controller.dto.ItemDTO;
import repository.model.Generactive;
import repository.model.Group;
import repository.model.Item;
import service.GroupService;
import service.ItemService;
import utils.ApplicationContext;

public class MockDataHelper {

    private static GroupService groupService = new ApplicationContext().getGroupService();
    private static ItemService itemService = new ApplicationContext().getItemService();

    public static void run(){
        GroupDTO group = new GroupDTO(1,0,"Root");
        GroupDTO group1 = new GroupDTO(2,1,"SubRoot");
        ItemDTO itemDTO = new ItemDTO(1,100,"AMD",2,1);
        System.out.println(itemService.create(itemDTO));
    }
}
