package mcit.bigdata.course4

class Trips {
  val extTrips = "CREATE EXTERNAL TABLE ext_trips ("+
    " route_id INT, " +
    " service_id STRING, " +
    " trip_id STRING, " +
    " trip_headsign STRING, " +
    " direction_id INT, " +
    " shape_id INT, " +
    " wheelchair_accessible INT, " +
    " note_fr STRING, " +
    " note_en STRING) " +
    " ROW FORMAT DELIMITED " +
    " FIELDS TERMINATED BY ',' " +
    " STORED AS TEXTFILE " +
    " LOCATION '/user/winter2020/vasu/project4/trips/' "
    " tblproperties (" +
    " 'skip.header.line.count' = '1', " +
    " 'serialization.null.format' = '' )"
}
