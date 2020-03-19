/*
 *
 *  * This file is part of moneydrops, licensed under the MIT License.
 *  *
 *  *  Copyright (c) crysis992 <crysis992@gmail.com>
 *  *  Copyright (c) contributors
 *  *
 *  *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  *  of this software and associated documentation files (the "Software"), to deal
 *  *  in the Software without restriction, including without limitation the rights
 *  *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  *  copies of the Software, and to permit persons to whom the Software is
 *  *  furnished to do so, subject to the following conditions:
 *  *
 *  *  The above copyright notice and this permission notice shall be included in all
 *  *  copies or substantial portions of the Software.
 *  *
 *  *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  *  SOFTWARE.
 *
 */

package net.crytec.pickmoney;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Arrays;
import java.util.List;

public enum ConfigOptions {

    SOUND("Options.Sound.Name", "ENTITY_PLAYER_LEVELUP"),
    SOUND_PITCH("Options.Sound.Pitch", 1.25F),
    SOUND_VOLUME("Options.Sound.Volume", 1.0F),

    BLACKLISTED_WORLDS("Blacklist", Arrays.asList("world2")),

    SHOW_DISPLAYNAME("Options.Show.DisplayName", true),
    SHOW_TITLE("Options.Show.Title", false),
    SHOW_CHAT("Options.Show.Chat", true),

    TITLE_HEADER("Messages.Title", ""),
    TITLE_SUB("Messages.Subtitle", "&7Picked up %value% money"),
    DROP_DISPLAYNAME("Messages.DisplayName", "&bValue: %value%"),
    PICKUP_MESSAGE("Messages.Pickup", "&7Picked up %value% Money"),
    LOST_MONEY("Messages.Death", "&7You have lost %value% from your balance because you've died."),

    DEFAULT_ICON("Options.Drop.DefaultIcon", "GOLD_INGOT"),
    MERGE_ITEMS("Options.Drop.Merge", true),
    DROP_NATURALLY("Options.Drop.DropNaturally", true),
    DO_DECIMAL_DROPS("Options.Drop.DecimalNumbers", true),
    MINIMUM_TO_DROP("Options.Drop.MinAmount", 0.01D),
    REQUIRE_PLAYERKILL("Options.Drop.RequireKiller", false),

    PLAYER_DROP_ENABLED("Player.Enabled", false),
    PLAYER_DROP_PERCENTAGE("Player.PercentageAmount", "0.5-2.45"),
    PLAYER_DROP_CHANCE("Player.Chance", 20),
    PLAYER_DROP_HARDCAP("Player.Hardcap", 2500);


    private static YamlConfiguration CONFIG;
    private final String path;
    private final Object def;

    ConfigOptions(final String path, final Object object) {
        this.path = path;
        this.def = object;
    }

    public static YamlConfiguration getFile() {
        return CONFIG;
    }

    /**
     * Set the {@code YamlConfiguration} to use.
     *
     * @param config The config to set.
     */
    public static void setFile(final YamlConfiguration config) {
        CONFIG = config;
    }

    public boolean asBoolean() {
        return CONFIG.getBoolean(this.path);
    }

    public double asDouble() {
        return CONFIG.getDouble(this.path);
    }

    public int asInt() {
        return CONFIG.getInt(this.path);
    }

    public float asFloat() {
        return (float) CONFIG.getDouble(this.path);
    }

    public String asString() {
        return CONFIG.getString(this.path);
    }

    public String asString(final boolean translateColor) {
        return ChatColor.translateAlternateColorCodes('&', CONFIG.getString(this.path));
    }

    public List<String> asStringList() {
        return CONFIG.getStringList(this.path);
    }

    /**
     * Get the default value of the path.
     *
     * @return The default value of the path.
     */
    public Object getDefault() {
        return this.def;
    }

    /**
     * Get the path to the string.
     *
     * @return The path to the string.
     */
    public String getPath() {
        return this.path;
    }

}
