package br.com.maicon.forum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
