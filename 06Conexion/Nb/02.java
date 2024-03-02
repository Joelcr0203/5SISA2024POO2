<?xml version="1.0" encoding="UTF-8"?>
<!--
        *** GENERATED FROM project.xml - DO NOT EDIT  ***
        ***         EDIT ../build.xml INSTEAD         ***

        For the purpose of easier reading the script
        is divided into following sections:
        - initialization
        - compilation
        - dist
        - execution
        - debugging
        - javadoc
        - test compilation
        - test execution
        - test debugging
        - cleanup

        -->
<project xmlns:webproject1="http://www.netbeans.org/ns/web-project/1" xmlns:webproject2="http://www.netbeans.org/ns/web-project/2" xmlns:webproject3="http://www.netbeans.org/ns/web-project/3" basedir=".." default="default" name="05Conexion-impl">
    <import file="ant-deploy.xml"/>
    <fail message="Please build using Ant 1.7.1 or higher.">
        <condition>
            <not>
                <antversion atleast="1.7.1"/>
            </not>
        </condition>
    </fail>
    <target depends="dist,javadoc" description="Build whole project." name="default"/>
    <!--
                INITIALIZATION SECTION
            -->
    <target name="-pre-init">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="-pre-init" name="-init-private">
        <property file="nbproject/private/private.properties"/>
    </target>
    <target depends="-pre-init,-init-private" name="-init-user">
        <property file="${user.properties.file}"/>
        <!-- The two properties below are usually overridden -->
        <!-- by the active platform. Just a fallback. -->
        <property name="default.javac.source" value="1.4"/>
        <property name="default.javac.target" value="1.4"/>
    </target>
    <target depends="-pre-init,-init-private,-init-user" name="-init-project">
        <property file="nbproject/project.properties"/>
    </target>
    <target depends="-pre-init,-init-private,-init-user,-init-project,-init-macrodef-property" if="dist.ear.dir" name="-do-ear-init"/>
    <target depends="-pre-init,-init-private,-init-user,-init-project,-init-macrodef-property" name="-do-init">
        <condition property="have.tests">
            <or>
                <available file="${test.src.dir}"/>
            </or>
        </condition>
        <condition property="have.sources">
            <or>
                <available file="${src.dir}"/>
            </or>
        </condition>
        <condition property="netbeans.home+have.tests">
            <and>
                <isset property="netbeans.home"/>
                <isset property="have.tests"/>
            </and>
        </condition>
        <condition property="no.javadoc.preview">
            <isfalse value="${javadoc.preview}"/>
        </condition>
        <property name="javac.compilerargs" value=""/>
        <condition property="no.deps">
            <and>
                <istrue value="${no.dependencies}"/>
            </and>
        </condition>
        <condition property="no.dist.ear.dir">
            <not>
                <isset property="dist.ear.dir"/>
            </not>
        </condition>
        <property name="build.web.excludes" value="${build.classes.excludes}"/>
        <condition property="do.compile.jsps">
            <istrue value="${compile.jsps}"/>
        </condition>
        <condition property="do.debug.server">
            <or>
                <not>
                    <isset property="debug.server"/>
                </not>
                <istrue value="${debug.server}"/>
                <and>
                    <not>
                        <istrue value="${debug.server}"/>
                    </not>
                    <not>
                        <istrue value="${debug.client}"/>
                    </not>
                </and>
            </or>
        </condition>
        <condition property="do.debug.client">
            <istrue value="${debug.client}"/>
        </condition>
        <condition property="do.display.browser">
            <istrue value="${display.browser}"/>
        </condition>
        <condition property="do.display.browser.debug.old">
            <and>
                <isset property="do.display.browser"/>
                <not>
                    <isset property="do.debug.client"/>
                </not>
                <not>
                    <isset property="browser.context"/>
                </not>
            </and>
        </condition>
        <condition property="do.display.browser.debug">
            <and>
                <isset property="do.display.browser"/>
                <not>
                    <isset property="do.debug.client"/>
                </not>
                <isset property="browser.context"/>
            </and>
        </condition>
        <available file="${conf.dir}/MANIFEST.MF" property="has.custom.manifest"/>
        <available file="${persistence.xml.dir}/persistence.xml" property="has.persistence.xml"/>
        <condition property="do.war.package.with.custom.manifest">
            <isset property="has.custom.manifest"/>
        </condition>
        <condition property="do.war.package.without.custom.manifest">
            <not>
                <isset property="has.custom.manifest"/>
            </not>
        </condition>
        <condition property="do.tmp.war.package.with.custom.manifest">
            <and>
                <isset property="has.custom.manifest"/>
                <or>
                    <isfalse value="${directory.deployment.supported}"/>
                    <isset property="dist.ear.dir"/>
                </or>
            </and>
        </condition>
        <condition property="do.tmp.war.package.without.custom.manifest">
            <and>
                <not>
                    <isset property="has.custom.manifest"/>
                </not>
                <or>
                    <isfalse value="${directory.deployment.supported}"/>
                    <isset property="dist.ear.dir"/>
                </or>
            </and>
        </condition>
        <condition property="do.tmp.war.package">
            <or>
                <isfalse value="${directory.deployment.supported}"/>
                <isset property="dist.ear.dir"/>
            </or>
        </condition>
        <property name="build.meta.inf.dir" value="${build.web.dir}/META-INF"/>
        <condition else="" property="application.args.param" value="${application.args}">
            <and>
                <isset property="application.args"/>
                <not>
                    <equals arg1="${application.args}" arg2="" trim="true"/>
                </not>
            </and>
        </condition>
        <property name="source.encoding" value="${file.encoding}"/>
        <condition property="javadoc.encoding.used" value="${javadoc.encoding}">
            <and>
                <isset property="javadoc.encoding"/>
                <not>
                    <equals arg1="${javadoc.encoding}" arg2=""/>
                </not>
            </and>
        </condition>
        <property name="javadoc.encoding.used" value="${source.encoding}"/>
        <property name="includes" value="**"/>
        <property name="excludes" value=""/>
        <property name="runmain.jvmargs" value=""/>
        <path id="endorsed.classpath.path" path="${endorsed.classpath}"/>
        <condition else="" property="endorsed.classpath.cmd.line.arg" value="-Xbootclasspath/p:'${toString:endorsed.classpath.path}'">
            <and>
                <isset property="endorsed.classpath"/>
                <length length="0" string="${endorsed.classpath}" when="greater"/>
            </and>
        </condition>
        <condition else="false" property="jdkBug6558476">
            <and>
                <matches pattern="1\.[56]" string="${java.specification.version}"/>
                <not>
                    <os family="unix"/>
                </not>
            </and>
        </condition>
        <property name="javac.fork" value="${jdkBug6558476}"/>
        <condition property="junit.available">
            <or>
                <available classname="org.junit.Test" classpath="${run.test.classpath}"/>
                <available classname="junit.framework.Test" classpath="${run.test.classpath}"/>
            </or>
        </condition>
        <condition property="testng.available">
            <available classname="org.testng.annotations.Test" classpath="${run.test.classpath}"/>
        </condition>
        <condition property="junit+testng.available">
            <and>
                <istrue value="${junit.available}"/>
                <istrue value="${testng.available}"/>
            </and>
        </condition>
        <condition else="testng" property="testng.mode" value="mixed">
            <istrue value="${junit+testng.available}"/>
        </condition>
        <condition else="" property="testng.debug.mode" value="-mixed">
            <istrue value="${junit+testng.available}"/>
        </condition>
    </target>
    <target depends="init" name="-init-cos" unless="deploy.on.save">
        <condition property="deploy.on.save" value="true">
            <or>
                <istrue value="${j2ee.deploy.on.save}"/>
                <istrue value="${j2ee.compile.on.save}"/>
            </or>
        </condition>
    </target>
    <target name="-post-init">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="-pre-init,-init-private,-init-user,-init-project,-do-init" name="-init-check">
        <fail unless="src.dir">Must set src.dir</fail>
        <fail unless="test.src.dir">Must set test.src.dir</fail>
        <fail unless="build.dir">Must set build.dir</fail>
        <fail unless="build.web.dir">Must set build.web.dir</fail>
        <fail unless="build.generated.dir">Must set build.generated.dir</fail>
        <fail unless="dist.dir">Must set dist.dir</fail>
        <fail unless="build.classes.dir">Must set build.classes.dir</fail>
        <fail unless="dist.javadoc.dir">Must set dist.javadoc.dir</fail>
        <fail unless="build.test.classes.dir">Must set build.test.classes.dir</fail>
        <fail unless="build.test.results.dir">Must set build.test.results.dir</fail>
        <fail unless="build.classes.excludes">Must set build.classes.excludes</fail>
        <fail unless="dist.war">Must set dist.war</fail>
        <condition property="missing.j2ee.server.home">
            <and>
                <matches pattern="j2ee.server.home" string="${j2ee.platform.classpath}"/>
                <not>
                    <isset property="j2ee.server.home"/>
                </not>
            </and>
        </condition>
        <fail if="missing.j2ee.server.home">
