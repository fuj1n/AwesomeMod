Awesome Mod - modJam
====================

Install Instructions
====================
Client Installation
1. Open Minecraft.jar in an archive program such as WinRAR or 7-Zip.
2. Delete META-INF.
3. Install Minecraft Forge Universal (recommended build).
4. If it does not exist already, create a folder called "mods" in the .minecraft folder.
5. Copy the AwesomeMod folder to the "mods" folder located in .minecraft folder.

Server Installation
1. Open minecraft_server.jar in an archive program such as WinRAR or 7-Zip.
2. Delete META-INF.
3. Install Minecraft Forge Universal (recommended build).
4. If it does not exist already, create a folder called "mods" in your server directory.
5. Copy the AwesomeMod folder to the "mods" folder located in your server directory.

Mod Description
===============

AwesomeMod by fuj1n - Written for ModJam 2013

This is a mod I have written for ModJam 2013, the inspiration for this mod is Awesome.

This mod adds a variety of different blocks which serve mostly deco purposes.

Blocks added by this mod have glowing properties.

There are several additions in this mod, which are:
    World generation:
        This mod adds world-gen for special glowing ores called Awesome Ores, which when smelted produce Awesome Gems
        and a small 5x5 structure comprised of Awesome Blocks called the Awesome Room, in the middle of the Awesome Room
        there is a chest with randomly-generated items which are picked from a list inside ComponentChestContents(see below).
    Smelting:
        This mod has only two smelting recipes added, one being Awesome Ore smelting into 8 Awesome Ingots and the other one
        is smelting coal into 3 Dark Extract which I will get to in a minute.
    Crafting:
        In this mod, I have added a variety of different crafting recipes, first of all, crafting any iron-staged tool/armor piece
        surrounded by four Black Awesome Gems yields an Awesome tool/armor piece.
        
        Surrounding stone with four Black Awesome Gems yields one Awesome Block.
        
        Now, you will notice that Black Awesome Gems are used for pretty much anything, so I have added a recipe to
        convert any Awesome Gem to the Black Awesome Gem, this is achieved by surrounding Dark Extract with 8 gems,
        this yields 8 Black Awesome Gems.
        
        Surrounding an Awesome Block with 8 Awesome Gems will yield the Standard-Textured Awesome Block of the
        corresponding color.
        
        Surrounding an Awesome Block with 6 Awesome Gems on the sides and 2 gunpowder on top/bottom will yield a
        Creeper-Textured Awesome Block of the corresponding color.
                                  
                                   |BXX|  
        Using this recipe layout   |BBB| where B is either wooden planks or stone and X is any Awesome Gem will yield the
        Glowing Chair of that type.|BXB|
                                  
                                   |XXX|
        Using this recipe layout   |BBB| where B is either wooden planks or stone and X is any Awesome Gem will produce the
        Glowing Table of that type.|BXB|
        
                                                                                          |OIO|
        Additionaly to all the recipes listed above, laying out the recipe in this layout |IEI| where O is the
        Lime Awesome Ore, I is the Lime Awesome Gem and E is the Dark Extract will yield  |OIO|
        fuj1n's Head, which I add to all my mods as a convention.
        
    Additional Info:
        Below is the list of all possible randomly generated chest items for Awesome Rooms
        (Syntax = Item, Metadata/{Possible Metadata}, minimum, maximum, weight)
                awesomeBlock, 0, 2, 5, 20
                gunpowder, 0, 3, 5, 5
                stone, 0, 1, 2, 2
                diamond, 0, 1, 5, 1
                emerald, 0, 2, 4, 3
                darkExtract, 0, 3, 10, 10
                blockSteel, 0, 1, 2, 1
                ingotIron, 0, 1, 4, 5
                coal, 0, 5, 10, 10
                awesomePickaxe, {0, 10, 20, 200, 280}, 1, 1, 3
                awesomeShovel, {0, 10, 20, 200, 280}, 1, 1, 3
                awesomeSword, {0, 10, 20, 200, 280}, 1, 1, 3
                awesomeAxe, {0, 10, 20, 200, 280}, 1, 1, 3
                awesomeHoe, {0, 10, 20, 200, 280}, 1, 1, 3
                awesomeHelmet, {0, 10, 20}, 1, 1, 3
                awesomeChestplate, {0, 10, 20}, 1, 1, 3
                awesomeLeggings, {0, 10, 20}, 1, 1, 3
                awesomeBoots, {0, 10, 20}, 1, 1, 3
                awesomeBlockStandard, {0 to 15}, 1, 3, 3
                awesomeBlockCreeper, {0 to 15}, 1, 3, 2
                awesomeOre, {0 to 15}, 1, 4, 10
                awesomeIngot, {0 to 15}, 2, 10, 5
                                
                                 
