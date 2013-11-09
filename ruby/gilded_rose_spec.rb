require 'simplecov'

SimpleCov.start

require File.join(File.dirname(__FILE__), 'gilded_rose')

describe GildedRose do

  it 'should update quality and sell in correctly while not changing names' do
    items = [
        Item.new('+5 Dexterity Vest', 10, 20),
        Item.new('Aged Brie', 0, 0),
        Item.new('Elixir of the Mongoose', 5, 7),
        Item.new('Sulfuras, Hand of Ragnaros', 0, 0),
        Item.new('Sulfuras, Hand of Ragnaros', -1, 100),
        Item.new('Backstage passes to a TAFKAL80ETC concert', 15, 20),
        Item.new('Backstage passes to a TAFKAL80ETC concert', 15, 49),
    ]

    GildedRose.new().update_quality(items)

    items[0].name.should == '+5 Dexterity Vest'
    items[0].sell_in.should == 9
    items[0].quality.should == 19

    items[1].name.should == 'Aged Brie'
    items[1].quality.should == 2
    items[1].sell_in.should == -1

    items[2].name.should == 'Elixir of the Mongoose'
    items[2].sell_in.should == 4
    items[2].quality.should == 6

    items[3].name.should == 'Sulfuras, Hand of Ragnaros'
    items[3].quality.should == 0
    items[3].sell_in.should == 0

    items[4].name.should == 'Sulfuras, Hand of Ragnaros'
    items[4].quality.should == 100
    items[4].sell_in.should == -1

    items[5].name.should == 'Backstage passes to a TAFKAL80ETC concert'
    items[5].quality.should == 21
    items[5].sell_in.should == 14

    items[1].quality = 100

    GildedRose.new().update_quality(items)

    items[0].sell_in.should == 8
    items[0].quality.should == 18

    items[1].quality.should == 100
    items[1].sell_in.should == -2

    items[2].sell_in.should == 3
    items[2].quality.should == 5

    items[3].quality.should == 0
    items[3].sell_in.should == 0

    items[4].quality.should == 100
    items[4].sell_in.should == -1

    items[5].quality.should == 22
    items[5].sell_in.should == 13

    4.times { GildedRose.new().update_quality(items) }

    items[5].quality.should == 27
    items[5].sell_in.should == 9

    items[6].quality.should == 50
    items[6].sell_in.should == 9

    5.times { GildedRose.new().update_quality(items) }

    items[5].quality.should == 38
    items[5].sell_in.should == 4

    items[6].quality.should == 50
    items[6].sell_in.should == 4

    4.times { GildedRose.new().update_quality(items) }

    items[5].quality.should == 50
    items[5].sell_in.should == 0

    items[6].quality.should == 50
    items[6].sell_in.should == 0

    GildedRose.new().update_quality(items)

    items[5].quality.should == 0
    items[5].sell_in.should == -1

    items[6].quality.should == 0
    items[6].sell_in.should == -1
  end

end
