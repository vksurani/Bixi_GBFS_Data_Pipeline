package mcit.bigdata.course4

object Frequencies {
  val extFrequencies : String =
    "CREATE EXTERNAL TABLE ext_frequencies ("+
      " trip_id STRING, " +
      " start_time STRING, " +
      " end_time STRING, " +
      " headway_secs INT) " +
      " ROW FORMAT DELIMITED " +
      " FIELDS TERMINATED BY ',' " +
      " STORED AS TEXTFILE " +
      " LOCATION '/user/winter2020/vasu/project4/frequencies/' "
      " blproperties (" +
      " 'skip.header.line.count' = '1', " +
      " 'serialization.null.format' = '' )"
}
