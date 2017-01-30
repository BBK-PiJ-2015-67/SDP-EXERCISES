package exercise2

import scala.io.StdIn.readLine
import scala.util.Random

object Hammurabi {

  val YEARS_TO_PLAY = 10
  val BUSHELS_TO_SURVIVE = 20
  val ACRES_PERSON_CAN_FARM = 10
  val BUSHELS_PER_ACRE_TO_FARM = 2
  val CHANCE_OF_PLAGUE = 15


  var starved = 0 // how many people starved
  var immigrants = 5 // how many people came to the city
  var population = 100
  var harvest = 3000 // total bushels harvested
  var bushelsPerAcre = 3 // amount harvested for each acre planted
  var rats_ate = 200 // bushels destroyed by rats
  var bushelsInStorage = 2800
  var acresOwned = 1000
  var pricePerAcre = 19 // each acre costs this many bushels
  var plagueDeaths = 0

  /**
    * Prints the game's introductory message
    */
  def printIntroductoryMessage () {
    println(s"""
        Congratulations, you are the newest ruler of ancient Samaria, elected
        for a ten year term of office. Your duties are to dispense food, direct
        farming, and buy and sell land as needed to support your people. Watch
        out for rat infestations and the plague! Grain is the general currency,
        measured in bushels. The following will help you in your decisions:

            * Each person needs at least $BUSHELS_TO_SURVIVE bushels of grain per year to survive.

            * Each person can farm at most $ACRES_PERSON_CAN_FARM acres of land.

            * It takes $BUSHELS_PER_ACRE_TO_FARM bushels of grain to farm an acre of land.

            * The market price for land fluctuates yearly.

        Rule wisely and you will be showered with appreciation at the end of
        your term. Rule poorly and you will be kicked out of office!
    """)
  }

  /**
    * Runs the hammurabi game
    */
  def hammurabi () {
    printIntroductoryMessage()

    for (year <- 1 to YEARS_TO_PLAY) {
      val acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      if (acresToBuy > 0) {
        acresOwned = acresOwned + acresToBuy
      } else {
        val acresToSell = askHowMuchLandToSell(acresOwned)
        acresOwned = acresOwned - acresToSell
      }
      val bushelsToFeed = askHowMuchGrainToFeed(bushelsInStorage)
      bushelsInStorage = bushelsInStorage - (bushelsToFeed * population)

      val acresToPlant = askHowManyAcresToPlant(acresOwned, bushelsInStorage, population)

      plagueDeaths = getPlagueDeathCount(population)
      population = population - plagueDeaths

      starved = getStarvationCount(population, bushelsToFeed)

      println("O great Hammurabi!\n" +
        "You are in year " + year + " of your ten year rule.\n" +
        "In the previous year " + starved + " people starved to death.\n" +
        "In the previous year " + immigrants + " people entered the kingdom.\n" +
        "The population is now " + population + ".\n" +
        "We harvested " + harvest + " bushels at " + bushelsPerAcre + " bushels per acre.\n" +
        "Rats destroyed " + rats_ate + " bushels, leaving " + bushelsInStorage + " bushels in storage.\n" +
        "The city owns " + acresOwned + " acres of land.\n" +
        "Land is currently worth " + pricePerAcre + " bushels per acre.\n" +
        "There were " + plagueDeaths + " deaths from the plague.\n"
      )
    }
  }

  /**
    * Asks for an Int from the console and repeats until an Int
    * has been entered
    *
    * @param message A String containing the question the Int will match
    * @return The inputted Int
    */
  def readInt (message: String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _ : Throwable =>
        println("That's not an integer. Please enter an integer.")
        readInt(message)
    }
  }

  def askHowMuchLandToBuy (bushels: Int, price: Int): Int = {
    askUntilValid(
      "How many acres will you buy? ",
      "\nO great Hammurabi, we have but " + bushels + " bushels!",
      f => { f < 0 || f * price > bushels }
    )
  }

  def askHowMuchLandToSell (acres: Int): Int = {
    askUntilValid(
      "How many acres will you sell? ",
      "\nO great Hammurabi, we have but " + acres + " acres of land!",
      f => { f < 0 || f > acres }
    )
  }

  def askHowMuchGrainToFeed (bushels: Int): Int = {
    askUntilValid(
      "\nHow much will you feed your people? ",
      "\nO great Hammurabi, we have but " + bushels + " bushels!",
      f => { f < 0 || f > bushels }
    )
  }

  /**
    * Support function that takes a question, error message, and a validator function
    * and then reads an Int from the console. The function will evaluate the input and
    * repeat the question until valid input has been provided (fails the condition in the
    * passed function)
    *
    * @param question A String containing the question being asked
    * @param invalidMsg A String that will be displayed if the input is invalid
    * @param cond Function to evaluate the input Int and returns true if the value is invalid, false if it's valid
    * @return The validated input
    */
  def askUntilValid(question: String, invalidMsg: String, cond: Int => Boolean): Int = {
    var response = readInt(question)
    while (cond(response)) {
      println(invalidMsg)
      response = readInt(question)
    }
    response
  }

  def askHowManyAcresToPlant (acres: Int, bushels: Int, people: Int): Int = {
    val question = "\nHow many acres will you plant with seed? "
    var acresToPlant = readInt(question)

    while (acresToPlant < 0 ||
      acresToPlant > people * ACRES_PERSON_CAN_FARM ||
      acresToPlant * BUSHELS_PER_ACRE_TO_FARM > bushels) {

      if (acresToPlant > people * ACRES_PERSON_CAN_FARM) {
        println("\nO great Hammurabi, we have but " + people + " with which to farm!")
        acresToPlant = readInt(question)
      } else if (acresToPlant * BUSHELS_PER_ACRE_TO_FARM > bushels) {
        println("\nO great Hammurabi, we have but " + bushels + " with which to farm!")
        acresToPlant = readInt(question)
      } else {
        println("\nO great Hammurabi, surely you jest!")
        acresToPlant = readInt(question)
      }
    }
    acresToPlant
  }

  def getPlagueDeathCount (people: Int): Int = {
    if (Random.nextInt(100) < CHANCE_OF_PLAGUE) people / 2 else 0
  }

  def getStarvationCount (people: Int, bushels: Int): Int = {
    var bushelsFedPerPerson = bushels / people

    0
  }
}
