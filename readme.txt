Steps:   Refer "HadoopSetupinWindows7.docx" before doing the following steps make sure all your Java, Hadoop, Maven paths are set in Windows 7 Environment.

Pre-requisites 

1.	Java 8
2.	Eclipse JEE Mars 2
3.	Maven 3.3.9
4.	Hadoop 2.3

Too install the tools.jar to Maven local repository issue below command

Assume my Java installation path=C:/Progra~1/Java/jdk1.8.0_92/lib/tools.jar

D:\github\MapReduce\>mvn install:install-file -DgroupId=jdk.tools -DartifactId=jdk.tools -Dpackaging=jar -Dversion=1.8 -Dfile=${java.home}/../lib/tools.jar -DgeneratePom=true



Step 1: To check the classpath settings for Hadoop

D:\github\MapReduce>hadoop classpath
C:\hadoop-2.3.0\etc\hadoop;C:\hadoop-2.3.0\share\hadoop\common\lib\*;C:\hadoop-2.3.0\share\hadoop\common\*;C:\hadoop-2.3.0\share\hadoop\hdfs;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\*;C:\hadoop-2.3.0\share\hadoop\hdfs\*;C:\hadoop-2.3.0\share\hadoop\yarn\lib\*;C:\hadoop-2.3.0\share\hadoop\yarn\*;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\*;C:\hadoop-2.3.0\share\hadoop\mapreduce\*


Step 2.1: To bring up the Hadoop Namenode, NodeManager, ResourceManager, DataNode.

C:\hadoop-2.3.0\sbin>dir
11/02/2014  09:55 PM             2,752 distribute-exclude.sh
11/02/2014  09:55 PM             5,814 hadoop-daemon.sh
11/02/2014  09:55 PM             1,360 hadoop-daemons.sh
11/02/2014  09:55 PM             1,597 hdfs-config.cmd
11/02/2014  09:55 PM             1,427 hdfs-config.sh
11/02/2014  09:55 PM             2,291 httpfs.sh
11/02/2014  09:55 PM             4,063 mr-jobhistory-daemon.sh
11/02/2014  09:55 PM             1,648 refresh-namenodes.sh
11/02/2014  09:55 PM             2,145 slaves.sh
11/02/2014  09:55 PM             1,727 start-all.cmd
11/02/2014  09:55 PM             1,471 start-all.sh
11/02/2014  09:55 PM             1,128 start-balancer.sh
11/02/2014  09:55 PM             1,360 start-dfs.cmd
11/02/2014  09:55 PM             3,705 start-dfs.sh
11/02/2014  09:55 PM             1,357 start-secure-dns.sh
11/02/2014  09:55 PM             1,524 start-yarn.cmd
11/02/2014  09:55 PM             1,347 start-yarn.sh
11/02/2014  09:55 PM             1,718 stop-all.cmd
11/02/2014  09:55 PM             1,462 stop-all.sh
11/02/2014  09:55 PM             1,179 stop-balancer.sh
11/02/2014  09:55 PM             1,414 stop-dfs.cmd
11/02/2014  09:55 PM             3,206 stop-dfs.sh
11/02/2014  09:55 PM             1,340 stop-secure-dns.sh
11/02/2014  09:55 PM             1,595 stop-yarn.cmd
11/02/2014  09:55 PM             1,340 stop-yarn.sh
11/02/2014  09:55 PM             4,278 yarn-daemon.sh
11/02/2014  09:55 PM             1,353 yarn-daemons.sh
              27 File(s)         55,601 bytes

C:\hadoop-2.3.0\sbin>jps
6784
9512 Jps

c:\hadoop-2.3.0\sbin>start-all.cmd
This script is Deprecated. Instead use start-dfs.cmd and start-yarn.cmd
starting yarn daemons

or 

c:\hadoop-2.3.0\sbin>start-dfs.cmd   -> will bring up NameNode, DataNode

c:\hadoop-2.3.0\sbin>jps
6432 NameNode
6984 Jps
7640
8972 DataNode

c:\hadoop-2.3.0\sbin>start-yarn.cmd    -> will bring up ResourceManager, NodeManager
starting yarn daemons


Step 2.2: Verify with jps command for 4 Hadoop services should be up and running. (no output means check your jps is pointing to JAVA_HOME or not)

C:\hadoop-2.3.0\sbin>jps
6784
7568 ResourceManager
9584 Jps
6968 NodeManager
1196 NameNode
9980 DataNode

C:\hadoop-2.3.0\sbin>

