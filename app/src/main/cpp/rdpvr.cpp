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

static std::string jstringToString(JNIEnv * const env, jstring str) {
    if (nullptr == env) throw std::invalid_argument(STRINGIFY(env) " is null");
    if (nullptr == str) throw std::invalid_argument(STRINGIFY(str) " is null");
    assert(sizeof(jchar) == sizeof(char16_t));

    LOGI("jstringToString()");

    const jchar * const jStrData = env->GetStringChars(str, nullptr);
    auto * const u16CStrData = reinterpret_cast<const char16_t *>(jStrData);
    const std::size_t utf16CStrDataSize = env->GetStringLength(str);
    const std::u16string u16str(u16CStrData, u16CStrData + utf16CStrDataSize);
    env->ReleaseStringChars(str, jStrData);

    return std::wstring_convert<std::codecvt_utf8_utf16<char16_t>,char16_t>().to_bytes(u16str);
}

static std::string getClassName(JNIEnv * const env, jobject obj) {
    std::string ret =
            jstringToString(
                    env,
                    reinterpret_cast<jstring>(env->CallObjectMethod(
                            env->GetObjectClass(obj),
                            env->GetMethodID(
                                    env->FindClass("java/lang/Class"),
                                    "getName",
                                    "()Ljava/lang/String;"))));
    return ret.substr(ret.find_last_of('.') + 1);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_mefazm_rdpvr_SessionActivity_connect(JNIEnv* env, jobject obj, jstring hostname, jstring username, jstring password) {
    if (nullptr == env) throw std::invalid_argument(STRINGIFY(env) " is null.");
    if (nullptr == hostname) throw std::invalid_argument(STRINGIFY(hostname) " is null.");
    if (nullptr == username) throw std::invalid_argument(STRINGIFY(username) " is null.");
    if (nullptr == password) throw std::invalid_argument(STRINGIFY(password) " is null.");

    TAG = getClassName(env, obj);
    LOGI("hostname: \"%s\", username: \"%s\", password: \"%s\"",
         jstringToString(env, hostname).c_str(),
         jstringToString(env, username).c_str(),
         jstringToString(env, password).c_str());
}
