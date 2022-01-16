#include "tools.h"

#include "log.h"

#include <cassert>
#include <locale>
#include <codecvt>

std::string jStringToString(JNIEnv * const env, jstring str) {
    if (nullptr == env) throw std::invalid_argument(STRINGIFY(env) " is null");
    if (nullptr == str) throw std::invalid_argument(STRINGIFY(str) " is null");
    assert(sizeof(jchar) == sizeof(char16_t));

    LOGI("jStringToString()");

    const jchar * const jStrData = env->GetStringChars(str, nullptr);
    auto * const u16CStrData = reinterpret_cast<const char16_t *>(jStrData);
    const std::size_t utf16CStrDataSize = env->GetStringLength(str);
    const std::u16string u16str(u16CStrData, u16CStrData + utf16CStrDataSize);
    env->ReleaseStringChars(str, jStrData);

    return std::wstring_convert<std::codecvt_utf8_utf16<char16_t>,char16_t>().to_bytes(u16str);
}

std::string getClassName(JNIEnv * const env, jobject obj) {
    std::string ret =
            jStringToString(
                    env,
                    reinterpret_cast<jstring>(env->CallObjectMethod(
                            env->GetObjectClass(obj),
                            env->GetMethodID(
                                    env->FindClass("java/lang/Class"),
                                    "getName",
                                    "()Ljava/lang/String;"))));
    return ret.substr(ret.find_last_of('.') + 1);
}
