#include "log.h"

#include <jni.h>

#include <string>
#include <sstream>
#include <iomanip>
#include <stdexcept>
#include <locale>
#include <codecvt>

#include <cstdint>
#include <cinttypes>
#include <cassert>

constexpr const char TAG[] = "com.mefazm.rdpvr.SessionActivity";

static std::string jstringToString(JNIEnv* env, jstring str) {
    if (nullptr == env) throw std::invalid_argument("env is null.");
    if (nullptr == str) throw std::invalid_argument("str is null.");
    assert(sizeof(jchar) == sizeof(char16_t));

    __android_log_print(ANDROID_LOG_INFO, TAG, "jstringToString()");

    auto * const u16CStrData = reinterpret_cast<const char16_t *>(env->GetStringChars(str, nullptr));
    const std::size_t utf16CStrDataSize = env->GetStringLength(str);

    const std::u16string u16str(u16CStrData, u16CStrData + utf16CStrDataSize);
    std::string outStr = std::wstring_convert<std::codecvt_utf8_utf16<char16_t>,char16_t>().to_bytes(u16str);

    return outStr;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_mefazm_rdpvr_SessionActivity_connect(JNIEnv* env, jobject, jstring hostname, jstring username, jstring password) {
    if (nullptr == env) throw std::invalid_argument("env is null.");
    if (nullptr == hostname) throw std::invalid_argument("hostname is null.");
    if (nullptr == username) throw std::invalid_argument("username is null.");
    if (nullptr == password) throw std::invalid_argument("password is null.");
    __android_log_print(ANDROID_LOG_INFO, TAG, "hostname: %s, username: %s, password: %s",
                        jstringToString(env, hostname).c_str(),
                        jstringToString(env, username).c_str(),
                        jstringToString(env, password).c_str());
}
