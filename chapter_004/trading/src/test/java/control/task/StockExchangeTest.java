package control.task;

import control.task.base.classes.ActionRequest;
import control.task.base.classes.TypeRequest;
import org.junit.Test;
import static org.junit.Assert.*;

public class StockExchangeTest {
    RequestStock requestStock = new RequestStock(1, "VTB", TypeRequest.ADD, ActionRequest.ASK, 12, 3);
    RequestStock vtbBidOne = new RequestStock(1, "VTB", TypeRequest.ADD, ActionRequest.BID, 12, 6);
    RequestStock vtbBidTwo = new RequestStock(2, "VTB", TypeRequest.ADD, ActionRequest.BID, 13, 12);
    RequestStock vtbSaleOne = new RequestStock(3, "VTB", TypeRequest.ADD, ActionRequest.ASK, 13, 7);
    RequestStock vtbBidRemove = new RequestStock(2, "VTB", TypeRequest.DELETE, ActionRequest.BID, 13, 4);
    RequestStock vtbSaleRemove = new RequestStock(2, "VTB", TypeRequest.DELETE, ActionRequest.ASK, 13, 4);
    RequestStock sberBidOne = new RequestStock(1, "Sber", TypeRequest.ADD, ActionRequest.BID, 62, 5);
    RequestStock sberBidTwo = new RequestStock(1, "Sber", TypeRequest.ADD, ActionRequest.BID, 12, 8);
    StockExchange stock = new StockExchange();

    @Test
    public void checkRequestType() {
    }

    @Test
    public void addAReguestToGlassReturnTrue() {
        assertTrue(stock.addToGlass(requestStock));
        System.out.println(stock.toString());
    }

    @Test
    public void addMoreReguestsToGlassReturnTrue() {
        assertTrue(stock.addToGlass(vtbBidOne));
        assertTrue(stock.addToGlass(vtbBidTwo));
        assertTrue(stock.addToGlass(vtbSaleOne));
        assertTrue(stock.addToGlass(sberBidOne));
        assertTrue(stock.addToGlass(sberBidTwo));
        System.out.println(stock.toString());
    }

    @Test
    public void addMoreReguestsAndRemoveOneToGlassReturnTrue() {
        assertTrue(stock.addToGlass(vtbBidOne));
        assertTrue(stock.addToGlass(vtbBidTwo));
        assertTrue(stock.addToGlass(vtbSaleOne));
        assertTrue(stock.addToGlass(sberBidOne));
        assertTrue(stock.addToGlass(sberBidTwo));
        assertTrue(stock.addToGlass(vtbBidRemove));
        System.out.println(stock.toString());
    }
    @Test
    public void addMoreReguestsAndRemoveOneToGlassReturnFalse() {
        StockExchange stock = new StockExchange();
        assertTrue(stock.addToGlass(vtbBidOne));
        assertTrue(stock.addToGlass(vtbBidTwo));
        assertTrue(stock.addToGlass(vtbSaleOne));
        assertTrue(stock.addToGlass(sberBidOne));
        assertTrue(stock.addToGlass(sberBidTwo));
        assertTrue(stock.addToGlass(vtbBidRemove));
        assertFalse(stock.addToGlass(vtbSaleRemove));
        System.out.println(stock.toString());
    }
}