# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.12

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/tcp_broadcast_tree.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/tcp_broadcast_tree.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/tcp_broadcast_tree.dir/flags.make

CMakeFiles/tcp_broadcast_tree.dir/main.cpp.o: CMakeFiles/tcp_broadcast_tree.dir/flags.make
CMakeFiles/tcp_broadcast_tree.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/tcp_broadcast_tree.dir/main.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/tcp_broadcast_tree.dir/main.cpp.o -c /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/main.cpp

CMakeFiles/tcp_broadcast_tree.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/tcp_broadcast_tree.dir/main.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/main.cpp > CMakeFiles/tcp_broadcast_tree.dir/main.cpp.i

CMakeFiles/tcp_broadcast_tree.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/tcp_broadcast_tree.dir/main.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/main.cpp -o CMakeFiles/tcp_broadcast_tree.dir/main.cpp.s

# Object files for target tcp_broadcast_tree
tcp_broadcast_tree_OBJECTS = \
"CMakeFiles/tcp_broadcast_tree.dir/main.cpp.o"

# External object files for target tcp_broadcast_tree
tcp_broadcast_tree_EXTERNAL_OBJECTS =

tcp_broadcast_tree: CMakeFiles/tcp_broadcast_tree.dir/main.cpp.o
tcp_broadcast_tree: CMakeFiles/tcp_broadcast_tree.dir/build.make
tcp_broadcast_tree: CMakeFiles/tcp_broadcast_tree.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable tcp_broadcast_tree"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/tcp_broadcast_tree.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/tcp_broadcast_tree.dir/build: tcp_broadcast_tree

.PHONY : CMakeFiles/tcp_broadcast_tree.dir/build

CMakeFiles/tcp_broadcast_tree.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/tcp_broadcast_tree.dir/cmake_clean.cmake
.PHONY : CMakeFiles/tcp_broadcast_tree.dir/clean

CMakeFiles/tcp_broadcast_tree.dir/depend:
	cd /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/cmake-build-debug /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/cmake-build-debug /Volumes/256/GitHub/tcp-broadcast-tree/C++/tcp-broadcast-tree/cmake-build-debug/CMakeFiles/tcp_broadcast_tree.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/tcp_broadcast_tree.dir/depend

