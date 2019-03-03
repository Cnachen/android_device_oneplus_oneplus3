/*
 * Copyright (C) 2014 The CyanogenMod Project
 *           (C) 2017 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aospextended.keydisabler;

/*
 * Disable capacitive keys
 *
 * This is intended for use on devices in which the capacitive keys
 * can be fully disabled for replacement with a soft navbar. You
 * really should not be using this on a device with mechanical or
 * otherwise visible-when-inactive keys
 */

public class KeyDisabler {

    private static String CONTROL_PATH = "/proc/touchpanel/key_disable";
    private static String FPC_PATH = "/sys/module/fpc1020_tee/parameters/ignor_home_for_ESD";

    public static boolean isSupported() {
        return FileUtils.isFileWritable(CONTROL_PATH) &&
                   FileUtils.isFileWritable(FPC_PATH);
    }

    public static boolean isActive() {
        return FileUtils.readOneLine(CONTROL_PATH).equals("1") ||
                   FileUtils.readOneLine(FPC_PATH).equals("1");
    }

    public static boolean setActive(boolean state) {
        String value = state ? "1" : "0";
        boolean control = FileUtils.writeLine(CONTROL_PATH, value);
        boolean fpc =  FileUtils.writeLine(FPC_PATH, value);

        return control && fpc;
    }
}
