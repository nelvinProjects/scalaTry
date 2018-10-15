package garage

/**
  * Vehicle parts that may need fixing
  *
  * @param regNo    vehicle registration number
  * @param partName
  * @param broken   whether the part is broken and needs fixing
  * @param partCost cost of repair
  */
class Part(val regNo: String, val partName: String, var broken: Boolean, val partCost: Double) {
  override def toString: String = s"Reg No: $regNo, Part Name: $partName, Broken: $broken," +
    s" Cost: £$partCost"
}
