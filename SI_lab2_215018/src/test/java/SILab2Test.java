import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    private List<Item> createList(Item... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void EveryBranchTest(){
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 5));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        assertTrue(SILab2.checkCart(createList(new Item("Item1", "1234", 50, 0)), 125)); //validni bez popust

        assertTrue(SILab2.checkCart(createList(new Item("Item2", "1286", 200, 0.1F)), 190)); //validni so popust

        ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(createList(new Item("Item3", "12g3", 200, 0)), 230));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(createList(new Item("Item4", null, 90, 0)), 100));
        assertTrue(ex.getMessage().contains("No barcode!"));

        assertTrue(SILab2.checkCart(createList(new Item("Item5", "01283", 320, 0.6F)), 320)); //validni so dopolnitelen popust

        assertFalse(SILab2.checkCart(createList(new Item(null, "1226", 220, 0)), 190)); //setname "unknown" i ke vrati false za payment
    }
}
