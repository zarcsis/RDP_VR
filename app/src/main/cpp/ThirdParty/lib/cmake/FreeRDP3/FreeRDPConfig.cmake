include(CMakeFindDependencyMacro)
find_dependency(WinPR 3.9.0)

if("ON" AND NOT "ON")
	find_dependency(ZLIB)
endif()


####### Expanded from @PACKAGE_INIT@ by configure_package_config_file() #######
####### Any changes to this file will be overwritten by the next CMake run ####
####### The input file was FreeRDPConfig.cmake.in                            ########

get_filename_component(PACKAGE_PREFIX_DIR "${CMAKE_CURRENT_LIST_DIR}/../../../" ABSOLUTE)

macro(set_and_check _var _file)
  set(${_var} "${_file}")
  if(NOT EXISTS "${_file}")
    message(FATAL_ERROR "File or directory ${_file} referenced by variable ${_var} does not exist !")
  endif()
endmacro()

macro(check_required_components _NAME)
  foreach(comp ${${_NAME}_FIND_COMPONENTS})
    if(NOT ${_NAME}_${comp}_FOUND)
      if(${_NAME}_FIND_REQUIRED_${comp})
        set(${_NAME}_FOUND FALSE)
      endif()
    endif()
  endforeach()
endmacro()

####################################################################################

set(FreeRDP_VERSION_MAJOR "3")
set(FreeRDP_VERSION_MINOR "9")
set(FreeRDP_VERSION_REVISION "0")

set_and_check(FreeRDP_INCLUDE_DIR "${PACKAGE_PREFIX_DIR}/include/freerdp3/")

set(FreeRDP_INSTALL_PREFIX ".")
set(FreeRDP_RELATIVE_PLUGIN_DIR ".")
set(FreeRDP_PLUGIN_DIR "${FreeRDP_INSTALL_PREFIX}/${FreeRDP_RELATIVE_PLUGIN_DIR}")
set(FreeRDP_PROXY_PLUGIN_DIR "${FreeRDP_PLUGIN_DIR}/proxy")
set(FreeRDP_EXTENSION_DIR "${FreeRDP_PLUGIN_DIR}/extensions")

include("${CMAKE_CURRENT_LIST_DIR}/FreeRDPTargets.cmake")