The Java EE server classpath is not correctly set up - server home directory is missing.
Either open the project in the IDE and assign the server or setup the server classpath manually.
For example like this:
   ant -Dj2ee.server.home=&lt;app_server_installation_directory&gt;
                </fail>
        <fail unless="j2ee.platform.classpath">
The Java EE server classpath is not correctly set up. Your active server type is ${j2ee.server.type}.
Either open the project in the IDE and assign the server or setup the server classpath manually.
For example like this:
   ant -Duser.properties.file=&lt;path_to_property_file&gt; (where you put the property "j2ee.platform.classpath" in a .properties file)
or ant -Dj2ee.platform.classpath=&lt;server_classpath&gt; (where no properties file is used)
                </fail>
    </target>
    <target name="-init-macrodef-property">
        <macrodef name="property" uri="http://www.netbeans.org/ns/web-project/1">
            <attribute name="name"/>
            <attribute name="value"/>
            <sequential>
                <property name="@{name}" value="${@{value}}"/>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-ap-cmdline-properties" if="ap.supported.internal" name="-init-macrodef-javac-with-processors">
        <macrodef name="javac" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${src.dir}" name="srcdir"/>
            <attribute default="${build.classes.dir}" name="destdir"/>
            <attribute default="${javac.classpath}:${j2ee.platform.classpath}" name="classpath"/>
            <attribute default="${javac.processorpath}" name="processorpath"/>
            <attribute default="${build.generated.sources.dir}/ap-source-output" name="apgeneratedsrcdir"/>
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="${javac.debug}" name="debug"/>
            <attribute default="${empty.dir}" name="gensrcdir"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property location="${build.dir}/empty" name="empty.dir"/>
                <mkdir dir="${empty.dir}"/>
                <mkdir dir="@{apgeneratedsrcdir}"/>
                <javac debug="@{debug}" deprecation="${javac.deprecation}" destdir="@{destdir}" encoding="${source.encoding}" excludes="@{excludes}" fork="${javac.fork}" includeantruntime="false" includes="@{includes}" source="${javac.source}" srcdir="@{srcdir}" target="${javac.target}">
                    <src>
                        <dirset dir="@{gensrcdir}" erroronmissingdir="false">
                            <include name="*"/>
                        </dirset>
                    </src>
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                    <compilerarg line="${endorsed.classpath.cmd.line.arg}"/>
                    <compilerarg line="${javac.compilerargs}"/>
                    <compilerarg value="-processorpath"/>
                    <compilerarg path="@{processorpath}:${empty.dir}"/>
                    <compilerarg line="${ap.processors.internal}"/>
                    <compilerarg value="-s"/>
                    <compilerarg path="@{apgeneratedsrcdir}"/>
                    <compilerarg line="${ap.proc.none.internal}"/>
                    <customize/>
                </javac>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-ap-cmdline-properties" name="-init-macrodef-javac-without-processors" unless="ap.supported.internal">
        <macrodef name="javac" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${src.dir}" name="srcdir"/>
            <attribute default="${build.classes.dir}" name="destdir"/>
            <attribute default="${javac.classpath}:${j2ee.platform.classpath}" name="classpath"/>
            <attribute default="${javac.processorpath}" name="processorpath"/>
            <attribute default="${build.generated.sources.dir}/ap-source-output" name="apgeneratedsrcdir"/>
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="${javac.debug}" name="debug"/>
            <attribute default="${empty.dir}" name="gensrcdir"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property location="${build.dir}/empty" name="empty.dir"/>
                <mkdir dir="${empty.dir}"/>
                <javac debug="@{debug}" deprecation="${javac.deprecation}" destdir="@{destdir}" encoding="${source.encoding}" excludes="@{excludes}" includeantruntime="false" includes="@{includes}" source="${javac.source}" srcdir="@{srcdir}" target="${javac.target}">
                    <src>
                        <dirset dir="@{gensrcdir}" erroronmissingdir="false">
                            <include name="*"/>
                        </dirset>
                    </src>
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                    <compilerarg line="${endorsed.classpath.cmd.line.arg}"/>
                    <compilerarg line="${javac.compilerargs}"/>
                    <customize/>
                </javac>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-javac-with-processors,-init-macrodef-javac-without-processors" name="-init-macrodef-javac">
        <macrodef name="depend" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${src.dir}" name="srcdir"/>
            <attribute default="${build.classes.dir}" name="destdir"/>
            <attribute default="${javac.classpath}:${j2ee.platform.classpath}" name="classpath"/>
            <sequential>
                <depend cache="${build.dir}/depcache" destdir="@{destdir}" excludes="${excludes}" includes="${includes}" srcdir="@{srcdir}">
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                </depend>
            </sequential>
        </macrodef>
        <macrodef name="force-recompile" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${build.classes.dir}" name="destdir"/>
            <sequential>
                <fail unless="javac.includes">Must set javac.includes</fail>
                <pathconvert pathsep="${line.separator}" property="javac.includes.binary">
                    <path>
                        <filelist dir="@{destdir}" files="${javac.includes}"/>
                    </path>
                    <globmapper from="*.java" to="*.class"/>
                </pathconvert>
                <tempfile deleteonexit="true" property="javac.includesfile.binary"/>
                <echo file="${javac.includesfile.binary}" message="${javac.includes.binary}"/>
                <delete>
                    <files includesfile="${javac.includesfile.binary}"/>
                </delete>
                <delete file="${javac.includesfile.binary}"/>
            </sequential>
        </macrodef>
    </target>
    <target if="${junit.available}" name="-init-macrodef-junit-init">
        <condition else="false" property="nb.junit.batch" value="true">
            <and>
                <istrue value="${junit.available}"/>
                <not>
                    <isset property="test.method"/>
                </not>
            </and>
        </condition>
        <condition else="false" property="nb.junit.single" value="true">
            <and>
                <istrue value="${junit.available}"/>
                <isset property="test.method"/>
            </and>
        </condition>
    </target>
    <target name="-init-test-properties">
        <property name="test.binaryincludes" value="&lt;nothing&gt;"/>
        <property name="test.binarytestincludes" value=""/>
        <property name="test.binaryexcludes" value=""/>
    </target>
    <target if="${nb.junit.single}" name="-init-macrodef-junit-single" unless="${nb.junit.batch}">
        <macrodef name="junit" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <junit dir="${basedir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" showoutput="true" tempdir="${java.io.tmpdir}">
                    <test methods="@{testmethods}" name="@{testincludes}" todir="${build.test.results.dir}"/>
                    <syspropertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <formatter type="brief" usefile="false"/>
                    <formatter type="xml"/>
                    <jvmarg value="-ea"/>
                    <customize/>
                </junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-test-properties" if="${nb.junit.batch}" name="-init-macrodef-junit-batch" unless="${nb.junit.single}">
        <macrodef name="junit" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property name="run.jvmargs.ide" value=""/>
                <junit dir="${basedir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" showoutput="true" tempdir="${build.dir}">
                    <batchtest todir="${build.test.results.dir}">
                        <fileset dir="${test.src.dir}" excludes="@{excludes},${excludes}" includes="@{includes}">
                            <filename name="@{testincludes}"/>
                        </fileset>
                        <fileset dir="${build.test.classes.dir}" excludes="@{excludes},${excludes},${test.binaryexcludes}" includes="${test.binaryincludes}">
                            <filename name="${test.binarytestincludes}"/>
                        </fileset>
                    </batchtest>
                    <syspropertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <formatter type="brief" usefile="false"/>
                    <formatter type="xml"/>
                    <jvmarg value="-ea"/>
                    <jvmarg line="${run.jvmargs.ide}"/>
                    <customize/>
                </junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-junit-init,-init-macrodef-junit-single, -init-macrodef-junit-batch" if="${junit.available}" name="-init-macrodef-junit"/>
    <target if="${testng.available}" name="-init-macrodef-testng">
        <macrodef name="testng" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <condition else="" property="testng.methods.arg" value="@{testincludes}.@{testmethods}">
                    <isset property="test.method"/>
                </condition>
                <union id="test.set">
                    <fileset dir="${test.src.dir}" excludes="@{excludes},**/*.xml,${excludes}" includes="@{includes}">
                        <filename name="@{testincludes}"/>
                    </fileset>
                </union>
                <taskdef classname="org.testng.TestNGAntTask" classpath="${run.test.classpath}" name="testng"/>
                <testng classfilesetref="test.set" failureProperty="tests.failed" listeners="org.testng.reporters.VerboseReporter" methods="${testng.methods.arg}" mode="${testng.mode}" outputdir="${build.test.results.dir}" suitename="05Conexion" testname="TestNG tests" workingDir="${basedir}">
                    <xmlfileset dir="${build.test.classes.dir}" includes="@{testincludes}"/>
                    <propertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </propertyset>
                    <customize/>
                </testng>
            </sequential>
        </macrodef>
    </target>
    <target name="-init-macrodef-test-impl">
        <macrodef name="test-impl" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element implicit="true" name="customize" optional="true"/>
            <sequential>
                <echo>No tests executed.</echo>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-junit" if="${junit.available}" name="-init-macrodef-junit-impl">
        <macrodef name="test-impl" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element implicit="true" name="customize" optional="true"/>
            <sequential>
                <webproject2:junit excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize/>
                </webproject2:junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-testng" if="${testng.available}" name="-init-macrodef-testng-impl">
        <macrodef name="test-impl" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element implicit="true" name="customize" optional="true"/>
            <sequential>
                <webproject2:testng excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize/>
                </webproject2:testng>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-test-impl,-init-macrodef-junit-impl,-init-macrodef-testng-impl" name="-init-macrodef-test">
        <macrodef name="test" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <sequential>
                <webproject2:test-impl excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize>
                        <classpath>
                            <path path="${run.test.classpath}:${j2ee.platform.classpath}:${j2ee.platform.embeddableejb.classpath}"/>
                        </classpath>
                        <jvmarg line="${endorsed.classpath.cmd.line.arg}"/>
                        <jvmarg line="${runmain.jvmargs}"/>
                    </customize>
                </webproject2:test-impl>
            </sequential>
        </macrodef>
    </target>
    <target if="${junit.available}" name="-init-macrodef-junit-debug" unless="${nb.junit.batch}">
        <macrodef name="junit-debug" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <junit dir="${basedir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" showoutput="true" tempdir="${java.io.tmpdir}">
                    <test methods="@{testmethods}" name="@{testincludes}" todir="${build.test.results.dir}"/>
                    <syspropertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <formatter type="brief" usefile="false"/>
                    <formatter type="xml"/>
                    <jvmarg value="-ea"/>
                    <jvmarg value="-agentlib:jdwp=transport=${debug-transport},address=${jpda.address}"/>
                    <customize/>
                </junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-test-properties" if="${nb.junit.batch}" name="-init-macrodef-junit-debug-batch">
        <macrodef name="junit-debug" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element name="customize" optional="true"/>
            <sequential>
                <property name="run.jvmargs.ide" value=""/>
                <junit dir="${basedir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" showoutput="true" tempdir="${build.dir}">
                    <batchtest todir="${build.test.results.dir}">
                        <fileset dir="${test.src.dir}" excludes="@{excludes},${excludes}" includes="@{includes}">
                            <filename name="@{testincludes}"/>
                        </fileset>
                        <fileset dir="${build.test.classes.dir}" excludes="@{excludes},${excludes},${test.binaryexcludes}" includes="${test.binaryincludes}">
                            <filename name="${test.binarytestincludes}"/>
                        </fileset>
                    </batchtest>
                    <syspropertyset>
                        <propertyref prefix="test-sys-prop."/>
                        <mapper from="test-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <formatter type="brief" usefile="false"/>
                    <formatter type="xml"/>
                    <jvmarg value="-ea"/>
                    <jvmarg line="${run.jvmargs.ide}"/>
                    <jvmarg value="-agentlib:jdwp=transport=${debug-transport},address=${jpda.address}"/>
                    <customize/>
                </junit>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-junit-debug,-init-macrodef-junit-debug-batch" if="${junit.available}" name="-init-macrodef-junit-debug-impl">
        <macrodef name="test-debug-impl" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <element implicit="true" name="customize" optional="true"/>
            <sequential>
                <webproject2:junit-debug excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize/>
                </webproject2:junit-debug>
            </sequential>
        </macrodef>
    </target>
    <target if="${testng.available}" name="-init-macrodef-testng-debug">
        <macrodef name="testng-debug" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${main.class}" name="testClass"/>
            <attribute default="" name="testMethod"/>
            <element name="customize2" optional="true"/>
            <sequential>
                <condition else="-testclass @{testClass}" property="test.class.or.method" value="-methods @{testClass}.@{testMethod}">
                    <isset property="test.method"/>
                </condition>
                <condition else="-suitename 05Conexion -testname @{testClass} ${test.class.or.method}" property="testng.cmd.args" value="@{testClass}">
                    <matches pattern=".*\.xml" string="@{testClass}"/>
                </condition>
                <delete dir="${build.test.results.dir}" quiet="true"/>
                <mkdir dir="${build.test.results.dir}"/>
                <webproject1:debug args="${testng.cmd.args}" classname="org.testng.TestNG" classpath="${debug.test.classpath}:${j2ee.platform.embeddableejb.classpath}">
                    <customize>
                        <customize2/>
                        <jvmarg value="-ea"/>
                        <arg line="${testng.debug.mode}"/>
                        <arg line="-d ${build.test.results.dir}"/>
                        <arg line="-listener org.testng.reporters.VerboseReporter"/>
                    </customize>
                </webproject1:debug>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-testng-debug" if="${testng.available}" name="-init-macrodef-testng-debug-impl">
        <macrodef name="testng-debug-impl" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${main.class}" name="testClass"/>
            <attribute default="" name="testMethod"/>
            <element implicit="true" name="customize2" optional="true"/>
            <sequential>
                <webproject2:testng-debug testClass="@{testClass}" testMethod="@{testMethod}">
                    <customize2/>
                </webproject2:testng-debug>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-junit-debug-impl" if="${junit.available}" name="-init-macrodef-test-debug-junit">
        <macrodef name="test-debug" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <attribute default="${main.class}" name="testClass"/>
            <attribute default="" name="testMethod"/>
            <sequential>
                <webproject2:test-debug-impl excludes="@{excludes}" includes="@{includes}" testincludes="@{testincludes}" testmethods="@{testmethods}">
                    <customize>
                        <classpath>
                            <path path="${run.test.classpath}:${j2ee.platform.classpath}:${j2ee.platform.embeddableejb.classpath}"/>
                        </classpath>
                        <jvmarg line="${endorsed.classpath.cmd.line.arg}"/>
                        <jvmarg line="${runmain.jvmargs}"/>
                    </customize>
                </webproject2:test-debug-impl>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-testng-debug-impl" if="${testng.available}" name="-init-macrodef-test-debug-testng">
        <macrodef name="test-debug" uri="http://www.netbeans.org/ns/web-project/2">
            <attribute default="${includes}" name="includes"/>
            <attribute default="${excludes}" name="excludes"/>
            <attribute default="**" name="testincludes"/>
            <attribute default="" name="testmethods"/>
            <attribute default="${main.class}" name="testClass"/>
            <attribute default="" name="testMethod"/>
            <sequential>
                <webproject2:testng-debug-impl testClass="@{testClass}" testMethod="@{testMethod}">
                    <customize2>
                        <syspropertyset>
                            <propertyref prefix="test-sys-prop."/>
                            <mapper from="test-sys-prop.*" to="*" type="glob"/>
                        </syspropertyset>
                    </customize2>
                </webproject2:testng-debug-impl>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-macrodef-test-debug-junit,-init-macrodef-test-debug-testng" name="-init-macrodef-test-debug"/>
    <target name="-init-macrodef-java">
        <macrodef name="java" uri="http://www.netbeans.org/ns/web-project/1">
            <attribute default="${main.class}" name="classname"/>
            <attribute default="${debug.classpath}" name="classpath"/>
            <element name="customize" optional="true"/>
            <sequential>
                <java classname="@{classname}" fork="true">
                    <jvmarg line="${endorsed.classpath.cmd.line.arg}"/>
                    <jvmarg line="${runmain.jvmargs}"/>
                    <classpath>
                        <path path="@{classpath}:${j2ee.platform.classpath}"/>
                    </classpath>
                    <syspropertyset>
                        <propertyref prefix="run-sys-prop."/>
                        <mapper from="run-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <customize/>
                </java>
            </sequential>
        </macrodef>
    </target>
    <target name="-init-macrodef-nbjsdebug">
        <macrodef name="nbjsdebugstart" uri="http://www.netbeans.org/ns/web-project/1">
            <attribute default="${client.url}" name="webUrl"/>
            <sequential>
                <nbjsdebugstart urlPart="${client.urlPart}" webUrl="@{webUrl}"/>
            </sequential>
        </macrodef>
    </target>
    <target depends="-init-debug-args" name="-init-macrodef-nbjpda">
        <macrodef name="nbjpdastart" uri="http://www.netbeans.org/ns/web-project/1">
            <attribute default="${main.class}" name="name"/>
            <attribute default="${debug.classpath}:${j2ee.platform.classpath}" name="classpath"/>
            <sequential>
                <nbjpdastart addressproperty="jpda.address" name="@{name}" transport="${debug-transport}">
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                </nbjpdastart>
            </sequential>
        </macrodef>
        <macrodef name="nbjpdareload" uri="http://www.netbeans.org/ns/web-project/1">
            <attribute default="${build.classes.dir}" name="dir"/>
            <sequential>
                <nbjpdareload>
                    <fileset dir="@{dir}" includes="${fix.classes}">
                        <include name="${fix.includes}*.class"/>
                    </fileset>
                </nbjpdareload>
            </sequential>
        </macrodef>
        <macrodef name="nbjpdaappreloaded" uri="http://www.netbeans.org/ns/web-project/1">
            <sequential>
                <nbjpdaappreloaded/>
            </sequential>
        </macrodef>
    </target>
    <target name="-init-debug-args">
        <condition else="dt_socket" property="debug-transport-by-os" value="dt_shmem">
            <os family="windows"/>
        </condition>
        <condition else="${debug-transport-by-os}" property="debug-transport" value="${debug.transport}">
            <isset property="debug.transport"/>
        </condition>
    </target>
    <target depends="-init-debug-args" name="-init-macrodef-debug">
        <macrodef name="debug" uri="http://www.netbeans.org/ns/web-project/1">
            <attribute default="${main.class}" name="classname"/>
            <attribute default="${debug.classpath}:${j2ee.platform.classpath}" name="classpath"/>
            <attribute default="${application.args.param}" name="args"/>
            <element name="customize" optional="true"/>
            <sequential>
                <java classname="@{classname}" fork="true">
                    <jvmarg line="${endorsed.classpath.cmd.line.arg}"/>
                    <jvmarg value="-agentlib:jdwp=transport=${debug-transport},address=${jpda.address}"/>
                    <jvmarg line="${runmain.jvmargs}"/>
                    <classpath>
                        <path path="@{classpath}"/>
                    </classpath>
                    <syspropertyset>
                        <propertyref prefix="run-sys-prop."/>
                        <mapper from="run-sys-prop.*" to="*" type="glob"/>
                    </syspropertyset>
                    <arg line="@{args}"/>
                    <customize/>
                </java>
            </sequential>
        </macrodef>
    </target>
    <target name="-init-taskdefs">
        <fail unless="libs.CopyLibs.classpath">
