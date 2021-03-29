package member.models;

import common.models.CurrentUser;
import common.models.DataManager;
import common.models.User;

@SuppressWarnings({"unchecked"})
public class UserDataManager extends DataManager {
    private static UserDataManager instance;

    private UserDataManager() {
        super("User", "userName");
    }

    public static UserDataManager getInstanceOf(){
        if(instance==null){
            instance = new UserDataManager();
        }
        return instance;
    }

    //todo rename method. it's not obvious what the
    // method is doing.
    @Override
    public void updateData(Object item) {
        // update current state of the user
        User user = CurrentUser.getCurrentUser();
        super.updateData(user);
        // update the new state of the user
        super.updateData(item);
    }
}
