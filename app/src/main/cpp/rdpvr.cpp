#include <jni.h>
#include <android/log.h>

extern "C"
JNIEXPORT void JNICALL
Java_com_mefazm_rdpvr_SessionActivity_connect(JNIEnv*, jobject) {
    __android_log_print(ANDROID_LOG_VERBOSE, "SessionActivity", "Call connect fromm C++");
}
