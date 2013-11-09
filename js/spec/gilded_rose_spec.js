describe("Gilded Rose", function() {

    it('should update quality and sell in correctly', function() {
        var i = 0;
        var items = [
            new Item('+5 Dexterity Vest', 10, 20),
            new Item('Aged Brie', 0, 0),
            new Item('Elixir of the Mongoose', 5, 7),
            new Item('Sulfuras, Hand of Ragnaros', 0, 0),
            new Item('Sulfuras, Hand of Ragnaros', -1, 100),
            new Item('Backstage passes to a TAFKAL80ETC concert', 15, 20),
            new Item('Backstage passes to a TAFKAL80ETC concert', 15, 49)
        ]

        update_quality(items);

        expect(items[0].name).toEqual('+5 Dexterity Vest');
        expect(items[0].sell_in).toEqual(9);
        expect(items[0].quality).toEqual(19);

        expect(items[1].name).toEqual('Aged Brie');
        expect(items[1].quality).toEqual(2);
        expect(items[1].sell_in).toEqual(-1);

        expect(items[2].name).toEqual('Elixir of the Mongoose');
        expect(items[2].sell_in).toEqual(4);
        expect(items[2].quality).toEqual(6);

        expect(items[3].name).toEqual('Sulfuras, Hand of Ragnaros');
        expect(items[3].quality).toEqual(0);
        expect(items[3].sell_in).toEqual(0);

        expect(items[4].name).toEqual('Sulfuras, Hand of Ragnaros');
        expect(items[4].quality).toEqual(100);
        expect(items[4].sell_in).toEqual(-1);

        expect(items[5].name).toEqual('Backstage passes to a TAFKAL80ETC concert');
        expect(items[5].quality).toEqual(21);
        expect(items[5].sell_in).toEqual(14);

        items[1].quality = 100

        update_quality(items)

        expect(items[0].sell_in).toEqual(8);
        expect(items[0].quality).toEqual(18);

        expect(items[1].quality).toEqual(100);
        expect(items[1].sell_in).toEqual(-2);

        expect(items[2].sell_in).toEqual(3);
        expect(items[2].quality).toEqual(5);

        expect(items[3].quality).toEqual(0);
        expect(items[3].sell_in).toEqual(0);

        expect(items[4].quality).toEqual(100);
        expect(items[4].sell_in).toEqual(-1);

        expect(items[5].quality).toEqual(22);
        expect(items[5].sell_in).toEqual(13);

        for (i = 1; i <= 4; ++i) {update_quality(items);}

        expect(items[5].quality).toEqual(27);
        expect(items[5].sell_in).toEqual(9);

        expect(items[6].quality).toEqual(50);
        expect(items[6].sell_in).toEqual(9);

        for (i = 1; i <= 5; ++i) {update_quality(items);}

        expect(items[5].quality).toEqual(38);
        expect(items[5].sell_in).toEqual(4);

        expect(items[6].quality).toEqual(50);
        expect(items[6].sell_in).toEqual(4);

        for (i = 1; i <= 4; ++i) {update_quality(items);}

        expect(items[5].quality).toEqual(50);
        expect(items[5].sell_in).toEqual(0);

        expect(items[6].quality).toEqual(50);
        expect(items[6].sell_in).toEqual(0);

        update_quality(items)

        expect(items[5].quality).toEqual(0);
        expect(items[5].sell_in).toEqual(-1);

        expect(items[6].quality).toEqual(0);
        expect(items[6].sell_in).toEqual(-1);

    });


});
