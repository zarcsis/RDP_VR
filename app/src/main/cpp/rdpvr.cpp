#include "log.h"
#include "tools.h"

#include <sstream>
#include <iomanip>
#include <stdexcept>
#include <locale>
#include <codecvt>

#include <cstdint>
#include <cinttypes>
#include <cassert>

extern "C"
JNIEXPORT void JNICALL
Java_com_mefazm_rdpvr_SessionActivity_connect(JNIEnv* env, jobject obj, jstring hostname, jstring username, jstring password) {
    if (nullptr == env) throw std::invalid_argument(STRINGIFY(env) " is null.");
    if (nullptr == hostname) throw std::invalid_argument(STRINGIFY(hostname) " is null.");
    if (nullptr == username) throw std::invalid_argument(STRINGIFY(username) " is null.");
    if (nullptr == password) throw std::invalid_argument(STRINGIFY(password) " is null.");

    TAG = getClassName(env, obj);
    LOGI("hostname: \"%s\", username: \"%s\", password: \"%s\"",
         jStringToString(env, hostname).c_str(),
         jStringToString(env, username).c_str(),
         jStringToString(env, password).c_str());
}

extern "C"
JNIEXPORT void JNICALL
Java_com_mefazm_rdpvr_SessionActivity_resize(JNIEnv *, jobject, jint width, jint height) {
    if (1 > width) throw std::invalid_argument(STRINGIFY(width) " < 1.");
    if (1 > height) throw std::invalid_argument(STRINGIFY(height) " < 1.");
    LOGI("width: \"%d\", height: \"%d\"", width, height);
}
