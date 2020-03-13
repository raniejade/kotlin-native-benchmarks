#include "library.h"

JNIEXPORT jstring JNICALL Java_benchmark_External_str(JNIEnv* env, jobject thisObject) {
    return env->NewStringUTF("Hello World");
}

JNIEXPORT jint JNICALL Java_benchmark_External_int(JNIEnv* env, jobject thisObject) {
    return 0;
}