The libs.CopyLibs.classpath property is not set up.
This property must point to 
org-netbeans-modules-java-j2seproject-copylibstask.jar file which is part
of NetBeans IDE installation and is usually located at 
&lt;netbeans_installation&gt;/java&lt;version&gt;/ant/extra folder.
Either open the project in the IDE and make sure CopyLibs library
exists or setup the property manually. For example like this:
 ant -Dlibs.CopyLibs.classpath=a/path/to/org-netbeans-modules-java-j2seproject-copylibstask.jar
                </fail>
        <taskdef classpath="${libs.CopyLibs.classpath}" resource="org/netbeans/modules/java/j2seproject/copylibstask/antlib.xml"/>
    </target>
    <target name="-init-ap-cmdline-properties">
        <property name="annotation.processing.enabled" value="true"/>
        <property name="annotation.processing.processors.list" value=""/>
        <property name="annotation.processing.run.all.processors" value="true"/>
        <property name="javac.processorpath" value="${javac.classpath}"/>
        <property name="javac.test.processorpath" value="${javac.test.classpath}"/>
        <condition property="ap.supported.internal" value="true">
            <not>
                <matches pattern="1\.[0-5](\..*)?" string="${javac.source}"/>
            </not>
        </condition>
    </target>
    <target depends="-init-ap-cmdline-properties" if="ap.supported.internal" name="-init-ap-cmdline-supported">
        <condition else="" property="ap.processors.internal" value="-processor ${annotation.processing.processors.list}">
            <isfalse value="${annotation.processing.run.all.processors}"/>
        </condition>
        <condition else="" property="ap.proc.none.internal" value="-proc:none">
            <isfalse value="${annotation.processing.enabled}"/>
        </condition>
    </target>
    <target depends="-init-ap-cmdline-properties,-init-ap-cmdline-supported" name="-init-ap-cmdline">
        <property name="ap.cmd.line.internal" value=""/>
    </target>
    <!--
                pre NB7.2 profiling section; consider it deprecated
            -->
    <target depends="-profile-pre-init, init, -profile-post-init, -profile-init-check" if="profiler.info.jvmargs.agent" name="profile-init"/>
    <target if="profiler.info.jvmargs.agent" name="-profile-pre-init">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target if="profiler.info.jvmargs.agent" name="-profile-post-init">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="-profile-pre-init, init, -profile-post-init" if="profiler.info.jvmargs.agent" name="-profile-init-check">
        <fail unless="profiler.info.jvm">Must set JVM to use for profiling in profiler.info.jvm</fail>
        <fail unless="profiler.info.jvmargs.agent">Must set profiler agent JVM arguments in profiler.info.jvmargs.agent</fail>
    </target>
    <!--
                end of pre NB7.2 profiling section
            -->
    <target depends="-pre-init,-init-private,-init-user,-init-project,-do-init,-post-init,-init-check,-init-macrodef-property,-init-macrodef-javac,-init-macrodef-test,-init-macrodef-test-debug,-init-macrodef-java,-init-macrodef-nbjpda,-init-macrodef-nbjsdebug,-init-macrodef-debug,-init-taskdefs,-init-ap-cmdline" name="init"/>
    <!--
                COMPILATION SECTION
            -->
    <target depends="init" if="no.dist.ear.dir" name="deps-module-jar" unless="no.deps"/>
    <target depends="init" if="dist.ear.dir" name="deps-ear-jar" unless="no.deps"/>
    <target depends="init, deps-module-jar, deps-ear-jar" name="deps-jar" unless="no.deps"/>
    <target depends="init,deps-jar" name="-pre-pre-compile">
        <mkdir dir="${build.classes.dir}"/>
    </target>
    <target name="-pre-compile">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target name="-copy-webdir">
        <copy todir="${build.web.dir}">
            <fileset dir="${web.docbase.dir}" excludes="${build.web.excludes},${excludes}" includes="${includes}"/>
        </copy>
        <copy todir="${build.web.dir}/WEB-INF">
            <fileset dir="${webinf.dir}" excludes="${build.web.excludes}"/>
        </copy>
    </target>
    <target depends="init, deps-jar, -pre-pre-compile, -pre-compile, -copy-manifest, -copy-persistence-xml, -copy-webdir, library-inclusion-in-archive,library-inclusion-in-manifest" if="have.sources" name="-do-compile">
        <webproject2:javac destdir="${build.classes.dir}" gensrcdir="${build.generated.sources.dir}"/>
        <copy todir="${build.classes.dir}">
            <fileset dir="${src.dir}" excludes="${build.classes.excludes},${excludes}" includes="${includes}"/>
        </copy>
    </target>
    <target if="has.custom.manifest" name="-copy-manifest">
        <mkdir dir="${build.meta.inf.dir}"/>
        <copy todir="${build.meta.inf.dir}">
            <fileset dir="${conf.dir}" includes="MANIFEST.MF"/>
        </copy>
    </target>
    <target if="has.persistence.xml" name="-copy-persistence-xml">
        <mkdir dir="${build.web.dir}/WEB-INF/classes/META-INF"/>
        <copy todir="${build.web.dir}/WEB-INF/classes/META-INF">
            <fileset dir="${persistence.xml.dir}" includes="persistence.xml orm.xml"/>
        </copy>
    </target>
    <target name="-post-compile">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,deps-jar,-pre-pre-compile,-pre-compile,-do-compile,-post-compile" description="Compile project." name="compile"/>
    <target name="-pre-compile-single">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,deps-jar,-pre-pre-compile" name="-do-compile-single">
        <fail unless="javac.includes">Must select some files in the IDE or set javac.includes</fail>
        <webproject2:javac excludes="" gensrcdir="${build.generated.sources.dir}" includes="${javac.includes}"/>
        <copy todir="${build.classes.dir}">
            <fileset dir="${src.dir}" excludes="${build.classes.excludes},${excludes}" includes="${includes}"/>
        </copy>
    </target>
    <target name="-post-compile-single">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,deps-jar,-pre-pre-compile,-pre-compile-single,-do-compile-single,-post-compile-single" name="compile-single"/>
    <property name="jspc.schemas" value="/resources/schemas/"/>
    <property name="jspc.dtds" value="/resources/dtds/"/>
    <target depends="compile" description="Test compile JSP pages to expose compilation errors." if="do.compile.jsps" name="compile-jsps">
        <mkdir dir="${build.generated.dir}/src"/>
        <java classname="org.netbeans.modules.web.project.ant.JspC" failonerror="true" fork="true">
            <arg value="-uriroot"/>
            <arg file="${basedir}/${build.web.dir}"/>
            <arg value="-d"/>
            <arg file="${basedir}/${build.generated.dir}/src"/>
            <arg value="-die1"/>
            <arg value="-schemas ${jspc.schemas}"/>
            <arg value="-dtds ${jspc.dtds}"/>
            <arg value="-compilerSourceVM ${javac.source}"/>
            <arg value="-compilerTargetVM ${javac.target}"/>
            <arg value="-javaEncoding ${source.encoding}"/>
            <arg value="-sysClasspath ${libs.jsp-compilation-syscp.classpath}"/>
            <classpath path="${java.home}/../lib/tools.jar:${libs.jsp-compiler.classpath}:${libs.jsp-compilation.classpath}"/>
        </java>
        <mkdir dir="${build.generated.dir}/classes"/>
        <webproject2:javac classpath="${build.classes.dir}:${libs.jsp-compilation.classpath}:${javac.classpath}:${j2ee.platform.classpath}" destdir="${build.generated.dir}/classes" srcdir="${build.generated.dir}/src"/>
    </target>
    <target depends="compile" if="jsp.includes" name="-do-compile-single-jsp">
        <fail unless="javac.jsp.includes">Must select some files in the IDE or set javac.jsp.includes</fail>
        <mkdir dir="${build.generated.dir}/src"/>
        <java classname="org.netbeans.modules.web.project.ant.JspCSingle" failonerror="true" fork="true">
            <arg value="-uriroot"/>
            <arg file="${basedir}/${build.web.dir}"/>
            <arg value="-d"/>
            <arg file="${basedir}/${build.generated.dir}/src"/>
            <arg value="-die1"/>
            <arg value="-schemas ${jspc.schemas}"/>
            <arg value="-dtds ${jspc.dtds}"/>
            <arg value="-sysClasspath ${libs.jsp-compilation-syscp.classpath}"/>
            <arg value="-jspc.files"/>
            <arg path="${jsp.includes}"/>
            <arg value="-compilerSourceVM ${javac.source}"/>
            <arg value="-compilerTargetVM ${javac.target}"/>
            <arg value="-javaEncoding ${source.encoding}"/>
            <classpath path="${java.home}/../lib/tools.jar:${libs.jsp-compiler.classpath}:${libs.jsp-compilation.classpath}"/>
        </java>
        <mkdir dir="${build.generated.dir}/classes"/>
        <webproject2:javac classpath="${build.classes.dir}:${libs.jsp-compilation.classpath}:${javac.classpath}:${j2ee.platform.classpath}" destdir="${build.generated.dir}/classes" srcdir="${build.generated.dir}/src">
            <customize>
                <patternset includes="${javac.jsp.includes}"/>
            </customize>
        </webproject2:javac>
    </target>
    <target name="compile-single-jsp">
        <fail unless="jsp.includes">Must select a file in the IDE or set jsp.includes</fail>
        <antcall target="-do-compile-single-jsp"/>
    </target>
    <!--
                DIST BUILDING SECTION
            -->
    <target name="-pre-dist">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,compile,compile-jsps,-pre-dist" if="do.war.package.without.custom.manifest" name="-do-dist-without-manifest">
        <dirname file="${dist.war}" property="dist.jar.dir"/>
        <mkdir dir="${dist.jar.dir}"/>
        <jar compress="${jar.compress}" jarfile="${dist.war}">
            <fileset dir="${build.web.dir}" excludes="WEB-INF/classes/.netbeans_*,${dist.archive.excludes}"/>
        </jar>
    </target>
    <target depends="init,compile,compile-jsps,-pre-dist" if="do.war.package.with.custom.manifest" name="-do-dist-with-manifest">
        <dirname file="${dist.war}" property="dist.jar.dir"/>
        <mkdir dir="${dist.jar.dir}"/>
        <jar compress="${jar.compress}" jarfile="${dist.war}" manifest="${build.meta.inf.dir}/MANIFEST.MF">
            <fileset dir="${build.web.dir}" excludes="WEB-INF/classes/.netbeans_*,${dist.archive.excludes}"/>
        </jar>
    </target>
    <target depends="init,compile,compile-jsps,-pre-dist" if="do.tmp.war.package.without.custom.manifest" name="-do-tmp-dist-without-manifest">
        <dirname file="${dist.war}" property="dist.jar.dir"/>
        <mkdir dir="${dist.jar.dir}"/>
        <jar compress="${jar.compress}" jarfile="${dist.war}">
            <fileset dir="${build.web.dir}" excludes="WEB-INF/classes/.netbeans_*,${dist.archive.excludes}"/>
        </jar>
    </target>
    <target depends="init,compile,compile-jsps,-pre-dist" if="do.tmp.war.package.with.custom.manifest" name="-do-tmp-dist-with-manifest">
        <dirname file="${dist.war}" property="dist.jar.dir"/>
        <mkdir dir="${dist.jar.dir}"/>
        <jar compress="${jar.compress}" jarfile="${dist.war}" manifest="${build.meta.inf.dir}/MANIFEST.MF">
            <fileset dir="${build.web.dir}" excludes="WEB-INF/classes/.netbeans_*,${dist.archive.excludes}"/>
        </jar>
    </target>
    <target depends="init,compile,compile-jsps,-pre-dist,-do-dist-with-manifest,-do-dist-without-manifest" name="do-dist"/>
    <target depends="init" if="dist.ear.dir" name="library-inclusion-in-manifest">
        <mkdir dir="${build.web.dir}/META-INF"/>
        <manifest file="${build.web.dir}/META-INF/MANIFEST.MF" mode="update"/>
    </target>
    <target depends="init" name="library-inclusion-in-archive" unless="dist.ear.dir"/>
    <target depends="init" if="dist.ear.dir" name="-clean-webinf-lib">
        <delete dir="${build.web.dir}/WEB-INF/lib"/>
    </target>
    <target depends="init,-clean-webinf-lib,compile,compile-jsps,-pre-dist,library-inclusion-in-manifest" if="do.tmp.war.package" name="do-ear-dist">
        <dirname file="${dist.ear.war}" property="dist.jar.dir"/>
        <mkdir dir="${dist.jar.dir}"/>
        <jar compress="${jar.compress}" jarfile="${dist.ear.war}" manifest="${build.web.dir}/META-INF/MANIFEST.MF">
            <fileset dir="${build.web.dir}" excludes="WEB-INF/classes/.netbeans_*,${dist.archive.excludes}"/>
        </jar>
    </target>
    <target name="-post-dist">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,compile,-pre-dist,do-dist,-post-dist" description="Build distribution (WAR)." name="dist"/>
    <target depends="init,-clean-webinf-lib,-init-cos,compile,-pre-dist,do-ear-dist,-post-dist" description="Build distribution (WAR) to be packaged into an EAR." name="dist-ear"/>
    <!--
                EXECUTION SECTION
            -->
    <target depends="run-deploy,run-display-browser" description="Deploy to server and show in browser." name="run"/>
    <target name="-pre-run-deploy">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target name="-post-run-deploy">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target name="-pre-nbmodule-run-deploy">
        <!-- Empty placeholder for easier customization. -->
        <!-- This target can be overriden by NetBeans modules. Don't override it directly, use -pre-run-deploy task instead. -->
    </target>
    <target name="-post-nbmodule-run-deploy">
        <!-- Empty placeholder for easier customization. -->
        <!-- This target can be overriden by NetBeans modules. Don't override it directly, use -post-run-deploy task instead. -->
    </target>
    <target name="-run-deploy-am">
        <!-- Task to deploy to the Access Manager runtime. -->
    </target>
    <target depends="init,-init-cos,compile,compile-jsps,-do-compile-single-jsp,-pre-dist,-do-tmp-dist-with-manifest,-do-tmp-dist-without-manifest,-pre-run-deploy,-pre-nbmodule-run-deploy,-run-deploy-nb,-init-deploy-ant,-deploy-ant,-run-deploy-am,-post-nbmodule-run-deploy,-post-run-deploy,-do-update-breakpoints" name="run-deploy"/>
    <target if="netbeans.home" name="-run-deploy-nb">
        <nbdeploy clientUrlPart="${client.urlPart}" debugmode="false" forceRedeploy="${forceRedeploy}"/>
    </target>
    <target name="-init-deploy-ant" unless="netbeans.home">
        <property name="deploy.ant.archive" value="${dist.war}"/>
        <property name="deploy.ant.docbase.dir" value="${web.docbase.dir}"/>
        <property name="deploy.ant.resource.dir" value="${resource.dir}"/>
        <property name="deploy.ant.enabled" value="true"/>
    </target>
    <target depends="dist,-run-undeploy-nb,-init-deploy-ant,-undeploy-ant" name="run-undeploy"/>
    <target if="netbeans.home" name="-run-undeploy-nb">
        <fail message="Undeploy is not supported from within the IDE"/>
    </target>
    <target depends="init,-pre-dist,dist,-post-dist" name="verify">
        <nbverify file="${dist.war}"/>
    </target>
    <target depends="run-deploy,-init-display-browser,-display-browser-nb-old,-display-browser-nb,-display-browser-cl" name="run-display-browser"/>
    <target if="do.display.browser" name="-init-display-browser">
        <condition property="do.display.browser.nb.old">
            <and>
                <isset property="netbeans.home"/>
                <not>
                    <isset property="browser.context"/>
                </not>
            </and>
        </condition>
        <condition property="do.display.browser.nb">
            <and>
                <isset property="netbeans.home"/>
                <isset property="browser.context"/>
            </and>
        </condition>
        <condition property="do.display.browser.cl">
            <isset property="deploy.ant.enabled"/>
        </condition>
    </target>
    <target if="do.display.browser.nb.old" name="-display-browser-nb-old">
        <nbbrowse url="${client.url}"/>
    </target>
    <target if="do.display.browser.nb" name="-display-browser-nb">
        <nbbrowse context="${browser.context}" url="${client.url}" urlPath="${client.urlPart}"/>
    </target>
    <target if="do.display.browser.cl" name="-get-browser" unless="browser">
        <condition property="browser" value="rundll32">
            <os family="windows"/>
        </condition>
        <condition else="" property="browser.args" value="url.dll,FileProtocolHandler">
            <os family="windows"/>
        </condition>
        <condition property="browser" value="/usr/bin/open">
            <os family="mac"/>
        </condition>
        <property environment="env"/>
        <condition property="browser" value="${env.BROWSER}">
            <isset property="env.BROWSER"/>
        </condition>
        <condition property="browser" value="/usr/bin/firefox">
            <available file="/usr/bin/firefox"/>
        </condition>
        <condition property="browser" value="/usr/local/firefox/firefox">
            <available file="/usr/local/firefox/firefox"/>
        </condition>
        <condition property="browser" value="/usr/bin/mozilla">
            <available file="/usr/bin/mozilla"/>
        </condition>
        <condition property="browser" value="/usr/local/mozilla/mozilla">
            <available file="/usr/local/mozilla/mozilla"/>
        </condition>
        <condition property="browser" value="/usr/sfw/lib/firefox/firefox">
            <available file="/usr/sfw/lib/firefox/firefox"/>
        </condition>
        <condition property="browser" value="/opt/csw/bin/firefox">
            <available file="/opt/csw/bin/firefox"/>
        </condition>
        <condition property="browser" value="/usr/sfw/lib/mozilla/mozilla">
            <available file="/usr/sfw/lib/mozilla/mozilla"/>
        </condition>
        <condition property="browser" value="/opt/csw/bin/mozilla">
            <available file="/opt/csw/bin/mozilla"/>
        </condition>
    </target>
    <target depends="-get-browser" if="do.display.browser.cl" name="-display-browser-cl">
        <fail unless="browser">
                    Browser not found, cannot launch the deployed application. Try to set the BROWSER environment variable.
                </fail>
        <property name="browse.url" value="${deploy.ant.client.url}${client.urlPart}"/>
        <echo>Launching ${browse.url}</echo>
        <exec executable="${browser}" spawn="true">
            <arg line="${browser.args} ${browse.url}"/>
        </exec>
    </target>
    <target depends="init,-init-cos,compile-single" name="run-main">
        <fail unless="run.class">Must select one file in the IDE or set run.class</fail>
        <webproject1:java classname="${run.class}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single" name="run-test-with-main">
        <fail unless="run.class">Must select one file in the IDE or set run.class</fail>
        <webproject1:java classname="${run.class}" classpath="${run.test.classpath}"/>
    </target>
    <target depends="init" if="netbeans.home" name="-do-update-breakpoints">
        <webproject1:nbjpdaappreloaded/>
    </target>
    <!--
                DEBUGGING SECTION
            -->
    <target depends="init,-init-cos,compile,compile-jsps,-do-compile-single-jsp,-pre-dist,-do-tmp-dist-with-manifest,-do-tmp-dist-without-manifest" description="Debug project in IDE." if="netbeans.home" name="debug">
        <nbstartserver debugmode="true"/>
        <antcall target="connect-debugger"/>
        <nbdeploy clientUrlPart="${client.urlPart}" debugmode="true" forceRedeploy="true"/>
        <antcall target="debug-display-browser-old"/>
        <antcall target="debug-display-browser"/>
        <antcall target="connect-client-debugger"/>
    </target>
    <target if="do.debug.server" name="connect-debugger" unless="is.debugged">
        <condition property="listeningcp" value="sourcepath">
            <istrue value="${j2ee.compile.on.save}"/>
        </condition>
        <nbjpdaconnect address="${jpda.address}" host="${jpda.host}" listeningcp="${listeningcp}" name="${name}" transport="${jpda.transport}">
            <classpath>
                <path path="${debug.classpath}:${j2ee.platform.classpath}"/>
            </classpath>
            <sourcepath>
                <path path="${web.docbase.dir}"/>
            </sourcepath>
        </nbjpdaconnect>
    </target>
    <target if="do.display.browser.debug.old" name="debug-display-browser-old">
        <nbbrowse url="${client.url}"/>
    </target>
    <target if="do.display.browser.debug" name="debug-display-browser">
        <nbbrowse context="${browser.context}" url="${client.url}" urlPath="${client.urlPart}"/>
    </target>
    <target if="do.debug.client" name="connect-client-debugger">
        <webproject1:nbjsdebugstart webUrl="${client.url}"/>
    </target>
    <target depends="init,compile-test-single" if="netbeans.home" name="-debug-start-debuggee-main-test">
        <fail unless="debug.class">Must select one file in the IDE or set debug.class</fail>
        <webproject1:debug classname="${debug.class}" classpath="${debug.test.classpath}"/>
    </target>
    <target depends="init,compile-test-single,-debug-start-debugger-main-test,-debug-start-debuggee-main-test" if="netbeans.home" name="debug-test-with-main"/>
    <target depends="init,compile,compile-jsps,-do-compile-single-jsp,debug" if="netbeans.home" name="debug-single"/>
    <target depends="init" if="netbeans.home" name="-debug-start-debugger-main-test">
        <webproject1:nbjpdastart classpath="${debug.test.classpath}" name="${debug.class}"/>
    </target>
    <target depends="init" if="netbeans.home" name="-debug-start-debugger">
        <webproject1:nbjpdastart name="${debug.class}"/>
    </target>
    <target depends="init,compile-single" if="netbeans.home" name="-debug-start-debuggee-single">
        <fail unless="debug.class">Must select one file in the IDE or set debug.class</fail>
        <webproject1:debug classname="${debug.class}"/>
    </target>
    <target depends="init,compile-single,-debug-start-debugger,-debug-start-debuggee-single" if="netbeans.home" name="debug-single-main"/>
    <target depends="init" name="-pre-debug-fix">
        <fail unless="fix.includes">Must set fix.includes</fail>
        <property name="javac.includes" value="${fix.includes}.java"/>
    </target>
    <target depends="init,-pre-debug-fix,compile-single" if="netbeans.home" name="-do-debug-fix">
        <webproject1:nbjpdareload/>
    </target>
    <target depends="init,-pre-debug-fix,-do-debug-fix" if="netbeans.home" name="debug-fix"/>
    <!--
            =================
            PROFILING SECTION
            =================
            -->
    <!--
                pre NB7.2 profiling section; consider it deprecated
            -->
    <target description="Profile a J2EE project in the IDE." if="profiler.info.jvmargs.agent" name="-profile-pre72">
        <condition else="start-profiled-server" property="profiler.startserver.target" value="start-profiled-server-extraargs">
            <isset property="profiler.info.jvmargs.extra"/>
        </condition>
        <antcall target="${profiler.startserver.target}"/>
        <antcall target="run"/>
        <antcall target="-profile-start-loadgen"/>
    </target>
    <target if="profiler.info.jvmargs.agent" name="start-profiled-server">
        <nbstartprofiledserver forceRestart="${profiler.j2ee.serverForceRestart}" javaPlatform="${profiler.info.javaPlatform}" startupTimeout="${profiler.j2ee.serverStartupTimeout}">
            <jvmarg value="${profiler.info.jvmargs.agent}"/>
            <jvmarg value="${profiler.j2ee.agentID}"/>
        </nbstartprofiledserver>
    </target>
    <target if="profiler.info.jvmargs.agent" name="start-profiled-server-extraargs">
        <nbstartprofiledserver forceRestart="${profiler.j2ee.serverForceRestart}" javaPlatform="${profiler.info.javaPlatform}" startupTimeout="${profiler.j2ee.serverStartupTimeout}">
            <jvmarg value="${profiler.info.jvmargs.extra}"/>
            <jvmarg value="${profiler.info.jvmargs.agent}"/>
            <jvmarg value="${profiler.j2ee.agentID}"/>
        </nbstartprofiledserver>
    </target>
    <target depends="profile-init,compile-test-single" if="profiler.info.jvmargs.agent" name="-profile-test-single-pre72">
        <fail unless="netbeans.home">This target only works when run from inside the NetBeans IDE.</fail>
        <nbprofiledirect>
            <classpath>
                <path path="${run.test.classpath}"/>
                <path path="${j2ee.platform.classpath}"/>
            </classpath>
        </nbprofiledirect>
        <junit dir="${profiler.info.dir}" errorproperty="tests.failed" failureproperty="tests.failed" fork="true" jvm="${profiler.info.jvm}" showoutput="true">
            <env key="${profiler.info.pathvar}" path="${profiler.info.agentpath}:${profiler.current.path}"/>
            <jvmarg value="${profiler.info.jvmargs.agent}"/>
            <jvmarg line="${profiler.info.jvmargs}"/>
            <test name="${profile.class}"/>
            <classpath>
                <path path="${run.test.classpath}"/>
                <path path="${j2ee.platform.classpath}"/>
            </classpath>
            <syspropertyset>
                <propertyref prefix="test-sys-prop."/>
                <mapper from="test-sys-prop.*" to="*" type="glob"/>
            </syspropertyset>
            <formatter type="brief" usefile="false"/>
            <formatter type="xml"/>
        </junit>
    </target>
    <target if="netbeans.home" name="-profile-check">
        <condition property="profiler.configured">
            <or>
                <contains casesensitive="true" string="${run.jvmargs.ide}" substring="-agentpath:"/>
                <contains casesensitive="true" string="${run.jvmargs.ide}" substring="-javaagent:"/>
            </or>
        </condition>
    </target>
    <target depends="init,-init-cos,compile,compile-jsps,-do-compile-single-jsp,-pre-dist,-do-tmp-dist-with-manifest,-do-tmp-dist-without-manifest" name="-do-profile">
        <startprofiler/>
        <nbstartserver profilemode="true"/>
        <nbdeploy clientUrlPart="${client.urlPart}" forceRedeploy="true" profilemode="true"/>
        <antcall target="debug-display-browser-old"/>
        <antcall target="debug-display-browser"/>
        <antcall target="-profile-start-loadgen"/>
    </target>
    <target depends="-profile-check,-profile-pre72" description="Profile a J2EE project in the IDE." if="profiler.configured" name="profile" unless="profiler.info.jvmargs.agent">
        <antcall target="-do-profile"/>
    </target>
    <target depends="-profile-test-single-pre72" name="profile-test-single"/>
    <target depends="-profile-check" if="profiler.configured" name="profile-test" unless="profiler.info.jvmargs.agent">
        <startprofiler/>
        <antcall target="test-single"/>
    </target>
    <target if="profiler.loadgen.path" name="-profile-start-loadgen">
        <loadgenstart path="${profiler.loadgen.path}"/>
    </target>
    <!--
                JAVADOC SECTION
            -->
    <target depends="init" if="have.sources" name="javadoc-build">
        <mkdir dir="${dist.javadoc.dir}"/>
        <javadoc additionalparam="${javadoc.additionalparam}" author="${javadoc.author}" charset="UTF-8" destdir="${dist.javadoc.dir}" docencoding="UTF-8" encoding="${javadoc.encoding.used}" failonerror="true" noindex="${javadoc.noindex}" nonavbar="${javadoc.nonavbar}" notree="${javadoc.notree}" private="${javadoc.private}" source="${javac.source}" splitindex="${javadoc.splitindex}" use="${javadoc.use}" useexternalfile="true" version="${javadoc.version}" windowtitle="${javadoc.windowtitle}">
            <classpath>
                <path path="${javac.classpath}:${j2ee.platform.classpath}"/>
            </classpath>
            <fileset dir="${src.dir}" excludes="${excludes}" includes="${includes}">
                <filename name="**/*.java"/>
            </fileset>
            <fileset dir="${build.generated.sources.dir}" erroronmissingdir="false">
                <include name="**/*.java"/>
            </fileset>
        </javadoc>
        <copy todir="${dist.javadoc.dir}">
            <fileset dir="${src.dir}" excludes="${excludes}" includes="${includes}">
                <filename name="**/doc-files/**"/>
            </fileset>
            <fileset dir="${build.generated.sources.dir}" erroronmissingdir="false">
                <include name="**/doc-files/**"/>
            </fileset>
        </copy>
    </target>
    <target depends="init,javadoc-build" if="netbeans.home" name="javadoc-browse" unless="no.javadoc.preview">
        <nbbrowse file="${dist.javadoc.dir}/index.html"/>
    </target>
    <target depends="init,javadoc-build,javadoc-browse" description="Build Javadoc." name="javadoc"/>
    <!--
                
                TEST COMPILATION SECTION
            -->
    <target depends="init,compile" if="have.tests" name="-pre-pre-compile-test">
        <mkdir dir="${build.test.classes.dir}"/>
        <property name="j2ee.platform.embeddableejb.classpath" value=""/>
    </target>
    <target name="-pre-compile-test">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,compile,-pre-pre-compile-test,-pre-compile-test" if="have.tests" name="-do-compile-test">
        <webproject2:javac classpath="${javac.test.classpath}:${j2ee.platform.classpath}:${j2ee.platform.embeddableejb.classpath}" debug="true" destdir="${build.test.classes.dir}" srcdir="${test.src.dir}"/>
        <copy todir="${build.test.classes.dir}">
            <fileset dir="${test.src.dir}" excludes="${build.classes.excludes},${excludes}" includes="${includes}"/>
        </copy>
    </target>
    <target name="-post-compile-test">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,compile,-pre-pre-compile-test,-pre-compile-test,-do-compile-test,-post-compile-test" name="compile-test"/>
    <target name="-pre-compile-test-single">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,compile,-pre-pre-compile-test,-pre-compile-test-single" if="have.tests" name="-do-compile-test-single">
        <fail unless="javac.includes">Must select some files in the IDE or set javac.includes</fail>
        <webproject2:javac classpath="${javac.test.classpath}:${j2ee.platform.classpath}:${j2ee.platform.embeddableejb.classpath}" debug="true" destdir="${build.test.classes.dir}" excludes="" includes="${javac.includes}" srcdir="${test.src.dir}"/>
        <copy todir="${build.test.classes.dir}">
            <fileset dir="${test.src.dir}" excludes="${build.classes.excludes},${excludes}" includes="${includes}"/>
        </copy>
    </target>
    <target name="-post-compile-test-single">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,compile,-pre-pre-compile-test,-pre-compile-test-single,-do-compile-test-single,-post-compile-test-single" name="compile-test-single"/>
    <!--
                
                TEST EXECUTION SECTION
            -->
    <target depends="init" if="have.tests" name="-pre-test-run">
        <mkdir dir="${build.test.results.dir}"/>
    </target>
    <target depends="init,compile-test,-pre-test-run" if="have.tests" name="-do-test-run">
        <webproject2:test includes="${includes}" testincludes="**/*Test.java"/>
    </target>
    <target depends="init,compile-test,-pre-test-run,-do-test-run" if="have.tests" name="-post-test-run">
        <fail if="tests.failed" unless="ignore.failing.tests">Some tests failed; see details above.</fail>
    </target>
    <target depends="init" if="have.tests" name="test-report"/>
    <target depends="init" if="netbeans.home+have.tests" name="-test-browse"/>
    <target depends="init,compile-test,-pre-test-run,-do-test-run,test-report,-post-test-run,-test-browse" description="Run unit tests." name="test"/>
    <target depends="init" if="have.tests" name="-pre-test-run-single">
        <mkdir dir="${build.test.results.dir}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single" if="have.tests" name="-do-test-run-single">
        <fail unless="test.includes">Must select some files in the IDE or set test.includes</fail>
        <webproject2:test excludes="" includes="${test.includes}" testincludes="${test.includes}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single,-do-test-run-single" if="have.tests" name="-post-test-run-single">
        <fail if="tests.failed" unless="ignore.failing.tests">Some tests failed; see details above.</fail>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single,-do-test-run-single,-post-test-run-single" description="Run single unit test." name="test-single"/>
    <target depends="init,compile-test-single,-pre-test-run-single" if="have.tests" name="-do-test-run-single-method">
        <fail unless="test.class">Must select some files in the IDE or set test.class</fail>
        <fail unless="test.method">Must select some method in the IDE or set test.method</fail>
        <webproject2:test excludes="" includes="${javac.includes}" testincludes="${test.class}" testmethods="${test.method}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single,-do-test-run-single-method" if="have.tests" name="-post-test-run-single-method">
        <fail if="tests.failed" unless="ignore.failing.tests">Some tests failed; see details above.</fail>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single,-do-test-run-single-method,-post-test-run-single-method" description="Run single unit test." name="test-single-method"/>
    <!--
                
                TEST DEBUGGING SECTION
            -->
    <target depends="init,compile-test-single,-pre-test-run-single" if="have.tests" name="-debug-start-debuggee-test">
        <fail unless="test.class">Must select one file in the IDE or set test.class</fail>
        <webproject2:test-debug excludes="" includes="${javac.includes}" testClass="${test.class}" testincludes="${javac.includes}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single" if="have.tests" name="-debug-start-debuggee-test-method">
        <fail unless="test.class">Must select one file in the IDE or set test.class</fail>
        <fail unless="test.method">Must select some method in the IDE or set test.method</fail>
        <webproject2:test-debug excludes="" includes="${javac.includes}" testClass="${test.class}" testMethod="${test.method}" testincludes="${test.class}" testmethods="${test.method}"/>
    </target>
    <target depends="init,compile-test" if="netbeans.home+have.tests" name="-debug-start-debugger-test">
        <webproject1:nbjpdastart classpath="${debug.test.classpath}" name="${test.class}"/>
    </target>
    <target depends="init,compile-test,-debug-start-debugger-test,-debug-start-debuggee-test" name="debug-test"/>
    <target depends="init,compile-test-single,-debug-start-debugger-test,-debug-start-debuggee-test-method" name="debug-test-method"/>
    <target depends="debug-test-method" name="debug-single-method"/>
    <target depends="init,-pre-debug-fix,compile-test-single" if="netbeans.home" name="-do-debug-fix-test">
        <webproject1:nbjpdareload dir="${build.test.classes.dir}"/>
    </target>
    <target depends="init,-pre-debug-fix,-do-debug-fix-test" if="netbeans.home" name="debug-fix-test"/>
    <!--
                
                CLEANUP SECTION
            -->
    <target depends="init" name="deps-clean" unless="no.deps"/>
    <target depends="init" name="do-clean">
        <condition property="build.dir.to.clean" value="${build.web.dir}">
            <isset property="dist.ear.dir"/>
        </condition>
        <property name="build.dir.to.clean" value="${build.web.dir}"/>
        <delete includeEmptyDirs="true" quiet="true">
            <fileset dir="${build.dir.to.clean}/WEB-INF/lib"/>
        </delete>
        <delete dir="${build.dir}"/>
        <available file="${build.dir.to.clean}/WEB-INF/lib" property="status.clean-failed" type="dir"/>
        <delete dir="${dist.dir}"/>
    </target>
    <target depends="do-clean" if="status.clean-failed" name="check-clean">
        <echo message="Warning: unable to delete some files in ${build.web.dir}/WEB-INF/lib - they are probably locked by the J2EE server. "/>
        <echo level="info" message="To delete all files undeploy the module from Server Registry in Runtime tab and then use Clean again."/>
    </target>
    <target depends="init" if="netbeans.home" name="undeploy-clean">
        <nbundeploy failOnError="false" startServer="false"/>
    </target>
    <target name="-post-clean">
        <!-- Empty placeholder for easier customization. -->
        <!-- You can override this target in the ../build.xml file. -->
    </target>
    <target depends="init,undeploy-clean,deps-clean,do-clean,check-clean,-post-clean" description="Clean build products." name="clean"/>
    <target depends="clean" description="Clean build products." name="clean-ear"/>
</project>