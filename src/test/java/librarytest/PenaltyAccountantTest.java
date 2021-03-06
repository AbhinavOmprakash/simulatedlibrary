package librarytest;


import library.DataManager;
import library.PenaltyAccountant;
import library.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PenaltyAccountantTest {

    @Mock
    DataManager<String, User> dataManager;

    @Mock
    User user;
    int overDueDays;

    @BeforeEach
    public void setup() {
        when(user.getOverdueFeesPerDay()).thenReturn(1.0);
        when(user.getPenaltyDue()).thenReturn(10.3);
        when(user.getID()).thenReturn(123456789);

        overDueDays = 10;
        String id = "123456789";
        ArrayList<User> users = new ArrayList<>(Arrays.asList(user));
        when(dataManager.search(id)).thenReturn(users);

    }

    @Test
    void testChargePenalty() {
        PenaltyAccountant penaltyAccountant = new PenaltyAccountant(dataManager);
        double expectedPenalty = 10.3 + (1.0*10);
        assertEquals(expectedPenalty,penaltyAccountant.chargePenalty(user, overDueDays));


    }
}
