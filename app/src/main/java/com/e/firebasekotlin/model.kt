package com.e.firebasekotlin

class model {
    internal lateinit var image: String
    internal lateinit var song:String
    internal lateinit var title:String
    //
    //    //constructor
    fun model() {}

    fun model(song: String, image: String, title: String) {

        this.song = song
        this.image = image
        this.title = title

    }

    //getter and setters press Alt+Insert
    fun getImage(): String {
        return image
    }

    fun setImage(image: String) {
        this.image = image
    }

    fun getSong(): String {
        return song
    }

    fun setSong(song: String) {
        this.song = song
    }

    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }


}