package mcit.bigdata.course4

class EnrichedTrips {
  val enTrips = "CREATE TABLE winter2020_vasu.enriched_trips ("+
    " route_id INT, " +
    " service_id STRING, " +
    " trip_id STRING, " +
    " trip_headsign STRING, " +
    " direction_id INT, " +
    " shape_id INT, " +
    " note_fr STRING, " +
    " note_en STRING, " +
    " date STRING, " +
    " exception_type INT, " +
    " start_time STRING, " +
    " end_time STRING, " +
    " headway_secs INT) " +
    " PARTITIONED BY (wheelchair_accessible  INT) " +
    " ROW FORMAT DELIMITED " +
    " FIELDS TERMINATED BY ',' " +
    " STORED AS PARQUET "
}
