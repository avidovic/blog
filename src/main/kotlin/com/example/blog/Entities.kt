package com.example.blog

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime


/*

Here we don’t use data classes with val properties because JPA is not designed to work with immutable classes
or the methods generated automatically by data classes. If you are using other Spring Data flavor,
most of them are designed to support such constructs so you should use classes like data class
    User(val login: String, ...)
when using Spring Data MongoDB, Spring Data JDBC, etc.
 */


@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null
)

@Entity
class User(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null
)
