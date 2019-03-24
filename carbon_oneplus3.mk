# Copyright (C) 2016 The CyanogenMod Project
# Copyright (C) 2017-2018 The LineageOS Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Inherit Carbon GSM telephony parts
$(call inherit-product, vendor/carbon/config/gsm.mk)

# Inherit from full_oneplus3.mk
$(call inherit-product, device/oneplus/oneplus3/full_oneplus3.mk)

# Inherit some common carbon stuff.
$(call inherit-product, vendor/carbon/config/common.mk)

# Include Build configuration
TARGET_BOOT_ANIMATION_RES := 1080

# Vendor security patch level
VENDOR_SECURITY_PATCH := 2018-11-01

PRODUCT_NAME := carbon_oneplus3
PRODUCT_DEVICE := oneplus3
PRODUCT_MANUFACTURER := OnePlus
PRODUCT_BRAND := OnePlus

PRODUCT_GMS_CLIENTID_BASE := android-oneplus

TARGET_VENDOR := oneplus

PRODUCT_PROPERTY_OVERRIDES += \
	ro.carbon.maintainer="mxdfpha"
