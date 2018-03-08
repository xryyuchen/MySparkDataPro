package com.yc.myprj.common.constant

import java.io.File

import com.yc.myprj.common.utils.PropertiesUtil

/**
  * 全局配置常量
  */

object MyConstant {


  /**
    * MySql 链接配置常量
    */
  object MySqlConstant{

    val MYSQL_URL = ""
    val MYSQL_USER = ""
    val MYSQL_PWD = ""
    val MYSQL_POOL_MIN = ""      //连接池最小连接数量
    val MYSQL_POOL_INI = ""      //连接池初始化连接数量
    val MYSQL_POOL_MAX = ""     //连接池最大使用连接数量
    val MYSQL_MAXWAIT = ""      //获取连接最大等待超时的时间
    val MYSQL_FREE_TIME = "" //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    val MYSQL_MINACTIVE_TIME = "" //配置一个连接在池中最小生存的时间，单位是毫秒

  }

  /**
    * 共用常量
    */
  val DIR_SEPARATOR = File.separator;

  /**
    * hdfs配置相关的常量
    */
  object HDFSConstant{
    val DFS_SUPPORT_APPEND =true;
    //  val HIVE_PATH_PRE = "hdfs://ns7/user/mart_mobile/fdm.db/fdm_cmo_appcore_business_logs";
    val HIVE_PATH_PRE = "/user/hive/warehouse/keywords.db";
    val HIVE_PATH_PRE_TMP = "hdfs://ns7/user/mart_mobile/fdm.db/fdm_cmo_appcore_business_logs_tmp";
    val HIVE_PATH_PRE_TEST = "hdfs://ns7/user/mart_mobile/tmp.db/fdm_cmo_appcore_business_logs";
    val HIVE_PATH_PRE_TEST_TMP = "hdfs://ns7/user/mart_mobile/tmp.db/fdm_cmo_appcore_business_logs_tmp";
    val CHECKPOINT_DIR="hdfs://ns7/user/mart_mobile/tmp.db/tmp_spark_checkpoint";
    val HDFS_FILE_MAX_SIZE=1024 * 1024   * 100;//100M
    val HDFS_RETRY_NUM=10;//hdfs操作最大重试次数
    val HDFS_RETRY_SLEEP_TIME=1;//重试过程中间隔

  }

  /**
    * sparkstreaming配置相关常量
    */
  val  SPARK_PRE_PARTITION_MAX_NUM=30000;
  val  SPARK_MAX_RUN_JOBS_NUM=3;
  val  SPARK_PARALLELISM_NUM=100;
  val  SPARK_RECEIVE_INTERVAL_SEC=5;
  val  SPARK_COALESCE_NUM=0;
  val  SPARK_DRA_MIN_NUM=0;
  val  SPARK_DRA_MAX_NUM=2;
  val  CONSUMER_GROUP_POS_VALUE="default";
  val  SPARK_LOG_LEVEL_VALUE="WARN";
  val  SPARK_SCHEDULER_MODE_VALUE="FAIR";


  /**
    * cli 命令参数
    *
    */
  val HELP="help";
  val SERVICE="service";
  val CONSUMER_TOPIC="consumer_topic";
  val KAFKA_BROKER_ID="kafka_broker_id";
  val TASK_NAME="task_name";
  val CONSUMER_GROUP="consumer_group";
  val RULES_FILE_PATH = "rules_file_path";
  val RUN_MODEL="run_model";
  val SPARK_MAX_RUN_JOBS="spark_max_run_jobs";
  val SPARK_PARALLELISM="spark_parallelism";
  val SPARK_PRE_PARTITION_MAX="spark_pre_partition_max";
  val SPARK_RECEIVE_INTERVAL="spark_receive_interval";
  val SPARK_COALESCE="spark_coalesce";
  val SPARK_DRA_MIN="spark_dra_min";
  val SPARK_DRA_MAX="spark_dra_max";
  val CONSUMER_GROUP_POS="consumer_group_pos";
  val SPARK_LOG_LEVEL="spark_log_level";
  val SPARK_SCHEDULER_MODE="spark_scheduler_mode";

  /**
    * 时间格式相关常量
    */

  val DATE_PATTERN_DEFAULT = "yyyyMMdd/HH";
  val DATE_PATTERN_DEFAULT2 = "yyyyMMddHHmmss";


  /**
    * kafka配置相关的常量
    */
  object KafkaCOnstant{

    private val kafkaPro = PropertiesUtil.loadProperty("kafka-conf.properties")

    //product
    val KAFKA_BROKER_LIST_PRODUCT = kafkaPro.getProperty("my.kafka.producer.servers")
    val KAFKA_KEYSER_PRODUCT = kafkaPro.getProperty("my.kafka.producer.keySerializerClass")
    val KAFKA_VALUESER_PRODUCT = kafkaPro.getProperty("my.kafka.producer.valueSerializerClass","org.apache.kafka.common.serialization.StringSerializer")

    my.kafka.producer.batchSize=131072
    my.kafka.producer.bufferMemory=33554432
    my.kafka.producer.requestTimeoutMs=30000
    my.kafka.producer.reties=0
    my.kafka.producer.lingerMs=1
    my.kafka.producer.compressionType=gzip






    //consumer
    val BROKER_LIST_CONSUME = kafkaPro.getProperty("my.kafka.producer.servers")
    val AUTO_OFFSET_RESET = "latest";//earliest latest
    val ENABLE_AUTO_COMMIT = false;//如果为false 需要自己实现offset操作
    val KAFKA_GROUP_TEST="-spark-dataflow-group-test";
    val MAX_FETCH_BYTES=(1024*1024*1024*1).toString();//1G

  }

}