C:\hadoop-2.3.0\sbin>hadoop namenode -format
DEPRECATED: Use of this script to execute hdfs command is deprecated.
Instead use the hdfs command for it.
16/06/17 01:32:51 INFO namenode.NameNode: STARTUP_MSG:
/************************************************************
STARTUP_MSG: Starting NameNode
STARTUP_MSG:   host = NCS-210715RT13/192.168.1.7
STARTUP_MSG:   args = [-format]
STARTUP_MSG:   version = 2.3.0
STARTUP_MSG:   classpath = C:\hadoop-2.3.0\etc\hadoop;C:\hadoop-2.3.0\share\hadoop\common\lib\activation-1.1.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\asm-3.2.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\avro-1.7.4.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-beanutils-1.7.0.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-beanutils-core-1.8.0.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-cli-1.2.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-codec-1.4.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-collections-3.2.1.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-compress-1.4.1.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-configuration-1.6.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-digester-1.8.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-el-1.0.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-httpclient-3.1.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-io-2.4.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-lang-2.6.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-logging-1.1.3.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-math3-3.1.1.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\commons-net-3.1.jar;C:\hadoop
-2.3.0\share\hadoop\common\lib\gson-2.2.4-sources.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\gson-2.2.4.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\guava-11.0.2.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\hadoop-annotations-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\hadoop-auth-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\httpclient-4.2.5.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\httpcore-4.2.5.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jackson-core-asl-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jackson-jaxrs-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jackson-mapper-asl-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jackson-xc-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jasper-compiler-5.5.23.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jasper-runtime-5.5.23.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\java-xmlbuilder-0.4.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jaxb-api-2.2.2.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jaxb-impl-2.2.3-1.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jersey-core-1.9.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jersey-json-1.9.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jersey-server-1.9.jar;C:\hadoop-2.3.0\share\
hadoop\common\lib\jets3t-0.9.0.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jettison-1.1.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jetty-6.1.26.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jetty-util-6.1.26.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jsch-0.1.42.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jsp-api-2.1.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\jsr305-1.3.9.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\junit-4.8.2.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\log4j-1.2.17.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\mockito-all-1.8.5.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\netty-3.6.2.Final.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\paranamer-2.3.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\protobuf-java-2.5.0.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\servlet-api-2.5.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\slf4j-api-1.7.5.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\slf4j-log4j12-1.7.5.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\snappy-java-1.0.4.1.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\stax-api-1.0-2.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\xmlenc-0.52.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\xz-1.0.jar;C:\hadoop-2.3.0\share\hadoop\common\lib\zookeep
er-3.4.5.jar;C:\hadoop-2.3.0\share\hadoop\common\hadoop-common-2.3.0-tests.jar;C:\hadoop-2.3.0\share\hadoop\common\hadoop-common-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\common\hadoop-nfs-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\hdfs;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\asm-3.2.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\commons-cli-1.2.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\commons-codec-1.4.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\commons-daemon-1.0.13.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\commons-el-1.0.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\commons-io-2.4.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\commons-lang-2.6.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\commons-logging-1.1.3.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\guava-11.0.2.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\jackson-core-asl-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\jackson-mapper-asl-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\jasper-runtime-5.5.23.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\jersey-core-1.9.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\jersey-server-1.9.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\jetty-6.1.26.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\jetty-util-6.1.26.jar;C:\hadoop-2.3.0\s
hare\hadoop\hdfs\lib\jsp-api-2.1.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\jsr305-1.3.9.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\log4j-1.2.17.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\netty-3.6.2.Final.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\protobuf-java-2.5.0.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\servlet-api-2.5.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\lib\xmlenc-0.52.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\hadoop-hdfs-2.3.0-tests.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\hadoop-hdfs-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\hdfs\hadoop-hdfs-nfs-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\activation-1.1.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\aopalliance-1.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\asm-3.2.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\commons-cli-1.2.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\commons-codec-1.4.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\commons-compress-1.4.1.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\commons-httpclient-3.1.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\commons-io-2.4.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\commons-lang-2.6.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\commons-logging-1.1.3.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\guava-11.0
.2.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\guice-3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\guice-servlet-3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jackson-core-asl-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jackson-jaxrs-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jackson-mapper-asl-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jackson-xc-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\javax.inject-1.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jaxb-api-2.2.2.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jaxb-impl-2.2.3-1.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jersey-client-1.9.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jersey-core-1.9.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jersey-guice-1.9.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jersey-json-1.9.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jersey-server-1.9.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jettison-1.1.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jetty-6.1.26.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jetty-util-6.1.26.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jline-0.9.94.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\jsr305-1.3.9.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\log4j-1.2.17.jar;C:\hadoop-2.3.0\share\ha
doop\yarn\lib\protobuf-java-2.5.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\servlet-api-2.5.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\stax-api-1.0-2.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\xz-1.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\lib\zookeeper-3.4.5.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-api-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-applications-distributedshell-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-applications-unmanaged-am-launcher-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-client-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-common-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-server-common-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-server-nodemanager-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-server-resourcemanager-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-server-tests-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\yarn\hadoop-yarn-server-web-proxy-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\aopalliance-1.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\asm-3.2.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\avro-1.7.4.jar;C:\hadoop-2.3.0\share\hadoop\mapred
uce\lib\commons-compress-1.4.1.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\commons-io-2.4.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\guice-3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\guice-servlet-3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\hadoop-annotations-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\hamcrest-core-1.1.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\jackson-core-asl-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\jackson-mapper-asl-1.8.8.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\javax.inject-1.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\jersey-core-1.9.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\jersey-guice-1.9.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\jersey-server-1.9.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\junit-4.10.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\log4j-1.2.17.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\netty-3.6.2.Final.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\paranamer-2.3.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\protobuf-java-2.5.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\snappy-java-1.0.4.1.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\lib\xz-1.0.jar;C:\hadoop-2.3.0\
share\hadoop\mapreduce\hadoop-mapreduce-client-app-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\hadoop-mapreduce-client-common-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\hadoop-mapreduce-client-core-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\hadoop-mapreduce-client-hs-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\hadoop-mapreduce-client-hs-plugins-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\hadoop-mapreduce-client-jobclient-2.3.0-tests.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\hadoop-mapreduce-client-jobclient-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\hadoop-mapreduce-client-shuffle-2.3.0.jar;C:\hadoop-2.3.0\share\hadoop\mapreduce\hadoop-mapreduce-examples-2.3.0.jar
STARTUP_MSG:   build = http://svn.apache.org/repos/asf/hadoop/common -r 1567123; compiled by 'jenkins' on 2014-02-11T13:40Z
STARTUP_MSG:   java = 1.8.0_92
************************************************************/
Formatting using clusterid: CID-9b2fefe9-bcd5-4c55-95a1-f8b7e225cfe7
16/06/17 01:32:52 INFO namenode.FSNamesystem: fsLock is fair:true
16/06/17 01:32:52 INFO namenode.HostFileManager: read includes:
HostSet(
)
16/06/17 01:32:52 INFO namenode.HostFileManager: read excludes:
HostSet(
)
16/06/17 01:32:52 INFO blockmanagement.DatanodeManager: dfs.block.invalidate.limit=1000
16/06/17 01:32:52 INFO blockmanagement.DatanodeManager: dfs.namenode.datanode.registration.ip-hostname-check=true
16/06/17 01:32:52 INFO util.GSet: Computing capacity for map BlocksMap
16/06/17 01:32:52 INFO util.GSet: VM type       = 64-bit
16/06/17 01:32:52 INFO util.GSet: 2.0% max memory 889 MB = 17.8 MB
16/06/17 01:32:52 INFO util.GSet: capacity      = 2^21 = 2097152 entries
16/06/17 01:32:52 INFO blockmanagement.BlockManager: dfs.block.access.token.enable=false
16/06/17 01:32:52 INFO blockmanagement.BlockManager: defaultReplication         = 1
16/06/17 01:32:52 INFO blockmanagement.BlockManager: maxReplication             = 512
16/06/17 01:32:52 INFO blockmanagement.BlockManager: minReplication             = 1
16/06/17 01:32:52 INFO blockmanagement.BlockManager: maxReplicationStreams      = 2
16/06/17 01:32:52 INFO blockmanagement.BlockManager: shouldCheckForEnoughRacks  = false
16/06/17 01:32:52 INFO blockmanagement.BlockManager: replicationRecheckInterval = 3000
16/06/17 01:32:52 INFO blockmanagement.BlockManager: encryptDataTransfer        = false
16/06/17 01:32:52 INFO blockmanagement.BlockManager: maxNumBlocksToLog          = 1000
16/06/17 01:32:52 INFO namenode.FSNamesystem: fsOwner             = ganjimr (auth:SIMPLE)
16/06/17 01:32:52 INFO namenode.FSNamesystem: supergroup          = supergroup
16/06/17 01:32:52 INFO namenode.FSNamesystem: isPermissionEnabled = false
16/06/17 01:32:52 INFO namenode.FSNamesystem: HA Enabled: false
16/06/17 01:32:52 INFO namenode.FSNamesystem: Append Enabled: true
16/06/17 01:32:52 INFO util.GSet: Computing capacity for map INodeMap
16/06/17 01:32:52 INFO util.GSet: VM type       = 64-bit
16/06/17 01:32:52 INFO util.GSet: 1.0% max memory 889 MB = 8.9 MB
16/06/17 01:32:52 INFO util.GSet: capacity      = 2^20 = 1048576 entries
16/06/17 01:32:52 INFO namenode.NameNode: Caching file names occuring more than 10 times
16/06/17 01:32:52 INFO util.GSet: Computing capacity for map cachedBlocks
16/06/17 01:32:52 INFO util.GSet: VM type       = 64-bit
16/06/17 01:32:52 INFO util.GSet: 0.25% max memory 889 MB = 2.2 MB
16/06/17 01:32:52 INFO util.GSet: capacity      = 2^18 = 262144 entries
16/06/17 01:32:52 INFO namenode.FSNamesystem: dfs.namenode.safemode.threshold-pct = 0.9990000128746033
16/06/17 01:32:52 INFO namenode.FSNamesystem: dfs.namenode.safemode.min.datanodes = 0
16/06/17 01:32:52 INFO namenode.FSNamesystem: dfs.namenode.safemode.extension     = 30000
16/06/17 01:32:53 INFO namenode.FSNamesystem: Retry cache on namenode is enabled
16/06/17 01:32:53 INFO namenode.FSNamesystem: Retry cache will use 0.03 of total heap and retry cache entry expiry time is 600000 millis
16/06/17 01:32:53 INFO util.GSet: Computing capacity for map Namenode Retry Cache
16/06/17 01:32:53 INFO util.GSet: VM type       = 64-bit
16/06/17 01:32:53 INFO util.GSet: 0.029999999329447746% max memory 889 MB = 273.1 KB
16/06/17 01:32:53 INFO util.GSet: capacity      = 2^15 = 32768 entries
16/06/17 01:32:53 INFO common.Storage: Storage directory \hadoop\data\dfs\namenode has been successfully formatted.
16/06/17 01:32:53 INFO namenode.FSImage: Saving image file \hadoop\data\dfs\namenode\current\fsimage.ckpt_0000000000000000000 using no compression
16/06/17 01:32:53 INFO namenode.FSImage: Image file \hadoop\data\dfs\namenode\current\fsimage.ckpt_0000000000000000000 of size 219 bytes saved in 0 seconds.
16/06/17 01:32:53 INFO namenode.NNStorageRetentionManager: Going to retain 1 images with txid >= 0
16/06/17 01:32:53 INFO util.ExitUtil: Exiting with status 0
16/06/17 01:32:53 INFO namenode.NameNode: SHUTDOWN_MSG:
/************************************************************
SHUTDOWN_MSG: Shutting down NameNode at NCS-210715RT13/192.168.1.7
************************************************************/



