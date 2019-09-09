package com.levi.avaliator.dtos

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable


class AverageUnitDTO @JsonCreator constructor(@JsonProperty("sum") val sum: Double, @JsonProperty("count") val count: Int) : Serializable {

}
