/*
 * Minecraft Development for IntelliJ
 *
 * https://mcdev.io/
 *
 * Copyright (C) 2024 minecraft-dev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, version 3.0 only.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.7.0")
    id("com.gradle.develocity") version("3.17.2")
    id("com.gradle.common-custom-user-data-gradle-plugin") version ("1.13")
}

rootProject.name = "MinecraftDev"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include("mixin-test-data")

startParameter.warningMode = WarningMode.All

develocity {
    server = "https://develocity-field.gradle.com"
    allowUntrustedServer = false

    buildScan {
        capture { true }
        uploadInBackground = true
    }
}

buildCache {
    local {
        isEnabled = true
    }
    remote(develocity.buildCache) {
        isEnabled = true
        isPush = true
    }
}
