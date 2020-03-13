cmake_minimum_required(VERSION 3.10)
project(jni)

message($ENV{JAVA_HOME}/include)

add_library(jni SHARED library.cpp)

target_include_directories(jni PRIVATE "$ENV{JAVA_HOME}/include" PRIVATE "$ENV{JAVA_HOME}/include/linux")