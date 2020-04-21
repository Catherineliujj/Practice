LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := JniTest
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_LDLIBS := \
	-llog \
	-lz \
	-lm \

LOCAL_SRC_FILES := \
	F:\New\Practice\app\src\main\jni\main.c \
	F:\New\Practice\app\src\main\jni\util.c \

LOCAL_C_INCLUDES += F:\New\Practice\app\src\main\jni
LOCAL_C_INCLUDES += F:\New\Practice\app\src\debug\jni

include $(BUILD_SHARED_LIBRARY)
