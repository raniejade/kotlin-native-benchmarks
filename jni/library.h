#ifndef LIBRARY_H
#define LIBRARY_H
#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jstring JNICALL Java_benchmark_External_str(JNIEnv* env, jobject thisObject);

JNIEXPORT jint JNICALL Java_benchmark_External_int(JNIEnv* env, jobject thisObject);

#ifdef __cplusplus
}
#endif

#endif