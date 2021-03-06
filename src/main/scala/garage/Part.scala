package garage

/**
  * Vehicle parts that may need fixing
  *
  * @param regNo    vehicle registration number
  * @param partName
  * @param broken   whether the part is broken and needs fixing
  * @param partCost cost of repair
  */
class Part(val regNo: String, val partID: Int, val partName: String, var broken: Boolean, val partCost: Double,
           val timeToFixMins: Int) {
  override def toString: String = s"Reg No: $regNo, ID: $partID, Part Name: $partName, Broken: $broken," +
    s" Cost: £$partCost, Estimated time to fix(mins): $timeToFixMins"
}
