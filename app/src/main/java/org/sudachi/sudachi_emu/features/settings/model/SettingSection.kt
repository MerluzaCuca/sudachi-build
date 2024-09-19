// SPDX-FileCopyrightText: 2023 yuzu Emulator Project
// SPDX-License-Identifier: GPL-2.0-or-later

package org.sudachi.sudachi_emu.features.settings.model

/**
 * A semantically-related group of Settings objects. These Settings are
 * internally stored as a HashMap.
 */
class SettingSection(val name: String) {
    val settings = HashMap<String, AbstractSetting>()

    /**
     * Convenience method; inserts a value directly into the backing HashMap.
     *
     * @param setting The Setting to be inserted.
     */
    fun putSetting(setting: AbstractSetting) {
        settings[setting.key!!] = setting
    }

    /**
     * Convenience method; gets a value directly from the backing HashMap.
     *
     * @param key Used to retrieve the Setting.
     * @return A Setting object (you should probably cast this before using)
     */
    fun getSetting(key: String): AbstractSetting? {
        return settings[key]
    }

    fun mergeSection(settingSection: SettingSection) {
        for (setting in settingSection.settings.values) {
            putSetting(setting)
        }
    }
}