c:\hadoop-2.3.0\sbin>

-- To bring down Hadoop services issue below command.
c:\hadoop-2.3.0\sbin>stop-all.cmd
This script is Deprecated. Instead use stop-dfs.cmd and stop-yarn.cmd
SUCCESS: Sent termination signal to the process with PID 7060.
SUCCESS: Sent termination signal to the process with PID 8000.
stopping yarn daemons
SUCCESS: Sent termination signal to the process with PID 9736.
SUCCESS: Sent termination signal to the process with PID 10456.

INFO: No tasks running with the specified criteria.

c:\hadoop-2.3.0\sbin>

Step 3: Copy file(s) from local directory to hdfs (for ex here we are copying infile.txt to hdfs /in/wc directory)

D:\github\MapReduce\src\main\resources>dir
16/06/2016  01:09 PM                95 infile.txt
16/06/2016  01:08 PM               788 infile1.txt
15/06/2016  05:33 PM             2,486 logback.xml
14/06/2016  06:01 PM               162 wc.txt

--To make directories in /in/wc 
D:\github\MapReduce\src\main\resources>hdfs dfs -mkdir -p /in/wc

-- If file already exists in hdfs means delete it 
D:\github\MapReduce\src\main\resources>hdfs dfs -rm /in/wc/infile.txt
16/06/16 13:12:33 INFO fs.TrashPolicyDefault: Namenode trash configuration: Deletion interval = 0 minutes, Emptier interval = 0 minutes.
Deleted /in/wc/infile.txt

