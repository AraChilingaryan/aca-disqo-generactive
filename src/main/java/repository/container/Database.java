package repository.container;

import repository.model.Group;
import repository.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static List<Group> groupList;

    public static void saveToDatabase(final List<Group> groups){
        groupList = groups;
    }


    public static List<Group> getGroupList() {
        return groupList;
    }
}
