package manage.bleatcoin.lamb.Admin;

import manage.bleatcoin.lamb.Admin.entities.Response;
import manage.bleatcoin.lamb.Admin.entities.LogEntry;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatronApplicationTests {

    @Autowired
    Controller controller;

    @MockBean
    ILogEntryRepository ilr;

    private LogEntry l1 = new LogEntry();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getAllPatronsInDb() {
        l1.setDate("2000-01-01 00:00:00");
        l1.setAction("Add Coins");
        l1.setInfo("Added 1 Coins to User");
        when(ilr.findAll()).thenReturn(new ArrayList<>(Arrays.asList(l1)));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(l1)), controller.getAll());
    }

    @Test
    public void getPatronByIdWhenNullPatronInDb() {
        l1.setDate("2000-01-01 00:00:00");
        l1.setAction("Add Coins");
        l1.setInfo("Added 1 Coins to User");
        String TEST_ID = "2001-10-21 12:45:12";
        when(ilr.findById(TEST_ID)).thenReturn(Optional.empty());
        Assert.assertEquals(new Response(true, "No Log Entry with given ID: " + TEST_ID), controller.getLogEntryById(TEST_ID));
    }

    @Test
    public void getPatronByIdWhenPatronInDb() {
        l1.setDate("2000-01-01 00:00:00");
        l1.setAction("Add Coins");
        l1.setInfo("Added 1 Coins to User");
        String TEST_ID = "2000-01-01 00:00:00";
        when(ilr.findById(TEST_ID)).thenReturn(Optional.of(l1));
        Assert.assertEquals(l1, controller.getLogEntryById(TEST_ID));
    }
}
