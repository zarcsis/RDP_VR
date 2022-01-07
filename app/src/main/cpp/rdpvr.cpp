#include "log.h"

#include <jni.h>

#include <string>
#include <sstream>
#include <iomanip>
#include <stdexcept>

#include <cstdint>
#include <cinttypes>
#include <cassert>

constexpr const char TAG[] = "com.mefazm.rdpvr.SessionActivity";
constexpr const char TEST_STR[] = "𐎠𐎠𐎠";
constexpr const wchar_t TEST_WSTR[] = L"𐎠𐎠𐎠";
constexpr const char16_t TEST_16STR[] = u"𐎠𐎠𐎠";
constexpr const char8_t TEST_8STR[] = u8"𐎠𐎠𐎠";

static std::string jstringToString(JNIEnv* env, jstring str) {
    if (nullptr == env) throw std::invalid_argument("env is null.");
    if (nullptr == str) throw std::invalid_argument("str is null.");
    assert(sizeof(jchar) == sizeof(char16_t));

    auto * const u16CStrData = reinterpret_cast<const char16_t *>(env->GetStringChars(str, nullptr));
    const std::size_t utf16CStrDataSize = env->GetStringLength(str);

    const std::u16string u16str(u16CStrData, u16CStrData + utf16CStrDataSize - 1);
    // TODO: Implement conversion from u16string to string
    std::string outStr;

    std::stringstream ss;
    for (std::size_t i = 0; i < utf16CStrDataSize; ++i) {
        ss << "0x" << std::uppercase << std::setfill('0') << std::setw(sizeof(char16_t) * 2) << std::hex << u16CStrData[i];
        if (i < utf16CStrDataSize - 1) ss << ' ';
    }
    __android_log_print(ANDROID_LOG_INFO, TAG, "utf16CStr[%zu]: %s", utf16CStrDataSize, ss.str().c_str());

    return outStr;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_mefazm_rdpvr_SessionActivity_connect(JNIEnv* env, jobject, jstring hostname, jstring username, jstring password) {
    if (nullptr == env) throw std::invalid_argument("env is null.");
    if (nullptr == hostname) throw std::invalid_argument("hostname is null.");
    if (nullptr == username) throw std::invalid_argument("username is null.");
    if (nullptr == password) throw std::invalid_argument("password is null.");
    __android_log_print(ANDROID_LOG_INFO, TAG, "Call connect fromm C++");
    __android_log_print(ANDROID_LOG_INFO, TAG, "sizeof(char): %zu, sizeof(wchar_t): %zu, sizeof(char16_t): %zu, sizeof(char8_t): %zu", sizeof(char), sizeof(wchar_t), sizeof(char16_t), sizeof(char8_t));
    __android_log_print(ANDROID_LOG_INFO, TAG, "sizeof(TEST_STR): %zu, sizeof(TEST_WSTR): %zu, sizeof(TEST_16STR): %zu, sizeof(TEST_8STR): %zu", sizeof(TEST_STR), sizeof(TEST_WSTR), sizeof(TEST_16STR), sizeof(TEST_8STR));
    __android_log_print(ANDROID_LOG_INFO, TAG, "hostname: %s, username: %s, password: %s",
                        jstringToString(env, hostname).c_str(),
                        jstringToString(env, username).c_str(),
                        jstringToString(env, password).c_str());
}