-- To copy the file(for ex: D:\github\MapReduce\src\main\resources\infile.txt) to hdfs
D:\github\MapReduce\src\main\resources>hdfs dfs -put infile.txt /in/wc/

-- To list the file
D:\github\MapReduce\src\main\resources>hdfs dfs -ls /in/wc/infile.txt
Found 1 items
-rw-r--r--   1 ganjimr supergroup         95 2016-06-16 13:12 /in/wc/infile.txt

-- To see the contents of the file
D:\github\MapReduce\src\main\resources>hdfs dfs -cat /in/wc/infile.txt
Hadoop is Great
Hadoop is Future
Again Hadoop is Great
Hadoop Hadoop Hadoop
Hadoop is Great
D:\github\MapReduce\src\main\resources>cd ../../..


-- To install tools.jar in local maven repository (one time activity)

C:\>mvn install:install-file -DgroupId=jdk.tools -DartifactId=jdk.tools -Dpackaging=jar -Dversion=1.8 -Dfile=${java.home}/../lib/tools.jar -DgeneratePom=true
C:\
[INFO] Scanning for projects...
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.pom (4 KB at 1.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/22/maven-plugins-22.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/22/maven-plugins-22.pom (13 KB at 28.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/21/maven-parent-21.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/21/maven-parent-21.pom (26 KB at 58.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-clean-plugin/2.5/maven-clean-plugin-2.5.jar (25 KB at 53.7 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/2.4/maven-install-plugin-2.4.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/2.4/maven-install-plugin-2.4.pom (7 KB at 14.5 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/23/maven-plugins-23.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/23/maven-plugins-23.pom (9 KB at 20.8 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/22/maven-parent-22.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/22/maven-parent-22.pom (30 KB at 65.7 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/apache/11/apache-11.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/apache/11/apache-11.pom (15 KB at 11.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/2.4/maven-install-plugin-2.4.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/2.4/maven-install-plugin-2.4.jar (27 KB at 58.2 KB/sec)
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-install-plugin:2.4:install-file (default-cli) @ standalone-pom ---
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-api/2.0.6/maven-plugin-api-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-api/2.0.6/maven-plugin-api-2.0.6.pom (2 KB at 3.3 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven/2.0.6/maven-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven/2.0.6/maven-2.0.6.pom (9 KB at 20.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/5/maven-parent-5.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/5/maven-parent-5.pom (15 KB at 34.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/apache/3/apache-3.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/apache/3/apache-3.pom (4 KB at 7.8 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-project/2.0.6/maven-project-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-project/2.0.6/maven-project-2.0.6.pom (3 KB at 5.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-settings/2.0.6/maven-settings-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-settings/2.0.6/maven-settings-2.0.6.pom (2 KB at 4.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-model/2.0.6/maven-model-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-model/2.0.6/maven-model-2.0.6.pom (3 KB at 6.8 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/1.4.1/plexus-utils-1.4.1.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/1.4.1/plexus-utils-1.4.1.pom (2 KB at 4.3 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/1.0.11/plexus-1.0.11.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/1.0.11/plexus-1.0.11.pom (9 KB at 20.5 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-9-stable-1/plexus-container-default-1.0-alpha-9-stable-1.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-9-stable-1/plexus-container-default-1.0-alpha-9-stable-1.pom (4 KB at 9.0 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-containers/1.0.3/plexus-containers-1.0.3.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-containers/1.0.3/plexus-containers-1.0.3.pom (492 B at 1.1 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/1.0.4/plexus-1.0.4.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/1.0.4/plexus-1.0.4.pom (6 KB at 13.1 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/1.0.4/plexus-utils-1.0.4.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/1.0.4/plexus-utils-1.0.4.pom (7 KB at 15.5 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/classworlds/classworlds/1.1-alpha-2/classworlds-1.1-alpha-2.pom
Downloaded: https://repo.maven.apache.org/maven2/classworlds/classworlds/1.1-alpha-2/classworlds-1.1-alpha-2.pom (4 KB at 7.0 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-profile/2.0.6/maven-profile-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-profile/2.0.6/maven-profile-2.0.6.pom (2 KB at 4.5 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact-manager/2.0.6/maven-artifact-manager-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact-manager/2.0.6/maven-artifact-manager-2.0.6.pom (3 KB at 6.0 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-repository-metadata/2.0.6/maven-repository-metadata-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-repository-metadata/2.0.6/maven-repository-metadata-2.0.6.pom (2 KB at 4.2 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact/2.0.6/maven-artifact-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact/2.0.6/maven-artifact-2.0.6.pom (2 KB at 3.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-registry/2.0.6/maven-plugin-registry-2.0.6.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-registry/2.0.6/maven-plugin-registry-2.0.6.pom (2 KB at 4.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.5/plexus-utils-3.0.5.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.5/plexus-utils-3.0.5.pom (3 KB at 3.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/3.1/plexus-3.1.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/3.1/plexus-3.1.pom (19 KB at 34.8 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/sonatype/spice/spice-parent/17/spice-parent-17.pom
Downloaded: https://repo.maven.apache.org/maven2/org/sonatype/spice/spice-parent/17/spice-parent-17.pom (7 KB at 15.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/sonatype/forge/forge-parent/10/forge-parent-10.pom
Downloaded: https://repo.maven.apache.org/maven2/org/sonatype/forge/forge-parent/10/forge-parent-10.pom (14 KB at 30.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-digest/1.0/plexus-digest-1.0.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-digest/1.0/plexus-digest-1.0.pom (2 KB at 2.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-components/1.1.7/plexus-components-1.1.7.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-components/1.1.7/plexus-components-1.1.7.pom (5 KB at 11.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/1.0.8/plexus-1.0.8.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/1.0.8/plexus-1.0.8.pom (8 KB at 16.3 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-8/plexus-container-default-1.0-alpha-8.pom
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-8/plexus-container-default-1.0-alpha-8.pom (8 KB at 16.5 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-api/2.0.6/maven-plugin-api-2.0.6.jar
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-project/2.0.6/maven-project-2.0.6.jar
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-settings/2.0.6/maven-settings-2.0.6.jar
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-profile/2.0.6/maven-profile-2.0.6.jar
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-registry/2.0.6/maven-plugin-registry-2.0.6.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-api/2.0.6/maven-plugin-api-2.0.6.jar (13 KB at 27.0 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-9-stable-1/plexus-container-default-1.0-alpha-9-stable-1.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-profile/2.0.6/maven-profile-2.0.6.jar (35 KB at 29.7 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/junit/junit/3.8.1/junit-3.8.1.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-registry/2.0.6/maven-plugin-registry-2.0.6.jar (29 KB at 23.1 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/classworlds/classworlds/1.1-alpha-2/classworlds-1.1-alpha-2.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-project/2.0.6/maven-project-2.0.6.jar (114 KB at 84.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-model/2.0.6/maven-model-2.0.6.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-settings/2.0.6/maven-settings-2.0.6.jar (48 KB at 30.5 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact-manager/2.0.6/maven-artifact-manager-2.0.6.jar
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-9-stable-1/plexus-container-default-1.0-alpha-9-stable-1.jar (190 KB at 120.7 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-repository-metadata/2.0.6/maven-repository-metadata-2.0.6.jar
Downloaded: https://repo.maven.apache.org/maven2/junit/junit/3.8.1/junit-3.8.1.jar (119 KB at 60.7 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact/2.0.6/maven-artifact-2.0.6.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-repository-metadata/2.0.6/maven-repository-metadata-2.0.6.jar (24 KB at 11.5 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.5/plexus-utils-3.0.5.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact-manager/2.0.6/maven-artifact-manager-2.0.6.jar (56 KB at 26.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-digest/1.0/plexus-digest-1.0.jar
Downloaded: https://repo.maven.apache.org/maven2/classworlds/classworlds/1.1-alpha-2/classworlds-1.1-alpha-2.jar (37 KB at 17.5 KB/sec)
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-model/2.0.6/maven-model-2.0.6.jar (85 KB at 39.5 KB/sec)
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-digest/1.0/plexus-digest-1.0.jar (12 KB at 4.6 KB/sec)
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact/2.0.6/maven-artifact-2.0.6.jar (86 KB at 33.4 KB/sec)
Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.5/plexus-utils-3.0.5.jar (226 KB at 74.4 KB/sec)
[INFO] Installing C:\Progra~1\Java\jdk1.8.0_92\jre\..\lib\tools.jar to C:\Users\ganjimr\.m2\repository\jdk\tools\jdk.tools\1.8\jdk.tools-1.8.jar
[INFO] Installing C:\Users\ganjimr\AppData\Local\Temp\mvninstall660453036421579455.pom to C:\Users\ganjimr\.m2\repository\jdk\tools\jdk.tools\1.8\jdk.tools-1.8.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 25.938 s
[INFO] Finished at: 2016-06-17T00:38:42+08:00
[INFO] Final Memory: 10M/491M
[INFO] ------------------------------------------------------------------------

C:\>



Step 4:   Compile the Hadoop Maven project
Step 4.1: To convert the Java project to eclipse accessible and compile issue below command.

D:\github\MapReduce>mvn eclipse:clean eclipse:eclipse clean install
D:\github\MapReduce>mvn clean install
D:\github\MapReduce>mvn dependency:tree

It will download the necessary hadoop and hadoop dependency jars to C:\Users\<usernameXXX>\.m2 directory


D:\github\MapReduce>mvn eclipse:clean eclipse:eclipse install
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building MapReduce 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-eclipse-plugin:2.10:clean (default-cli) @ MapReduce ---
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/2.1/wagon-provider-api-2.1.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/2.1/wagon-provider-api-2.1.pom (2 KB at 0.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon/2.1/wagon-2.1.pom
...
[INFO]
[INFO] --- maven-compiler-plugin:3.5.1:testCompile (default-testCompile) @ MapReduce ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ MapReduce ---
[INFO] Surefire report directory: D:\github\MapReduce\target\surefire-reports

-------------------------------------------------------
T E S T S
-------------------------------------------------------
Running in.edureka.mapreduce.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.153 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ MapReduce ---
[INFO] Building jar: D:\github\MapReduce\target\MapReduce-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ MapReduce ---
[INFO] Installing D:\github\MapReduce\target\MapReduce-0.0.1-SNAPSHOT.jar to C:\Users\ganjimr\.m2\repository\in\edureka\mapreduce\MapReduce\0.0.1-SNAPSHOT\MapReduce-0.0.1-SNAPSHOT.jar
[INFO] Installing D:\github\MapReduce\pom.xml to C:\Users\ganjimr\.m2\repository\in\edureka\mapreduce\MapReduce\0.0.1-SNAPSHOT\MapReduce-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 04:05 min
[INFO] Finished at: 2016-06-16T13:18:36+08:00
[INFO] Final Memory: 24M/541M
[INFO] ------------------------------------------------------------------------

D:\github\MapReduce\target>dir
17/06/2016  01:31 AM    <DIR>          classes
17/06/2016  01:31 AM    <DIR>          generated-sources
17/06/2016  01:31 AM    <DIR>          generated-test-sources
17/06/2016  01:31 AM            23,994 MapReduce-0.0.1-SNAPSHOT.jar
17/06/2016  01:31 AM    <DIR>          maven-archiver
17/06/2016  01:31 AM    <DIR>          maven-status
17/06/2016  01:31 AM    <DIR>          surefire-reports
17/06/2016  01:31 AM    <DIR>          test-classes

D:\github\MapReduce\target>hadoop jar MapReduce-0.0.1-SNAPSHOT.jar in.edureka.mapreduce.WordCount /in/wc /out/wc
16/06/17 01:36:05 INFO mapreduce.WordCount: {} WordCount
16/06/17 01:36:06 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
16/06/17 01:36:07 WARN mapreduce.JobSubmitter: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
16/06/17 01:36:07 INFO input.FileInputFormat: Total input paths to process : 1
16/06/17 01:36:08 INFO mapreduce.JobSubmitter: number of splits:1
16/06/17 01:36:08 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1466098389434_0001
16/06/17 01:36:08 INFO impl.YarnClientImpl: Submitted application application_1466098389434_0001
16/06/17 01:36:09 INFO mapreduce.Job: The url to track the job: http://NCS-210715RT13:8088/proxy/application_1466098389434_0001/
16/06/17 01:36:09 INFO mapreduce.Job: Running job: job_1466098389434_0001
16/06/17 01:36:20 INFO mapreduce.Job: Job job_1466098389434_0001 running in uber mode : false
16/06/17 01:36:20 INFO mapreduce.Job:  map 0% reduce 0%
16/06/17 01:36:28 INFO mapreduce.Job:  map 100% reduce 0%
16/06/17 01:36:36 INFO mapreduce.Job:  map 100% reduce 100%
16/06/17 01:36:38 INFO mapreduce.Job: Job job_1466098389434_0001 completed successfully
16/06/17 01:36:38 INFO mapreduce.Job: Counters: 49
        File System Counters
                FILE: Number of bytes read=194
                FILE: Number of bytes written=173699
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=198
                HDFS: Number of bytes written=39
                HDFS: Number of read operations=6
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=4915
                Total time spent by all reduces in occupied slots (ms)=5995
                Total time spent by all map tasks (ms)=4915
                Total time spent by all reduce tasks (ms)=5995
                Total vcore-seconds taken by all map tasks=4915
                Total vcore-seconds taken by all reduce tasks=5995
                Total megabyte-seconds taken by all map tasks=5032960
                Total megabyte-seconds taken by all reduce tasks=6138880
        Map-Reduce Framework
                Map input records=5
                Map output records=16
                Map output bytes=156
                Map output materialized bytes=194
                Input split bytes=103
                Combine input records=0
                Combine output records=0
                Reduce input groups=5
                Reduce shuffle bytes=194
                Reduce input records=16
                Reduce output records=5
                Spilled Records=32
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=127
                CPU time spent (ms)=1356
                Physical memory (bytes) snapshot=403562496
                Virtual memory (bytes) snapshot=550739968
                Total committed heap usage (bytes)=324009984
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters
                Bytes Read=95
        File Output Format Counters
                Bytes Written=39

D:\github\MapReduce\target>


--Some Useful hdfs commands

1. List All Files & Subdirectory Contents from the Command Line or multiple directories
hdfs dfs -ls -R /
hdfs dfs -ls -R /in /out

D:\github\MapReduce\target>hdfs dfs -ls -R /in /out
drwxr-xr-x   - ganjimr supergroup          0 2016-06-17 01:34 /in/wc
-rw-r--r--   1 ganjimr supergroup         95 2016-06-17 01:34 /in/wc/infile.txt
drwxr-xr-x   - ganjimr supergroup          0 2016-06-17 01:36 /out/wc
-rw-r--r--   1 ganjimr supergroup          0 2016-06-17 01:36 /out/wc/_SUCCESS
-rw-r--r--   1 ganjimr supergroup         39 2016-06-17 01:36 /out/wc/part-r-00000

D:\github\MapReduce\target>hdfs dfs -cat /out/wc/part-r-00000
Again   1
Future  1
Great   3
Hadoop  7
is      4

D:\github\MapReduce\target>

C:\hadoop-2.3.0\sbin>hdfs dfs -ls -R /in /out
-rw-r--r--   1 ganjimr supergroup  141698284 2016-06-10 17:57 /in/recipeitems-latest.json
drwxr-xr-x   - ganjimr supergroup          0 2016-06-16 13:12 /in/wc
-rw-r--r--   1 ganjimr supergroup         95 2016-06-16 13:12 /in/wc/infile.txt
-rw-r--r--   1 ganjimr supergroup        162 2016-06-14 18:03 /in/wc/wc.txt
-rw-r--r--   1 ganjimr supergroup          0 2016-06-10 17:58 /out/_SUCCESS
-rw-r--r--   1 ganjimr supergroup       3082 2016-06-10 17:58 /out/part-r-00000
drwxr-xr-x   - ganjimr supergroup          0 2016-06-16 13:25 /out/wc
-rw-r--r--   1 ganjimr supergroup          0 2016-06-16 13:25 /out/wc/_SUCCESS
-rw-r--r--   1 ganjimr supergroup        141 2016-06-16 13:25 /out/wc/part-r-00000
drwxr-xr-x   - ganjimr supergroup          0 2016-06-13 17:51 /out/wccsv
-rw-r--r--   1 ganjimr supergroup          0 2016-06-13 17:51 /out/wccsv/_SUCCESS
-rw-r--r--   1 ganjimr supergroup  117671422 2016-06-13 17:51 /out/wccsv/part-r-00000

C:\hadoop-2.3.0\sbin>


Step 8 – namenode GUI, resourcemanager GUI

--2) To check the input /output folders in browser mode
http://localhost:50070/explorer.html

Namenode GUI address – http://localhost:50070
Resourcemanager GUI address - http://localhost:8088


Wow you did your first Hadoop Program. Congrats


Reference(s):

1.	https://github.com/steveloughran/winutils  -> Download to your local machine’s D:\github\ and compare with C:\hadoop-2.3.0 (download https://archive.apache.org/dist/hadoop/core/hadoop-2.3.0/hadoop-2.3.0.tar.gz and unzip in C:\) and copy all the necessary files such as winutils.exe etc.

2.	https://hadoopi.wordpress.com/2013/05/25/setup-maven-project-for-hadoop-in-5mn/

3.	http://www.codeproject.com/Articles/757934/Apache-Hadoop-for-Windows-Platform

4.	https://github.com/prabaprakash/Hadoop-2.3

5.	http://www.edureka.co/   

6.	https://in.linkedin.com/in/muthu4all -> from Edureka Instructor Muthu

7.	http://docs.hortonworks.com/HDPDocuments/HDP2/HDP-2.3.4-Win/bk_QuickStart_HDPWin/content/ch_qinst.html

8.	https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html     -> For Java path

9.	http://www.dummies.com/how-to/content/hadoop-distributed-file-system-shell-commands.html     -> For hdfs commands
10.	https://hadoop.apache.org/docs/r2.4.1/hadoop-project-dist/hadoop-common/FileSystemShell.html -> For hdfs commands










for patient:

hdfs dfs -mkdir -p /in/mr
hdfs dfs -put D:\github\edureka_LMS\trunk\src\main\resources\mr\* /in/mr
hdfs dfs -ls /in/mr /out/mr
hadoop jar wc.jar in.edureka.mapreduce.WordCount /in/mr /out/mr



