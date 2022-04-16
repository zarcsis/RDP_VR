cmake_minimum_required(VERSION 3.23.1)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

project("rdpvr" CXX)

add_library(${PROJECT_NAME} SHARED rdpvr.cpp tools.cpp)
target_compile_options(${PROJECT_NAME}
    PRIVATE -Wall
    PRIVATE -Wextra
    PRIVATE -Werror
)
find_library(log-lib log)
target_link_libraries(${PROJECT_NAME} ${log-lib})
