#----------------------------------------------------------------
# Generated CMake target import file for configuration "Release".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "winpr" for configuration "Release"
set_property(TARGET winpr APPEND PROPERTY IMPORTED_CONFIGURATIONS RELEASE)
set_target_properties(winpr PROPERTIES
  IMPORTED_LOCATION_RELEASE "${_IMPORT_PREFIX}/lib/libwinpr3.so"
  IMPORTED_SONAME_RELEASE "libwinpr3.so"
  )

list(APPEND _cmake_import_check_targets winpr )
list(APPEND _cmake_import_check_files_for_winpr "${_IMPORT_PREFIX}/lib/libwinpr3.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
