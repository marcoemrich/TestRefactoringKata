     import static org.junit.Assert.assertEquals;

     import org.junit.Test;

     public class GildedRoseTest {

	@Test
	public void updateQuality_BrieItem() {
		Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(2, app.items[0].quality);
	}

	@Test
	public void updateQuality_BrieItem_HQ_negativeSI() {
		Item[] items = new Item[] { new Item("Aged Brie", -1, 100) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(100, app.items[0].quality);
	}

	@Test
	public void toString_Brie() {
		Item[] items = new Item[] { new Item("Aged Brie", -1, 100) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie, -2, 100", app.items[0].toString());
	}

	@Test
	public void updateQuality_TAFKAL80ETC() {
		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
	}

	@Test
	public void updateQuality_TAFKAL80ETC_HQ() {
		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 0, 0100) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
	}

	@Test
	public void updateQuality_TAFKAL80ETC_HQ_SI2() {
		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 2, 0100) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(64, app.items[0].quality);
	}

	@Test
	public void updateQuality_TAFKAL80ETC_SI20() {
		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 20, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(1, app.items[0].quality);
	}

	@Test
	public void updateQuality_TAFKAL80ETC_Q50() {
		Item[] items = new Item[] { new Item(
				"Backstage passes to a TAFKAL80ETC concert", 0, 49) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
	}

	@Test
	public void updateQuality_Sulfuras() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(0, app.items[0].quality);
	}

	@Test
	public void updateQuality_Sulfuras_HQ() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0,
				100) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(100, app.items[0].quality);
	}

	@Test
	public void updateQuality_Sulfuras_HQ_negativeSI() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1,
				100) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(100, app.items[0].quality);
	}

	@Test
	public void updateQuality_random_HQ() {
		Item[] items = new Item[] { new Item("random", 0, 0100) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(62, app.items[0].quality);
	}

	@Test
	public void updateQuality_random_negativeSI() {
		Item[] items = new Item[] { new Item("random", -1, 0100) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(62, app.items[0].quality);
	}

	@Test
	public void updateQuality_random_negativeQ_negativeSI() {
		Item[] items = new Item[] { new Item("random", -1, -1) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(-1, app.items[0].quality);
	}
    }
