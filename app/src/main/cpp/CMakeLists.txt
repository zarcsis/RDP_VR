cmake_minimum_required(VERSION 3.30.3)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_SCAN_FOR_MODULES OFF)

project("rdpvr" CXX)

add_library(${PROJECT_NAME} SHARED rdpvr.cpp tools.cpp)
target_compile_options(${PROJECT_NAME}
    PRIVATE -Wall
    PRIVATE -Wextra
    PRIVATE -Werror
    PRIVATE -Wno-deprecated-declarations
)
find_library(log-lib log)
target_link_libraries(${PROJECT_NAME} ${log-lib})
