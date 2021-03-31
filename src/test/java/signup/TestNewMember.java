package signup;

import common.models.*;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import setup.ObjectFactory;
import signup.models.NewMember;
import signup.models.SignUpData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestNewMember {
    //todo too many dependencies?
    SignUpData signUpData = ObjectFactory.getBasicSignUpData(); //test data

    DataManager mockDataManager = mock(DataManager.class);
    MembershipLevelFactory membershipLevelFactory = mock(MembershipLevelFactory.class);

    NewMember newMember = new NewMember(mockDataManager, membershipLevelFactory);
    ArgumentCaptor<Member> memberCaptor = ArgumentCaptor.forClass(Member.class);

    @Test
    void memberIsCreatedProperly() {
        MembershipPolicy policy  = ObjectFactory.getBasicPolicy();

        Member expectedMember = new Member(signUpData.firstName,
                signUpData.lastName,
                signUpData.userName,
                new MembershipLevel(policy));

        when(membershipLevelFactory.createMembershipLevel(anyString())).thenReturn(new MembershipLevel(policy));

        newMember.create(signUpData);

        verify(mockDataManager).addItem(memberCaptor.capture());
        Member capturedMember = memberCaptor.getValue();

        assertEquals(expectedMember, capturedMember);

    }
}
