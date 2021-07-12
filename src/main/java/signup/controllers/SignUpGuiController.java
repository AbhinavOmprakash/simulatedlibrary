package signup.controllers;

import common.factory.FactoryController;
import common.factory.FactoryGui;
import common.factory.FactoryGuiController;
import common.models.Member;
import login.models.LoginData;
import signup.models.MemberAssembler;
import signup.models.RawSignUpData;

public class SignUpGuiController extends FactoryGuiController<Member> {
    FactoryController<LoginData> loginFactory;
    public SignUpGuiController(FactoryGui page,
                               MemberAssembler memberAssembler,
                               FactoryController<LoginData> loginFactory) {
        super(page, memberAssembler);
        this.loginFactory = loginFactory;
    }

    @Override
    protected void createNewItem() {
        RawSignUpData rawSignUpData = (RawSignUpData) page.getRawData();
        factory.create(rawSignUpData.getCompatibleData());
        loginFactory.create(rawSignUpData.getCompatibleData());
    }


}
