<?xml version="1.0" encoding="UTF-8"?>
<!-- You may freely edit this file. See commented blocks below for -->
<!-- some examples of how to customize the build. -->
<!-- (If you delete it and reopen the project it will be recreated.) -->
<!-- By default, only the Clean and Build commands use this build script. -->
<!-- Commands such as Run, Debug, and Test only use this build script if -->
<!-- the Compile on Save feature is turned off for the project. -->
<!-- You can turn off the Compile on Save (or Deploy on Save) setting -->
<!-- in the project's Project Properties dialog box.-->
<project name="05Conexion" default="default" basedir=".">
    <description>Builds, tests, and runs the project 05Conexion.</description>
    <import file="nbproject/build-impl.xml"/>
    <!--

    There exist several targets which are by default empty and which can be 
    used for execution of your tasks. These targets are usually executed 
    before and after some main targets. They are: 

      -pre-init:                 called before initialization of project properties 
      -post-init:                called after initialization of project properties 
      -pre-compile:              called before javac compilation 
      -post-compile:             called after javac compilation 
      -pre-compile-single:       called before javac compilation of single file
      -post-compile-single:      called after javac compilation of single file
      -pre-compile-test:         called before javac compilation of JUnit tests
      -post-compile-test:        called after javac compilation of JUnit tests
      -pre-compile-test-single:  called before javac compilation of single JUnit test
      -post-compile-test-single: called after javac compilation of single JUunit test
      -pre-dist:                 called before archive building 
      -post-dist:                called after archive building 
      -post-clean:               called after cleaning build products 
      -pre-run-deploy:           called before deploying
      -post-run-deploy:          called after deploying

    Example of pluging an obfuscator after the compilation could look like 

        <target name="-post-compile">
            <obfuscate>
                <fileset dir="${build.classes.dir}"/>
            </obfuscate>
        </target>

    For list of available properties check the imported 
    nbproject/build-impl.xml file. 


    Other way how to customize the build is by overriding existing main targets.
    The target of interest are: 

      init-macrodef-javac:    defines macro for javac compilation
      init-macrodef-junit:   defines macro for junit execution
      init-macrodef-debug:    defines macro for class debugging
      do-dist:                archive building
      run:                    execution of project 
      javadoc-build:          javadoc generation 

    Example of overriding the target for project execution could look like 

        <target name="run" depends="<PROJNAME>-impl.jar">
            <exec dir="bin" executable="launcher.exe">
                <arg file="${dist.jar}"/>
            </exec>
        </target>

    Notice that overridden target depends on jar target and not only on 
    compile target as regular run target does. Again, for list of available 
    properties which you can use check the target you are overriding in 
    nbproject/build-impl.xml file. 

    -->
</project>