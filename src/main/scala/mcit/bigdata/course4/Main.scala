package mcit.bigdata.course4

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import java.sql.DriverManager

object MainRun extends App {

  val conf = new Configuration()
  conf.addResource(new Path("/Users/vasusurani/opt/hadoop-2.7.7/etc/cloudera/core-site.xml"))
  conf.addResource(new Path("/Users/vasusurani/opt/hadoop-2.7.7/etc/cloudera/hdfs-site.xml"))

  val fs: FileSystem = FileSystem.get(conf)

  if (fs.exists(new Path("/user/winter2020/vasu/project4")))
    fs.delete(new Path("/user/winter2020/vasu/project4"), true)
  fs.mkdirs(new Path("/user/winter2020/vasu/project4"))

  fs.mkdirs(new Path("/user/winter2020/vasu/project4/trips"))
  fs.copyFromLocalFile(new Path("file:///home/vasu/stm/trips.txt"),
    new Path("/user/winter2020/vasu/project4/trips/"))

  fs.mkdirs(new Path("/user/winter2020/vasu/project4/calendar_dates"))
  fs.copyFromLocalFile(new Path("file:///home/vasu/stm/calendar_dates.txt"),
    new Path("/user/winter2020/vasu/project4/calendar_dates/"))

  fs.mkdirs(new Path("/user/winter2020/vasu/project4/frequencies"))
  fs.copyFromLocalFile(new Path("file:///home/vasu/stm/frequencies.txt"),
    new Path("/user/winter2020/vasu/project4/frequencies/"))

  val driverName: String = "org.apache.hive.jdbc.HiveDriver"
  Class.forName(driverName)
  val connectionString: String = "jdbc:hive2://quickstart.cloudera:10000/winter2020_vasu;user=vasu;"
  val connection = DriverManager.getConnection(connectionString)
  val stmt = connection.createStatement()

  stmt.execute("DROP TABLE IF EXISTS winter2020_vasu.ext_trips")
  val extTrip = new Trips().extTrips
  stmt.execute(extTrip)

  stmt.execute("DROP TABLE IF EXISTS winter2020_vasu.ext_calendar_dates")
  val extCal = new CalendarDates().extCalendarDates
  stmt.execute(extCal)

  stmt.execute("DROP TABLE IF EXISTS winter2020_vasu.ext_frequencies")
  val extFreq = Frequencies.extFrequencies
  stmt.execute(extFreq)

  stmt.execute("DROP TABLE IF EXISTS winter2020_vasu.enriched_trips")
  val enTrips = new EnrichedTrips().enTrips
  stmt.execute(enTrips)

  stmt.execute("set hive.exec.dynamic.partition.mode=nonstrict")

  val wrData = new WriteData().writeTrips
  stmt.execute(wrData)

  stmt.close()
  connection.close()
}
