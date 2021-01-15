package mcit.bigdata.course4

class CalendarDates {
  val extCalendarDates = "CREATE EXTERNAL TABLE ext_calendar_dates ("+
    " service_id STRING, " +
    " date STRING, " +
    " exception_type INT) " +
    " ROW FORMAT DELIMITED " +
    " FIELDS TERMINATED BY ',' " +
    " STORED AS TEXTFILE " +
    " LOCATION '/user/winter2020/vasu/project4/calendar_dates/' "
    " tblproperties (" +
    " 'skip.header.line.count' = '1', " +
    " 'serialization.null.format' = '' )"
}
