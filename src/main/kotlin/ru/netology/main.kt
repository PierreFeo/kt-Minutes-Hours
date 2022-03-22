package ru.netology

const val SECONDS = 60
const val MINUTES = SECONDS * SECONDS
const val HOURS = 24 * MINUTES

fun main() {
    val time = 7200
    println(agoToText(time))
}

fun agoToText(time: Int): String {
    return when (time) {
        in 0..SECONDS -> "был(а) в сети только что"
        in SECONDS..MINUTES -> "${time / SECONDS} ${changeEndMin(time)} назад"
        in MINUTES..HOURS -> "${time / MINUTES} ${changeEndHur(time)} назад"
        in HOURS..HOURS * 2 -> "был(а) в сети сегодня"
        in HOURS * 2..HOURS * 3 -> "был(а) в сети вчера"
        else -> "был(а) в сети давно"
    }
}

fun changeEndMin(time: Int): String {
    val min = time / SECONDS
    return when {
        min % 10 == 1 && min != 11 -> "минуту"
        min % 10 in 2..4 && min !in 12..14 -> "минуты"
        else -> "минут"
    }
}

fun changeEndHur(time: Int): String {
    val hur = time / MINUTES
    return when {
        hur % 10 == 1 && hur != 11 -> "час"
        hur % 10 in 2..4 && hur !in 12..14 -> "часа"
        else -> "часов"
    }
}

