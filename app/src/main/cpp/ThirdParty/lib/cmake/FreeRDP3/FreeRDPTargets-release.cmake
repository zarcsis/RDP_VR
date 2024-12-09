#----------------------------------------------------------------
# Generated CMake target import file for configuration "Release".
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "freerdp" for configuration "Release"
set_property(TARGET freerdp APPEND PROPERTY IMPORTED_CONFIGURATIONS RELEASE)
set_target_properties(freerdp PROPERTIES
  IMPORTED_LOCATION_RELEASE "${_IMPORT_PREFIX}/lib/libfreerdp3.so"
  IMPORTED_SONAME_RELEASE "libfreerdp3.so"
  )

list(APPEND _cmake_import_check_targets freerdp )
list(APPEND _cmake_import_check_files_for_freerdp "${_IMPORT_PREFIX}/lib/libfreerdp3.so" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
