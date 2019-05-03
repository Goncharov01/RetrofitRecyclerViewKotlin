package com.example.retrofitkotlin

//1)Создать класс модели, который будет перегоняться в JSON
data class Anekdot(
    val desc: String,
    val elementPureHtml: String,
    val link: Any,
    val name: String,
    val site: String
)