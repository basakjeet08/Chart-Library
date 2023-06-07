package com.dev.anirban.chartlibrary.library.circular.interfaces

/**
 * This implementation needs to be implemented by all the classes which provide an implementation to
 * handle data
 *
 * @property itemsList This is the list of items which are shown in the readings
 * @property sweepAngles This is the list of sweep angles which would be used to draw the readings
 * in the canvas
 * @property target This is the target to be achieved by the user
 * @property achieved This the value of what is achieved by the user
 *
 * @property siUnit This is the SI Unit text
 * @property cgsUnit This is the CGS Unit text
 * @property conversionRate This is the conversion rate according to which the CGS values can be
 * transformed into SI Unit
 *
 * @property doCalculations This function performs the calculation login in the class
 */
interface CircularDataInterface {

    val itemsList: List<Pair<String, Float>>
    var sweepAngles: MutableList<Float>

    var target: Float
    var achieved: Float

    val siUnit: String
    val cgsUnit: String

    val conversionRate: (Float) -> Float

    fun doCalculations()
}