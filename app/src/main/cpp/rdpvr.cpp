#include <jni.h>
#include <android/log.h>

extern "C"
JNIEXPORT void JNICALL
Java_com_mefazm_rdpvr_MainActivity_connect(JNIEnv*, jobject) {
    __android_log_print(ANDROID_LOG_VERBOSE, "MainActivity", "Call connect fromm C++");
}
